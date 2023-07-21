package fr.projet.port.controller;

import fr.projet.port.entity.*;
import fr.projet.port.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

//@COntroller : annotation de composant, spring reconnait cette classe comme un controller
@Controller
//@RequestMapping : url de début pour accéder à ce controller
@RequestMapping("/sealink")
public class TrajetController {
    //   @Autowired : spring fait l'injection de dépendance de TrajetService dans cette classe
    @Autowired
    private TrajetService trajetService;


    @Autowired
    private ConteneurService conteneurService;
    @Autowired
    private PortService portService;

    @Autowired
    private ConteneurController conteneurController;

    @Autowired
    private  NavireService navireService;



    /**
     *
     * Appel la méthode vérifDemandeTrajet et demandetrajet dans la classe TransitaireService
     * puis récupère pour mettre dans un MAV pour ensuite l'envoyer vers listeTransitairee.html avec
     * comme donnée la liste de trajet
     * @param portDepart
     * @param portArrivee
     * @return
     */
//    @PostMapping : recoit une requete HTTP de type "POST" avec en URL /sealink/demandeTrajet
//    @RequestParam : permet de prendre les valeurs envoyé par l'utilisateur et de les mettre dans des paramètres
    @PostMapping("/demandeTrajet")
    public ModelAndView demandeTrajet(@RequestParam("portDepart")String portDepart,
                                      @RequestParam("destination")String portArrivee,
                                      @RequestParam("conteneur")String conteneur){
        System.out.println("je passe dans controller");
        /*
        trajetService.verifDemandeTrajet(portDepart,portArrivee);
        //appel la méthode afficherListeTransitaire dans la classe TransitaireService
        List<Transitaire> listeTrajet = trajetService.demandeTrajet(portDepart,portArrivee,conteneur);

        //instance mav avec la vue listeTransitairee.html

        ModelAndView mav = new ModelAndView("listeTransitaire");

         */
        portService.getPortDepart(portDepart);
        portService.getPortArrivee(portArrivee);

        conteneurController.choisirTaille(conteneur);
       List<Trajet> trajet =  trajetService.demandeTrajet(portService.getPortDepart(portDepart), (Port) portService.getPortArrivee(portArrivee),
        conteneurController.choisirTaille(conteneur));




        //System.out.println("portDepart :"+trajet.getPortDepart()+" portArrivee : "+trajet.getPortArrivee());


        ModelAndView mav = new ModelAndView("listeTransitaire");
        //ajout de la liste listeTransitaire dans l'objet mav
        mav.addObject("listeTrajet",trajet);//listeTrajet
        return mav;
    }

    /**
     * cette méthode permet de choisir un trajet, de faire un set et d'envoyer sur la vue "ajout d'une marchandise"
     * @param idTrajet
     * @return
     */
    @PostMapping("/choixTrajet")
    public ModelAndView choisirTrajet(@RequestParam("trajetId")String idTrajet,
                                    @RequestParam("conteneur")String listeConteneur){
        //transforme idTrajet en liste pour ensuite pouvoir la spliter
        List<String> list = Arrays.asList(idTrajet.split(","));
        System.out.println("test"+list);
        //System.out.println("test"+list.get(1));
        //index 5 permet d'avoir nom du transitaire
       System.out.println(list.get(5));
       String nomTransitaire = list.get(5);
       //transforme conteneur en liste pour pouvoir split et prendre le 1er index
        List<String> liste = Arrays.asList(listeConteneur.split(","));
        System.out.println("mon idConteneur "+liste.get(0));
        //faire un set conteneur
        long idConteneur = Long.parseLong(liste.get(0));
        conteneurService.setIdConteneur(idConteneur);


        //String conteneur = liste.get(0);
        //parse la chaine caractère idTrajet en Long
        long trajetId=Long.parseLong(list.get(1));




       trajetService.setTrajetId(trajetId);

       //transitaireService.updateConteneur(idTrajet);

        ModelAndView mav = new ModelAndView("ajoutMarchandise");
        return mav;

       // return "redirect:/sealink/commande/passerCommande";
    }


    @PostMapping("/demanderUnNavire")
    public ModelAndView renseignerResaNavire(String portDepart,
                                             String destination,
                                             String dateDepart,
                                             String dateArriveePrevue,
                                             String tailleConteneur){
        System.out.println(portDepart+" "+destination+" "+dateDepart+" "+dateArriveePrevue+" "+tailleConteneur);

        /*
        System.out.println("mon depart venant de la DAO "+trajetService.getDateDepartPrevue(dateDepart));

        System.out.println("ma date de depart : "+trajetService.getDateDepartPrevue(dateDepart));
        System.out.println("ma date d'arrivee : "+trajetService.getDateArriveePrevue(dateArriveePrevue));
        System.out.println("nombre conteneur : "+conteneurController.getNbConteneur(nbConteneur));



        */
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");

        //Next parse the date from the @RequestParam, specifying the TO type as a TemporalQuery:
        //LocalDate date = (LocalDate) formatter.parse(dateDepart);
        //LocalDate date2 = (LocalDate) formatter.parse(dateArriveePrevue);



       List<Navire> listeNavires = navireService.renseignerInfoResa(portDepart,destination,dateDepart,dateArriveePrevue,tailleConteneur);
       ModelAndView mav = new ModelAndView("listeNavire");
       mav.addObject("liste",listeNavires);
        return mav;
    }

    /*
    @GetMapping("/liste")
    public ModelAndView showListNavire(ModelAndView mav){
        List<Navire> listeNavires = navireService.renseignerInfoResa(portService.getPortDepart(portDepart),
                (Port) portService.getPortArrivee(destination),
                trajetService.getDateDepartPrevue(dateDepart),
                trajetService.getDateArriveePrevue(dateArriveePrevue),
                conteneurController.getNbConteneur(nbConteneur),
                conteneurController.choisirTaille(tailleConteneur));

    }*/







}
