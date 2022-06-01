package free_games.free_games_backend.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/accessDenied")
public class AccessDeniedController {

    @RequestMapping
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleAccessDenied(){
        return "Access denied for this user";
    }
}