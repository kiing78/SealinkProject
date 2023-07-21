package fr.projet.port.service;

import fr.projet.port.dao.PortDao;
import fr.projet.port.entity.Port;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service : annotation de composant, spring va reconnaitre cette classe comme service
@Service
public class PortServiceImpl implements PortService<Port> {
    //   @Autowired : spring fait l'injection de dépendance de PortDao dans cette classe
    @Autowired
    private PortDao portDao;


    @Override
    public Port getPortDepart(String portDepart) {
        return portDao.findPortDepart(portDepart);

    }


    @Override
    public Port getPortArrivee(String portArrivee) {
        return portDao.findPortArrivee(portArrivee);
    }
}
