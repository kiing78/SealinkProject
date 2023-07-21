package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="personne_morales")
@PrimaryKeyJoinColumn(name = "idEntreprise")//permet de prendre l'id d'entreprise en heritage
public class PersonneMorale extends Entreprise{

    //Attributs
    @OneToOne
    @JoinColumn(name="client")
    private Client client;

    //Constructeurs



    public PersonneMorale(){

    }

    //Getters & setters


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
