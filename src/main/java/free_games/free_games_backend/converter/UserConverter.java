package free_games.free_games_backend.converter;

import free_games.free_games_backend.dto.UserDto;
import free_games.free_games_backend.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class UserConverter {
    private final PasswordEncoder passwordEncoder;
    private ModelMapper mapper;

    @Autowired
    public UserConverter(PasswordEncoder passwordEncoder, ModelMapper mapper) {
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public void convertPasswordToEntity(UserDto userDto, UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
    }

    public Converter<UserDto, UserEntity> convertToEntity() {
        return mappingContext -> {
            UserDto source = mappingContext.getSource();
            UserEntity destination = mappingContext.getDestination();
            convertPasswordToEntity(source, destination);
            return destination;
        };
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(UserDto.class, UserEntity.class)
                .addMappings(mapper -> mapper.skip(UserEntity::setPassword))
                .setPostConverter(convertToEntity());
    }


    public UserEntity toEntity(UserDto userDto) {
        return Objects.isNull(userDto) ? null : mapper.map(userDto, UserEntity.class);
    }


    public UserDto toDto(UserEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, UserDto.class);
    }

}
