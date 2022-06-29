package net.guides.springboot2.springboot2jpacrudexample.model.wms;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Bon_Sortie")
public class Bon_Sortie {
    @javax.persistence.Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;


    Date Date_Creation = java.util.Calendar.getInstance().getTime();

    @Column
    private String Local;

    @Column
    private String Responsable;

    @Column
    private String Reclamation;

    @Lob
    private byte[] Detail;

    public Bon_Sortie(  String local, String responsable, String reclamation, byte[] detail) {

        Local = local;
        Responsable = responsable;
        Reclamation = reclamation;
        Detail = detail;
    }

    public Bon_Sortie( ) {

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


