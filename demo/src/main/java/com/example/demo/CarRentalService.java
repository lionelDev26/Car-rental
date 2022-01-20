package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CarRentalService {
	
	private List<Voiture> cars = new ArrayList<Voiture>();

	private PersonneRepository personneRepository;
	private VoitureRepository voitureRepository;
	private LocationRepository locationRepository;


	
	@Autowired
	public CarRentalService(PersonneRepository personneRepository, VoitureRepository voitureRepository, LocationRepository locationRepository) {
		// cars.add(new Voiture("11AA22", "Ferrari", 1000));
		// cars.add(new Voiture("33BB44", "Porshe", 2222));
		this.personneRepository = personneRepository;
		this.voitureRepository = voitureRepository;
		this.locationRepository = locationRepository;


	}


	@GetMapping("/cars")
	public Iterable<Voiture> getListOfvoitures(){
		return voitureRepository.findAll();
	}
	
	@PostMapping("/cars")
	public void addCar(@RequestBody Voiture car) throws Exception{
		System.out.println(car);
		cars.add(car);
	}

	@GetMapping("/cars/{plateNumber}")
	public Voiture getCar(@PathVariable(value = "plateNumber") String plateNumber){
		return voitureRepository.findById(plateNumber).get();
	}

	@PutMapping("/cars/{plateNumber}")

	public void rent(@PathVariable(value = "plateNumber") String plateNumber, @RequestParam(value="rent") boolean rent, @RequestBody Date date){
		System.out.println(date);

		Voiture car = this.getCar(plateNumber);
		if(car!=null) {
			car.setLocation(rent);
			System.out.println(car);
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune voiture avec cette plaque");


	}

}
