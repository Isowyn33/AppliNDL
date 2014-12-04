package com.cookiebots.metier;

public class Personne {

    private int num;
    private String nom;
    private String prenom;

    public Personne() {

    }

    public Personne(String nom, String prenom, int num) {
        this.nom = nom;
        this.prenom = prenom;

        this.num = num;
    }

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
