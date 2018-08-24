package net.alexdixon.soccercompetitiontracker.models.forms;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @Size(min = 3 , message = "Name must have atleast 3 letters" )
    private String team_name;



    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Fixture> fixtures = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Player> players = new ArrayList<>();

    public int getId(){
        return id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }






}
