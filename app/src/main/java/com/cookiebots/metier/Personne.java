package com.cookiebots.metier;

public class Personne {

    private int id;
    private int num;
    private String nom;
    private String prenom;

    public String getSante() {
        return sante;
    }

    public void setSante(String sante) {
        this.sante = sante;
    }

    private String sante;

    public int getID(){return id;}

    public void setId(int id){this.id = id;}

    public void setNum(int num) {
        this.num = num;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNum() {
        return num;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }
}
