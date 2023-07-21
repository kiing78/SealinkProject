package fr.projet.port.dao;

import fr.projet.port.entity.Port;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PortDao extends CrudRepository<Port, Long> {
    @Query(value="SELECT DISTINCT *\n"+
    "FROM ports \n"+
    "WHERE prt_nom=:portDepart",nativeQuery = true)
    public Port findPortDepart(@Param("portDepart")String portDepart);

    @Query(value="SELECT DISTINCT *\n"+
    "FROM ports \n"+
    "WHERE prt_nom=:portArrivee",nativeQuery = true)
    public Port findPortArrivee(@Param("portArrivee")String portArrivee);


}
