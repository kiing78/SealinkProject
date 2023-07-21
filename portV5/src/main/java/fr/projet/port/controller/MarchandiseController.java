package fr.projet.port.controller;


import fr.projet.port.service.ConteneurService;
import fr.projet.port.service.MarchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sealink/marchandise")
public class MarchandiseController {

    @Autowired
    private MarchandiseService marchandiseService;

    @Autowired
    private ConteneurService conteneurService;


    /**
     * on set les variables et on envoie vers la page de paiement
     * @param longueur
     * @param largeur
     * @param poids
     * @param typologie
     * @param specification
     * @param valeurMonetaire
     * @return
     */
    @PostMapping("/addMarchandise")
    public ModelAndView addMarchandise(@RequestParam("longueur")float longueur,
                                           @RequestParam("largeur") float largeur,
                                           @RequestParam("poids") float poids,
                                           @RequestParam("typologie")String typologie,
                                           @RequestParam("specification") String specification,
                                           @RequestParam("valeurMonetaire") float valeurMonetaire) {
        System.out.println("je passe dans le controller");
        //marchandiseService.ajouterMarchandise(nom,volume,specification);
        marchandiseService.setMarchandise(longueur,largeur,poids,typologie,specification,valeurMonetaire);

        ModelAndView mav = new ModelAndView("pagePaiement");
        return mav;
    }


    /**
     * le controller Commande va faire une redirection vers cette methode pour ajouter
     * la marchandise à la bdd une fois que le paiement a été validé
     */
    @PostMapping("/valideMarchandise")
    public void ajouterMarchandise(){
        System.out.println("je suis en train de valider la marchandise");

        marchandiseService.ajouterMarchandise(marchandiseService.getLongueur(),
                marchandiseService.getLargeur(),
                marchandiseService.getPoids(),
                marchandiseService.getTypologie(),
                marchandiseService.getSpecification(),
                marchandiseService.getValeurMonetaire(),
                conteneurService.getIdConteneur());
    }
}
