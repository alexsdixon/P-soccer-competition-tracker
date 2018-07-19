package net.alexdixon.soccercompetitiontracker.controllers;


import net.alexdixon.soccercompetitiontracker.models.data.TeamDao;
import net.alexdixon.soccercompetitiontracker.models.forms.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("team")
public class TeamController {

    @Autowired
    private TeamDao teamDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("teams", teamDao.findAll());
        model.addAttribute("title", "Teams");

        return "team/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("title", "Team");
        model.addAttribute("team", new Team());
        return "team/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Team team, Errors errors) {

        if (errors.hasErrors()) {
            return "team/add";
        }
        teamDao.save(team);
        return "redirect:";
    }



}
