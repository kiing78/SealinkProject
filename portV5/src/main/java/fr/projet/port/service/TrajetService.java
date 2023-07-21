package fr.projet.port.service;

import fr.projet.port.entity.Port;
import fr.projet.port.entity.Trajet;
import fr.projet.port.entity.TypeConteneur;

import java.time.LocalDate;
import java.util.List;

public interface TrajetService<T> {
    public List<T> demandeTrajet(Port portDepart, Port destination, TypeConteneur conteneur);
    public boolean verifDemandeTrajet(String portDepart, String destination);
    public boolean verifChoixTrajet(long id);
    public void setTrajetId(long id);
    public long getTrajetId();
    public Trajet getDateDepartPrevue(String dateDepartPrevue);

    public Trajet getDateArriveePrevue(String dateArriveePrevue);
}
