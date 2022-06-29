package net.guides.springboot2.springboot2jpacrudexample.model.Donnee;

public class Categorie_Local {
    String Nom ;
    String Valeur ;

    public Categorie_Local(String nom, String valeur) {
        Nom = nom;
        Valeur = valeur;
    }
    public Categorie_Local( ) {

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
