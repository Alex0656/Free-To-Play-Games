package free_games.free_games_backend.exception;

public class ForbiddenSuperAdminDeleteException extends RuntimeException{
    public ForbiddenSuperAdminDeleteException(String message) {
        super(message);
    }
}
