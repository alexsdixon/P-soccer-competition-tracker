package net.alexdixon.soccercompetitiontracker.controllers;

import net.alexdixon.soccercompetitiontracker.models.data.FixtureDao;
import net.alexdixon.soccercompetitiontracker.models.data.PlayerDao;
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


    @RequestMapping(value = "")
    public String index (Model model) {

        model.addAttribute("fixtures", fixtureDao.findAll());
        model.addAttribute("players", playerDao.findAll());
        model.addAttribute("title", "JAMROCK SOCCER CUP");

        return "guest/index";
    }



}