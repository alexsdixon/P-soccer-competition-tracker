package net.alexdixon.soccercompetitiontracker.controllers;

import net.alexdixon.soccercompetitiontracker.models.data.PlayerDao;
import net.alexdixon.soccercompetitiontracker.models.data.TeamDao;
import net.alexdixon.soccercompetitiontracker.models.forms.Player;
import net.alexdixon.soccercompetitiontracker.models.forms.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("player")
public class PlayerController {


    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private TeamDao teamDao;


    @RequestMapping(value = "")
    public String index (Model model) {

        model.addAttribute("players", playerDao.findAll());
        model.addAttribute("title", "Leading Players");

        return "player/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayaddPlayerForm(Model model) {
        model.addAttribute("title", "Add Player");
        model.addAttribute(new Player());
        model.addAttribute("teams", teamDao.findAll());
        return "player/add";
    }

    @RequestMapping (value = "add", method = RequestMethod.POST)
    public String processAddPlayerForm(@ModelAttribute @Valid Player newPlayer, Errors errors,
                                       @RequestParam int teamId, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Player");
            return "player/add";
        }

        Team side = teamDao.findOne(teamId);
        newPlayer.setTeam(side);
        playerDao.save(newPlayer);
        return "redirect:";
    }



    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemovePlayerForm(Model model) {
        model.addAttribute("players", playerDao.findAll());
        model.addAttribute ("title", "Remove Player");
        return "player/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemovePlayerForm(@RequestParam int[] playerIds) {

        for (int playerId : playerIds) {
            playerDao.delete(playerId);
        }

        return "redirect:";
    }


    @RequestMapping(value = "edit/{playerId}", method = RequestMethod.GET)
    public String displayEditPlayerForm(Model model, @PathVariable int playerId) {

        model.addAttribute("title", "Edit Player");
        model.addAttribute("player", playerDao.findOne(playerId));
        model.addAttribute("teams", teamDao.findAll());
        return "player/edit";
    }


    @RequestMapping(value = "edit/{playerId}", method = RequestMethod.POST)
    public String processEditPlayerForm(Model model, @PathVariable int playerId,
                                         @ModelAttribute  @Valid Player newPlayer, Errors errors,
                                         @RequestParam int teamId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Player");
            return "player/edit";
        }

        Player editedPlayer = playerDao.findOne(playerId);
        editedPlayer.setPlayer_name(newPlayer.getPlayer_name());
        editedPlayer.setTeam(teamDao.findOne(teamId));
        editedPlayer.setPlayer_position(newPlayer.getPlayer_position());
        editedPlayer.setGoal_scored(newPlayer.getGoal_scored());
        editedPlayer.setAssists(newPlayer.getAssists());
        editedPlayer.setClean_sheet(newPlayer.getClean_sheet());
        editedPlayer.setRed_card(newPlayer.getRed_card());
        editedPlayer.setYellow_card(newPlayer.getYellow_card());

        playerDao.save(editedPlayer);

        return "redirect:/player";
    }


}