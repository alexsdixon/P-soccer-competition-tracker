package net.alexdixon.soccercompetitiontracker.models.forms;

public enum PlayerPosition {


    GOALKEEPER ("Goalkeeper"),
    DEFENDER ("Defender"),
    MIDFIELDER ("Midfielder"),
    WINGER ("Winger"),
    STRIKER ("Striker");

    private final String name;

    PlayerPosition(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
