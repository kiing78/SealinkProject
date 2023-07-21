package fr.projet.port.dao;

import fr.projet.port.entity.Port;
import fr.projet.port.entity.Trajet;
import fr.projet.port.entity.TypeConteneur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//@Repository : annotation de composant, spring va reconnaitre cette interface comme un repository
@Repository
//CRUD : 4 opération de persistence de donnée
//CrudRepository : opération de persistence de donnée pour un repository
public interface TrajetDao extends CrudRepository<Trajet,Long> {
//    @Query : permet de définir une requête spécifique
//    nativeQuery=true : permet d'écrire du SQL natif
    @Query(value="SELECT DISTINCT *\n"+
            "FROM trajets tra\n" +
            "INNER JOIN transitaires trans ON tra.transitaire = trans.id_transitaire\n" +
            "INNER JOIN conteneurs conte  ON conte.transitaire= trans.id_transitaire\n" +
            "INNER JOIN ports pd ON tra.port_depart = pd.id_port\n" +
            "INNER JOIN ports dest ON  tra.port_arrive = dest.id_port\n" +
            "INNER JOIN type_conteneurs typ ON conte.type_conteneur = typ.id_type_conteneur\n" +
            "WHERE port_depart = :por\n" +
            "AND port_arrive=:des\n" +
            "AND conte.type_conteneur= :conten",nativeQuery=true)
    public List<Trajet> findByPort(@Param("por") Port portDepart, @Param("des") Port destination, @Param("conten") TypeConteneur conteneur);

    @Query(value="SELECT DISTINCT *\n"+
    "FROM trajets \n"+
    "WHERE trj_date_depart_estimee = :dateDepartPrevue",nativeQuery = true)
    public Trajet findByDateDepartPrevue(@Param("dateDepartPrevue")String dateDepartPrevue);

    @Query(value="SELECT DISTINCT *\n"+
            "FROM trajets \n"+
            "WHERE trj_date_arrivee_reelle = :dateArrivePrevue",nativeQuery = true)
    public Trajet findByDateArriveePrevue(@Param("dateArrivePrevue")String dateDepartPrevue);
}
