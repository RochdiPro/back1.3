package net.guides.springboot2.springboot2jpacrudexample.model.Vente;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Bon_Commande_Client")
public class Bon_Commande_Client  {

    @javax.persistence.Id
    @Column(name = "Id_Bon_Commande ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Bon_Commande  ;


    @Column(name = "Id_Clt")
    private String Id_Clt ;

    @Column(name = "Type")
    private String Type  ;

    @Column(name = "Etat")
    private String Etat ;

    @Column(name = "Total_HT_Brut")
    private double Total_HT_Brut = 0;

    @Column(name = "Total_Remise")
    private double Total_Remise = 0;

    @Column(name = "Total_HT_Net")
    private double Total_HT_Net = 0;

    @Column(name = "Total_Fodec")
    private double Total_Fodec = 0;

    @Column(name = "Total_Tva")
    private double Total_Tva = 0;

    @Column(name = "Total_TTC")
    private double Total_TTC = 0;

    @Column(name = "Total_Retenues")
    private double Total_Retenues  ;

    @Column(name = "Description")
    private String Description ;

    @Column(name = "Id_Responsable")
    private String Id_Responsable;

    @Column(name = "Mode_Paiement")
    private String Mode_Paiement;

    @Lob
    private byte[] Detail;

    @Column(name = "Frais_Livraison")
    private double Frais_Livraison =0 ;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();

    public Bon_Commande_Client(String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_Retenues, String description, String id_Responsable, String mode_Paiement, byte[] detail, double frais_Livraison, Date date_Creation) {
        Id_Clt = id_Clt;
        Type = type;
        Etat = etat;
        Total_HT_Brut = total_HT_Brut;
        Total_Remise = total_Remise;
        Total_HT_Net = total_HT_Net;
        Total_Fodec = total_Fodec;
        Total_Tva = total_Tva;
        Total_TTC = total_TTC;
        Total_Retenues = total_Retenues;
        Description = description;
        Id_Responsable = id_Responsable;
        Mode_Paiement = mode_Paiement;
        Detail = detail;
        Frais_Livraison = frais_Livraison;
        Date_Creation = date_Creation;
    }

    public Long getId_Bon_Commande() {
        return Id_Bon_Commande;
    }

    public void setId_Bon_Commande(Long id_Bon_Commande) {
        Id_Bon_Commande = id_Bon_Commande;
    }

    public String getId_Clt() {
        return Id_Clt;
    }

    public void setId_Clt(String id_Clt) {
        Id_Clt = id_Clt;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public double getTotal_HT_Brut() {
        return Total_HT_Brut;
    }

    public void setTotal_HT_Brut(double total_HT_Brut) {
        Total_HT_Brut = total_HT_Brut;
    }

    public double getTotal_Remise() {
        return Total_Remise;
    }

    public void setTotal_Remise(double total_Remise) {
        Total_Remise = total_Remise;
    }

    public double getTotal_HT_Net() {
        return Total_HT_Net;
    }

    public void setTotal_HT_Net(double total_HT_Net) {
        Total_HT_Net = total_HT_Net;
    }

    public double getTotal_Fodec() {
        return Total_Fodec;
    }

    public void setTotal_Fodec(double total_Fodec) {
        Total_Fodec = total_Fodec;
    }

    public double getTotal_Tva() {
        return Total_Tva;
    }

    public void setTotal_Tva(double total_Tva) {
        Total_Tva = total_Tva;
    }

    public double getTotal_TTC() {
        return Total_TTC;
    }

    public void setTotal_TTC(double total_TTC) {
        Total_TTC = total_TTC;
    }

    public double getTotal_Retenues() {
        return Total_Retenues;
    }

    public void setTotal_Retenues(double total_Retenues) {
        Total_Retenues = total_Retenues;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getId_Responsable() {
        return Id_Responsable;
    }

    public void setId_Responsable(String id_Responsable) {
        Id_Responsable = id_Responsable;
    }

    public String getMode_Paiement() {
        return Mode_Paiement;
    }

    public void setMode_Paiement(String mode_Paiement) {
        Mode_Paiement = mode_Paiement;
    }

    public byte[] getDetail() {
        return Detail;
    }

    public void setDetail(byte[] detail) {
        Detail = detail;
    }

    public double getFrais_Livraison() {
        return Frais_Livraison;
    }

    public void setFrais_Livraison(double frais_Livraison) {
        Frais_Livraison = frais_Livraison;
    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }
}
