package free_games.free_games_backend.controller;

import free_games.free_games_backend.dto.UserDto;
import free_games.free_games_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    @PostMapping
    public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto userDto, Authentication authentication) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("location", userDto.getEmail())
                .body(userService.save(userDto, authentication));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPER_ADMIN')")
    @GetMapping(value = "/{id}")
    public UserDto get(@PathVariable String id) {
        return userService.get(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPER_ADMIN')")
    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public String delete(@PathVariable String id, Authentication authentication) {
        return userService.delete(id, authentication);
    }
}
