package fr.projet.port.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
//@Entity : fais persister la table dans la BDD
@Entity
//@Table(name="") : donne un nom à la table persisté
@Table(name="trajets")
public class Trajet {
    //Attributs
    //@Id : défini l'attribut suivant comme clé primaire dans la table
    @Id
    //@GeneratedValue : permet d'indiquer la façon dont sera générer la clé primaire
    //IDENTITY : la clé primaire est généré de façon incrémenté par Hibernate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="") donne le nom de la colonne
    @Column(name="id_trajet")
    private long idTrajet;
//    @ManyToOne : cardinalité (format UML) de table Trajet (n) à table Port (1)
    @ManyToOne
//    @JoinColumn(name="") : la clé étrangère rejoint la table avec le nom de colonne attribué
    @JoinColumn(name="port_depart")
    private Port portDepart;

    @ManyToOne
    @JoinColumn(name="port_arrive")
    private Port portArrivee;
//    @OneToMany(mappedBy="") : cardinalité (format UML) de table trajet (1) à table Commande (n), cet attribut est lié à
//    l'attribut trajet dans la classe Commande
    @OneToMany(mappedBy = "trajet")
    private List<Commande> listeCommandes;

    @Column(name="trj_prix")
    private float trajetPrix;
    @Column(name="trj_date_depart_estimee")
    private LocalDate trajetDateDepartEstimee;
    @Column(name="trj_date_depart_reelle")
    private LocalDate getTrajetDateDepartEstimee;

    @Column(name="trj_date_arrivee_estime")
    private LocalDate trajetDateArriveeEstime;

    @Column(name="trj_date_arrivee_reelle")
    private LocalDate trajetDateArriveeReelle;

    @Column(name="trj_etat_trajet",length = 50)
    private String trajetEtat;

    @ManyToOne
    @JoinColumn(name="navire")
    private Navire navire;

    @ManyToOne
    @JoinColumn(name="transitaire")
    private Transitaire transitaire;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "trajet")
    private List<Conteneur> listeConteneurs;

    //Constructeurs

    public Trajet(Port portDepart, Port portArrivee) {
        this.portDepart = portDepart;
        this.portArrivee = portArrivee;
    }

    public Trajet(Port portDepart, Port portArrivee, List<Conteneur> listeConteneurs,Transitaire transitaire) {
        this.portDepart = portDepart;
        this.portArrivee = portArrivee;
        this.listeConteneurs = listeConteneurs;
        this.transitaire = transitaire;
    }

    public Trajet(
                  Port portDepart,
                  Port portArrivee,
                  //List<Commande> idCommandeTrajet,
                  float trajetPrix,
                  LocalDate trajetDateDepartEstimee,
                  LocalDate getTrajetDateDepartEstimee,
                  LocalDate trajetDateArriveeEstime,
                  LocalDate trajetDateArriveeReelle,
                  String trajetEtat,
                  Navire navire,
                  Transitaire transitaire
                  //List<Conteneur> idConteneurs
                  ) {
        this.portDepart = portDepart;
        this.portArrivee = portArrivee;
       // this.idCommandeTrajet = idCommandeTrajet;
        this.trajetPrix = trajetPrix;
        this.trajetDateDepartEstimee = trajetDateDepartEstimee;
        this.getTrajetDateDepartEstimee = getTrajetDateDepartEstimee;
        this.trajetDateArriveeEstime = trajetDateArriveeEstime;
        this.trajetDateArriveeReelle = trajetDateArriveeReelle;
        this.trajetEtat = trajetEtat;
        this.navire = navire;
        this.transitaire = transitaire;
        //this.idConteneurs = idConteneurs;
    }

    public Trajet(){

    }
    //Getters & setters

    public long getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(long idTrajet) {
        this.idTrajet = idTrajet;
    }


    public Port getPortDepart() {
        return portDepart;
    }

    public void setPortDepart(Port portDepart) {
        this.portDepart = portDepart;
    }

    public Port getPortArrivee() {
        return portArrivee;
    }

    public void setPortArrivee(Port portArrivee) {
        this.portArrivee = portArrivee;
    }

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    public Navire getNavire() {
        return navire;
    }

    public void setNavire(Navire navire) {
        this.navire = navire;
    }

    public Transitaire getTransitaire() {
        return transitaire;
    }

    public void setTransitaire(Transitaire transitaire) {
        this.transitaire = transitaire;
    }

    public List<Conteneur> getListeConteneurs() {
        return listeConteneurs;
    }

    public void setListeConteneurs(List<Conteneur> listeConteneurs) {
        this.listeConteneurs = listeConteneurs;
    }

    public float getTrajetPrix() {
        return trajetPrix;
    }

    public void setTrajetPrix(float trajetPrix) {
        this.trajetPrix = trajetPrix;
    }

    public LocalDate getTrajetDateDepartEstimee() {
        return trajetDateDepartEstimee;
    }

    public void setTrajetDateDepartEstimee(LocalDate trajetDateDepartEstimee) {
        this.trajetDateDepartEstimee = trajetDateDepartEstimee;
    }

    public LocalDate getGetTrajetDateDepartEstimee() {
        return getTrajetDateDepartEstimee;
    }

    public void setGetTrajetDateDepartEstimee(LocalDate getTrajetDateDepartEstimee) {
        this.getTrajetDateDepartEstimee = getTrajetDateDepartEstimee;
    }

    public LocalDate getTrajetDateArriveeEstime() {
        return trajetDateArriveeEstime;
    }

    public void setTrajetDateArriveeEstime(LocalDate trajetDateArriveeEstime) {
        this.trajetDateArriveeEstime = trajetDateArriveeEstime;
    }

    public LocalDate getTrajetDateArriveeReelle() {
        return trajetDateArriveeReelle;
    }

    public void setTrajetDateArriveeReelle(LocalDate trajetDateArriveeReelle) {
        this.trajetDateArriveeReelle = trajetDateArriveeReelle;
    }

    public String getTrajetEtat() {
        return trajetEtat;
    }

    public void setTrajetEtat(String trajetEtat) {
        this.trajetEtat = trajetEtat;
    }



    //Methodes



    public String toString() {
        return
                " prixTrajet=" + trajetPrix +
                        ","+idTrajet +
                ", dateArriveeEstime=" + trajetDateArriveeEstime +
                ", etatTrajet='" + trajetEtat + '\'' +
                "," + transitaire.afficherNomEntreprise()+
                ", conteneur "+ getListeConteneurs();
    }



}

