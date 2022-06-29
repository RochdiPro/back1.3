package net.guides.springboot2.springboot2jpacrudexample.model.Stock;

import javax.persistence.*;

@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @Column(name = "Id_Produit")
    private Long Id_Produit ;

    @Column(name = "Ref_Fr")
    private String Ref_Fr ;

    @Column(name = "Quantite")
    private int Quantite= 0 ;

    @Column(name = "Ancien_Prix")
    private Double Ancien_Prix  ;

    @Column(name = "Prix")
    private Double Prix  ;

    @Column(name = "Valeur_Produit")
    private Double Valeur_Produit = Double.valueOf(1);

    @Column(name = "Type_Detail")
    private String Type_Detail;

    @Lob
    private byte[] Details ;


    public Stock(Long id_Produit, String ref_Fr, int quantite, Double ancien_Prix, Double prix, String type_Detail, byte[] details) {
        Id_Produit = id_Produit;
        Ref_Fr = ref_Fr;
        Quantite = quantite;
        Ancien_Prix = ancien_Prix;
        Prix = prix;
        Type_Detail = type_Detail;
        Details = details;
    }

    public Stock( ) {

    }


    public Long getId_Produit() {
        return Id_Produit;
    }

    public void setId_Produit(Long id_Produit) {
        Id_Produit = id_Produit;
    }

    public String getRef_Fr() {
        return Ref_Fr;
    }

    public void setRef_Fr(String ref_Fr) {
        Ref_Fr = ref_Fr;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }

    public Double getAncien_Prix() {
        return Ancien_Prix;
    }

    public void setAncien_Prix(Double ancien_Prix) {
        Ancien_Prix = ancien_Prix;
    }

    public Double getPrix() {
        return Prix;
    }

    public void setPrix(Double prix) {
        Prix = prix;
    }

    public String getType_Detail() {
        return Type_Detail;
    }

    public void setType_Detail(String type_Detail) {
        Type_Detail = type_Detail;
    }

    public byte[] getDetails() {
        return Details;
    }

    public void setDetails(byte[] details) {
        Details = details;
    }

    public Double getValeur_Produit() {
        return Valeur_Produit;
    }

    public void setValeur_Produit(Double valeur_Produit) {
        Valeur_Produit = valeur_Produit;
    }
}
