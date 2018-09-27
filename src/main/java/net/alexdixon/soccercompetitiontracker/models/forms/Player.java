package net.alexdixon.soccercompetitiontracker.models.forms;

import javax.persistence.*;
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

    private PlayerPosition position;
    private int goal_scored;
    private int assists;
    private int clean_sheet;
    private int red_card;
    private int yellow_card;
    private int games_played;

    public Player(String player_name, int goal_scored, int assists, int clean_sheet, int red_card, int yellow_card, int games_played) {

        this.player_name = player_name;
        this.goal_scored = goal_scored;
        this.assists = assists;
        this.clean_sheet = clean_sheet;
        this.red_card = red_card;
        this.yellow_card = yellow_card;
        this.games_played = games_played;
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

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }


}