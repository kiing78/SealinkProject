package fr.projet.port.service;

import fr.projet.port.entity.Conteneur;

import java.util.List;

public interface ConteneurService<T> {

    public void setIdConteneur(long id);
    public long getIdConteneur();

    public Conteneur getNbConteneur(int nbConteneur);
}
