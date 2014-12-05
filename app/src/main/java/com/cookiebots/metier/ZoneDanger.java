package com.cookiebots.metier;

public class ZoneDanger {
    private int id;
    private float latitude;
    private float longitude;
    private int rayon;
    private String designation;
    private String danger;

    public int getID(){return id;}

    public void setId(int id){this.id = id;}

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) { this.latitude = latitude; }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public int getRayon() {
        return rayon;
    }

    public String getdanger() {
        return danger;
    }

    public void setdanger(String danger) {
        this.danger = danger;
    }
}
