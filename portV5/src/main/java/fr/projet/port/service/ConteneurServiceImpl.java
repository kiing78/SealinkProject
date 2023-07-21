package fr.projet.port.service;


import fr.projet.port.dao.ConteneurDao;
import fr.projet.port.entity.Conteneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConteneurServiceImpl implements ConteneurService<Conteneur> {

    @Autowired
    private ConteneurDao conteneurDao;

    private long conteneurId;



    @Override
    public void setIdConteneur(long conteneurId) {
        this.conteneurId=conteneurId;
    }

    @Override
    public long getIdConteneur() {
        return conteneurId;
    }

    @Override
    public Conteneur getNbConteneur(int nbConteneur) {
        return conteneurDao.findByNbConteneur(nbConteneur);
    }
}
