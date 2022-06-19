package free_games.free_games_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradingFloorsDto {
    private String id;
    private String name;
    private String link;
    private String img;
}
