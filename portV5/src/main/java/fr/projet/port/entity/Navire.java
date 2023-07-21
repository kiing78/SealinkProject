package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="navires")
public class Navire {
    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_navire")
    private long idNavire;

    @Column(name="nvr_immatriculation", length = 50)
    private String navireImmatriculation;

    @Column(name = "nvr_nom",length = 50)
    private String navireNom;

    @Column(name="nvr_capacite_max")
    private int navireCapaciteMax;

    @Column(name="nvr_nb_emplacement")
    private int navireNbEmplacement;

    @ManyToOne
    @JoinColumn(name="armateur")
    private Armateur armateur;

    @ManyToOne
    @JoinColumn(name="pays")
    private Pays pays;

    @OneToMany(mappedBy = "navire")
    private List<Trajet> listeTrajets;

    //Constructeurs


    public Navire(
                  String navireImmatriculation,
                  String navireNom,
                  int navireCapaciteMax,
                  int navireNbEmplacement,
                  Armateur armateur,
                  Pays pays
                  //List<Trajet> idTrajets
                  ) {

        this.navireImmatriculation = navireImmatriculation;
        this.navireNom = navireNom;
        this.navireCapaciteMax = navireCapaciteMax;
        this.navireNbEmplacement = navireNbEmplacement;
        this.armateur = armateur;
        this.pays = pays;
        //this.idTrajets = idTrajets;
    }
    public Navire(){

    }
    //Getters & Setters

    public long getIdNavire() {
        return idNavire;
    }

    public void setIdNavire(long idNavire) {
        this.idNavire = idNavire;
    }

    public String getNavireImmatriculation() {
        return navireImmatriculation;
    }

    public void setNavireImmatriculation(String navireImmatriculation) {
        this.navireImmatriculation = navireImmatriculation;
    }

    public String getNavireNom() {
        return navireNom;
    }

    public void setNavireNom(String navireNom) {
        this.navireNom = navireNom;
    }

    public int getNavireCapaciteMax() {
        return navireCapaciteMax;
    }

    public void setNavireCapaciteMax(int navireCapaciteMax) {
        this.navireCapaciteMax = navireCapaciteMax;
    }

    public int getNavireNbEmplacement() {
        return navireNbEmplacement;
    }

    public void setNavireNbEmplacement(int navireNbEmplacement) {
        this.navireNbEmplacement = navireNbEmplacement;
    }

    public Armateur getArmateur() {
        return armateur;
    }

    public void setArmateur(Armateur armateur) {
        this.armateur = armateur;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Trajet> getListeTrajets() {
        return listeTrajets;
    }

    public void setListeTrajets(List<Trajet> listeTrajets) {
        this.listeTrajets = listeTrajets;
    }

    @Override
    public String toString() {
        return "Navire{" +
                "idNavire=" + idNavire +
                ", navireImmatriculation='" + navireImmatriculation + '\'' +
                ", navireNom='" + navireNom + '\'' +
                ", navireCapaciteMax=" + navireCapaciteMax +
                ", navireNbEmplacement=" + navireNbEmplacement +
                ", armateur=" + armateur +
                ", pays=" + pays +
                ", listeTrajets=" + listeTrajets +
                '}';
    }
}
