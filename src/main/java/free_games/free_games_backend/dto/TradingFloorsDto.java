package free_games.free_games_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradingFloorsDto {

    @NotBlank(message = "У площадки должно быть имя")
    private String name;

    @NotBlank(message = "У площадки должен быть логотип")
    private String img;

    @NotBlank(message = "Ссылка является обязательным полем")
    private String link;


}