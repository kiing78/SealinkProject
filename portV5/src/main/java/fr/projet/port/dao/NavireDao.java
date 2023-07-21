package fr.projet.port.dao;

import fr.projet.port.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NavireDao extends CrudRepository<Navire,Long> {
    @Query(value = "SELECT *\n"+
    "FROM navires nav \n"+
    "INNER JOIN trajets tra ON tra.navire= nav.id_navire\n"+
    "INNER JOIN conteneurs conte ON conte.trajet = tra.id_trajet \n"+
    "INNER JOIN ports por ON por.id_port = tra.port_depart\n"+
    "INNER JOIN ports dest On dest.id_port = tra.port_arrive\n"+
    "INNER  JOIN type_conteneurs typ ON conte.type_conteneur = typ.id_type_conteneur\n"+
    "WHERE por.prt_nom = :portDepart\n"+
    "AND dest.prt_nom = :portArrivee\n"+
    "AND typ.tyc_dimension = :tailleConteneur\n"+
    "AND tra.trj_date_depart_estimee= :departPrevue\n"+
    "AND tra.trj_date_arrivee_reelle=:arrivee",nativeQuery = true)
    public List<Navire>findNavire(@Param("portDepart") String portDepart,
                                          @Param("portArrivee")String portArrivee,
                                          @Param("departPrevue") String dateDepartPrevue,
                                          @Param("arrivee")String dateArriveePrevue,
                                          @Param("tailleConteneur")String tailleConteneur);
}
