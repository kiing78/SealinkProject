package fr.projet.port.service;

import org.springframework.stereotype.Service;


public interface CommandeService<T> {
    public void ajouterUneCommande(long idTrajet);
    public void supprimerUneCommande();
}
