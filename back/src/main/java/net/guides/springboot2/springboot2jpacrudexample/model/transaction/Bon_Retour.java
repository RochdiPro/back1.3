package net.guides.springboot2.springboot2jpacrudexample.model.transaction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Bon_Retour")
public class Bon_Retour {

    @Id
    @Column(name = "Id_Bon_Retour")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Bon_Retour;

    @Column(name = "Id_Clt")
    private String Id_Clt;

    @Column(name = "N_Facture")
    private String N_Facture;




    @Column(name = "Description")
    private String Description;

    @Column(name = "Local")
    private String Local;

    @Column(name = "Id_Responsable")
    private String Id_Responsable;

    @Column(name = "Etat")
    private String Etat ="En Cours";

    @Column(name = "Type_Detail")
    private String Type_Detail;

    @Lob
    private byte[] Details ;

    @Column(name = "Date")
    Date Date_Creation=java.util.Calendar.getInstance().getTime();

    public Bon_Retour(Long id_Bon_Retour, String id_Clt, String n_Facture , String description, String local, String id_Responsable, String type_Detail, byte[] details) {
        Id_Bon_Retour = id_Bon_Retour;
        Id_Clt = id_Clt;
        N_Facture = n_Facture;
        Description = description;
        Local = local;
        Id_Responsable = id_Responsable;
        Type_Detail = type_Detail;
        Details = details;
    }

    public Bon_Retour( String id_Clt, String n_Facture,  String description, String local, String id_Responsable, String type_Detail, byte[] details) {

        Id_Clt = id_Clt;
        N_Facture = n_Facture;

        Description = description;
        Local = local;
        Id_Responsable = id_Responsable;
        Type_Detail = type_Detail;
        Details = details;
    }

    public Bon_Retour( ) {

    }

    public Long getId_Bon_Retour() {
        return Id_Bon_Retour;
    }

    public void setId_Bon_Retour(Long id_Bon_Retour) {
        Id_Bon_Retour = id_Bon_Retour;
    }

    public String getId_Clt() {
        return Id_Clt;
    }

    public void setId_Clt(String id_Clt) {
        Id_Clt = id_Clt;
    }

    public String getN_Facture() {
        return N_Facture;
    }

    public void setN_Facture(String n_Facture) {
        N_Facture = n_Facture;
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

    public byte[] getDetails() {
        return Details;
    }

    public void setDetails(byte[] details) {
        Details = details;
    }

    public String getEtat() {return Etat;}

    public void setEtat(String etat) {  Etat = etat;}

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }
}
