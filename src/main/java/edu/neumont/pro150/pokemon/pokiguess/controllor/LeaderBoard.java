package edu.neumont.pro150.pokemon.pokiguess.controllor;

/**
 * LeaderBoard
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaderboard")
public class LeaderBoard {

    @GetMapping("")
    public String board(Model model) {
        model.addAttribute("projName", "PokiGuess");
        model.addAttribute("heading", "Leader Board");
        return "leaderboard";
    }
}
