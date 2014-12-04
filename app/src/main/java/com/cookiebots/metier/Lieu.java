package com.cookiebots.metier;

public class Lieu {
    private int latitude;
    private int longitude;
    private String nom;

    public Lieu() {}

    public Lieu(int latitude, int longitude, String nom) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
