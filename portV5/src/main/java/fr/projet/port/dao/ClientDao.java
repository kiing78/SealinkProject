package fr.projet.port.dao;

import fr.projet.port.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends CrudRepository<Client,Long> {

    @Query(value="SELECT DISTINCT *\n" +
            "FROM clients c\n" +
            "WHERE c.mail_client=:email\n" +
            "AND c.password_client =:pass",nativeQuery = true)
    public List<Client> findByMailAndPassword(@Param("email")String mail, @Param("pass")String password);
}
