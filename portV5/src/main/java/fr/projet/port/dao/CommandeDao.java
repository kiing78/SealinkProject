package fr.projet.port.dao;

import fr.projet.port.entity.Commande;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CommandeDao extends CrudRepository<Commande, Long> {
    //@Modifying permet de faire d'autre requete que les SELECT (ex : insert,update, delete)
    @Transactional
    @Modifying
    @Query(value="INSERT INTO commandes (trajet)\n " +
            "VALUES (:idTrajet)",nativeQuery = true)
    public void addCommande(@Param("idTrajet")long trajet);


}
