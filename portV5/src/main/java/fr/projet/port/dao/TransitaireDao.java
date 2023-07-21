package fr.projet.port.dao;

import fr.projet.port.entity.Trajet;
import fr.projet.port.entity.Transitaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface TransitaireDao extends CrudRepository<Transitaire, Long> {

   @Query(value="SELECT DISTINCT *\n" +
           "FROM transitaires trans\n" +
           "inner join trajets tra ON trans.trajet = tra.id_trajet\n" +
           "INNER JOIN port pd ON pd.id_port = tra.port_depart\n" +
           "INNER join port dest ON dest.id_port = tra.destination\n" +
           "INNER JOIN transitaire_conteneur conte ON trans.id_transitaire = conte.transitaire\n"+
           "INNER JOIN conteneur cont ON conte.conteneur = cont.id_conteneur\n"+
           "where pd.nom_port = :por\n" +
           "and dest.nom_port = :des\n"+
           "and cont.type_conteneur= :conteneur",nativeQuery=true)
   public List<Transitaire> findByPort(@Param("por")String portDepart, @Param("des") String destination, @Param("conteneur")String conteneur);

   @Query(value="SELECT * \n" +
           "FROM transitaires t \n" +
           "WHERE  t.mail_transitaire=:email\n"+
           "AND t.password_transitaire =:pass",nativeQuery = true)
   public List<Transitaire> findByMailAndPassword(@Param("email")String mail,@Param("pass")String password);
}
