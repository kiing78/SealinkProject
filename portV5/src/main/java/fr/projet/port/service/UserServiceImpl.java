package fr.projet.port.service;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import fr.projet.port.dao.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import fr.projet.port.entity.Role;
//import fr.projet.port.entity.User;
//
//
//
//@Service
//public class UserServiceImpl implements UserService, UserDetailsService{
//    @Autowired
//    UserDao repo;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public Optional<User> findByUsername(String user) {
//        return repo.findByUsername(user);
//    }
//
//    @Override
//    public void save(User u) {
//        u.setPassword(passwordEncoder.encode(u.getPassword()));
//        u.setPassword(u.getPassword());
//        repo.save(u);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		Optional<User> optUser = findByUsername(username);
////		if(optUser.isEmpty()) {
////			throw new UsernameNotFoundException("inconnu");
////		}
////		User user = optUser.get();
//        //on récupère l'utilisateur
//        User user = findByUsername(username).
//                orElseThrow(()-> new UsernameNotFoundException("inconnu"));
//        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//        Set<Role> roles = user.getRoles();
//        for (Role role : roles) {
//            auths.add(new SimpleGrantedAuthority(role.getLibelle()));
//        }
//
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auths);
//    }
//}


