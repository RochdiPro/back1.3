package net.guides.springboot2.springboot2jpacrudexample.model.Achat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Bon_Commande")
public class Bon_Commande {

    @Id
    @Column(name = "Id_Bon_Commande")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Bon_Commande;

    @Column(name = "Id_Responsable")
    private String Id_Responsable;

    @Column(name = "Id_Fr")
    private String Id_Fr;

    @Column(name = "Date")
    private java.util.Date Date;

    @Column(name = "Type_Reglement")
    private String Type_Reglement;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Mode_Livraison")
    private String Mode_Livraison;

    @Column(name = "Date_Livraison")
    private Date Date_Livraison;

    @Column(name = "Contact")
    private String Contact;

    @Column(name = "Marge_Jour")
    private int Marge_Jour = 0;

    @Column(name = "Court")
    private double Court = 1;

    @Column(name = "Devise")
    private String Devise;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Type_Detail")
    private String Type_Detail;

    @Column(name = "Total_HT_Net")
    private double Total_HT_Net = 0;

    @Column(name = "Total_Fodec")
    private double Total_Fodec = 0;

    @Column(name = "Total_Tva")
    private double Total_Tva = 0;

    @Column(name = "Total_TTC")
    private double Total_TTC = 0;

    @Lob
    private byte[] Details ;


    public Bon_Commande( ) {

    }

    public Bon_Commande(String id_Responsable, String id_Fr, Date date, String type_Reglement, String email, String mode_Livraison, Date date_Livraison, String contact, int marge_Jour, double court, String devise, String description,  double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, String type_Detail,  byte[] details) {
        Id_Responsable = id_Responsable;
        Id_Fr = id_Fr;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,1);
        Date =cal.getTime();


        Type_Reglement = type_Reglement;
        Email = email;
        Mode_Livraison = mode_Livraison;

        cal.setTime(date_Livraison);
        cal.add(Calendar.DATE,1);
        Date_Livraison =cal.getTime();

        Contact = contact;
        Marge_Jour = marge_Jour;
        Court = court;
        Devise = devise;
        Description = description;

        Total_HT_Net = total_HT_Net;
        Total_Fodec = total_Fodec;
        Total_Tva = total_Tva;
        Total_TTC = total_TTC;
        Type_Detail = type_Detail;
        Details = details;
    }

    public Long getId_Bon_Commande() {
        return Id_Bon_Commande;
    }

    public void setId_Bon_Commande(Long id_Bon_Commande) {
        Id_Bon_Commande = id_Bon_Commande;
    }

    public String getId_Responsable() {
        return Id_Responsable;
    }

    public void setId_Responsable(String id_Responsable) {
        Id_Responsable = id_Responsable;
    }

    public String getId_Fr() {
        return Id_Fr;
    }

    public void setId_Fr(String id_Fr) {
        Id_Fr = id_Fr;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public String getType_Reglement() {
        return Type_Reglement;
    }

    public void setType_Reglement(String type_Reglement) {
        Type_Reglement = type_Reglement;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMode_Livraison() {
        return Mode_Livraison;
    }

    public void setMode_Livraison(String mode_Livraison) {
        Mode_Livraison = mode_Livraison;
    }

    public Date getDate_Livraison() {
        return Date_Livraison;
    }

    public void setDate_Livraison(Date date_Livraison) {
        Date_Livraison = date_Livraison;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public int getMarge_Jour() {
        return Marge_Jour;
    }

    public void setMarge_Jour(int marge_Jour) {
        Marge_Jour = marge_Jour;
    }

    public double getCourt() {
        return Court;
    }

    public void setCourt(double court) {
        Court = court;
    }

    public String getDevise() {
        return Devise;
    }

    public void setDevise(String devise) {
        Devise = devise;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getType_Detail() {
        return Type_Detail;
    }

    public void setType_Detail(String type_Detail) {
        Type_Detail = type_Detail;
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



    public byte[] getDetails() {
        return Details;
    }

    public void setDetails(byte[] details) {
        Details = details;
    }
}
