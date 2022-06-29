package net.guides.springboot2.springboot2jpacrudexample.controller.Stock.type;

public class Detail_Stock_Local {

    Long Id_Produit ;
    Integer Qte;
    Integer Qte_Local;
    String Local ;
    double Prix ;


    public Detail_Stock_Local(Long id_Produit, Integer qte, Integer qte_Local, String local, double prix) {
        Id_Produit = id_Produit;
        Qte = qte;
        Qte_Local = qte_Local;
        Local = local;
        Prix = prix;
    }

    public Detail_Stock_Local( ) {

    }

    public Long getId_Produit() {
        return Id_Produit;
    }

    public void setId_Produit(Long id_Produit) {
        Id_Produit = id_Produit;
    }

    public Integer getQte() {
        return Qte;
    }

    public void setQte(Integer qte) {
        Qte = qte;
    }

    public Integer getQte_Local() {
        return Qte_Local;
    }

    public void setQte_Local(Integer qte_Local) {
        Qte_Local = qte_Local;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }

    public double getPrix() {
        return Prix;
    }

    public void setPrix(double prix) {
        Prix = prix;
    }
}

