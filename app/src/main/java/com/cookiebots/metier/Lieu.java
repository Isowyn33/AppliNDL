package com.cookiebots.metier;

import java.util.List;

public class Lieu {
    private int latitude;
    private int longitude;
    private String nom;
    private List<String> listTypes;

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

    public List<String> getlistTypes() { return listTypes; }

    public void setlistTypes(List<String> listTypes) { this.listTypes = listTypes; }

}
