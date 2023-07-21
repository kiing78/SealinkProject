package fr.projet.port.service;

import java.util.List;
import java.util.stream.Collectors;

import fr.projet.port.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.port.dto.UserDTO;
import fr.projet.port.entity.User;


@Service
@Transactional
public class AuthService {
    @Autowired
    UserDao userRepo;

    @Transactional(readOnly = true)
    public UserDTO login(String username, String password) throws UsernameNotFoundException {
        System.out.println("username : "+ username);
        System.out.println("password : "+ password);
        User user = userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("inconnu"));

        boolean passwordCorrect = BCrypt.checkpw(password, user.getPassword());
        if(!passwordCorrect) throw new UsernameNotFoundException("inconnu");

        UserDTO userDTO = new UserDTO();
        userDTO.setNom(user.getNom());
        userDTO.setPrenom(user.getPrenom());
        userDTO.setUsername(user.getUsername());
        List<String> roles = user.getRoles().stream().map(r ->{
            return r.getLibelle();
        }).collect(Collectors.toList());
        userDTO.setRoles(roles);
        return userDTO ;
    }
}
