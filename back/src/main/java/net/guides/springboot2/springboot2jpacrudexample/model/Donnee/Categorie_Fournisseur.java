package net.guides.springboot2.springboot2jpacrudexample.model.Donnee;

public class Categorie_Fournisseur {
    String Nom ;
    String Valeur ;

    public Categorie_Fournisseur(String nom, String valeur) {
        Nom = nom;
        Valeur = valeur;
    }

    public Categorie_Fournisseur( ) {

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
