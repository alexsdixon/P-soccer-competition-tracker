package net.alexdixon.soccercompetitiontracker.models.forms;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
public class Blog {




    @Id
    @GeneratedValue
    private int id;



    @NotNull
    @Size(min=1,  message= "topic is invalid")
    private String topic;

    @NotNull
    @Size(min=1,  message= "description is invalid")
    private String description;


    @GeneratedValue
    public LocalDateTime created  = LocalDateTime.now();

    public Blog(String topic, String description) {

        this.topic = topic;
        this.description = description;

    }

    public Blog () {}


    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }











}
