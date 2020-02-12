package Application.Service;

import Application.GlobalProperties;
import Application.model.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FootService {
    @Autowired
    private GlobalProperties globalProperties;
    public List<team_retour> getForEntityOperation() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", "d9c19fdaf9b64f21a09c372e83bcd170");
        //String url = globalProperties.url_teams;
        String url = "http://api.football-data.org/v2/competitions/2001/teams";
        HttpEntity entity = new HttpEntity(headers);
        Reponse rep = restTemplate.exchange(url, HttpMethod.GET, entity, Reponse.class).getBody();
        return rep.getTeams();

    }

}

@JsonIgnoreProperties
class Reponse{
    List<team_retour> teams;
    public Reponse() {
    }
    public List<team_retour> getTeams() {
        return teams;
    }

    public void setTeams(List<team_retour> teams) {
        this.teams = teams;
    }
}