package free_games.free_games_backend.controller;

import free_games.free_games_backend.dto.UserDto;
import free_games.free_games_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
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
    public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("user-id", userDto.getEmail())
                .body(userService.save(userDto));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPER_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> get(@PathVariable String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("user-id", id)
                .body(userService.get(id));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPER_ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAll());
    }
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("user-id", id)
                .body(userService.delete(id));
    }
}
