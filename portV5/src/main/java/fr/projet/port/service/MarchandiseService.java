package fr.projet.port.service;

import org.springframework.stereotype.Service;


public interface MarchandiseService<T> {
    public void ajouterMarchandise(float longueur, float largeur, float poids, String typologie, String specification, float valeurMonetaire, long conteneur);
    public void setMarchandise(float longueur, float largeur, float poids, String typologie, String specification, float valeurMonetaire);
    public float getLongueur();
    public float getLargeur();
    public float getPoids();
    public String getTypologie();
    public String getSpecification();
    public float getValeurMonetaire();

}
