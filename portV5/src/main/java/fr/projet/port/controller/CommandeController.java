package fr.projet.port.controller;

import fr.projet.port.entity.Trajet;
import fr.projet.port.service.CommandeService;
import fr.projet.port.service.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/sealink/commande")
public class CommandeController {
    @Autowired
    private TrajetService trajetService;
    @Autowired
    private MarchandiseController marchandiseController;

    @Autowired
    private CommandeService commandeService;



    //ajouter le RequestMethod.GET, RequestMethod.POST car sinon il va prendre la requete comme une GET

    /**
     * permet de valider la commande en ajoutant le trajet et la marchandise dans la base de données
     * @return
     */
    @RequestMapping(value="/passerCommande", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView passerCommande()  {
        System.out.println("voici le trajet : "+trajetService.getTrajetId());

        commandeService.ajouterUneCommande(trajetService.getTrajetId());
        marchandiseController.ajouterMarchandise();

        //faire en sorte que marchandiseController ajoute la marchandise dans la bdd
        ModelAndView mav = new ModelAndView("success");

        return mav;

    }

    /**
     * permet d'envoyer sur la page accueil
     * @return
     */
    @GetMapping("/home")
    public ModelAndView retourAccueil(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
