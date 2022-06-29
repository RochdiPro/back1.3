package net.guides.springboot2.springboot2jpacrudexample.model.Achat;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Fiche_BEI")
public class Fiche_BEI {

    @Id
    @Column(name = "Id_Bon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Bon;

    @Column(name = "Id_Responsable")
    private String Id_Responsable;

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

    @Column(name = "Etat")
    private String Etat;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Local")
    private String Local;

    @Column(name = "Titre")
    private String Titre;

    @Column(name = "Transfert")
    private String Transfert;

    @Column(name = "Lc")
    private String Lc;

    @Column(name = "Fed")
    private String Fed;

    @Column(name = "Mode_Livraison")
    private String Mode_Livraison;

    @Column(name = "Type_Livraison")
    private String Type_Livraison;

    @Column(name = "Charge_Transitaire")
    private double Charge_Transitaire= 0;

    @Column(name = "Charge_Banque")
    private double Charge_Banque= 0;

    @Column(name = "Charge_Magasin")
    private double Charge_Magasin= 0;

    @Column(name = "Ag_Transitaire")
    private String Ag_Transitaire;

    @Column(name = "N_Preforma")
    private String N_Preforma;

    @Column(name = "Date_Proforma")
    private Date Date_Proforma;

    @Column(name = "Date_Facture")
    private Date Date_Facture;

    @Column(name = "Date_Livraison")
    private Date Date_Livraison;

    @Column(name = "Date_Paiement")
    private Date Date_Paiement;

    @Column(name = "Date_Be")
    private Date Date_Be;

    @Column(name = "Charge_Transport_Importation")
    private double Charge_Transport_Importation= 0;

    @Column(name = "Charge_Assurance_Importation")
    private double Charge_Assurance_Importation= 0;

     @Column(name = "Cours")
    private double Cours= 1;

    @Column(name = "Devise")
    private String Devise;

    @Column(name = "Transport_Inclut")
    private boolean Transport_Inclut = false;



    @Column(name = "Total_Fodec")
    private double Total_Fodec = 0;

    @Column(name = "Total_Tva")
    private double Total_Tva = 0;



    @Column(name = "Total_R_HT")
    private double Total_R_HT = 0;



    @Column(name = "Totale_Declare")
    private double Totale_Declare = 0;

    @Column(name = "Totale_Taxe")
    private double Totale_Taxe = 0;

    @Column(name = "Totale_Tva")
    private double Totale_Tva = 0;

    @Column(name = "Penalite")
    private double Penalite = 0;

    @Column(name = "Type_Detail")
    private String Type_Detail;

    @Lob
    private byte[] Details ;

    @Column(name = "type_Doc_Banque")
    private String Type_Doc_Banque;

    @Lob
    private byte[] Doc_Banque ;

    @Column(name = "Type_Doc_Importation")
    private String Type_Doc_Importation;

    @Lob
    private byte[] Doc_Importation ;

    @Column(name = "Type_Doc_Transitaire")
    private String Type_Doc_Transitaire;

    @Lob
    private byte[] Doc_Transitaire ;

    @Column(name = "Type_Doc_Transport")
    private String Type_Doc_Transport;

    @Lob
    private byte[] Doc_Transport ;




    Date Date_Creation=java.util.Calendar.getInstance().getTime();


    public Fiche_BEI(String id_Responsable, String id_Fr, String mode_Paiement, double charge_Transport, double autre_Charge_Fixe, String ag_Transport, String type, String n_Facture, String etat, String description, String local, String titre, String transfert, String lc, String fed, String mode_Livraison, String type_Livraison, double charge_Transitaire, double charge_Banque, double charge_Magasin, String ag_Transitaire, String n_Preforma, Date date_Proforma, Date date_Facture, Date date_Livraison, Date date_Paiement, Date date_Be, double charge_Transport_Importation, double charge_Assurance_Importation, double cours, String devise, boolean transport_Inclut,  double total_Fodec, double total_Tva, double total_R_HT,   double totale_Declare, double totale_Taxe, double totale_Tva, double penalite, String type_Detail, byte[] details ,  String type_Doc_Banque, byte[] Doc_Banque ,  String type_Doc_Importation, byte[] Doc_Importation ,  String type_Doc_Transitaire, byte[] Doc_Transitaire ,  String type_Doc_Transport, byte[] Doc_Transport       ) {
        Id_Responsable = id_Responsable;
        Id_Fr = id_Fr;
        Mode_Paiement = mode_Paiement;
        Charge_Transport = charge_Transport;
        Autre_Charge_Fixe = autre_Charge_Fixe;
        Ag_Transport = ag_Transport;
        Type = type;
        N_Facture = n_Facture;
        Etat = etat;
        Description = description;
        Local = local;
        Titre = titre;
        Transfert = transfert;
        Lc = lc;
        Fed = fed;
        Mode_Livraison = mode_Livraison;
        Type_Livraison = type_Livraison;
        Charge_Transitaire = charge_Transitaire;
        Charge_Banque = charge_Banque;
        Charge_Magasin = charge_Magasin;
        Ag_Transitaire = ag_Transitaire;
        N_Preforma = n_Preforma;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date_Proforma);
        cal.add(Calendar.DATE,1);
        Date_Proforma =cal.getTime();


        cal.setTime(date_Facture);
        cal.add(Calendar.DATE,1);
        Date_Facture = cal.getTime();


        cal.setTime(date_Livraison);
        cal.add(Calendar.DATE,1);
        Date_Livraison =cal.getTime();

        cal.setTime(date_Paiement);
        cal.add(Calendar.DATE,1);
        Date_Paiement = cal.getTime();

        cal.setTime(date_Be);
        cal.add(Calendar.DATE,1);
        Date_Be =  cal.getTime();

        Charge_Transport_Importation = charge_Transport_Importation;
        Charge_Assurance_Importation = charge_Assurance_Importation;
        Cours = cours;
        Devise = devise;
        Transport_Inclut = transport_Inclut;

        Total_Fodec = total_Fodec;
        Total_Tva = total_Tva;

        Total_R_HT = total_R_HT;

        Totale_Declare = totale_Declare;
        Totale_Taxe = totale_Taxe;
        Totale_Tva = totale_Tva;
        Penalite = penalite;
        Type_Detail = type_Detail;
        Details = details;
        Type_Doc_Banque = type_Doc_Banque;
        this.Doc_Banque  = Doc_Banque;
        Type_Doc_Importation = type_Doc_Importation;
        this.Doc_Importation = Doc_Importation;
        Type_Doc_Transitaire = type_Doc_Transitaire;
        this.Doc_Transitaire = Doc_Transitaire;
        Type_Doc_Transport = type_Doc_Transport;
        this.Doc_Transport = Doc_Transport;
    }

    public Fiche_BEI(String id_Responsable, String id_Fr, String mode_Paiement, double charge_Transport, double autre_Charge_Fixe, String ag_Transport, String type, String n_Facture, String etat, String description, String local, String titre, String transfert, String lc, String fed, String mode_Livraison, String type_Livraison, double charge_Transitaire, double charge_Banque, double charge_Magasin, String ag_Transitaire, String n_Preforma, Date date_Proforma, Date date_Facture, Date date_Livraison, Date date_Paiement, Date date_Be, double charge_Transport_Importation, double charge_Assurance_Importation, double cours, String devise, boolean transport_Inclut,  double total_Fodec, double total_Tva, double total_R_HT,   double totale_Declare, double totale_Taxe, double totale_Tva, double penalite, String type_Detail, byte[] details ) {
        Id_Responsable = id_Responsable;
        Id_Fr = id_Fr;
        Mode_Paiement = mode_Paiement;
        Charge_Transport = charge_Transport;
        Autre_Charge_Fixe = autre_Charge_Fixe;
        Ag_Transport = ag_Transport;
        Type = type;
        N_Facture = n_Facture;
        Etat = etat;
        Description = description;
        Local = local;
        Titre = titre;
        Transfert = transfert;
        Lc = lc;
        Fed = fed;
        Mode_Livraison = mode_Livraison;
        Type_Livraison = type_Livraison;
        Charge_Transitaire = charge_Transitaire;
        Charge_Banque = charge_Banque;
        Charge_Magasin = charge_Magasin;
        Ag_Transitaire = ag_Transitaire;
        N_Preforma = n_Preforma;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date_Proforma);
        cal.add(Calendar.DATE,1);
        Date_Proforma =cal.getTime();


        cal.setTime(date_Facture);
        cal.add(Calendar.DATE,1);
        Date_Facture = cal.getTime();


        cal.setTime(date_Livraison);
        cal.add(Calendar.DATE,1);
        Date_Livraison =cal.getTime();

        cal.setTime(date_Paiement);
        cal.add(Calendar.DATE,1);
        Date_Paiement = cal.getTime();

        cal.setTime(date_Be);
        cal.add(Calendar.DATE,1);
        Date_Be =  cal.getTime();

        Charge_Transport_Importation = charge_Transport_Importation;
        Charge_Assurance_Importation = charge_Assurance_Importation;
        Cours = cours;
        Devise = devise;
        Transport_Inclut = transport_Inclut;

        Total_Fodec = total_Fodec;
        Total_Tva = total_Tva;

        Total_R_HT = total_R_HT;

        Totale_Declare = totale_Declare;
        Totale_Taxe = totale_Taxe;
        Totale_Tva = totale_Tva;
        Penalite = penalite;
        Type_Detail = type_Detail;
        Details = details;
    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    public Long getId_Bon() {
        return Id_Bon;
    }

    public void setId_Bon(Long id_Bon) {
        Id_Bon = id_Bon;
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

    public double getCours() {
        return Cours;
    }

    public void setCours(double cours) {
        Cours = cours;
    }

    public double getPenalite() {
        return Penalite;
    }

    public void setPenalite(double penalite) {
        Penalite = penalite;
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


    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
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

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getTransfert() {
        return Transfert;
    }

    public void setTransfert(String transfert) {
        Transfert = transfert;
    }

    public String getLc() {
        return Lc;
    }

    public void setLc(String lc) {
        Lc = lc;
    }

    public String getFed() {
        return Fed;
    }

    public void setFed(String fed) {
        Fed = fed;
    }

    public String getMode_Livraison() {
        return Mode_Livraison;
    }

    public void setMode_Livraison(String mode_Livraison) {
        Mode_Livraison = mode_Livraison;
    }

    public String getType_Livraison() {
        return Type_Livraison;
    }

    public void setType_Livraison(String type_Livraison) {
        Type_Livraison = type_Livraison;
    }

    public double getCharge_Transitaire() {
        return Charge_Transitaire;
    }

    public void setCharge_Transitaire(double charge_Transitaire) {
        Charge_Transitaire = charge_Transitaire;
    }

    public double getCharge_Banque() {
        return Charge_Banque;
    }

    public void setCharge_Banque(double charge_Banque) {
        Charge_Banque = charge_Banque;
    }

    public double getCharge_Magasin() {
        return Charge_Magasin;
    }

    public void setCharge_Magasin(double charge_Magasin) {
        Charge_Magasin = charge_Magasin;
    }

    public String getAg_Transitaire() {
        return Ag_Transitaire;
    }

    public void setAg_Transitaire(String ag_Transitaire) {
        Ag_Transitaire = ag_Transitaire;
    }

    public String getN_Preforma() {
        return N_Preforma;
    }

    public void setN_Preforma(String n_Preforma) {
        N_Preforma = n_Preforma;
    }

    public Date getDate_Proforma() {
        return Date_Proforma;
    }

    public void setDate_Proforma(Date date_Proforma) {
        Date_Proforma = date_Proforma;
    }

    public Date getDate_Facture() {
        return Date_Facture;
    }

    public void setDate_Facture(Date date_Facture) {
        Date_Facture = date_Facture;
    }

    public Date getDate_Livraison() {
        return Date_Livraison;
    }

    public void setDate_Livraison(Date date_Livraison) {
        Date_Livraison = date_Livraison;
    }

    public Date getDate_Paiement() {
        return Date_Paiement;
    }

    public void setDate_Paiement(Date date_Paiement) {
        Date_Paiement = date_Paiement;
    }

    public Date getDate_Be() {
        return Date_Be;
    }

    public void setDate_Be(Date date_Be) {
        Date_Be = date_Be;
    }

    public double getCharge_Transport_Importation() {
        return Charge_Transport_Importation;
    }

    public void setCharge_Transport_Importation(double charge_Transport_Importation) {
        Charge_Transport_Importation = charge_Transport_Importation;
    }

    public double getCharge_Assurance_Importation() {
        return Charge_Assurance_Importation;
    }

    public void setCharge_Assurance_Importation(double charge_Assurance_Importation) {
        Charge_Assurance_Importation = charge_Assurance_Importation;
    }


    public String getDevise() {
        return Devise;
    }

    public void setDevise(String devise) {
        Devise = devise;
    }

    public boolean isTransport_Inclut() {
        return Transport_Inclut;
    }

    public void setTransport_Inclut(boolean transport_Inclut) {
        Transport_Inclut = transport_Inclut;
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


    public double getTotal_R_HT() {
        return Total_R_HT;
    }

    public void setTotal_R_HT(double total_R_HT) {
        Total_R_HT = total_R_HT;
    }



    public double getTotale_Declare() {
        return Totale_Declare;
    }

    public void setTotale_Declare(double totale_Declare) {
        Totale_Declare = totale_Declare;
    }

    public double getTotale_Taxe() {
        return Totale_Taxe;
    }

    public void setTotale_Taxe(double totale_Taxe) {
        Totale_Taxe = totale_Taxe;
    }

    public double getTotale_Tva() {
        return Totale_Tva;
    }

    public void setTotale_Tva(double totale_Tva) {
        Totale_Tva = totale_Tva;
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

    public Fiche_BEI( ) {

    }

    public String getType_Doc_Banque() {
        return Type_Doc_Banque;
    }

    public void setType_Doc_Banque(String type_Doc_Banque) {
        Type_Doc_Banque = type_Doc_Banque;
    }

    public byte[] getDoc_Banque() {
        return Doc_Banque;
    }

    public void setDoc_Banque(byte[] doc_Banque) {
        Doc_Banque = doc_Banque;
    }

    public String getType_Doc_Importation() {
        return Type_Doc_Importation;
    }

    public void setType_Doc_Importation(String type_Doc_Importation) {
        Type_Doc_Importation = type_Doc_Importation;
    }

    public byte[] getDoc_Importation() {
        return Doc_Importation;
    }

    public void setDoc_Importation(byte[] doc_Importation) {
        Doc_Importation = doc_Importation;
    }

    public String getType_Doc_Transitaire() {
        return Type_Doc_Transitaire;
    }

    public void setType_Doc_Transitaire(String type_Doc_Transitaire) {
        Type_Doc_Transitaire = type_Doc_Transitaire;
    }

    public byte[] getDoc_Transitaire() {
        return Doc_Transitaire;
    }

    public void setDoc_Transitaire(byte[] doc_Transitaire) {
        Doc_Transitaire = doc_Transitaire;
    }

    public String getType_Doc_Transport() {
        return Type_Doc_Transport;
    }

    public void setType_Doc_Transport(String type_Doc_Transport) {
        Type_Doc_Transport = type_Doc_Transport;
    }

    public byte[] getDoc_Transport() {
        return Doc_Transport;
    }

    public void setDoc_Transport(byte[] doc_Transport) {
        Doc_Transport = doc_Transport;
    }
}
