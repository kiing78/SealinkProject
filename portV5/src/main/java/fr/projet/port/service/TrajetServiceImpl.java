package fr.projet.port.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import fr.projet.port.dao.TrajetDao;
import fr.projet.port.entity.Port;
import fr.projet.port.entity.Trajet;
import fr.projet.port.entity.Transitaire;
import fr.projet.port.entity.TypeConteneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//@Service : annotation de composant, spring va reconnaitre cette classe comme service
@Service
public class TrajetServiceImpl implements TrajetService<Trajet> {
//   @Autowired : spring fait l'injection de dépendance de TrajetDao dans cette classe
    @Autowired
    private TrajetDao trajetDao;


    private long trajetId;

    public void setTrajetId(long trajetId){
       this.trajetId=trajetId;
    }
    public long getTrajetId(){
        return trajetId;
    }

    @Override
    public Trajet getDateDepartPrevue(String dateDepartPrevue) {
        System.out.println("je suis dans le service pour départ");
        return trajetDao.findByDateDepartPrevue(dateDepartPrevue);
    }

    @Override
    public Trajet getDateArriveePrevue(String dateArriveePrevue) {
        return trajetDao.findByDateArriveePrevue(dateArriveePrevue);
    }

    @Override
    public List<Trajet> demandeTrajet(Port portDepart, Port destination, TypeConteneur conteneur) {
        System.out.println("je passe dans service");

        System.out.println("mon conteneur " +portDepart);

       // if(verifDemandeTrajet(portDepart,destination)) {


            List<Trajet> listeTrajet = trajetDao.findByPort(portDepart,destination,conteneur);
            System.out.println("test pour voir si ya");
            for (Trajet t : listeTrajet) {
                System.out.println("je passe dans la boucle");
                System.out.println(t.toString());

            }

            return listeTrajet;
       /* }
        else{
            System.out.println("erreur liste");
            return null;
        }*/
    }

    /*
    permet de vérifier si le port de depart et d'arrivee sont bien des chaine de caractere
     */
    @Override
    public boolean verifDemandeTrajet(String portDepart, String destination) {
        if (portDepart instanceof String && destination instanceof String) {
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean verifChoixTrajet(long id) {
      return false;
    }


}
