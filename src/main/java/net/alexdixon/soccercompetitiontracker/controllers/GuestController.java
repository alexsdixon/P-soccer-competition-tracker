package net.alexdixon.soccercompetitiontracker.controllers;

import net.alexdixon.soccercompetitiontracker.models.data.FixtureDao;
import net.alexdixon.soccercompetitiontracker.models.data.PlayerDao;
import net.alexdixon.soccercompetitiontracker.models.data.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping("guest")
public class GuestController {



    @Autowired
    private FixtureDao fixtureDao;

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private TeamDao teamDao;


    @RequestMapping(value = "")
    public String index (Model model) {

        model.addAttribute("fixtures", fixtureDao.findAll());
        model.addAttribute("players", playerDao.findAll());
        model.addAttribute("title", "JAMROCK SOCCER CUP");

        return "guest/index";
    }

    @RequestMapping(value = "leader")
    public String displayLeaderBoard ( Model model) {



        model.addAttribute("title", "Leader Board");
        model.addAttribute("players", playerDao.findByGoalScored());
        model.addAttribute("playersa", playerDao.findByAssist());
        model.addAttribute("playerscs", playerDao.findByCleanSheet());


        return "guest/leader";
    }

    @RequestMapping(value = "stats")
    public String displayStatsBoard ( Model model) {



        model.addAttribute("title", "Team Stats Board");
        model.addAttribute("teams", teamDao.findByPoints());



        return "guest/stats";
    }

    @RequestMapping(value = "everyplayer")
    public String displayEveryPlayer ( Model model) {



        model.addAttribute("title", "Every Player");
        model.addAttribute("players", playerDao.findBySorted());



        return "guest/everyplayer";
    }

}