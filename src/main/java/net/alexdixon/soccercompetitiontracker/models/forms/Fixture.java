package net.alexdixon.soccercompetitiontracker.models.forms;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Fixture {


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3,  message= "Please Enter Referee Name!")
    private String ref_name;

    @NotNull
    @Size(min=10,  message= "Please Enter Valid Date!(Eg. 2018-10-30")
    private String match_date;

    @NotNull
    @Size(min=6,  message= "Time is Invalid!(Eg. 6:00 PM")
    private String match_time;

    private String home_team_goal;

    private String away_team_goal;

    @ManyToOne
    private Team team;


    @ManyToOne
    private Team team_second;


    public Fixture(String ref_name, String match_date, String match_time, String home_team_goal, String away_team_goal){

        this.ref_name =  ref_name;
        this.match_date = match_date;
        this.match_time = match_time;
        this.home_team_goal = home_team_goal;
        this.away_team_goal = away_team_goal;
    }

    public Fixture() {}

    public int getId() {
        return id;
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

    public String getMatch_time() { return match_time; }

    public void setMatch_time(String match_time) { this.match_time = match_time; }

    public String getHome_team_goal() {
        return home_team_goal;
    }

    public void setHome_team_goal(String home_team_goal) {
        this.home_team_goal = home_team_goal;
    }

    public String getAway_team_goal() {
        return away_team_goal;
    }

    public void setAway_team_goal(String away_team_goal) {
        this.away_team_goal = away_team_goal;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam_second() {
        return team_second;
    }

    public void setTeam_second(Team team_second) {
        this.team_second = team_second;
    }



}
