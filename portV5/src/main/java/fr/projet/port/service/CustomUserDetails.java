package fr.projet.port.service;
/*
import fr.projet.port.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private User user; // Supposons qu'il existe une classe User qui représente votre modèle de données

    public CustomUserDetails(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        // Renvoyer le mot de passe de l'utilisateur
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // Renvoyer le nom d'utilisateur de l'utilisateur
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    // Autres méthodes à implémenter (isAccountNonExpired, isAccountNonLocked, etc.)
}

*/