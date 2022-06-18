package free_games.free_games_backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FreeGamesBackendApplication {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(FreeGamesBackendApplication.class, args);
        /*for (String name: applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }*/
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
