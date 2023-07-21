package fr.projet.port.service;
import java.util.Optional;

import fr.projet.port.entity.User;

public interface UserService {

    Optional<User> findByUsername(String user);

    void save(User u);
}