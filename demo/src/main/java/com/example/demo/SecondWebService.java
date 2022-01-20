package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondWebService {

	/**
	 * pour le request param : http://localhost:8080/voitures?marque=ferrari
	 */
	@GetMapping("/voitures")
	public List<Voiture> liste(@RequestParam(value = "marque") String brand){
		List<Voiture> voitures = new ArrayList<Voiture>();
		voitures.add(new Voiture("DD55FF", brand, 10));
		voitures.add(new Voiture("EE66GG", brand, 10000));
		System.out.println("Deuxième WS retourne : " + voitures);
		return voitures;
	}
	
	@GetMapping("/voitures/{prix}")
	public Voiture getVoiture(@PathVariable(value = "prix") int price) {
		System.out.println(price);
		return new Voiture("DD55FF", "Fiat", price);
	}
	

	
	@DeleteMapping("/voitures")
	public void delete(@RequestBody Voiture car) {
		System.out.println(car);
	}
	
}
