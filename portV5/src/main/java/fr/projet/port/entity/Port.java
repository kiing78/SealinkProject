package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ports")
public class Port {
    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_port")
    private long idPort;

    @Column(name="prt_nom",length=50)
    private String portNom;

    @Column(name="prt_indicatif", length = 50)
    private String portIndicatif;

    @Column(name="prt_ville", length = 50)
    private String portVille;

    @ManyToOne
    @JoinColumn(name="pays")
    private Pays pays;

    //Etant donnée que j'ai une ou pllusieurs objet qui ne sont pas présent dans ma BDD, je dois dire
    //a hibernate de les sauvegarder quand je sauvegarde leur parents, c'est pour ça que j'utilise cascadeType.ALL
    @OneToMany(mappedBy = "portDepart", cascade = CascadeType.ALL)
    private List<Trajet> listeTrajetPortDepart;
    @OneToMany(mappedBy = "portArrivee", cascade = CascadeType.ALL)
    private List<Trajet> listeTrajetPortArrivee;

    //Constructeurs

    public Port(String portNom) {
        this.portNom = portNom;
    }
    public Port(){

    }

    public Port(
                String portNom,
                String portIndicatif,
                String portVille,
                Pays pays
                //List<Trajet> trajetPortDepart,
                //List<Trajet> trajetPortArrivee
                ) {

        this.portNom = portNom;
        this.portIndicatif = portIndicatif;
        this.portVille = portVille;
        this.pays = pays;
       // this.idTrajetPortDepart = trajetPortDepart;
        //this.idTrajetPortArrivee = trajetPortArrivee;
    }

    public long getIdPort() {
        return idPort;
    }

    public void setIdPort(long idPort) {
        this.idPort = idPort;
    }




    public String getPortNom() {
        return portNom;
    }

    public void setPortNom(String portNom) {
        this.portNom = portNom;
    }

    public String getPortIndicatif() {
        return portIndicatif;
    }

    public void setPortIndicatif(String portIndicatif) {
        this.portIndicatif = portIndicatif;
    }

    public String getPortVille() {
        return portVille;
    }

    public void setPortVille(String portVille) {
        this.portVille = portVille;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Trajet> getListeTrajetPortDepart() {
        return listeTrajetPortDepart;
    }

    public void setListeTrajetPortDepart(List<Trajet> listeTrajetPortDepart) {
        this.listeTrajetPortDepart = listeTrajetPortDepart;
    }

    public List<Trajet> getListeTrajetPortArrivee() {
        return listeTrajetPortArrivee;
    }

    public void setListeTrajetPortArrivee(List<Trajet> listeTrajetPortArrivee) {
        this.listeTrajetPortArrivee = listeTrajetPortArrivee;
    }

    //methode
    @Override
    public String toString() {
        return portNom;
    }

}
