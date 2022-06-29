package net.guides.springboot2.springboot2jpacrudexample.model.Donnee;

public class Categorie_Type4 {
    String Nom ;
    String Valeur ;

    public Categorie_Type4 (String nom, String valeur) {
        Nom = nom;
        Valeur = valeur;
    }

    public Categorie_Type4( ) {

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
