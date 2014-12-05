package com.cookiebots.metier;

import java.util.List;

public class Lieu {
    private int id;
    private float latitude;
    private float longitude;
    private String nom;
    private List<String> listTypes;

    public int getID(){return id;}

    public void setId(int id){this.id = id;}

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public List<String> getlistTypes() { return listTypes; }

    public void setlistTypes(List<String> listTypes) { this.listTypes = listTypes; }

}
