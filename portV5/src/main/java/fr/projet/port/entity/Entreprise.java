package fr.projet.port.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="entreprises")
@Inheritance(strategy = InheritanceType.JOINED)//permet de faire l'heritage
public class Entreprise {

    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_entreprise")
    private long idEntreprise;

    @Column(name="ent_raison_sociale",length = 50)
    private String entrepriseRaisonSociale;

    @Column(name="ent_adresse_cp",length = 6)
    private int entrepriseAdresseCp;

    @Column(name="ent_adresse_voie",length = 50)
    private String entrepriseAdresseVoie;

    @Column(name="ent_adresse_province",length = 50)
    private String entrepriseAdresseProvince;

    @Column(name="ent_adresse_ville",length = 50)
    private String entrepriseAdresseVille;

    @Column(name="ent_duns",length = 50)
    private int entrepriseDuns;

    @ManyToOne
    @JoinColumn(name="pays")
    private Pays pays;

    @OneToMany(mappedBy = "entreprise")
    private List<Armateur> listeArmateurs;

    @OneToMany(mappedBy = "entreprise")
    private List<Transitaire> listeTransitaires;

    //Constructeur

    public Entreprise(
                      String entrepriseRaisonSociale,
                      int entrepriseAdresseCp,
                      String entrepriseAdresseVoie,
                      //String entrepriseAdresseProvince,
                      String entrepriseAdresseVille,
                      int entrepriseDuns,
                      Pays pays
                      //List<Armateur> idArmateurs,
                      //List<Transitaire> idTransitaires
                      ) {

        this.entrepriseRaisonSociale = entrepriseRaisonSociale;
        this.entrepriseAdresseCp = entrepriseAdresseCp;
        this.entrepriseAdresseVoie = entrepriseAdresseVoie;
        //this.entrepriseAdresseProvince = entrepriseAdresseProvince;
        this.entrepriseAdresseVille = entrepriseAdresseVille;
        this.entrepriseDuns = entrepriseDuns;
        this.pays = pays;
        //this.idArmateurs = idArmateurs;
        //this.idTransitaires = idTransitaires;
    }
    public Entreprise (){

    }

    //Getters & setters

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getEntrepriseRaisonSociale() {
        return entrepriseRaisonSociale;
    }

    public void setEntrepriseRaisonSociale(String entrepriseRaisonSociale) {
        this.entrepriseRaisonSociale = entrepriseRaisonSociale;
    }

    public int getEntrepriseAdresseCp() {
        return entrepriseAdresseCp;
    }

    public void setEntrepriseAdresseCp(int entrepriseAdresseCp) {
        this.entrepriseAdresseCp = entrepriseAdresseCp;
    }

    public String getEntrepriseAdresseVoie() {
        return entrepriseAdresseVoie;
    }

    public void setEntrepriseAdresseVoie(String entrepriseAdresseVoie) {
        this.entrepriseAdresseVoie = entrepriseAdresseVoie;
    }

    public String getEntrepriseAdresseProvince() {
        return entrepriseAdresseProvince;
    }

    public void setEntrepriseAdresseProvince(String entrepriseAdresseProvince) {
        this.entrepriseAdresseProvince = entrepriseAdresseProvince;
    }

    public String getEntrepriseAdresseVille() {
        return entrepriseAdresseVille;
    }

    public void setEntrepriseAdresseVille(String entrepriseAdresseVille) {
        this.entrepriseAdresseVille = entrepriseAdresseVille;
    }

    public int getEntrepriseDuns() {
        return entrepriseDuns;
    }

    public void setEntrepriseDuns(int entrepriseDuns) {
        this.entrepriseDuns = entrepriseDuns;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Armateur> getListeArmateurs() {
        return listeArmateurs;
    }

    public void setListeArmateurs(List<Armateur> listeArmateurs) {
        this.listeArmateurs = listeArmateurs;
    }

    public List<Transitaire> getListeTransitaires() {
        return listeTransitaires;
    }

    public void setListeTransitaires(List<Transitaire> listeTransitaires) {
        this.listeTransitaires = listeTransitaires;
    }
}
