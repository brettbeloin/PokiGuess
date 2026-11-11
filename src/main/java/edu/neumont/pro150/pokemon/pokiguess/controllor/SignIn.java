package edu.neumont.pro150.pokemon.pokiguess.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class SignIn {

    @GetMapping("")
    public String Sign(Model model) {
        return "signin";
    }
}
