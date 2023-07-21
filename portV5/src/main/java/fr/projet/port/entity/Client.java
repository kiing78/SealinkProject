package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;
//@Entity : fais persister la table dans la BDD
@Entity
//@Table(name="") : donne un nom à la table persisté
@Table(name="clients")
public class Client{
    //Attributs
    //@Id : défini l'attribut suivant comme clé primaire dans la table
    @Id
    //@GeneratedValue : permet d'indiquer la façon dont sera générer la clé primaire
    //IDENTITY : la clé primaire est généré de façon incrémenté par Hibernate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    @Column(name="") donne le nom de la colonne
    @Column(name="id_client")
    private long idClient;
    @Column(name="cli_nom",length=50)
    private String clientNom;
    @Column(name="cli_prenom",length=50)
    private String clientPrenom;
    @Column(name="cli_mail")
    private String clientMail;
    @Column(name="cli_password",length=50)
    private String clientPassword;

    //    @OneToMany(mappedBy="") : cardinalité (format UML) de table clients (1) à table Commande (n), cet attribut est lié à
//    l'attribut trajet dans la classe Commande
    @OneToMany(mappedBy = "client")
    private List<Commande> listeCommandes;

    @OneToMany(mappedBy = "client")
    private List<Marchandise> listeMarchandises;

    @OneToOne(mappedBy = "client")
    private PersonneMorale personneMorale;

    //Constructeurs
    public Client(long idClient,
                  String clientNom,
                  String clientPrenom,
                  String clientMail,
                  String clientPassword,
                  List<Commande> listeCommandes,
                  List<Marchandise> listeMarchandises,
                  PersonneMorale personneMorale) {
        this.idClient = idClient;
        this.clientNom = clientNom;
        this.clientPrenom = clientPrenom;
        this.clientMail = clientMail;
        this.clientPassword = clientPassword;
        this.listeCommandes = listeCommandes;
        this.listeMarchandises = listeMarchandises;
        this.personneMorale = personneMorale;
    }
    public Client(){

    }
    //Getters & setters

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    public String getClientPrenom() {
        return clientPrenom;
    }

    public void setClientPrenom(String clientPrenom) {
        this.clientPrenom = clientPrenom;
    }

    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    public List<Marchandise> getListeMarchandises() {
        return listeMarchandises;
    }

    public void setListeMarchandises(List<Marchandise> listeMarchandises) {
        this.listeMarchandises = listeMarchandises;
    }

    public PersonneMorale getPersonneMorale() {
        return personneMorale;
    }

    public void setPersonneMorale(PersonneMorale personneMorale) {
        this.personneMorale = personneMorale;
    }

    //Méthode

    @Override
    public String toString() {
        return "Client{" +
                "id=" + idClient +
                ", nomClient='" + clientNom + '\'' +
                ", prenomClient='" + clientPrenom + '\'' +
                ", mailClient='" + clientMail + '\'' +
                ", passwordClient='" + clientPassword + '\'' +
                ", listeCommandes=" + listeCommandes +
                '}';
    }
}
