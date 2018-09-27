package net.alexdixon.soccercompetitiontracker.controllers;



import net.alexdixon.soccercompetitiontracker.models.data.FixtureDao;
import net.alexdixon.soccercompetitiontracker.models.data.TeamDao;
import net.alexdixon.soccercompetitiontracker.models.forms.Fixture;
import net.alexdixon.soccercompetitiontracker.models.forms.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("fixture")
public class FixtureController {


    @Autowired
    private FixtureDao fixtureDao;

    @Autowired
    private TeamDao teamDao;


    @RequestMapping(value = "")
    public String index (Model model) {

        model.addAttribute("fixtures", fixtureDao.findAll());
        model.addAttribute("title", "MATCH FIXTURES");

        return "fixture/index";
        }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddFixtureForm(Model model) {
            model.addAttribute("title", "ADD FIXTURE");
            model.addAttribute(new Fixture());
            model.addAttribute("teams", teamDao.findAll());
            return "fixture/add";
        }

    @RequestMapping (value = "add", method = RequestMethod.POST)
    public String processAddFixtureForm(@ModelAttribute @Valid Fixture newFixture, Errors errors,
                                        @RequestParam int teamId, @RequestParam int team2Id, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "ADD FIXTURE");
            model.addAttribute("teams", teamDao.findAll());
            return "fixture/add";
        }

            Team side = teamDao.findOne(teamId);
            Team side_away = teamDao.findOne(team2Id);
            newFixture.setTeam(side);
            newFixture.setTeam_second(side_away);
            fixtureDao.save(newFixture);
            return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveFixtureForm(Model model) {
        model.addAttribute("fixtures", fixtureDao.findAll());
        model.addAttribute ("title", "DELETE FIXTURE");
        return "fixture/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveFixtureForm(@RequestParam(required=false) int[] fixtureIds,Model model) {

                if (fixtureIds == null) {
                    model.addAttribute("fixtures", fixtureDao.findAll());
                    model.addAttribute ("title", "DELETE FIXTURE");
                    model.addAttribute ("message", "Please choose a Fixture to delete or go back");
                    return "fixture/remove";
                }

                for (int fixtureId : fixtureIds) {
                    fixtureDao.delete(fixtureId);
                }

                return "redirect:";

    }



    @RequestMapping(value = "edit/{fixtureId}", method = RequestMethod.GET)
    public String displayEditFixtureForm(Model model, @PathVariable int fixtureId) {

        model.addAttribute("title", "ADD MATCH RESULTS");
        model.addAttribute("fixture", fixtureDao.findOne(fixtureId));
        model.addAttribute("teams", teamDao.findAll());
        return "fixture/edit";
    }


    @RequestMapping(value = "edit/{fixtureId}", method = RequestMethod.POST)
    public String processEditFixtureForm(Model model, @PathVariable int fixtureId,
                                         @ModelAttribute  @Valid Fixture newFixture,
                                         Errors errors, @RequestParam int teamId,@RequestParam int team2Id) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "ADD MATCH RESULTS");
            return "fixture/edit";
        }

        Fixture editedFixture = fixtureDao.findOne(fixtureId);
        editedFixture.setRef_name(newFixture.getRef_name());
        editedFixture.setMatch_date(newFixture.getMatch_date());
        editedFixture.setMatch_time(newFixture.getMatch_time());
        editedFixture.setHome_team_goal(newFixture.getHome_team_goal());
        editedFixture.setAway_team_goal(newFixture.getAway_team_goal());
        editedFixture.setTeam(teamDao.findOne(teamId));
        editedFixture.setTeam_second(teamDao.findOne(team2Id));
        fixtureDao.save(editedFixture);

        return "redirect:/fixture";
    }


}