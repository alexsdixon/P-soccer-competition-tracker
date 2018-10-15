package net.alexdixon.soccercompetitiontracker.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(value = "")
    public String index (Model model) {

        model.addAttribute("title", "ADMIN LOGIN");

        return "/login";
    }

}