package fr.projet.port.service;

import fr.projet.port.dao.TypeConteneurDao;
import fr.projet.port.entity.TypeConteneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeConteneurImpl implements TypeConteneurService<TypeConteneur> {
    @Autowired
    private TypeConteneurDao typeConteneurDao;

    @Override
    public TypeConteneur getTailleConteneur(String tailleConteneur) {
        return typeConteneurDao.findTailleConteneur(tailleConteneur);
    }
}
