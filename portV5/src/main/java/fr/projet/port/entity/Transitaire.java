package fr.projet.port.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="transitaires")
public class Transitaire{
    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_transitaire")
    private long idTransitaire;



    @Column(name="tra_mail",length=50)//taille caractere : length = 30
    private String transitaireMail;

    @OneToMany(mappedBy = "transitaire")
    private List<Conteneur> listeConteneurs;

    @ManyToOne
    @JoinColumn(name="entreprise")
    private Entreprise entreprise;

    @OneToMany(mappedBy = "transitaire")
    private List<Trajet> listeTrajets;


    //Constructeurs

    public Transitaire(){

    }

    public Transitaire(
                       String transitaireMail,
                       //List<Conteneur> idConteneurs,
                       Entreprise entreprise
                       //List<Trajet> idTrajets
                       ) {

        this.transitaireMail = transitaireMail;
        //this.idConteneurs = idConteneurs;
        this.entreprise = entreprise;
        //this.idTrajets = idTrajets;
    }
    //Getters & setters

    public long getIdTransitaire() {
        return idTransitaire;
    }

    public void setIdTransitaire(long idTransitaire) {
        this.idTransitaire = idTransitaire;
    }


    public String getTransitaireMail() {
        return transitaireMail;
    }

    public void setTransitaireMail(String transitaireMail) {
        this.transitaireMail = transitaireMail;
    }

    public List<Conteneur> getListeConteneurs() {
        return listeConteneurs;
    }

    public void setListeConteneurs(List<Conteneur> listeConteneurs) {
        this.listeConteneurs = listeConteneurs;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Trajet> getListeTrajets() {
        return listeTrajets;
    }

    public void setListeTrajets(List<Trajet> listeTrajets) {
        this.listeTrajets = listeTrajets;
    }

    //Methodes

    @Override
    public String toString() {
        return "Transitaire{" +
                "idTransitaire=" + idTransitaire +
                "nom entreprise "+entreprise.getEntrepriseRaisonSociale()+
                ", mailTransitaire='" + transitaireMail + '\'' +
                ", conteneurs=" + listeConteneurs +
                '}';
    }

    public String afficherNomEntreprise(){
       return  ""+entreprise.getEntrepriseRaisonSociale();
    }
}
