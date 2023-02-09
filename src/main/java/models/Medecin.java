package models;

import java.time.LocalDate;

public class Medecin {

    private int id;
    private String nomCOmplet;
    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private int salaire;
    private String adresse;
    private Specialite specialite;
    private Service service;

    public Medecin(int id, String nomCOmplet, LocalDate dateNaissance, LocalDate dateEmbauche, int salaire, String adresse) {
        this.id = id;
        this.nomCOmplet = nomCOmplet;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
        this.adresse = adresse;
    }

    public Medecin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCOmplet() {
        return nomCOmplet;
    }

    public void setNomCOmplet(String nomCOmplet) {
        this.nomCOmplet = nomCOmplet;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
