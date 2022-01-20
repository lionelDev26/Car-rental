package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class CarRentalClient {
	
	private static final Logger log = LoggerFactory.getLogger(CarRentalClient.class);

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<Voiture> request = new HttpEntity<>(new Voiture("11AAA22", "Volkswagen", 45));
		restTemplate.postForObject("http://localhost:8080/cars", request, Voiture.class);
		
        List cars = restTemplate.getForObject("http://localhost:8080/cars", List.class);
        log.info(cars.toString());
        
	}

}