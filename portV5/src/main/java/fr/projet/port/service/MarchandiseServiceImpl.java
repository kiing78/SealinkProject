package fr.projet.port.service;

import fr.projet.port.dao.MarchandiseDao;
import fr.projet.port.entity.Marchandise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarchandiseServiceImpl  implements MarchandiseService<Marchandise> {
    @Autowired
    private MarchandiseDao marchandiseDao;

    private float longueur;
    private float largeur;
    private float poids;
    private String typologie;
    private String specification;
    private float valeurMonetaire;



    @Override
    public void ajouterMarchandise(float longueur, float largeur, float poids, String typologie, String specification, float valeurMonetaire,long conteneur) {
        System.out.println("je passe dans le service marchandise");
        marchandiseDao.addMarchandise(longueur,largeur,poids,typologie,specification,valeurMonetaire,conteneur);

    }

    @Override
    public void setMarchandise(float longueur, float largeur, float poids, String typologie, String specification, float valeurMonetaire) {
        this.longueur=longueur;
        this.largeur=largeur;
        this.poids=poids;
        this.typologie=typologie;
        this.specification=specification;
        this.valeurMonetaire=valeurMonetaire;
    }
    public float getLongueur() {
        return longueur;
    }

    public float getLargeur() {
        return largeur;
    }

    public float getPoids() {
        return poids;
    }

    public String getTypologie() {
        return typologie;
    }

    public String getSpecification() {
        return specification;
    }

    public float getValeurMonetaire() {
        return valeurMonetaire;
    }
}
