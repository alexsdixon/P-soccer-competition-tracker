package net.alexdixon.soccercompetitiontracker.controllers;



import net.alexdixon.soccercompetitiontracker.models.data.FixtureDao;
import net.alexdixon.soccercompetitiontracker.models.forms.Fixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("fixture")
public class FixtureController {


    @Autowired
    private FixtureDao fixtureDao;



    //Request path to view all Match Fixtures
    @RequestMapping(value = "")
    public String index (Model model) {

        model.addAttribute("fixtures", fixtureDao.findAll());
        model.addAttribute("title", "Match Fixtures");

        return "fixture/index";
        }

    //Request path to add Match Fixtures
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddFixtureForm(Model model) {
            model.addAttribute("title", "Add Match Fixture");
            model.addAttribute(new Fixture());
            return "fixture/add";
        }

    //Process and validate new Match Fixture
    @RequestMapping (value = "add", method = RequestMethod.POST)
    public String processAddFixtureForm(@ModelAttribute @Valid Fixture newFixture, Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Fixture");
            return "fixture/add";
        }
            fixtureDao.save(newFixture);
            return "redirect:";
    }


    //Request path to Delete Old Match Fixtures
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveFixtureForm(Model model) {
        model.addAttribute("fixtures", fixtureDao.findAll());
        model.addAttribute ("title", "Remove Fixture");
        return "fixture/remove";
    }

    //Process remove Match Fixture
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveFixtureForm(@RequestParam int[] fixtureIds) {

        for (int fixtureId : fixtureIds) {
            fixtureDao.delete(fixtureId);
        }

        return "redirect:";
    }

    //Request path to Edit Match Fixtures
    @RequestMapping(value = "edit/{fixtureId}", method = RequestMethod.GET)
    public String displayEditFixtureForm(Model model, @PathVariable int fixtureId) {

        model.addAttribute("title", "Edit Fixture");
        model.addAttribute("fixture", fixtureDao.findOne(fixtureId));

        return "fixture/edit";
    }

    //Process Edit Match Fixture
    @RequestMapping(value = "edit/{fixtureId}", method = RequestMethod.POST)
    public String processEditFixtureForm(Model model, @PathVariable int fixtureId,
                                  @ModelAttribute  @Valid Fixture newFixture, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Fixture");
            return "fixture/edit";
        }

        Fixture editedFixture = fixtureDao.findOne(fixtureId);
        editedFixture.setHome_team_name(newFixture.getHome_team_name());
        editedFixture.setAway_team_name(newFixture.getAway_team_name());
        editedFixture.setRef_name(newFixture.getRef_name());
        editedFixture.setMatch_date(newFixture.getMatch_date());
        editedFixture.setMatch_time(newFixture.getMatch_time());

        fixtureDao.save(editedFixture);

        return "redirect:/fixture";
    }


}
