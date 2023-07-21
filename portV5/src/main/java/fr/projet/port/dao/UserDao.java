package fr.projet.port.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import fr.projet.port.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}