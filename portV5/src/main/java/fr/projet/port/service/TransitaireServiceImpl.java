package fr.projet.port.service;

import fr.projet.port.dao.TransitaireDao;
import fr.projet.port.entity.Trajet;
import fr.projet.port.entity.Transitaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransitaireServiceImpl implements TransitaireService<Transitaire> {
    @Autowired
    private TransitaireDao transitaireDao;
    @Override
    public List<Transitaire> afficherListeTransitaire(String portDepart, String portArrivee,String conteneur) {
        System.out.println("je passe dans service"+ "Depart :"+portDepart+" destination "+portArrivee);
       List<Transitaire> listeTransitaire=transitaireDao.findByPort(portDepart,portArrivee,conteneur);
       for(Transitaire t : listeTransitaire){

           System.out.println(t.toString());

       }

    return listeTransitaire;
    }

    @Override
    public void afficherUnTransitaire() {

    }

    @Override
    public void updateConteneur(long trajetId) {
        System.out.println("je suis dans transitaireService");
        System.out.println("l'id trajet "+trajetId);



    }


    }

