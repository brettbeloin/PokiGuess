package edu.neumont.pro150.pokemon.pokiguess.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projName", "PokiGuess");
        model.addAttribute("heading", "Home");
        return "index";
    }

    @PostMapping("/game")
    public String clicked(Model model) {
        return "game";
    }
}
