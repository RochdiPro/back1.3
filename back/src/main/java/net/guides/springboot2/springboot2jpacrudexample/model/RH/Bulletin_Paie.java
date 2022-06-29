package net.guides.springboot2.springboot2jpacrudexample.model.RH;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Bulletin_Paie")
public class Bulletin_Paie {

    @javax.persistence.Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "Date_de_Paie")
    private Date Date_de_Paie ;

    @Column(name = "CNSS")
    String CNSS;

    @Column(name = "Situation_Familiale")
    String Situation_Familiale ;

    @Column(name = "Enfant_A_Charge")
    int Enfant_A_Charge;

    @Column(name = "Salaire_de_Base")
    double Salaire_de_Base;

    @Column(name = "Taux_Horaire")
    double Taux_Horaire;

    @Column(name = "Mode_Paiement")
    double Mode_Paiement;

    @Column(name = "Nombre_Heure_Absence")
    int Nombre_Heure_Absence;

    @Column(name = "Nombre_Heure_Supplementaire")
    int Nombre_Heure_Supplementaire;

    @Column(name = "Prix_Heure_Supplementaire")
    double Prix_Heure_Supplementaire;

    @Column(name = "Conge_Pris_Mois")
    double Conge_Pris_Mois;

    @Column(name = "Conge_acquis_mois")
    double Conge_acquis_mois;

    @Column(name = "Solde_Conge")
    double Solde_Conge;

    @Lob
    private byte[] Detail;

    @ManyToOne()
    @JoinColumn(name="Id_Employe", referencedColumnName = "Id_Employe", insertable = false, updatable = false)
    private Employe Employe;


    public Bulletin_Paie(Date date_de_Paie, String CNSS, String situation_Familiale, int enfant_A_Charge, double salaire_de_Base, double taux_Horaire, double mode_Paiement, int nombre_Heure_Absence, int nombre_Heure_Supplementaire, double prix_Heure_Supplementaire, double conge_Pris_Mois, double conge_acquis_mois, double solde_Conge, byte[] detail, Employe employe) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date_de_Paie);
        cal.add(Calendar.DATE, 1);
        Date_de_Paie = cal.getTime();
        this.CNSS = CNSS;
        Situation_Familiale = situation_Familiale;
        Enfant_A_Charge = enfant_A_Charge;
        Salaire_de_Base = salaire_de_Base;
        Taux_Horaire = taux_Horaire;
        Mode_Paiement = mode_Paiement;
        Nombre_Heure_Absence = nombre_Heure_Absence;
        Nombre_Heure_Supplementaire = nombre_Heure_Supplementaire;
        Prix_Heure_Supplementaire = prix_Heure_Supplementaire;
        Conge_Pris_Mois = conge_Pris_Mois;
        Conge_acquis_mois = conge_acquis_mois;
        Solde_Conge = solde_Conge;
        Detail = detail;
        Employe = employe;
    }

    public Bulletin_Paie( ) {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDate_de_Paie() {
        return Date_de_Paie;
    }

    public void setDate_de_Paie(Date date_de_Paie) {
        Date_de_Paie = date_de_Paie;
    }

    public String getCNSS() {
        return CNSS;
    }

    public void setCNSS(String CNSS) {
        this.CNSS = CNSS;
    }

    public String getSituation_Familiale() {
        return Situation_Familiale;
    }

    public void setSituation_Familiale(String situation_Familiale) {
        Situation_Familiale = situation_Familiale;
    }

    public int getEnfant_A_Charge() {
        return Enfant_A_Charge;
    }

    public void setEnfant_A_Charge(int enfant_A_Charge) {
        Enfant_A_Charge = enfant_A_Charge;
    }

    public double getSalaire_de_Base() {
        return Salaire_de_Base;
    }

    public void setSalaire_de_Base(double salaire_de_Base) {
        Salaire_de_Base = salaire_de_Base;
    }

    public double getTaux_Horaire() {
        return Taux_Horaire;
    }

    public void setTaux_Horaire(double taux_Horaire) {
        Taux_Horaire = taux_Horaire;
    }

    public double getMode_Paiement() {
        return Mode_Paiement;
    }

    public void setMode_Paiement(double mode_Paiement) {
        Mode_Paiement = mode_Paiement;
    }

    public int getNombre_Heure_Absence() {
        return Nombre_Heure_Absence;
    }

    public void setNombre_Heure_Absence(int nombre_Heure_Absence) {
        Nombre_Heure_Absence = nombre_Heure_Absence;
    }

    public int getNombre_Heure_Supplementaire() {
        return Nombre_Heure_Supplementaire;
    }

    public void setNombre_Heure_Supplementaire(int nombre_Heure_Supplementaire) {
        Nombre_Heure_Supplementaire = nombre_Heure_Supplementaire;
    }

    public double getPrix_Heure_Supplementaire() {
        return Prix_Heure_Supplementaire;
    }

    public void setPrix_Heure_Supplementaire(double prix_Heure_Supplementaire) {
        Prix_Heure_Supplementaire = prix_Heure_Supplementaire;
    }

    public double getConge_Pris_Mois() {
        return Conge_Pris_Mois;
    }

    public void setConge_Pris_Mois(double conge_Pris_Mois) {
        Conge_Pris_Mois = conge_Pris_Mois;
    }

    public double getConge_acquis_mois() {
        return Conge_acquis_mois;
    }

    public void setConge_acquis_mois(double conge_acquis_mois) {
        Conge_acquis_mois = conge_acquis_mois;
    }

    public double getSolde_Conge() {
        return Solde_Conge;
    }

    public void setSolde_Conge(double solde_Conge) {
        Solde_Conge = solde_Conge;
    }

    public byte[] getDetail() {
        return Detail;
    }

    public void setDetail(byte[] detail) {
        Detail = detail;
    }

    public net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe getUtilisateur() {
        return Employe;
    }

    public void setUtilisateur(net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe utilisateur) {
        Employe = utilisateur;
    }
}
