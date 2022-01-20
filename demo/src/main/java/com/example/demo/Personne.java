package com.example.demo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Personne {
    private int identifiant;
    private String prenom;
    private String nom;
    private Voiture voiture;
    private Collection<Location> locations;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="conducteur")
    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }

    public Personne(int identifiant, String prenom, String nom) {
        this.identifiant = identifiant;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Personne() {
        identifiant = 0;
        prenom = "Aucun prénom";
        nom = "Aucun nom";
        voiture = null;
    }

    @Id
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }
@OneToOne(cascade=CascadeType.ALL)
    public Voiture getVoiture() {
        return voiture;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", voiture='" + voiture + '\'' +
                '}';
    }
}
