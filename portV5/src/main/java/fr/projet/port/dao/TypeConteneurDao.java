package fr.projet.port.dao;

import fr.projet.port.entity.TypeConteneur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeConteneurDao extends CrudRepository<TypeConteneur, Long> {
    @Query(value="SELECT DISTINCT *\n"+
    "FROM type_conteneurs\n"+
    "WHERE tyc_dimension=:tailleConteneur",nativeQuery = true)
    public TypeConteneur findTailleConteneur(@Param("tailleConteneur")String tailleConteneur);
}
