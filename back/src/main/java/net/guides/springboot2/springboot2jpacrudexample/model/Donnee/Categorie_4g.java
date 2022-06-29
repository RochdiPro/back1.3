package net.guides.springboot2.springboot2jpacrudexample.model.Donnee;

public class Categorie_4g {
    String Numero_Serie ;
    String Imei1  ;
    String Imei2 ;

    public Categorie_4g(String numero_Serie, String imei1, String imei2) {
        Numero_Serie = numero_Serie;
        Imei1 = imei1;
        Imei2 = imei2;
    }

    public String getNumero_Serie() {
        return Numero_Serie;
    }

    public void setNumero_Serie(String numero_Serie) {
        Numero_Serie = numero_Serie;
    }

    public String getImei1() {
        return Imei1;
    }

    public void setImei1(String imei1) {
        Imei1 = imei1;
    }

    public String getImei2() {
        return Imei2;
    }

    public void setImei2(String imei2) {
        Imei2 = imei2;
    }
}
