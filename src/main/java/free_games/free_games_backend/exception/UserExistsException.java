package free_games.free_games_backend.exception;


public class UserExistsException extends RuntimeException{
    public UserExistsException(String message) {
        super(message);
    }
}