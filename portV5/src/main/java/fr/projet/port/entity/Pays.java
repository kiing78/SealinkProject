package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pays")
public class Pays {
    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pays")
    private long idPays;

    @Column(name="ps_indicatif",length = 4)
    private String paysIndicatif;

    @Column(name="ps_nom",length = 50)
    private String paysNom;

    @OneToMany(mappedBy = "pays")
    private List<Port> listePorts;

    @OneToMany(mappedBy = "pays")
    private List<Navire> listeNavires;

    @OneToMany(mappedBy="pays")
    private List<Entreprise> listeEntreprises;

    //Constructeurs


    public Pays(
                String paysIndicatif,
                String paysNom
                //List<Port> idPorts,
                //List<Navire> idNavire,
                //List<Entreprise>
                ) {

        this.paysIndicatif = paysIndicatif;
        this.paysNom = paysNom;
       // this.idPorts = idPorts;
        //this.idNavire = idNavire;
        //this.idEntreprises = idEntreprises;
    }
    public Pays(){

    }

    //Getters & setters
    public long getIdPays() {
        return idPays;
    }

    public void setIdPays(long idPays) {
        this.idPays = idPays;
    }

    public String getPaysIndicatif() {
        return paysIndicatif;
    }

    public void setPaysIndicatif(String paysIndicatif) {
        this.paysIndicatif = paysIndicatif;
    }

    public String getPaysNom() {
        return paysNom;
    }

    public void setPaysNom(String paysNom) {
        this.paysNom = paysNom;
    }

    public List<Port> getListePorts() {
        return listePorts;
    }

    public void setListePorts(List<Port> listePorts) {
        this.listePorts = listePorts;
    }

    public List<Navire> getListeNavires() {
        return listeNavires;
    }

    public void setListeNavires(List<Navire> listeNavires) {
        this.listeNavires = listeNavires;
    }

    public List<Entreprise> getListeEntreprises() {
        return listeEntreprises;
    }

    public void setListeEntreprises(List<Entreprise> listeEntreprises) {
        this.listeEntreprises = listeEntreprises;
    }
}
