package net.guides.springboot2.springboot2jpacrudexample.model.RH;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Employe")
public class Employe implements Serializable {
    @Id
    @Column(name = "Id_Employe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id_Employe;

    @Column(name = "Role")
    private String Role ;

    @Column(name = "Acces")
    private int Acces  ;

    @Column(name = "Nom")
    private String Nom ;

    @Column(name = "Date_de_naissance")
    private java.util.Date Date_de_naissance ;

    @Column(name = "Date_de_embauche")
    private java.util.Date Date_de_embauche ;

    @Column(name = "Banque")
    private String Banque ;

    @Column(name = "Rib")
    private String Rib;

    @Column(name = "Tel")
    private String Tel ;

    @Column(name = "Pays")
    private String Pays ;

    @Column(name = "Ville")
    private String Ville ;

    @Column(name = "Email")
    private String Email ;

    @Column(name = "Adresse")
    private String  Adresse ;

    @Column(name = "Type_Piece_Identite")
    private String Type_Piece_Identite ;

    @Column(name = "N_Piece_Identite")
    private String N_Piece_Identite ;

    @Column(name = "Date_Piece_Identite")
    private java.util.Date Date_Piece_Identite ;

    @Column(name = "Description ")
    private String Description  ;

    @Column(name = "Image_Type")
    String Image_Type;

    @Lob
    private byte[] Image;

    @Column(name = "Cnss")
    String Cnss;

    @Column(name = "Situation_Familiale")
    String Situation_Familiale ;

    @Column(name = "Enfant_A_Charge")
    int Enfant_A_Charge;

    @Column(name = "Permis")
    String Permis;

    @Column(name = "Categorie_Permis")
    String Categorie_Permis ;

    @Column(name = "Date_de_Permis")
    private java.util.Date Date_de_Permis ;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();

    @Column(name = "Local")
    private String Local ;


    public Employe(String role, int acces, String nom,  Date date_de_naissance, Date date_de_embauche, String banque, String rib, String tel, String pays, String ville, String email, String adresse, String type_Piece_Identite, String n_Piece_Identite, Date date_Piece_Identite, String description, String image_Type, byte[] image ,String cnss ,  String situation_Familiale , int enfant_A_Charge , Date date_de_Permis , String permis , String categorie_Permis ,String local) {
        Role = role;
        Acces = acces;
        Nom = nom;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date_de_naissance);
        cal.add(Calendar.DATE, 1);
        Date_de_naissance = cal.getTime();

        cal.setTime(date_de_embauche);
        cal.add(Calendar.DATE, 1);
        Date_de_embauche = cal.getTime();

        cal.setTime(date_Piece_Identite);
        cal.add(Calendar.DATE, 1);
        Date_Piece_Identite = cal.getTime();

        cal.setTime(date_de_Permis);
        cal.add(Calendar.DATE, 1);
        Date_de_Permis = cal.getTime();

        Banque = banque;
        Rib = rib;
        Tel = tel;
        Pays = pays;
        Ville = ville;
        Email = email;
        Adresse = adresse;
        Type_Piece_Identite = type_Piece_Identite;
        N_Piece_Identite = n_Piece_Identite;
        Description = description;
        Image_Type = image_Type;
        Image = image;
        Cnss =cnss ;
        Situation_Familiale =  situation_Familiale ;
        Enfant_A_Charge = enfant_A_Charge;
        Permis=permis;
        Categorie_Permis=categorie_Permis;
        Local=local;
    }

    public Employe(   ) {

    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }

    public Date getDate_de_embauche() {
        return Date_de_embauche;
    }

    public void setDate_de_embauche(Date date_de_embauche) {
        Date_de_embauche = date_de_embauche;
    }

    public Long getId_Employe() {
        return Id_Employe;
    }

    public void setId_Employe(Long id_Utilisateur) {
        Id_Employe = id_Utilisateur;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getAcces() {
        return Acces;
    }

    public void setAcces(int acces) {
        Acces = acces;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }


    public Date getDate_de_naissance() {
        return Date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        Date_de_naissance = date_de_naissance;
    }

    public String getBanque() {
        return Banque;
    }

    public void setBanque(String banque) {
        Banque = banque;
    }

    public String getRib() {
        return Rib;
    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    public void setRib(String rib) {
        Rib = rib;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getType_Piece_Identite() {
        return Type_Piece_Identite;
    }

    public void setType_Piece_Identite(String type_Piece_Identite) {
        Type_Piece_Identite = type_Piece_Identite;
    }

    public String getN_Piece_Identite() {
        return N_Piece_Identite;
    }

    public void setN_Piece_Identite(String n_Piece_Identite) {
        N_Piece_Identite = n_Piece_Identite;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage_Type() {
        return Image_Type;
    }

    public void setImage_Type(String image_Type) {
        Image_Type = image_Type;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public Date getDate_Piece_Identite() {
        return Date_Piece_Identite;
    }

    public void setDate_Piece_Identite(Date date_Piece_Identite) {
        Date_Piece_Identite = date_Piece_Identite;
    }

    public String getCnss() {
        return Cnss;
    }

    public void setCnss(String cnss) {
        Cnss = cnss;
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

    public String getPermis() {
        return Permis;
    }

    public void setPermis(String permis) {
        Permis = permis;
    }

    public String getCategorie_Permis() {
        return Categorie_Permis;
    }

    public void setCategorie_Permis(String categorie_Permis) {
        Categorie_Permis = categorie_Permis;
    }

    public Date getDate_de_Permis() {
        return Date_de_Permis;
    }

    public void setDate_de_Permis(Date date_de_Permis) {
        Date_de_Permis = date_de_Permis;
    }
}
