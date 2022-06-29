package net.guides.springboot2.springboot2jpacrudexample.model.wms;

public class Quantite_Fiche_Technique {

    Long  id ;
    double Qte ;
    String fiche_Technique ;
    String nom_Article;

    public Quantite_Fiche_Technique( ) {

    }

    public Quantite_Fiche_Technique(  Long id, double qte, String fiche_Technique, String nom) {

        this.id = id;
        Qte = qte;
        this.fiche_Technique = fiche_Technique;
        this.nom_Article=nom;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQte() {
        return Qte;
    }

    public void setQte(double qte) {
        Qte = qte;
    }

    public String getFiche_Technique() {
        return fiche_Technique;
    }

    public void setFiche_Technique(String fiche_Technique) {
        this.fiche_Technique = fiche_Technique;
    }

    public String getNom_Article() {
        return nom_Article;
    }

    public void setNom_Article(String nom_Article) {
        this.nom_Article = nom_Article;
    }
}
