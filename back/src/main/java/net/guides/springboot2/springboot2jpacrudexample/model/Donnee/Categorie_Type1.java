package net.guides.springboot2.springboot2jpacrudexample.model.Donnee;

public class Categorie_Type1 {
    String Nom ;
    String Valeur ;

    public Categorie_Type1 (String nom, String valeur) {
        Nom = nom;
        Valeur = valeur;
    }

    public Categorie_Type1( ) {

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