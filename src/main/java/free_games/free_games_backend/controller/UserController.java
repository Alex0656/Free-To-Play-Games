package free_games.free_games_backend.controller;

import free_games.free_games_backend.dto.UserDto;
import free_games.free_games_backend.service.UserService;
import free_games.free_games_backend.type.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping
    public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto userDto, Principal authentication) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("location", userDto.getEmail())
                .body(userService.save(userDto, authentication));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @GetMapping(value = "/{id}")
    public UserDto get(@PathVariable String id) {
        return userService.get(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public String delete(@PathVariable String id, Principal authentication) {
        return userService.delete(id, authentication);
    }
}
