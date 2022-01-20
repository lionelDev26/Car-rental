package com.example.demo;

import javax.persistence.*;

@Entity
public class Location {
    private int idLocation;
    private String dateDebut;
    private String dateFin;
    private Voiture voitureLouee;
    private Personne conducteur;


    public Location(int idLocation, String dateDebut, String dateFin) {
        this.idLocation = idLocation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;

    }
    public void louer(Personne p, Voiture v) {
        this.setConducteur(p);
        this.setVoitureLouee(v);
    }
    public Location() {
        idLocation = 0;
        dateDebut = null;
        dateFin = null;
        voitureLouee = null;
        conducteur = null;

    }
    @Id
    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
    @ManyToOne(cascade=CascadeType.ALL)
    public Voiture getVoitureLouee() {
        return voitureLouee;
    }

    public void setVoitureLouee(Voiture voitureLouee) {
        this.voitureLouee = voitureLouee;
    }
    @ManyToOne(cascade=CascadeType.ALL)
    public Personne getConducteur() {
        return conducteur;
    }

    public void setConducteur(Personne conducteur) {
        this.conducteur = conducteur;
    }
}
