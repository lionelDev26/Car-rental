package com.example.demo;


import javax.persistence.Entity;

@Entity
public class Van extends Voiture{
	private int maxWeight;
	
	public Van() {
		super();
		
	}
	
	public Van(int maxWeight) {
		super();
		this.setMaxWeight(maxWeight);
		
	}
	
	public Van(String plateNumber, String brand, int price,int maxWeight) {
		super(plateNumber,brand,price);
		this.setMaxWeight(maxWeight);
		
	}
	
	public int getMaxWeight() {
		return this.maxWeight;
	}
	
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	@Override
	public String toString() {
		return "Van [plateNumber=" + super.getPlaque() + ", brand=" + super.getMarque() + ", price=" + super.getPrix() + ", max Weight=" + maxWeight + "]";
	}
	
	
}
