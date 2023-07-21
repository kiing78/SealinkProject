package fr.projet.port.controller;

import fr.projet.port.entity.User;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
public class LoginController {

  @PostMapping("/connexion")
    public String testConnexion(@Valid @ModelAttribute("userAccount")User userAccount,
                                      BindingResult result, ModelMap map){
    if(result.hasErrors()){
      return "error";
    }
    else{
      return "success";
    }
  }

  @GetMapping("/sealink/versConnexion")
  public ModelAndView envoyerConnexion(){
    return new ModelAndView("connexion");
  }
}
