package net.guides.springboot2.springboot2jpacrudexample.model.Donnee;

public class Categorie_Region {
    String Nom ;
    String Valeur ;

    public Categorie_Region (String nom, String valeur) {
        Nom = nom;
        Valeur = valeur;
    }

    public Categorie_Region( ) {

    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getValeur() {
        return Valeur;
    }

    public void setValeur(String valeur) {
        Valeur = valeur;
    }
}