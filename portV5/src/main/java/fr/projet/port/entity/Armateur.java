package fr.projet.port.entity;



import javax.persistence.*;
import java.util.List;
//@Entity : fais persister la table dans la BDD
@Entity
//@Table(name="") : donne un nom à la table persisté
@Table(name="armateurs")
public class Armateur{


    //Attributs
    //@Id : défini l'attribut suivant comme clé primaire dans la table
    @Id
    //@GeneratedValue : permet d'indiquer la façon dont sera générer la clé primaire
    //IDENTITY : la clé primaire est généré de façon incrémenté par Hibernate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    @Column(name="") donne le nom de la colonne
    @Column(name="id_armateur")
    private long idArmateur;

    //    @ManyToOne : cardinalité (format UML) de table Armateur (n) à table Entreprise (1)
    @ManyToOne
    //    @JoinColumn(name="") : la clé étrangère rejoint la table avec le nom de colonne attribué
    @JoinColumn(name="entreprise")
    private Entreprise entreprise;

    //    @OneToMany(mappedBy="") : cardinalité (format UML) de table trajet (1) à table Commande (n), cet attribut est lié à
//    l'attribut trajet dans la classe Commande
    @OneToMany(mappedBy = "armateur")
    private List<Navire> listeNavires;


    @Column(name="arm_mail",length=50)//taille caractere : length = 30
    private String armateurMail;

    //Constructeur
    public Armateur( Entreprise entreprise,
                     //List<Navire> idNavires,
                     String armMail) {

        this.entreprise = entreprise;
        //this.idNavires = idNavires;
        this.armateurMail = armateurMail;
    }
    public Armateur(){

    }
    //Getters & setters
    public long getIdArmateur() {
        return idArmateur;
    }

    public void setIdArmateur(long idArmateur) {
        this.idArmateur = idArmateur;
    }


    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Navire> getListeNavires() {
        return listeNavires;
    }

    public void setListeNavires(List<Navire> listeNavires) {
        this.listeNavires = listeNavires;
    }

    public String getArmateurMail() {
        return armateurMail;
    }

    public void setArmateurMail(String armateurMail) {
        this.armateurMail = armateurMail;
    }
}
