package net.alexdixon.soccercompetitiontracker.controllers;



import net.alexdixon.soccercompetitiontracker.models.data.FixtureDao;
import net.alexdixon.soccercompetitiontracker.models.forms.Fixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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




}
