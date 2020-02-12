package Application.Controller;

import Application.Service.FootService;
import Application.Service.team_retour;
import Application.Service.team_retour_good_name;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/teams/{id}")
    public ResponseEntity<team_retour_good_name> team(@PathVariable Long id) throws Exception {
        List<team_retour> a = new FootService().getForEntityOperation();
        List<team_retour_good_name> b = new ArrayList();
        for (int z = 0; z < a.size(); z++) {
            b.add(new team_retour_good_name(a.get(z)));
        }
        team_retour_good_name team = null;
        for (int i = 0; i < b.size(); i++){
            if(b.get(i).getId().equals(id)){
                team = b.get(i);
            }
        }
        if(team==null){
            return new ResponseEntity("Mauvais id", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(team,HttpStatus.OK);
        }
    }

}