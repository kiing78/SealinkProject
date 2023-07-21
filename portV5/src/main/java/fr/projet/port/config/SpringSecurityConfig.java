package fr.projet.port.config;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


//claase qui permet de recevoir les filtres
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        //authorizeRequests permet de définir les roles
        //permet d'autoriser les requetes correspondant aux antMatchers ci-dessous
        http.authorizeRequests()
                //antMatchers permet de définir l'association des roles avec les pages
                //permet de verouiller l'accès du chemin au role qui est dans hasRole
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                //anyRequest() : toute les autres requetes quand c'est suivi de authenticated
                //ça veut dire que  toute les autres requetes doivent etre authentifier par le login form
                //authenticated permet d'utiliser le formulaire formLogin()
                //authenticated : URL accessible à n'importe quel utilisateur authentifé independamment de ses roles
                //et autorisations
                .anyRequest().authenticated()
                .and()
                //l'authentification est autorisé avec le formulaire login
                .formLogin();




    }



    /*le filtre AuthenticationManagerBuilder permet de créer des identifiants encodés mais aussi de les assigner à des
    roles
    on déclare 2 utilisateurs avec des password crypté, l'user a accès uniquement au page /user
    et l'admin a accès au page /user et /admin



        //inMemoryAuthentication : les identifiants créer seront stocké dans la mémoire au lieu d'etre stocké
        //dans un jeton(JWT) ou dans la BDD
        //si je veux une connexion avec BDD :remplacer auth.inMemoryAuthentication() par auth.jdbcAuthentication()
        @Bean
        public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(User.withUsername("user")
                    .password(bCryptPasswordEncoder.encode("userPass"))
                    .roles("USER")
                    .build());
            manager.createUser(User.withUsername("admin")
                    .password(bCryptPasswordEncoder.encode("adminPass"))
                    .roles("USER", "ADMIN")
                    .build());
            return manager;
        }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
*/