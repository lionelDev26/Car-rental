package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(PersonneRepository personneRepository,LocationRepository locationRepository, VoitureRepository voitureRepository) {
		return (args) -> {
			Voiture voiture = new Voiture("11AA22", "Clio 3", 2000);

			Personne moi = new Personne(1, "Lionel", "Ngolo");
			moi.setVoiture(voiture);





			Location loc = new Location(0,"25/11/2021","26/11/2021");
			loc.louer(moi,voiture);
			loc.setConducteur(moi);

			Collection<Location>locations = new ArrayList<Location>();
			
			locations.add(loc);
			voiture.setLocations(locations);

			moi.setLocations(locations);

			locationRepository.save(loc);



		};
	}

}
