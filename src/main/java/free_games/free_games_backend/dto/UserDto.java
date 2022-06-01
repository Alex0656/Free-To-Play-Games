package free_games.free_games_backend.dto;

import free_games.free_games_backend.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    @NotBlank(message = "Email является обязательным полем")
    @Email(message = "Введен некорректный email")
    private String email;
    private String name;

    @NotBlank(message = "Пароль является обязательным полем")
    private String password;

    private String authority;
}
