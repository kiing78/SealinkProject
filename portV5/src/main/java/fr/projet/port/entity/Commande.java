package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="commandes")
public class Commande {
    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_commande")
    private long idCommande;

    @ManyToOne
    @JoinColumn(name="client")
    private Client client;

    @ManyToOne
    @JoinColumn(name="trajet")
    private Trajet trajet;

    //Constructeurs
    public Commande(){

    }

    public Commande(long idCommande, Client client, Trajet trajet) {
        this.idCommande = idCommande;
        this.client = client;
        this.trajet = trajet;
    }

    //Getters & setters
    public long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(long idCommande) {
        this.idCommande = idCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }
}
