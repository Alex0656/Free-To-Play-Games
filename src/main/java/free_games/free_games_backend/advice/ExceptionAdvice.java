package free_games.free_games_backend.advice;


import free_games.free_games_backend.dto.ErrorDto;
import free_games.free_games_backend.exception.ForbiddenSuperAdminDeleteException;
import free_games.free_games_backend.exception.UserExistsException;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleUnknownException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDto(
                        new Date(),
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Внутренняя ошибка сервера"
                ));
    }

     */

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUserNotFound(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(
                        new Date(),
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ErrorDto> handleUserExists(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorDto(
                        new Date(),
                        HttpStatus.CONFLICT,
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(ForbiddenSuperAdminDeleteException.class)
    public ResponseEntity<ErrorDto> handleAttemptToDeleteSuperAdmin(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ErrorDto(
                        new Date(),
                        HttpStatus.FORBIDDEN,
                        ex.getMessage()
                ));
    }
/*
    @ExceptionHandler(.class)
    public ResponseEntity<ErrorDto> handleInvalidInput(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(
                        new Date(),
                        HttpStatus.BAD_REQUEST,
                        ex.getMessage()
                ));
    }


 */

}
