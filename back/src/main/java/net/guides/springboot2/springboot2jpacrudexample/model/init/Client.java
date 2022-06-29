package net.guides.springboot2.springboot2jpacrudexample.model.init;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @Column(name = "Id_Clt")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id_Clt;

    @Column(name = "Nom_Client")
    private String Nom_Client ;

    @Column(name = "Categorie_Fiscale")
    private String Categorie_Fiscale  ;

    @Column(name = "Contact")
    private String Contact  ;

    @Column(name = "Adresse")
    private String Adresse  ;

    @Column(name = "Ville")
    private String Ville ;

    @Column(name = "Region")
    private String Region ;

    @Column(name = "Pays")
    private String Pays   ;

    @Column(name = "Email")
    private String Email  ;

    @Column(name = "Site_Web")
    private String Site_Web ;

    @Column(name = "Banque1")
    private String Banque1 ;

    @Column(name = "Banque2")
    private String Banque2 ;

    @Column(name = "Rib1")
    private String Rib1;

    @Column(name = "Rib2")
    private String Rib2 ;

    @Column(name = "Categorie_Client")
    private String Categorie_Client ;

    @Column(name = "TimbreFiscal")
    private boolean Timbre_Fiscal ;

    @Column(name = "Representant")
    private String Representant ;

    @Column(name = "Bloque_Vente")
    private boolean Bloque_Vente ;

    @Column(name = "Solde_Facture")
    private double Solde_Facture;

    @Column(name = "Risque")
    private double Risque;

    @Column(name = "Plafond")
    private double Plafond ;

    @Column(name = "Code_Tva")
    private String Code_Tva ;

    @Column(name = "Tel1")
    private String Tel1 ;

    @Column(name = "Tel2")
    private String Tel2;

    @Column(name = "Fax")
    private String Fax ;

    @Column(name = "Type_Piece_Identite")
    private String Type_Piece_Identite ;

    @Column(name = "Description ")
    private String Description  ;

    @Column(name = "N_Piece_Identite")
    private String N_Piece_Identite ;

    @Column(name = "Date_Livraison_Identite")
    private Date Date_Livraison_Identite ;

    @Column(name = "N_Attestation_Exoneration")
    private String N_Attestation_Exoneration ;

    @Column(name = "Debut_Exoneration")
    private Date Debut_Exoneration ;

    @Column(name = "Fin_Exoneration")
    private Date Fin_Exoneration ;

    @Column(name = "Reduction_Tva")
    double Reduction_Tva ;

    @Column(name = "Image_Type")
    String Image_Type;

    @Lob
    private byte[] Image;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    public Client( ) {
    }


    public Client(String nom_client, String categorie_fiscale, String contact, String adresse, String ville, String region, String pays, String email, String site_web, String banque1, String banque2, String rib1, String rib2, String categorie_client, boolean timbre_fiscal, String representant, String description, boolean bloque_vente, double solde_facture, double risque, double plafond, String code_tva, String tel1, String tel2, String fax , String type_piece_identite, String n_piece_identite,   Date date_Livraison_Identite, String n_attestation_exoneration, Date debut_Exoneration, Date fin_Exoneration, double reduction_tva, String contentType, byte[] bytes) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date_Livraison_Identite);
        cal.add(Calendar.DATE, 1);
        Date_Livraison_Identite = cal.getTime();


        cal.setTime(debut_Exoneration);
        cal.add(Calendar.DATE, 1);
        Debut_Exoneration = cal.getTime();

        cal.setTime(fin_Exoneration);
        cal.add(Calendar.DATE, 1);
        Fin_Exoneration = cal.getTime();

        Nom_Client = nom_client;
        Categorie_Fiscale = categorie_fiscale;
        Contact = contact;
        Adresse = adresse;
        Ville = ville;
        Region = region;
        Pays = pays;
        Email = email;
        Site_Web = site_web;
        Banque1 = banque1;
        Banque2 = banque2;
        Rib1 = rib1;
        Rib2 = rib2;
        Categorie_Client = categorie_client;
        Timbre_Fiscal = timbre_fiscal;
        Representant = representant;
        Bloque_Vente = bloque_vente;
        Solde_Facture = solde_facture;
        Risque = risque;
        Plafond = plafond;
        Code_Tva = code_tva;
        Tel1 = tel1;
        Tel2 = tel2;
        Fax = fax;
        Type_Piece_Identite = type_piece_identite;
        Description = description;
        N_Piece_Identite = n_piece_identite;
        N_Attestation_Exoneration = n_attestation_exoneration;
        Reduction_Tva = reduction_tva;
        Image_Type = contentType;
        Image = bytes;

    }

    public Long getId_Clt() {
        return Id_Clt;
    }

    public void setId_Clt(Long id_Clt) {
        Id_Clt = id_Clt;
    }

    public String getNom_Client() {
        return Nom_Client;
    }

    public void setNom_Client(String nom_Client) {
        Nom_Client = nom_Client;
    }

    public String getCategorie_Fiscale() {
        return Categorie_Fiscale;
    }

    public void setCategorie_Fiscale(String categorie_Fiscale) {
        Categorie_Fiscale = categorie_Fiscale;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSite_Web() {
        return Site_Web;
    }

    public void setSite_Web(String site_Web) {
        Site_Web = site_Web;
    }

    public String getBanque1() {
        return Banque1;
    }

    public void setBanque1(String banque1) {
        Banque1 = banque1;
    }

    public String getBanque2() {
        return Banque2;
    }

    public void setBanque2(String banque2) {
        Banque2 = banque2;
    }

    public String getRib1() {
        return Rib1;
    }

    public void setRib1(String rib1) {
        Rib1 = rib1;
    }

    public String getRib2() {
        return Rib2;
    }

    public void setRib2(String rib2) {
        Rib2 = rib2;
    }

    public String getCategorie_Client() {
        return Categorie_Client;
    }

    public void setCategorie_Client(String categorie_Client) {
        Categorie_Client = categorie_Client;
    }

    public boolean isTimbre_Fiscal() {
        return Timbre_Fiscal;
    }

    public void setTimbre_Fiscal(boolean timbre_Fiscal) {
        Timbre_Fiscal = timbre_Fiscal;
    }

    public String getRepresentant() {
        return Representant;
    }

    public void setRepresentant(String representant) {
        Representant = representant;
    }

    public boolean isBloque_Vente() {
        return Bloque_Vente;
    }

    public void setBloque_Vente(boolean bloque_Vente) {
        Bloque_Vente = bloque_Vente;
    }

    public double getSolde_Facture() {
        return Solde_Facture;
    }

    public void setSolde_Facture(double solde_Facture) {
        Solde_Facture = solde_Facture;
    }

    public double getRisque() {
        return Risque;
    }

    public void setRisque(double risque) {
        Risque = risque;
    }

    public double getPlafond() {
        return Plafond;
    }

    public void setPlafond(double plafond) {
        Plafond = plafond;
    }

    public String getCode_Tva() {
        return Code_Tva;
    }

    public void setCode_Tva(String code_Tva) {
        Code_Tva = code_Tva;
    }

    public String getTel1() {
        return Tel1;
    }

    public void setTel1(String tel1) {
        Tel1 = tel1;
    }

    public String getTel2() {
        return Tel2;
    }

    public void setTel2(String tel2) {
        Tel2 = tel2;
    }



    public String getType_Piece_Identite() {
        return Type_Piece_Identite;
    }

    public void setType_Piece_Identite(String type_Piece_Identite) {
        Type_Piece_Identite = type_Piece_Identite;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getN_Piece_Identite() {
        return N_Piece_Identite;
    }

    public void setN_Piece_Identite(String n_Piece_Identite) {
        N_Piece_Identite = n_Piece_Identite;
    }

    public Date getDate_Livraison_Identite() {
        return Date_Livraison_Identite;
    }

    public void setDate_Livraison_Identite(Date date_Livraison_Identite) {
        Date_Livraison_Identite = date_Livraison_Identite;
    }

    public String getN_Attestation_Exoneration() {
        return N_Attestation_Exoneration;
    }

    public void setN_Attestation_Exoneration(String n_Attestation_Exoneration) {
        N_Attestation_Exoneration = n_Attestation_Exoneration;
    }

    public Date getDebut_Exoneration() {
        return Debut_Exoneration;
    }

    public void setDebut_Exoneration(Date debut_Exoneration) {
        Debut_Exoneration = debut_Exoneration;
    }

    public Date getFin_Exoneration() {
        return Fin_Exoneration;
    }

    public void setFin_Exoneration(Date fin_Exoneration) {
        Fin_Exoneration = fin_Exoneration;
    }

    public double getReduction_Tva() {
        return Reduction_Tva;
    }

    public void setReduction_Tva(double reduction_Tva) {
        Reduction_Tva = reduction_Tva;
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


}
