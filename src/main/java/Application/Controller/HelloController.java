package Application.Controller;

import Application.Service.FootService;
import Application.Service.team_retour;
import Application.Service.team_retour_good_name;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/teams")
    public List<team_retour_good_name> team() {
        List<team_retour> a = new FootService().getForEntityOperation();
        List<team_retour_good_name> b = new ArrayList();
        for (int z = 0; z < a.size(); z++) {
            b.add(new team_retour_good_name(a.get(z)));
        }
        return b;
    }

}