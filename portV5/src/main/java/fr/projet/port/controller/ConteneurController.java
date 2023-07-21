package fr.projet.port.controller;

import fr.projet.port.entity.Conteneur;
import fr.projet.port.entity.TypeConteneur;
import fr.projet.port.service.ConteneurService;
import fr.projet.port.service.TypeConteneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sealink/conteneur")
public class ConteneurController {
    @Autowired
    private TypeConteneurService typeConteneurService;

    @Autowired
    private ConteneurService conteneurService;

    @GetMapping("/taille")
    public TypeConteneur choisirTaille(String conteneur){
        return  typeConteneurService.getTailleConteneur(conteneur);

    }

    @GetMapping("/infoResa")
    public Conteneur getNbConteneur(int nbConteneur){
        return conteneurService.getNbConteneur(nbConteneur);
    }
}
