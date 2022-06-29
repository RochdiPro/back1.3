package net.guides.springboot2.springboot2jpacrudexample.model.init;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Fiche_Local")
public class Fiche_Local {

    @Id
    @Column(name = "Id_Local")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id_Local;

    @Column(name = "Nom_Local")
    String Nom_Local;

    @Column(name = "Categorie_Local")
    String Categorie_Local;

    @Column(name = "Description_Local")
    String Description_Local;

    @Column(name = "Largeur")
    double Largeur = 0 ;

    @Column(name = "Profondeur")
    double Profondeur = 0 ;

    @Column(name = "Hauteur")
    double Hauteur = 0 ;

    @Column(name = "Adresse")
    String Adresse;

    @Column(name = "Responsable")
    String Responsable;

    @Column(name = "Tel")
    String Tel;

    @Column(name = "Fax")
    String Fax;

    @Column(name = "Email")
    String Email;

    @Column(name = "Nature_Contrat")
    String Nature_Contrat;

    @Column(name = "Date_Debut")
    Date Date_Debut;

    @Column(name = "Date_Fin")
    Date Date_Fin;

    @Column(name = "Frais")
    double Frais = 0 ;

    @Column(name = "Nature_Frais")
    String Nature_Frais   ;

    @Column(name = "Latitude")
    double Latitude ;

    @Column(name = "Longitude")
    double Longitude ;

    @Column(name = "Surface")
    double Surface ;


    @Column(name = "Detail_Type")
    String Detail_Type;

    @Lob
    private byte[] Detail;

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    Date Date_Creation=java.util.Calendar.getInstance().getTime();



    public Fiche_Local(String nom_Local, String categorie_Local, String description_Local, double largeur, double profondeur, double hauteur, String adresse, String responsable, String tel, String fax, String email, String nature_Contrat, Date date_Debut, Date date_Fin, double frais, String nature_Frais, double latitude, double longitude, double surface , String detail_Type, byte[] detail ) {
        Nom_Local = nom_Local;
        Categorie_Local = categorie_Local;
        Description_Local = description_Local;
        Largeur = largeur;
        Profondeur = profondeur;
        Hauteur = hauteur;
        Adresse = adresse;
        Responsable = responsable;
        Tel = tel;
        Fax = fax;
        Email = email;
        Nature_Contrat = nature_Contrat;
        Date_Debut = date_Debut;
        Date_Fin = date_Fin;
        Frais = frais;
        Nature_Frais = nature_Frais;
        this.Latitude = latitude;
        this.Longitude = longitude;
        Surface=surface;
        Detail_Type = detail_Type;
        Detail = detail;

    }

    public Fiche_Local( ) {
    }

    public Long getId_Local() {
        return Id_Local;
    }

    public void setId_Local(Long id_Local) {
        Id_Local = id_Local;
    }

    public String getNom_Local() {
        return Nom_Local;
    }

    public void setNom_Local(String nom_Local) {
        Nom_Local = nom_Local;
    }

    public String getCategorie_Local() {
        return Categorie_Local;
    }

    public void setCategorie_Local(String categorie_Local) {
        Categorie_Local = categorie_Local;
    }

    public String getDescription_Local() {
        return Description_Local;
    }

    public void setDescription_Local(String description_Local) {
        Description_Local = description_Local;
    }

    public double getLargeur() {
        return Largeur;
    }

    public void setLargeur(double largeur) {
        Largeur = largeur;
    }

    public double getProfondeur() {
        return Profondeur;
    }

    public void setProfondeur(double profondeur) {
        Profondeur = profondeur;
    }

    public double getHauteur() {
        return Hauteur;
    }

    public void setHauteur(double hauteur) {
        Hauteur = hauteur;
    }

    public String getDetail_Type() {
        return Detail_Type;
    }

    public void setDetail_Type(String detail_Type) {
        Detail_Type = detail_Type;
    }

    public byte[] getDetail() {
        return Detail;
    }

    public void setDetail(byte[] detail) {
        Detail = detail;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String responsable) {
        Responsable = responsable;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNature_Contrat() {
        return Nature_Contrat;
    }

    public void setNature_Contrat(String nature_Contrat) {
        Nature_Contrat = nature_Contrat;
    }

    public Date getDate_Debut() {
        return Date_Debut;
    }

    public void setDate_Debut(Date date_Debut) {
        Date_Debut = date_Debut;
    }

    public Date getDate_Fin() {
        return Date_Fin;
    }

    public void setDate_Fin(Date date_Fin) {
        Date_Fin = date_Fin;
    }

    public double getFrais() {
        return Frais;
    }

    public void setFrais(double frais) {
        Frais = frais;
    }

    public String getNature_Frais() {
        return Nature_Frais;
    }

    public void setNature_Frais(String nature_Frais) {
        Nature_Frais = nature_Frais;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        this.Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        this.Longitude = longitude;
    }

    public double getSurface() {
        return Surface;
    }

    public void setSurface(double surface) {
        Surface = surface;
    }
}
