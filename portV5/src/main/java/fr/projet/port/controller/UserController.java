package fr.projet.port.controller;

/*
import fr.projet.port.entity.User;
import fr.projet.port.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;

@Controller
@RequestMapping("sealink/inscription")
public class UserController {

    @Autowired
    private UserService userService;

   // @Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/versInscription")
    public ModelAndView versInscription(){
        ModelAndView mav = new ModelAndView("inscription");

        return mav;
    }

    @PostMapping("/role")
    public void addUser(@Param("email")String email,
                        @Param("password") String password){
       // HashSet<Role> roles = new HashSet<Role>();
        //roles.add(role);
        User user = new User(email,password);
        userService.saveUsers(user);




    }

    @GetMapping("/addClient")
    public void addClient(){

    }
    @GetMapping("/addTransitaire")
    public void addTransitaire(){

    }
    @GetMapping("/addArmateur")
    public void addArmateur(){

    }


}
*/