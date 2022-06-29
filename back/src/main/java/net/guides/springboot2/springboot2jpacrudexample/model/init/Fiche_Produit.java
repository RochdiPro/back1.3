package net.guides.springboot2.springboot2jpacrudexample.model.init;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Entity
@Table(name = "Fiche_Produit")
public class Fiche_Produit {

    @Id
    @Column(name = "Id_Produit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id_Produit;

    @Column(name = "Code_Barre")
    String Code_Barre;

    @Column(name = "Source")
    String Source;

    @Column(name = "Nom_Produit")
    String Nom_Produit;

    @Column(name = "Type1")
    String Type1;

    @Column(name = "Type2")
    String Type2;

    @Column(name = "Famille")
    String Famille;

    @Column(name = "Sous_famille")
    String Sous_Famille;

    @Column(name = "Unite")
    String Unite;

    @Column(name = "Valeur_unite")
    double Valeur_Unite;

    @Column(name = "Ngp")
    String Ngp;

    @Column(name = "Caracteristique_Technique")
    String Caracteristique_Technique;

    @Column(name = "Marque")
    String Marque;

    @Column(name = "Pays")
    String Pays;

    @Column(name = "Ville")
    String Ville;

    @Column(name = "N_Imei")
    String N_Imei ;

    @Column(name = "N_Imei2")
    String N_Imei2;

    @Column(name = "Temperature_Max")
    double Temperature_Max;

    @Column(name = "Temperature_Min")
    double Temperature_Min;

    @Column(name = "N_Lot")
    String N_Lot;

    @Column(name = "Date_Fabrication")
    Date Date_Fabrication;

    @Column(name = "Date_Validite")
    Date Date_Validite;

    @Column(name = "Saison")
    private String Saison;

    @Column(name = "Region")
    private String Region;

    @Column(name = "N_serie")
    String N_Serie;

    @Column(name = "Couleur")
    String Couleur;

    @Column(name = "Taille")
    String Taille;

    @Column(name = "Role")
    String Role;

    @Column(name = "Tva")
    double Tva;

    @Column(name = "Fodec")
    String Fodec;

    @Column(name = "Image_type")
    String Image_type;

    @Column(name = "Certificat_type")
    String Certificat_type;

    @Column(name = "Rfid_type")
    String Rfid_type;

    @Lob
    private byte[] Image ;
    @Lob
    private byte[] Certificat;
    @Lob
    private byte[] Rfid;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();



    public Fiche_Produit( ) {

    }

    public Fiche_Produit(String code_Barre, String source, String nom_Produit, String type1, String type2, String famille, String sous_Famille, String unite, double valeur_Unite, String ngp, String caracteristique_Technique, String marque, String pays, String ville, String n_Imei, String n_Imei2, double temperature_Max, double temperature_Min, String n_Lot, Date date_Fabrication, Date date_Validite, String saison, String region, String n_Serie, String couleur, String taille, String role, double tva, String fodec, String image_type, String certificat_type, String rfid_type, byte[] image, byte[] certificat, byte[] rfid) {
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
        Caracteristique_Technique = caracteristique_Technique;
        Marque = marque;
        Pays = pays;
        Ville = ville;
        N_Imei = n_Imei;
        N_Imei2 = n_Imei2;
        Temperature_Max = temperature_Max;
        Temperature_Min = temperature_Min;
        N_Lot = n_Lot;
        Saison = saison;
        Region = region;
        N_Serie = n_Serie;
        Couleur = couleur;
        Taille = taille;
        Role = role;
        Tva = tva;
        Fodec = fodec;
        Image_type = image_type;
        Certificat_type = certificat_type;
        Rfid_type = rfid_type;
        Image = image;
        Certificat = certificat;
        Rfid = rfid;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date_Fabrication);
        cal.add(Calendar.DATE, 1);
        Date_Fabrication = cal.getTime();


        cal.setTime(date_Validite);
        cal.add(Calendar.DATE, 1);
        Date_Validite = cal.getTime();


    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    public Long getId_Produit() {
        return Id_Produit;
    }

    public void setId_Produit(Long id_Produit) {
        Id_Produit = id_Produit;
    }

    public String getCode_Barre() {
        return Code_Barre;
    }

    public void setCode_Barre(String code_Barre) {
        Code_Barre = code_Barre;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getNom_Produit() {
        return Nom_Produit;
    }

    public void setNom_Produit(String nom_Produit) {
        Nom_Produit = nom_Produit;
    }

    public String getType1() {
        return Type1;
    }

    public void setType1(String type1) {
        Type1 = type1;
    }

    public String getType2() {
        return Type2;
    }

    public void setType2(String type2) {
        Type2 = type2;
    }

    public String getFamille() {
        return Famille;
    }

    public void setFamille(String famille) {
        Famille = famille;
    }

    public String getSous_Famille() {
        return Sous_Famille;
    }

    public void setSous_Famille(String sous_Famille) {
        Sous_Famille = sous_Famille;
    }

    public String getUnite() {
        return Unite;
    }

    public void setUnite(String unite) {
        Unite = unite;
    }

    public double getValeur_Unite() {
        return Valeur_Unite;
    }

    public void setValeur_Unite(double valeur_Unite) {
        Valeur_Unite = valeur_Unite;
    }

    public String getNgp() {
        return Ngp;
    }

    public void setNgp(String ngp) {
        Ngp = ngp;
    }

    public String getCaracteristique_Technique() {
        return Caracteristique_Technique;
    }

    public void setCaracteristique_Technique(String caracteristique_Technique) {
        Caracteristique_Technique = caracteristique_Technique;
    }

    public String getN_Lot() {
        return N_Lot;
    }


    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getN_Imei() {
        return N_Imei;
    }

    public void setN_Imei(String n_Imei) {
        N_Imei = n_Imei;
    }

    public String getN_Imei2() {
        return N_Imei2;
    }

    public void setN_Imei2(String n_Imei2) {
        N_Imei2 = n_Imei2;
    }

    public double getTemperature_Max() {
        return Temperature_Max;
    }

    public void setTemperature_Max(double temperature_Max) {
        Temperature_Max = temperature_Max;
    }

    public double getTemperature_Min() {
        return Temperature_Min;
    }

    public void setTemperature_Min(double temperature_Min) {
        Temperature_Min = temperature_Min;
    }

    public String isN_Lot() {
        return N_Lot;
    }

    public void setN_Lot(String n_lot) {
        N_Lot = n_lot;
    }

    public Date getDate_Fabrication() {
        return Date_Fabrication;
    }

    public void setDate_Fabrication(Date date_Fabrication) {
        Date_Fabrication = date_Fabrication;
    }

    public Date getDate_Validite() {
        return Date_Validite;
    }

    public void setDate_Validite(Date date_Validite) {
        Date_Validite = date_Validite;
    }

    public String getSaison() {
        return Saison;
    }

    public void setSaison(String saison) {
        Saison = saison;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getN_Serie() {
        return N_Serie;
    }

    public void setN_Serie(String n_Serie) {
        N_Serie = n_Serie;
    }

    public String getCouleur() {
        return Couleur;
    }

    public void setCouleur(String couleur) {
        Couleur = couleur;
    }

    public String getTaille() {
        return Taille;
    }

    public void setTaille(String taille) {
        Taille = taille;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public double getTva() {
        return Tva;
    }

    public void setTva(double tva) {
        Tva = tva;
    }

    public String getFodec() {
        return Fodec;
    }

    public void setFodec(String fodec) {
        Fodec = fodec;
    }

    public String getImage_type() {
        return Image_type;
    }

    public void setImage_type(String image_type) {
        Image_type = image_type;
    }

    public String getCertificat_type() {
        return Certificat_type;
    }

    public void setCertificat_type(String certificat_type) {
        Certificat_type = certificat_type;
    }

    public String getRfid_type() {
        return Rfid_type;
    }

    public void setRfid_type(String rfid_type) {
        Rfid_type = rfid_type;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public byte[] getCertificat() {
        return Certificat;
    }

    public void setCertificat(byte[] certificat) {
        Certificat = certificat;
    }

    public byte[] getRfid() {
        return Rfid;
    }

    public void setRfid(byte[] rfid) {
        Rfid = rfid;
    }
}
