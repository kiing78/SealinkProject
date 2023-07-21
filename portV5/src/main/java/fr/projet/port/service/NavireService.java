package fr.projet.port.service;

import fr.projet.port.entity.*;


import java.time.LocalDate;
import java.util.List;

public interface NavireService<T> {
    public List<T> renseignerInfoResa(String portDepart,
                                      String portArrivee,
                                      String dateDepartPrevue,
                                      String dateArriveePrevue,
                                      String tailleConteneur);
}
