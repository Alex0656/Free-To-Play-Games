package free_games.free_games_backend.dto;

import free_games.free_games_backend.type.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private RoleType role;
}
