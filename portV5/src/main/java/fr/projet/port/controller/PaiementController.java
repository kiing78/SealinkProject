package fr.projet.port.controller;


;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
public class PaiementController {


   /**
    * permet d'envoyer sur le formulaire paiement de Stripe puis si le paiement est réussi d'envoyer dans l'url
    * commande/passerCommande ou si le client veut annulé son paiement de renvoyer vers l'accueil avec l'url commande/home
    * @return
    * @throws StripeException
    */
   @PostMapping("/create-checkout-session")
   public ModelAndView payer() throws StripeException {
      Stripe.apiKey = "sk_test_51MzEmPHnHgns4r51Dv4RSgLvceZ6Mkcho8cK3zLkYmky8UFjDjnIVsFbY4nqdhovsKIsqCwSvOAn9SB8uvdefjem001LZV9E2r";

      SessionCreateParams params = SessionCreateParams.builder()
              .setMode(SessionCreateParams.Mode.PAYMENT)
              //renvoie vers l'url passerCommande du controller CommandeController
              .setSuccessUrl("http://localhost:8080/sealink/commande/passerCommande")
              //url qui renvoi vers l'accueil si le client décide d'annuler son paiement
              .setCancelUrl("http://localhost:8080/sealink/commande/home")
              .addLineItem(
                      SessionCreateParams.LineItem.builder()
                              .setQuantity(1L)
                              .setPriceData(
                                      SessionCreateParams.LineItem.PriceData.builder()
                                              //la devise
                                              .setCurrency("usd")
                                              //le montant du prix
                                              .setUnitAmount(2000L)

                                              .setProductData(
                                                      SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                              //le nom de la marchandise
                                                              .setName("Commande")
                                                              .build())
                                              .build())
                              .build())
              .build();

      Session session = Session.create(params);
      ModelAndView mav = new ModelAndView("redirect:"+session.getUrl());
      return mav;
   }






}
