package net.guides.springboot2.springboot2jpacrudexample.model.init;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Contrainte")
public class Contrainte {

    @Id
    @Column(name = "Id_Contrainte")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id_Contrainte;

    @Column(name = "Nom_Contrainte")
    String Nom_Contrainte;

    @Column(name = "Code_Barre")
    boolean Code_Barre;

    @Column(name = "Source")
    boolean Source;

    @Column(name = "Nom_Produit")
    boolean Nom_Produit;

    @Column(name = "Type1")
    boolean Type1;

    @Column(name = "Type2")
    boolean Type2;

    @Column(name = "Famille")
    boolean Famille;

    @Column(name = "Sous_famille")
    boolean Sous_Famille;

    @Column(name = "Unite")
    boolean Unite;

    @Column(name = "Valeur_unite")
    boolean Valeur_Unite;

    @Column(name = "Ngp")
    boolean Ngp;

    @Column(name = "Rfid")
    boolean Rfid;

    @Column(name = "Caracteristique_Technique")
    boolean Caracteristique_Technique;

    @Column(name = "Marque")
    boolean Marque;


    @Column(name = "Src_img")
    boolean Src_Img;


    @Column(name = "Pays")
    boolean Pays;

    @Column(name = "Ville")
    boolean Ville;

    @Column(name = "N_Imei")
    boolean N_Imei;

    @Column(name = "N_Imei2")
    boolean N_Imei2;

    @Column(name = "Temperature_Max")
    boolean Temperature_Max;

    @Column(name = "Temperature_Min")
    boolean Temperature_Min;

    @Column(name = "N_lot")
    boolean N_Lot;
    @Column(name = "Date_Fabrication")
    boolean Date_Fabrication;
    @Column(name = "Date_Validite")
    boolean Date_Validite;

    @Column(name = "Saison")
    boolean Saison;
    @Column(name = "Region")
    boolean Region;

    @Column(name = "N_serie")
    boolean N_Serie;
    @Column(name = "Couleur")
    boolean Couleur;
    @Column(name = "Taille")
    boolean Taille;
    @Column(name = "Role")
    boolean Role;
    @Column(name = "Tva")
    boolean Tva;
    @Column(name = "Fodec")
    boolean Fodec;
    @Column(name = "Certificat")
    boolean Certificat ;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    public Contrainte() {

    }

    public Contrainte(Long id_Contrainte, String nom_Contrainte , boolean code_Barre, boolean source, boolean nom_Produit, boolean type1, boolean type2, boolean famille, boolean sous_Famille, boolean unite, boolean valeur_Unite, boolean ngp, boolean rfid, boolean caracteristique_Technique, boolean marque, boolean src_Img, boolean pays, boolean ville, boolean n_Imei, boolean n_Imei2, boolean temperature_Max, boolean temperature_Min, boolean n_lot, boolean date_Fabrication, boolean date_Validite, boolean saison, boolean region, boolean n_serie, boolean couleur, boolean taille, boolean role, boolean tva ,boolean fodec , boolean certificat ) {
        Nom_Contrainte =nom_Contrainte ;
        Id_Contrainte = id_Contrainte;
        Code_Barre = code_Barre;
        Source = source;
        Nom_Produit = nom_Produit;
        Type1 = type1;
        Type2 = type2;
        Famille = famille;
        Sous_Famille = sous_Famille;
        Unite = unite;
        Valeur_Unite = valeur_Unite;
        Ngp = ngp;
        Rfid = rfid;
        Caracteristique_Technique = caracteristique_Technique;
        Marque = marque;
        Src_Img = src_Img;
        Pays = pays;
        Ville = ville;
        N_Imei = n_Imei;
        N_Imei2 = n_Imei2;
        Temperature_Max = temperature_Max;
        Temperature_Min = temperature_Min;
        N_Lot = n_lot;
        Date_Fabrication = date_Fabrication;
        Date_Validite = date_Validite;
        Saison = saison;
        Region = region;
        N_Serie = n_serie;
        Couleur = couleur;
        Taille = taille;
        Role = role;
        Tva = tva;
        Fodec = fodec;
        Certificat =certificat;
    }

    public String getNom_Contrainte() {
        return Nom_Contrainte;
    }

    public void setNom_Contrainte(String nom_Contrainte) {
        Nom_Contrainte = nom_Contrainte;
    }

    public Long getId_Contrainte() {
        return Id_Contrainte;
    }

    public void setId_Contrainte(Long id_Contrainte) {
        Id_Contrainte = id_Contrainte;
    }

    public boolean isCode_Barre() {
        return Code_Barre;
    }

    public void setCode_Barre(boolean code_Barre) {
        Code_Barre = code_Barre;
    }

    public boolean isSource() {
        return Source;
    }

    public void setSource(boolean source) {
        Source = source;
    }

    public boolean isNom_Produit() {
        return Nom_Produit;
    }

    public void setNom_Produit(boolean nom_Produit) {
        Nom_Produit = nom_Produit;
    }

    public boolean isFodec() {
        return Fodec;
    }

    public void setFodec(boolean fodec) {
        Fodec = fodec;
    }

    public boolean isCertificat() {
        return Certificat;
    }

    public void setCertificat(boolean certificat) {
        Certificat = certificat;
    }

    public boolean isType1() {
        return Type1;
    }

    public void setType1(boolean type1) {
        Type1 = type1;
    }

    public boolean isType2() {
        return Type2;
    }

    public void setType2(boolean type2) {
        Type2 = type2;
    }

    public boolean isFamille() {
        return Famille;
    }

    public void setFamille(boolean famille) {
        Famille = famille;
    }

    public boolean isSous_Famille() {
        return Sous_Famille;
    }

    public void setSous_Famille(boolean sous_Famille) {
        Sous_Famille = sous_Famille;
    }

    public boolean isUnite() {
        return Unite;
    }

    public void setUnite(boolean unite) {
        Unite = unite;
    }

    public boolean isValeur_Unite() {
        return Valeur_Unite;
    }

    public void setValeur_Unite(boolean valeur_Unite) {
        Valeur_Unite = valeur_Unite;
    }

    public boolean isNgp() {
        return Ngp;
    }

    public void setNgp(boolean ngp) {
        Ngp = ngp;
    }

    public boolean isRfid() {
        return Rfid;
    }

    public void setRfid(boolean rfid) {
        Rfid = rfid;
    }

    public boolean isCaracteristique_Technique() {
        return Caracteristique_Technique;
    }

    public void setCaracteristique_Technique(boolean caracteristique_Technique) {
        Caracteristique_Technique = caracteristique_Technique;
    }

    public boolean isMarque() {
        return Marque;
    }

    public void setMarque(boolean marque) {
        Marque = marque;
    }

    public boolean isSrc_Img() {
        return Src_Img;
    }

    public void setSrc_Img(boolean src_Img) {
        Src_Img = src_Img;
    }

    public boolean isPays() {
        return Pays;
    }

    public void setPays(boolean pays) {
        Pays = pays;
    }

    public boolean isVille() {
        return Ville;
    }

    public void setVille(boolean ville) {
        Ville = ville;
    }

    public boolean isN_Imei() {
        return N_Imei;
    }

    public void setN_Imei(boolean n_Imei) {
        N_Imei = n_Imei;
    }

    public boolean isN_Imei2() {
        return N_Imei2;
    }

    public void setN_Imei2(boolean n_Imei2) {
        N_Imei2 = n_Imei2;
    }

    public boolean isTemperature_Max() {
        return Temperature_Max;
    }

    public void setTemperature_Max(boolean temperature_Max) {
        Temperature_Max = temperature_Max;
    }

    public boolean isTemperature_Min() {
        return Temperature_Min;
    }

    public void setTemperature_Min(boolean temperature_Min) {
        Temperature_Min = temperature_Min;
    }

    public boolean isN_Lot() {
        return N_Lot;
    }

    public void setN_Lot(boolean n_Lot) {
        N_Lot = n_Lot;
    }

    public boolean isDate_Fabrication() {
        return Date_Fabrication;
    }

    public void setDate_Fabrication(boolean date_Fabrication) {
        Date_Fabrication = date_Fabrication;
    }

    public boolean isDate_Validite() {
        return Date_Validite;
    }

    public void setDate_Validite(boolean date_Validite) {
        Date_Validite = date_Validite;
    }

    public boolean isSaison() {
        return Saison;
    }

    public void setSaison(boolean saison) {
        Saison = saison;
    }

    public boolean isRegion() {
        return Region;
    }

    public void setRegion(boolean region) {
        Region = region;
    }

    public boolean isN_Serie() {
        return N_Serie;
    }

    public void setN_Serie(boolean n_Serie) {
        N_Serie = n_Serie;
    }

    public boolean isCouleur() {
        return Couleur;
    }

    public void setCouleur(boolean couleur) {
        Couleur = couleur;
    }

    public boolean isTaille() {
        return Taille;
    }

    public void setTaille(boolean taille) {
        Taille = taille;
    }

    public boolean isRole() {
        return Role;
    }

    public void setRole(boolean role) {
        Role = role;
    }

    public boolean isTva() {
        return Tva;
    }

    public void setTva(boolean tva) {
        Tva = tva;
    }
}
