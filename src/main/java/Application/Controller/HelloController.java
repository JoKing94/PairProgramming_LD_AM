package Application.Controller;

import Application.Service.FootService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/teams")
    public String team(){ return new FootService().getForEntityOperation().toString();}

}