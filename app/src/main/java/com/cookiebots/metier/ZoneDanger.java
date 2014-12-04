package com.cookiebots.metier;

public class ZoneDanger {
    private Lieu centre;
    private int rayon;
    private String designation;

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
