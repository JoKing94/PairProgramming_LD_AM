package Application.Service;

public class team_retour_good_name {
    public Long id;
    public String name;
    public String abreviation;
    public team_retour_good_name() {
    }
    public team_retour_good_name(team_retour f) {
        this.id = f.getId();
        this.name = f.getName();
        this.abreviation = f.getTla();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }
}
