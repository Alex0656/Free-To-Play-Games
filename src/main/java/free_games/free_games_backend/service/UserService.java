package free_games.free_games_backend.service;


import free_games.free_games_backend.converter.UserConverter;
import free_games.free_games_backend.dto.UserDto;
import free_games.free_games_backend.exception.ForbiddenSuperAdminDeleteException;
import free_games.free_games_backend.exception.UserExistsException;
import free_games.free_games_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Value("${csv.users.path}")
    private  String csvUserPath;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findById(email).
                map(user -> User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .authorities(user.getAuthority())
                        .build())
                        .orElseThrow(() -> new UsernameNotFoundException("Пользователя не существует"));
    }



    @Transactional
    public UserDto save(UserDto userDto) {

        userDto.setAuthority("ADMIN");

        /* Благодаря кэшу 1 уровня
         * при нескольких findById все равно будет производится 1 запросвнутри 1 транзакции
         */
        if (userRepository.findById(userDto.getEmail()).isPresent()) {
            throw new UserExistsException("Пользователь с таким email существует");
        }

        return userConverter.toDto(userRepository.findById(userDto.getEmail()).
                orElse(userRepository.save(userConverter.toEntity(userDto))));
    }

    @Transactional(readOnly = true)
    public UserDto get(String id) {
        return userRepository.findById(id).map(userConverter::toDto)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не зарегистрирован"));
    }

    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .map(userConverter::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public String delete(String id) {
        return userRepository.findById(id)
                .map(entity -> {
                    if (entity.getAuthority().equals("SUPER_ADMIN")) {
                        throw new ForbiddenSuperAdminDeleteException("Нельзя удалять супер-админов");
                    }
                    userRepository.delete(entity);
                    return "success";
                })
                .orElseThrow(() ->new UsernameNotFoundException("Пользователь не был зарегистрирован"));
    }
}
