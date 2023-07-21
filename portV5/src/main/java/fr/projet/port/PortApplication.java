package fr.projet.port;


import fr.projet.port.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@EnableJpaRepositories("fr.projet.port.dao")
@ComponentScan({"fr.projet.port.controller","fr.projet.port.dao","fr.projet.port.service"})
@SpringBootApplication
public class PortApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortApplication.class, args);


		Pays pays1 = new Pays("fr","france");
		Pays pays2 = new Pays("chn","chine");
		Port port1 = new Port("shanghai","shg","shanghai",pays2);
		Port port2 = new Port("marseille","mar","marseille",pays1);
		TypeConteneur typ1 = new TypeConteneur("20pieds",26.0f,false,false,false,false,false);
		TypeConteneur typ2 = new TypeConteneur("40pieds",26.0f,false,false,false,false,false);
		List<Port> listePort = new ArrayList<Port>();
		listePort.add(port1);
		Entreprise ent = new Entreprise("mateleau",78420,"24 rue perdu","Bezons",500,pays1);
		Entreprise ent2 = new Entreprise("seamer",78420,"2 allée gruyere","Houilles",600,pays1);
		Entreprise ent3 = new Entreprise("arma",78420,"13 rue vignes","Chatou",300,pays1);
		Transitaire tran1 = new Transitaire("mateleau@gmail.com",ent);
		Transitaire tran2 = new Transitaire("seamer@gmail.com",ent2);
		Armateur arma = new Armateur(ent3,"arma@gmail.com");
		Navire navire = new Navire("ever200","evergreen",10000,5000,arma,pays1);
		Trajet trajet1 = new Trajet(port1,port2,400.5f, LocalDate.of(2023,7,12),LocalDate.of(2023,7,13),LocalDate.of(2023,8,10),LocalDate.of(2023,8,12),"disponible",navire
				,tran1);
		Conteneur conte = new Conteneur("520",tran1,typ1,trajet1);
		Conteneur conte2 = new Conteneur("540",tran1,typ2,trajet1);
		Conteneur conte3 = new Conteneur("620",tran2,typ1,trajet1);
		Conteneur conte4 = new Conteneur("640",tran2,typ2,trajet1);





	}

}
