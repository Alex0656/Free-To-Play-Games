package free_games.free_games_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ErrorDto {
    private final Date date;
    private final HttpStatus status;
    private final String message;
}