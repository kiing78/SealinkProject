package fr.projet.port.controller;

import fr.projet.port.entity.*;
import fr.projet.port.service.PortService;
import fr.projet.port.service.TrajetService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TrajetControllerTest {
    @Autowired
    private PortService portService;
    @Autowired
    private ConteneurController conteneurController;
    @Autowired
    private TrajetService trajetService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDemandeTrajetEndPoint() throws Exception{
        mockMvc.perform(post("/sealink/demandeTrajet"))
        .andExpect(status().isOk())
                .andExpect(content().string("Hello, world"));
    }

    @Test
    void demandeTrajet() throws ParseException {
        //GIVEN
        /*
        Port portDepart = new Port("marseille");
        Port portArrivee = new Port("shanghai");
        Transitaire transi = new Transitaire("mateleau");
        TypeConteneur typeConteneur = new TypeConteneur("20pieds");
        List<Conteneur> listeConteneur = new ArrayList<Conteneur>();
        Conteneur conte = new Conteneur(typeConteneur);
        listeConteneur.add(conte);
        Trajet testTrajet = new Trajet (1,5000.0f,29, "disponible",transi,listeConteneur);
        List<Trajet> listeTrajet = new ArrayList<Trajet>();
        listeTrajet.add(testTrajet);
        /*

        Transitaire transi = new Transitaire("mateleau");




        Trajet objectTrajet = new Trajet(portDepart,portArrivee,  listeConteneur,transi);
        List<Trajet> testTrajet = new ArrayList<Trajet>();
        testTrajet.add(objectTrajet);

         */


        /*
        //WHEN
        Port testP = portService.getPortDepart("marseille");
        Port test = (Port) portService.getPortArrivee("shanghai");
       List<Trajet> trajet = trajetService.demandeTrajet(testP,test,conteneurController.choisirTaille("20pieds"));



        //THEN
        assertEquals(listeTrajet.get(0),trajet.get(0));
        */
    }
}