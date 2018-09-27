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
    @Size(min = 3 , message = "Name must have at least 3 letters" )
    private String team_name;

    private int points;
    private int matches_played;
    private int matches_won;
    private int matches_lost;
    private int matches_draw;
    private int goals_for;
    private int goals_against;
    private int goal_difference;

    public Team(String team_name, int points, int matches_played, int matches_won, int matches_lost, int matches_draw, int goals_for, int goals_against, int goal_difference) {
        this.team_name = team_name;
        this.points = points;
        this.matches_played = matches_played;
        this.matches_won = matches_won;
        this.matches_lost = matches_lost;
        this.matches_draw = matches_draw;
        this.goals_for = goals_for;
        this.goals_against = goals_against;
        this.goal_difference = goal_difference;

    }

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Fixture> fixtures = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Player> players = new ArrayList<>();

    public Team(){}

    public int getId(){
        return id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMatches_played() {
        return matches_played;
    }

    public void setMatches_played(int matches_played) {
        this.matches_played = matches_played;
    }

    public int getMatches_won() {
        return matches_won;
    }

    public void setMatches_won(int matches_won) {
        this.matches_won = matches_won;
    }

    public int getMatches_lost() {
        return matches_lost;
    }

    public void setMatches_lost(int matches_lost) {
        this.matches_lost = matches_lost;
    }

    public int getMatches_draw() {
        return matches_draw;
    }

    public void setMatches_draw(int matches_draw) {
        this.matches_draw = matches_draw;
    }

    public int getGoals_for() {
        return goals_for;
    }

    public void setGoals_for(int goals_for) {
        this.goals_for = goals_for;
    }

    public int getGoals_against() {
        return goals_against;
    }

    public void setGoals_against(int goals_against) {
        this.goals_against = goals_against;
    }

    public int getGoal_difference() {
        return goal_difference;
    }

    public void setGoal_difference(int goal_difference) {
        this.goal_difference = goal_difference;
    }


}
