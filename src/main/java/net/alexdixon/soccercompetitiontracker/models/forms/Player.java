package net.alexdixon.soccercompetitiontracker.models.forms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Player {


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, message = "Name is invalid")
    private String player_name;


    @ManyToOne
    private Team team;

    @NotNull
    @Size(min = 1, message = "Position is invalid")
    private String player_position;


    private int goal_scored;
    private int assists;
    private int clean_sheet;
    private int red_card;
    private int yellow_card;


    public Player(String player_name,  String player_position, int goal_scored, int assists, int clean_sheet, int red_card, int yellow_card) {

        this.player_name = player_name;
        this.player_position = player_position;
        this.goal_scored = goal_scored;
        this.assists = assists;
        this.clean_sheet = clean_sheet;
        this.red_card = red_card;
        this.yellow_card = yellow_card;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_position() {
        return player_position;
    }

    public void setPlayer_position(String player_position) {
        this.player_position = player_position;
    }

    public int getGoal_scored() {
        return goal_scored;
    }

    public void setGoal_scored(int goal_scored) {
        this.goal_scored = goal_scored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getClean_sheet() {
        return clean_sheet;
    }

    public void setClean_sheet(int clean_sheet) {
        this.clean_sheet = clean_sheet;
    }

    public int getRed_card() {
        return red_card;
    }

    public void setRed_card(int red_card) {
        this.red_card = red_card;
    }

    public int getYellow_card() {
        return yellow_card;
    }

    public void setYellow_card(int yellow_card) {
        this.yellow_card = yellow_card;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }




}