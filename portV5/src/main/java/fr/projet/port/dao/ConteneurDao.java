package fr.projet.port.dao;

import fr.projet.port.entity.Conteneur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteneurDao extends CrudRepository<Conteneur,Long> {
    @Query(value = "SELECT DISTINCT *\n"+
    "FROM conteneurs \n"+
    "WHERE cnt_nb_conteneur= :nbConteneur",nativeQuery = true)
    public Conteneur findByNbConteneur(@Param("nbConteneur")int nbConteneur);
}
