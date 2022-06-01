package free_games.free_games_backend.repository;


import free_games.free_games_backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {

}
