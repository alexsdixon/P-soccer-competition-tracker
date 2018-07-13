package net.alexdixon.soccercompetitiontracker.models.forms;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Fixture {


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1,  message= "Name is invalid")
    private String team_name;


    @NotNull
    @Size(min=1,  message= "Name is invalid")
    private String ref_name;

    @NotNull
    @Size(min=1,  message= "date is invalid")
    private String match_date;

    @NotNull
    @Size(min=1,  message= "time is invalid")
    private String match_time;

    public Fixture(String team_name, String ref_name, String match_date, String match_time){

        this.team_name = team_name;
        this.ref_name =  ref_name;
        this.match_date = match_date;
        this.match_time = match_time;
    }

    public Fixture() {}

    public int getId() {
        return id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getRef_name() {
        return ref_name;
    }

    public void setRef_name(String ref_name) {
        this.ref_name = ref_name;
    }

    public String getMatch_date() {
        return match_date;
    }

    public void setMatch_date(String match_date) {
        this.match_date = match_date;
    }

    public String getMatch_time() {
        return match_time;
    }

    public void setMatch_time(String match_time) {
        this.match_time = match_time;
    }

}
