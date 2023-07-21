package fr.projet.port.service;

import fr.projet.port.entity.Trajet;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TransitaireService<T> {
    public List<T> afficherListeTransitaire(String portDepart, String portArrivee,String conteneur);
    public void afficherUnTransitaire();
    public void updateConteneur(long idTrajet);

}
