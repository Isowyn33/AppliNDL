package com.cookiebots.metier;

import java.util.List;

public class ZoneDanger {
    private int id;
    private Lieu centre;
    private int rayon;
    private String designation;
    private List<Dangers> dangers;

    public int getID(){return id;}

    public void setId(int id){this.id = id;}

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

    public List<Dangers> getDangers() {
        return dangers;
    }

    public void setDangers(List<Dangers> dangers) {
        this.dangers = dangers;
    }
}
