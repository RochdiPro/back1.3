package net.guides.springboot2.springboot2jpacrudexample.model.wms;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Bon_Rejet")
public class Bon_Rejet {

    @javax.persistence.Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;


    Date Date_Creation=java.util.Calendar.getInstance().getTime();

    @Column
    private String Local;

    @Column
    private  String Id_Bon;

    @Column
    private String Type_Bon;

    @Column
    private String Etat;

    @Column
    private String Responsable;

    @Column
    private String Reclamation;

    @Lob
    private byte[] Detail;


    public Bon_Rejet( ) {

    }

    public Bon_Rejet(String local, String id_Bon, String type_Bon, String etat, String responsable, String reclamation, byte[] detail) {
        Local = local;
        Id_Bon = id_Bon;
        Type_Bon = type_Bon;
        Etat = etat;
        Responsable = responsable;
        Reclamation = reclamation;
        Detail = detail;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }

    public String getId_Bon() {
        return Id_Bon;
    }

    public void setId_Bon(String id_Bon) {
        Id_Bon = id_Bon;
    }

    public String getType_Bon() {
        return Type_Bon;
    }

    public void setType_Bon(String type_Bon) {
        Type_Bon = type_Bon;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String responsable) {
        Responsable = responsable;
    }

    public String getReclamation() {
        return Reclamation;
    }

    public void setReclamation(String reclamation) {
        Reclamation = reclamation;
    }

    public byte[] getDetail() {
        return Detail;
    }

    public void setDetail(byte[] detail) {
        Detail = detail;
    }
}
