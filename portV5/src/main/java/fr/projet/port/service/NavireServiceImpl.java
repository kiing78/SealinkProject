package fr.projet.port.service;

import fr.projet.port.dao.NavireDao;
import fr.projet.port.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NavireServiceImpl implements NavireService<Navire>{
    @Autowired
    private NavireDao navireDao;
    @Override
    public List<Navire> renseignerInfoResa(String portDepart, String portArrivee, String  dateDepartPrevue, String dateArriveePrevue, String tailleConteneur) {
        System.out.println("je rentre dans le service");
        List<Navire> listeNavire = navireDao.findNavire(portDepart,portArrivee,dateDepartPrevue,dateArriveePrevue,tailleConteneur);

        System.out.println("normalement ma boucle navire devrait commencer");
        for(Navire n : listeNavire){
            System.out.println("test de la boucle service navire");
            System.out.println(n.getIdNavire());
        }

        return listeNavire;
    }
}
