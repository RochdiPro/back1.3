package net.guides.springboot2.springboot2jpacrudexample.model.Achat;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Fiche_BEL")
public class Fiche_BEL {
    @Id
    @Column(name = "Id_Bon_Entree_Local")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Bon_Entree_Local;

    @Column(name = "Id_Fr")
    private String Id_Fr;

    @Column(name = "Mode_Paiement")
    private String Mode_Paiement;

    @Column(name = "Charge_Transport")
    private double Charge_Transport = 0;

    @Column(name = "Autre_Charge_Fixe")
    private double Autre_Charge_Fixe = 0;

    @Column(name = "Ag_Transport")
    private String Ag_Transport;

    @Column(name = "Type")
    private String Type;

    @Column(name = "N_Facture")
    private String N_Facture;

    @Column(name = "Date_BEL")
    private Date Date_BEL;

    @Column(name = "Etat")
    private String Etat;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Local")
    private String Local;

    @Column(name = "Id_Responsable")
    private String Id_Responsable;

    @Column(name = "Type_Detail")
    private String Type_Detail;

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

    @Column(name = "Total_R_HT")
    private double Total_R_HT = 0;

    @Column(name = "Total_R_TTC")
    private double Total_R_TTC = 0;

    @Lob
    private byte[] Details;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();


    public Fiche_BEL() {

    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public Fiche_BEL(String id_Fr, String mode_Paiement, double charge_Transport, double autre_Charge_Fixe, String ag_Transport, String type, String n_Facture, Date date_BEL, String etat, String description, String local, String id_Responsable, String type_Detail, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_R_HT, double total_R_TTC, byte[] details) {
        Id_Fr = id_Fr;
        Mode_Paiement = mode_Paiement;
        Charge_Transport = charge_Transport;
        Autre_Charge_Fixe = autre_Charge_Fixe;
        Ag_Transport = ag_Transport;
        Type = type;
        N_Facture = n_Facture;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date_BEL);
        cal.add(Calendar.DATE,1);

        Date_BEL =cal.getTime();
        Etat = etat;
        Description = description;
        Local = local;
        Id_Responsable = id_Responsable;
        Type_Detail = type_Detail;
        Total_HT_Brut = total_HT_Brut;
        Total_Remise = total_Remise;
        Total_HT_Net = total_HT_Net;
        Total_Fodec = total_Fodec;
        Total_Tva = total_Tva;
        Total_TTC = total_TTC;
        Total_R_HT = total_R_HT;
        Total_R_TTC = total_R_TTC;
        Details = details;
    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    public Long getId_Bon_Entree_Local() {
        return Id_Bon_Entree_Local;
    }

    public void setId_Bon_Entree_Local(Long id_Bon_Entree_Local) {
        Id_Bon_Entree_Local = id_Bon_Entree_Local;
    }

    public String getId_Fr() {
        return Id_Fr;
    }

    public void setId_Fr(String id_Fr) {
        Id_Fr = id_Fr;
    }

    public String getMode_Paiement() {
        return Mode_Paiement;
    }

    public void setMode_Paiement(String mode_Paiement) {
        Mode_Paiement = mode_Paiement;
    }

    public double getCharge_Transport() {
        return Charge_Transport;
    }

    public void setCharge_Transport(double charge_Transport) {
        Charge_Transport = charge_Transport;
    }

    public double getAutre_Charge_Fixe() {
        return Autre_Charge_Fixe;
    }

    public void setAutre_Charge_Fixe(double autre_Charge_Fixe) {
        Autre_Charge_Fixe = autre_Charge_Fixe;
    }

    public String getAg_Transport() {
        return Ag_Transport;
    }

    public void setAg_Transport(String ag_Transport) {
        Ag_Transport = ag_Transport;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getN_Facture() {
        return N_Facture;
    }

    public void setN_Facture(String n_Facture) {
        N_Facture = n_Facture;
    }

    public Date getDate_BEL() {
        return Date_BEL;
    }

    public void setDate_BEL(Date date_BEL) {
        Date_BEL = date_BEL;
    }

    public String isReglement() {
        return Etat;
    }

    public void setReglement(String etat) {
        Etat = etat;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }

    public String getId_Responsable() {
        return Id_Responsable;
    }

    public void setId_Responsable(String id_Responsable) {
        Id_Responsable = id_Responsable;
    }

    public String getType_Detail() {
        return Type_Detail;
    }

    public void setType_Detail(String type_Detail) {
        Type_Detail = type_Detail;
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

    public double getTotal_R_HT() {
        return Total_R_HT;
    }

    public void setTotal_R_HT(double total_R_HT) {
        Total_R_HT = total_R_HT;
    }

    public double getTotal_R_TTC() {
        return Total_R_TTC;
    }

    public void setTotal_R_TTC(double total_R_TTC) {
        Total_R_TTC = total_R_TTC;
    }

    public byte[] getDetails() {
        return Details;
    }

    public void setDetails(byte[] details) {
        Details = details;
    }
}