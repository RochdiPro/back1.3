package net.guides.springboot2.springboot2jpacrudexample.model.tms;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "Affectation")
public class Affectation {
    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "idE")
    Integer idE;

    @Column(name = "nom")
    String nom;


    @Column(name = "matricule")
    String matricule;

    @Column(name = "dateLivraison")
    Date dateLivraison;

    @Column(name = "trajet")
    String trajet;

    @Column(name = "etatMission")
    String etatMission;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getIdE() {
        return idE;
    }

    public void setIdE(Integer idE) {
        this.idE = idE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getTrajet() {
        return trajet;
    }

    public void setTrajet(String trajet) {
        this.trajet = trajet;
    }

    public String getEtatMission() {
        return etatMission;
    }

    public void setEtatMission(String etatMission) {
        this.etatMission = etatMission;
    }

    public Affectation(Integer idE, String nom, String matricule, Date dateLivraison, String etatMission) {
        this.idE=idE;
        this.nom = nom;
        this.matricule = matricule;
        Calendar cal = Calendar.getInstance();
        TimeZone tz = TimeZone.getTimeZone("GMT");
        cal.setTimeZone(tz);
        cal.setTime(dateLivraison);
        cal.add(Calendar.DATE, 1);
        this.dateLivraison = cal.getTime();

       // this.dateLivraison = dateLivraison;
        this.etatMission = etatMission;
    }

    public Affectation(Integer idE, String nom, String matricule, Date dateLivraison, String trajet, String etatMission) {
        this.idE = idE;
        this.nom = nom;
        this.matricule = matricule;
        Calendar cal = Calendar.getInstance();
        TimeZone tz = TimeZone.getTimeZone("GMT");
        cal.setTimeZone(tz);
        cal.setTime(dateLivraison);
        cal.add(Calendar.DATE, 1);
        this.dateLivraison = cal.getTime();
        //this.dateLivraison = dateLivraison;
        this.trajet = trajet;
        this.etatMission = etatMission;
    }


    public Affectation(String trajet) {
        this.trajet = trajet;
    }

    public Affectation() {}
}
