package net.alexdixon.soccercompetitiontracker.controllers;


import net.alexdixon.soccercompetitiontracker.models.data.TeamDao;
import net.alexdixon.soccercompetitiontracker.models.forms.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "edit/{teamId}", method = RequestMethod.GET)
    public String displayEditTeamForm(Model model, @PathVariable int teamId) {

        model.addAttribute("title", "Edit Team");
        model.addAttribute("team", teamDao.findOne(teamId));
        return "team/edit";
    }


    @RequestMapping(value = "edit/{teamId}", method = RequestMethod.POST)
    public String processEditPlayerForm(Model model, @PathVariable int teamId,
                                        @ModelAttribute  @Valid Team newTeam, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Team");
            return "team/edit";
        }

        Team editedTeam = teamDao.findOne(teamId);
        editedTeam.setTeam_name(newTeam.getTeam_name());
        editedTeam.setPoints(newTeam.getPoints());
        editedTeam.setMatches_played(newTeam.getMatches_played());
        editedTeam.setMatches_won(newTeam.getMatches_won());
        editedTeam.setMatches_lost(newTeam.getMatches_lost());
        editedTeam.setMatches_draw(newTeam.getMatches_draw());
        editedTeam.setGoals_for(newTeam.getGoals_for());
        editedTeam.setGoals_against(newTeam.getGoals_against());
        editedTeam.setGoal_difference(newTeam.getGoal_difference());

        teamDao.save(editedTeam);

        return "redirect:/team";
    }


}



