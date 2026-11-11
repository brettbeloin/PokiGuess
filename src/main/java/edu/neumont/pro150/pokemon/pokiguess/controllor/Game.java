package edu.neumont.pro150.pokemon.pokiguess.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class Game {

    @GetMapping("")
    public String game(Model model) {
        model.addAttribute("projName", "PokiGuess");
        model.addAttribute("heading", "Guess who");
        return "game";
    }
}
