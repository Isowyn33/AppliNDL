package com.cookiebots.metier;

public class Zone {
    private Lieu centre;
    private int rayon;
    private String designation;

    public Zone() {}

    public Zone(int rayon, Lieu centre, String designation) {
        this.rayon = rayon;
        this.centre = centre;
        this.designation = designation;
    }

    public void setCentre(Lieu centre) {
        this.centre = centre;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public Lieu getCentre() {
        return centre;
    }

    public int getRayon() {
        return rayon;
    }
}
