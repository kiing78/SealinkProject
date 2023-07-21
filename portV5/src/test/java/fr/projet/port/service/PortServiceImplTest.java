package fr.projet.port.service;

import fr.projet.port.dao.PortDao;
import fr.projet.port.entity.Port;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)//pour dire qu'on veut utiliser les test unitaire avec spring
@SpringBootTest //Quand on utilise @Autowire il va préparer le context necessaire
class PortServiceImplTest {

    @Autowired
    private PortDao portDao;
    @Test
    public void shouldGetPortDepart() {
        //GIVEN
        Port port =new Port("marseille");




        //WHEN
            Port test = portDao.findPortDepart("marseille");
        //THEN
        assertEquals(port.getPortNom(),test.getPortNom());

    }

    @Test
    void getPortArrivee() {
        Port port = new Port("shanghai");


        Port portTest = portDao.findPortArrivee("shanghai");


        assertEquals(port.getPortNom(),portTest.getPortNom());
    }
}