package fr.projet.port.service;

import fr.projet.port.entity.Port;

public interface PortService<T> {
    public Port getPortDepart(String portDepart);
    public T getPortArrivee(String portArrivee);
}
