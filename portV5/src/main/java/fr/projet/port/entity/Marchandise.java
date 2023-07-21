package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="marchandises")
public class Marchandise {
    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_marchandise")
    private long idMarchandise;

    @Column(name="mrh_longueur")
    private float marchandiseLongueur;
    @Column(name="mrh_largeur")
    private float marchandiseLargeur;

    @Column(name="mrh_poids")
    private float marchandisePoids;

    @Column(name="mrh_typologie", length = 50)
    private String marchandisetypologie;
    @Column(name="mrh_valeur_monetaire")
    private float marchandiseValeurMonetaire;
    @Column(name="mrh_specification",length = 50)
    private String marchandiseSpecification;

    @ManyToOne
    @JoinColumn(name="client")
    private Client client;

    @ManyToOne
    @JoinColumn(name="conteneur")
    private Conteneur conteneur;

    //Constructeurs


    public Marchandise(long idMarchandise,
                       float marchandiseLongueur,
                       float marchandiseLargeur,
                       float marchandisePoids,
                       String marchandisetypologie,
                       float marchandiseValeurMonetaire,
                       String marchandiseSpecification,
                       Client client,
                       Conteneur conteneur) {
        this.idMarchandise = idMarchandise;
        this.marchandiseLongueur = marchandiseLongueur;
        this.marchandiseLargeur = marchandiseLargeur;
        this.marchandisePoids = marchandisePoids;
        this.marchandisetypologie = marchandisetypologie;
        this.marchandiseValeurMonetaire = marchandiseValeurMonetaire;
        this.marchandiseSpecification = marchandiseSpecification;
        this.client = client;
        this.conteneur = conteneur;
    }
    public Marchandise(){

    }
    //Getters & setters
    public long getIdMarchandise() {
        return idMarchandise;
    }

    public void setIdMarchandise(long idMarchandise) {
        this.idMarchandise = idMarchandise;
    }

    public float getMarchandiseLongueur() {
        return marchandiseLongueur;
    }

    public void setMarchandiseLongueur(float marchandiseLongueur) {
        this.marchandiseLongueur = marchandiseLongueur;
    }

    public float getMarchandiseLargeur() {
        return marchandiseLargeur;
    }

    public void setMarchandiseLargeur(float marchandiseLargeur) {
        this.marchandiseLargeur = marchandiseLargeur;
    }

    public float getMarchandisePoids() {
        return marchandisePoids;
    }

    public void setMarchandisePoids(float marchandisePoids) {
        this.marchandisePoids = marchandisePoids;
    }

    public String getMarchandisetypologie() {
        return marchandisetypologie;
    }

    public void setMarchandisetypologie(String marchandisetypologie) {
        this.marchandisetypologie = marchandisetypologie;
    }

    public float getMarchandiseValeurMonetaire() {
        return marchandiseValeurMonetaire;
    }

    public void setMarchandiseValeurMonetaire(float marchandiseValeurMonetaire) {
        this.marchandiseValeurMonetaire = marchandiseValeurMonetaire;
    }

    public String getMarchandiseSpecification() {
        return marchandiseSpecification;
    }

    public void setMarchandiseSpecification(String marchandiseSpecification) {
        this.marchandiseSpecification = marchandiseSpecification;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Conteneur getConteneur() {
        return conteneur;
    }

    public void setConteneur(Conteneur conteneur) {
        this.conteneur = conteneur;
    }

    //Methode

    @Override
    public String toString() {
        return "Marchandise{" +
                "idMarchandise=" + idMarchandise +
                ", specification=" + marchandiseSpecification;
    }
}
