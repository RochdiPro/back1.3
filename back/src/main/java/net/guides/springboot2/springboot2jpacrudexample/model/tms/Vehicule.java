package net.guides.springboot2.springboot2jpacrudexample.model.tms;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Vehicule")
public class Vehicule {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "matricule")
    String matricule;

    @Column(name = "marque")
    String marque;

    @Column(name = "modele")
    String modele;

    @Column(name = "couleur")
    String couleur;

    @Column(name = "categories")
    String categories;

    @Column(name = "kmactuel")
    Integer kmactuel;


    @Column(name = "kmprochainentretien")
    Integer kmprochainentretien;

    @Column(name = "consommationNormale")
    Float consommationNormale;

    @Column(name = "consommation")
    Integer consommation;

    @Column(name = "prixcarburant")
    Float prixcarburant;

    @Column(name = "carburant")
    String carburant;

    @Column(name = "distanceparcourie")
    Integer distanceparcourie;

    @Column(name = "charge_utile")
    Float charge_utile;

    @Column(name = "longueur")
    Float longueur;

    @Column(name = "largeur")
    Float largeur;

    @Column(name = "hauteur")
    Float hauteur;

    @Column(name = "charge_restante")
    Float charge_restante;

    @Column(name = "surface_restante")
    Float surface_restante;

    @Column(name = "datevisite")
    Date datevisite;

    @Column(name = "dateassurance")
    Date dateassurance;

    @Column(name = "datetaxe")
    Date datetaxe;

    @Column(name = "sujet")
    String sujet;

    @Column(name = "description")
    String description;

    @Column(name = "etatVehicule")
    String etatVehicule;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getKmactuel() {
        return kmactuel;
    }

    public void setKmactuel(Integer kmactuel) {
        this.kmactuel = kmactuel;
    }

    public Integer getKmprochainentretien() {
        return kmprochainentretien;
    }

    public void setKmprochainentretien(Integer kmprochainentretien) {
        this.kmprochainentretien = kmprochainentretien;
    }

    public Float getConsommationNormale() {
        return consommationNormale;
    }

    public void setConsommationNormale(Float consommationNormale) {
        this.consommationNormale = consommationNormale;
    }

    public Integer getConsommation() {
        return consommation;
    }

    public void setConsommation(Integer consommation) {
        this.consommation = consommation;
    }

    public Float getPrixcarburant() {
        return prixcarburant;
    }

    public void setPrixcarburant(Float prixcarburant) {
        this.prixcarburant = prixcarburant;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public Integer getDistanceparcourie() {
        return distanceparcourie;
    }

    public void setDistanceparcourie(Integer distanceparcourie) {
        this.distanceparcourie = distanceparcourie;
    }

    public Float getCharge_utile() {
        return charge_utile;
    }

    public void setCharge_utile(Float charge_utile) {
        this.charge_utile = charge_utile;
    }

    public Float getLongueur() {
        return longueur;
    }

    public void setLongueur(Float longueur) {
        this.longueur = longueur;
    }

    public Float getLargeur() {
        return largeur;
    }

    public void setLargeur(Float largeur) {
        this.largeur = largeur;
    }

    public Float getHauteur() {
        return hauteur;
    }

    public void setHauteur(Float hauteur) {
        this.hauteur = hauteur;
    }

    public Float getCharge_restante() {
        return charge_restante;
    }

    public void setCharge_restante(Float charge_restante) {
        this.charge_restante = charge_restante;
    }

    public Float getSurface_restante() {
        return surface_restante;
    }

    public void setSurface_restante(Float surface_restante) {
        this.surface_restante = surface_restante;
    }

    public Date getDatevisite() {
        return datevisite;
    }

    public void setDatevisite(Date datevisite) {
        this.datevisite = datevisite;
    }

    public Date getDateassurance() {
        return dateassurance;
    }

    public void setDateassurance(Date dateassurance) {
        this.dateassurance = dateassurance;
    }

    public Date getDatetaxe() {
        return datetaxe;
    }

    public void setDatetaxe(Date datetaxe) {
        this.datetaxe = datetaxe;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtatVehicule() {
        return etatVehicule;
    }

    public void setEtatVehicule(String etatVehicule) {
        this.etatVehicule = etatVehicule;
    }

    public Vehicule(String matricule, String marque, String modele, String couleur, String categories, int kmactuel, int kmprochainentretien, int consommation, String carburant, float prixcarburant, float consommationNormale, float charge_utile, float longueur, float largeur, float hauteur, float charge_restante, float surface_restante, Date datevisite, Date dateassurance, Date datetaxe, String sujet, String description, String etatVehicule) {
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.categories = categories;
        this.kmactuel = kmactuel;
        this.kmprochainentretien = kmprochainentretien;
        this.consommation = consommation;
        this.carburant = carburant;
        this.prixcarburant = prixcarburant;
        this.consommationNormale = consommationNormale;
        this.charge_utile = charge_utile;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.charge_restante = charge_restante;
        this.surface_restante = surface_restante;
        this.datevisite = datevisite;
        this.dateassurance = dateassurance;
        this.datetaxe = datetaxe;
        this.sujet = sujet;
        this.description = description;
        this.etatVehicule = etatVehicule;
    }

    public Vehicule(int kmactuel, int kmprochainentretien, int consommation, String carburant, float consommationNormale, int distanceparcourie, Date datevisite, Date dateassurance, Date datetaxe) {
        this.kmactuel = kmactuel;
        this.kmprochainentretien = kmprochainentretien;
        this.consommation = consommation;
        this.carburant = carburant;
        this.consommationNormale = consommationNormale;
        this.distanceparcourie = distanceparcourie;
        this.datevisite = datevisite;
        this.dateassurance = dateassurance;
        this.datetaxe = datetaxe;
    }

    public Vehicule(String sujet, String description) {
        this.sujet = sujet;
        this.description = description;
    }

    public Vehicule(int kmactuel, int consommation, int distanceparcourie) {
        this.kmactuel = kmactuel;
        this.consommation = consommation;
        this.distanceparcourie = distanceparcourie;
    }

    public Vehicule(String etatVehicule) {
        this.etatVehicule = etatVehicule;
    }

    public Vehicule(Float charge_restante, Float surface_restante) {
        this.charge_restante = charge_restante;
        this.surface_restante = surface_restante;
    }

    public Vehicule() {
    }
}
