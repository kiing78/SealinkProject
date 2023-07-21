package fr.projet.port.service;

import fr.projet.port.dao.TypeConteneurDao;
import fr.projet.port.entity.TypeConteneur;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TypeConteneurImplTest {
    @Autowired
    private TypeConteneurDao typeConteneurDao;

    @Test
    void getTailleConteneur() {
        //GIVEN
        TypeConteneur valeurAttendu = new TypeConteneur("20pieds");

        //WHEN
        TypeConteneur test = typeConteneurDao.findTailleConteneur("20pieds");

        //assertEquals(valeurAttendu.getDimension(),test.getDimension());
    }
}