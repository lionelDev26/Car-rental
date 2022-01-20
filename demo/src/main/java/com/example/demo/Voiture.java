package com.example.demo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

@Entity
public class Voiture {
	
	private String plaque;
	private String marque;
	private int prix;
	private boolean location;
	private Collection<Location>locations;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="voitureLouee")
	@JsonIgnore
	public Collection<Location> getLocations() {
		return locations;
	}

	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}

	public Voiture() {
		plaque = null;
		marque = "Non assigné";
		prix = 0;
		location = false;
		//conducteur = null;

	}
	
	public Voiture(String plaque, String marque, int prix) {
		this.plaque = plaque;
		this.marque = marque;
		this.prix = prix;
        this.location = false;

	}
	@Id
	public String getPlaque() {
		return plaque;
	}

	/*@OneToOne(mappedBy = "voiture",cascade = CascadeType.ALL)
	public Personne getConducteur() {
		return conducteur;
	}

	public void setConducteur(Personne conducteur) {
		this.conducteur = conducteur;
	}*/

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getPrix() {
		return prix;
	}
	
	public void setPrix(int prix) {
		this.prix = prix;
	}

	public boolean getLocation() {
		return this.location;
	}
	public void setLocation(boolean rent) {
		this.location = rent;
	}

	@Override
	public String toString() {
		return "Car{" +
				"plateNumber='" + plaque + '\'' +
				", brand='" + marque + '\'' +
				", price=" + prix +
				", rent=" + location +
				'}';
	}
}
