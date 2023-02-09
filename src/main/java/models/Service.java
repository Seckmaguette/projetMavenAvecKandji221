package models;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Service {

    private int id;
    private String libelle;
    private List<Medecin> medecins;
    private List<Specialite> specialites;

    public Service(int id) {
        this.id = id;
        this.libelle = libelle;
    }

    public Service() {
    }

    public void saisi(){

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Entrer le nom du service");
            libelle = sc.next();

        }while(libelle.isEmpty());
    }
    public Service(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }


    public List<Specialite> getSpecialites() {
        return specialites;
    }

    public void setSpecialites(List<Specialite> specialites) {
        this.specialites = specialites;
    }

    @Override
    public boolean equals(Object obj) {
        return  ((Service)obj).getId() == this.id;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
