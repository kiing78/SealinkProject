package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="conteneurs")
public class Conteneur {
    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conteneur")
    private long idConteneur;

    @Column(name="cnt_immatriculation", length = 50)
    private String conteneurImmatriculation;


    @ManyToOne
    @JoinColumn(name = "transitaire")
    private Transitaire transitaire;

    @ManyToOne
    @JoinColumn(name="type_conteneur")
    private TypeConteneur typeConteneur;



    @OneToMany(mappedBy = "conteneur")
    private List<Marchandise> listeMarchandises;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="trajet")
    private Trajet trajet;

    //Constructeurs



    public Conteneur(
                     String conteneurImmatriculation,
                     Transitaire transitaire,
                     TypeConteneur typeConteneur,
                     //List<Marchandise> idMarchandises,
                     Trajet trajet) {

        this.conteneurImmatriculation = conteneurImmatriculation;
        this.transitaire = transitaire;
        this.typeConteneur = typeConteneur;
        //this.idMarchandises = idMarchandises;
        this.trajet = trajet;
    }

    public Conteneur(){

    }
    //Getters & setters

    public long getIdConteneur() {
        return idConteneur;
    }

    public void setIdConteneur(long idConteneur) {
        this.idConteneur = idConteneur;
    }

    public String getConteneurImmatriculation() {
        return conteneurImmatriculation;
    }

    public void setConteneurImmatriculation(String conteneurImmatriculation) {
        this.conteneurImmatriculation = conteneurImmatriculation;
    }


    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public Transitaire getTransitaire() {
        return transitaire;
    }

    public void setTransitaire(Transitaire transitaire) {
        this.transitaire = transitaire;
    }

    public TypeConteneur getTypeConteneur() {
        return typeConteneur;
    }

    public void setTypeConteneur(TypeConteneur typeConteneur) {
        this.typeConteneur = typeConteneur;
    }

    public List<Marchandise> getListeMarchandises() {
        return listeMarchandises;
    }

    public void setListeMarchandises(List<Marchandise> listeMarchandises) {
        this.listeMarchandises = listeMarchandises;
    }


    //Methodes

    @Override
    public String toString() {
        return
                ""+getTypeConteneur();


    }
}
