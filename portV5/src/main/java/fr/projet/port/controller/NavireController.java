package fr.projet.port.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/sealink/navire")
public class NavireController {

    @GetMapping("/transitaireAccueil")
    public ModelAndView versTransitaireAccueil(){
        return new ModelAndView("transitaireAccueil");
    }
}
