package fr.projet.port.dao;

import fr.projet.port.entity.Marchandise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MarchandiseDao extends CrudRepository<Marchandise, Long> {

    @Transactional
    @Modifying
    @Query(value="INSERT INTO marchandises (mrh_largeur,mrh_longueur,mrh_poids,mrh_specification,mrh_typologie,mrh_valeur_monetaire,conteneur)\n " +
            "VALUES (:largeur, :longueur, :poids, :specification, :typologie, :valeur_monetaire, :conteneur)",nativeQuery=true)
    public void addMarchandise(@Param("longueur")float longueur,
                               @Param("largeur")float largeur,
                               @Param("poids")float poids,
                               @Param("typologie")String typologie,
                               @Param("specification")String specification,
                               @Param("valeur_monetaire")float valeurMonetaire,
                               @Param("conteneur")long conteneur);
}
