package net.guides.springboot2.springboot2jpacrudexample.controller.Stock.type;

public class Detail_Produit_Json {

    String N_Serie;
    String E1;
    String E2;
    String Fornisseur;
    String Local ;

    public Detail_Produit_Json(String n_Serie, String e1, String e2, String fornisseur, String local) {
        N_Serie = n_Serie;
        E1 = e1;
        E2 = e2;
        Fornisseur = fornisseur;
        Local = local;
    }

    public Detail_Produit_Json() {

    }

    public String getN_Serie() {
        return N_Serie;
    }

    public void setN_Serie(String n_Serie) {
        N_Serie = n_Serie;
    }

    public String getE1() {
        return E1;
    }

    public void setE1(String e1) {
        E1 = e1;
    }

    public String getE2() {
        return E2;
    }

    public void setE2(String e2) {
        E2 = e2;
    }

    public String getFornisseur() {
        return Fornisseur;
    }

    public void setFornisseur(String fornisseur) {
        Fornisseur = fornisseur;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }
}
