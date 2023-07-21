package fr.projet.port.service;

import fr.projet.port.dao.CommandeDao;
import fr.projet.port.entity.Trajet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImpl implements CommandeService<Trajet> {
    @Autowired
    private CommandeDao commandeDao;
    @Override
    public void ajouterUneCommande(long idTrajet) {
        commandeDao.addCommande(idTrajet);


    }

    @Override
    public void supprimerUneCommande() {

    }

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }
}
