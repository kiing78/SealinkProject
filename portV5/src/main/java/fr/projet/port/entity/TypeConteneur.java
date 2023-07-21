package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="type_conteneurs")
public class TypeConteneur {
    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_type_conteneur")
    private long idTypeConteneur;

    @OneToMany(mappedBy = "typeConteneur")
    private List<Conteneur> listeConteneurs;

    @Column(name="tyc_dimension", length = 50)
    private String typeConteneurDimension;

    @Column(name="tyc_capacite_max")
    private float typeConteneurCapaciteMax;

    @Column(name="tyc_refrigere")
    private boolean typeConteneurRefrigere;

    @Column(name="tyc_conteneur_citerne")
    private boolean typeConteneurCiterne;

    @Column(name="tyc_flatracks")
    private boolean typeConteneurFlatracks;

    @Column(name = "tyc_conteneur_open_top")
    private boolean typeConteneurOpenTop;

    @Column(name = "tyc_conteneur_open_side")
    private boolean typeConteneurOpenSide;

    //Constructeurs

    public TypeConteneur(){

    }
    public TypeConteneur(String typeConteneurDimension) {
        this.typeConteneurDimension = typeConteneurDimension;
    }

    public TypeConteneur(
                         //List<Conteneur> conteneur,
                         String typeConteneurDimension,
                         float typeConteneurCapaciteMax,
                         boolean typeConteneurRefrigere,
                         boolean typeConteneurCiterne,
                         boolean typeConteneurFlatracks,
                         boolean typeConteneurOpenTop,
                         boolean typeConteneurOpenSide) {

        //this.conteneur = conteneur;
        this.typeConteneurDimension = typeConteneurDimension;
        this.typeConteneurCapaciteMax = typeConteneurCapaciteMax;
        this.typeConteneurRefrigere = typeConteneurRefrigere;
        this.typeConteneurCiterne = typeConteneurCiterne;
        this.typeConteneurFlatracks = typeConteneurFlatracks;
        this.typeConteneurOpenTop = typeConteneurOpenTop;
        this.typeConteneurOpenSide = typeConteneurOpenSide;
    }


    //Getters & setters

    public long getIdTypeConteneur() {
        return idTypeConteneur;
    }

    public void setIdTypeConteneur(long idTypeConteneur) {
        this.idTypeConteneur = idTypeConteneur;
    }

    public List<Conteneur> getListeConteneurs() {
        return listeConteneurs;
    }

    public void setListeConteneurs(List<Conteneur> listeConteneurs) {
        this.listeConteneurs = listeConteneurs;
    }

    public String getTypeConteneurDimension() {
        return typeConteneurDimension;
    }

    public void setTypeConteneurDimension(String typeConteneurDimension) {
        this.typeConteneurDimension = typeConteneurDimension;
    }

    public float getTypeConteneurCapaciteMax() {
        return typeConteneurCapaciteMax;
    }

    public void setTypeConteneurCapaciteMax(float typeConteneurCapaciteMax) {
        this.typeConteneurCapaciteMax = typeConteneurCapaciteMax;
    }

    public boolean isTypeConteneurRefrigere() {
        return typeConteneurRefrigere;
    }

    public void setTypeConteneurRefrigere(boolean typeConteneurRefrigere) {
        this.typeConteneurRefrigere = typeConteneurRefrigere;
    }

    public boolean isTypeConteneurCiterne() {
        return typeConteneurCiterne;
    }

    public void setTypeConteneurCiterne(boolean typeConteneurCiterne) {
        this.typeConteneurCiterne = typeConteneurCiterne;
    }

    public boolean isTypeConteneurFlatracks() {
        return typeConteneurFlatracks;
    }

    public void setTypeConteneurFlatracks(boolean typeConteneurFlatracks) {
        this.typeConteneurFlatracks = typeConteneurFlatracks;
    }

    public boolean isTypeConteneurOpenTop() {
        return typeConteneurOpenTop;
    }

    public void setTypeConteneurOpenTop(boolean typeConteneurOpenTop) {
        this.typeConteneurOpenTop = typeConteneurOpenTop;
    }

    public boolean isTypeConteneurOpenSide() {
        return typeConteneurOpenSide;
    }

    public void setTypeConteneurOpenSide(boolean typeConteneurOpenSide) {
        this.typeConteneurOpenSide = typeConteneurOpenSide;
    }

    //Methodes
    @Override
    public String toString() {
        return
                ""+ typeConteneurDimension;
    }
}
