package fr.projet.port.init;


import java.util.HashSet;
import java.util.Set;

import fr.projet.port.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.projet.port.entity.Role;
import fr.projet.port.entity.User;


@Configuration
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    UserDao repo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("method run on DatabaseInitializer called");
        Set<Role> roles = new HashSet<>();
        Role r1 = new Role();
        r1.setLibelle("ROLE_CLIENT");
        roles.add(r1);
        Role r2 = new Role();
        r2.setLibelle("ROLE_ADMIN");
        roles.add(r2);

        User u = new User();
        u.setNom("admin");
        u.setPrenom("prenomAdmin");
        u.setUsername("admin");
        u.setPassword(passwordEncoder.encode("admin"));
        u.setRoles(roles);

        repo.save(u);
    }

}
