 package com.mycompany.gestionetudiants.model;

public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private String classe;
    private String cin;

    public Etudiant(int id, String nom, String prenom, String classe, String cin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.cin = cin;
    }

    public Etudiant(String nom, String prenom, String classe, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.cin = cin;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getClasse() {
        return classe;
    }

    public String getCin() {
        return cin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

}
