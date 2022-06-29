package net.guides.springboot2.springboot2jpacrudexample.model.wms;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Bon_Reception")
public class Bon_Reception {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();

    @Column
    private String Local;

    @Column
    private  long Id_Be;

    @Column
    private String Type_Be;

    @Column
    private String Etat;

    @Column
    private String Responsable;

    @Column
    private int Nb_Support ;

    public int getNb_Support() {
        return Nb_Support;
    }

    public void setNb_Support(int nb_Support) {
        Nb_Support = nb_Support;
    }

    @Lob
    private byte[] Detail;


    public Bon_Reception( ) {

    }

    public Bon_Reception(  String local, long id_Be, String type_Be, String etat, String responsable, byte[] detail , int nb_Support) {

        Local = local;
        Id_Be = id_Be;
        Type_Be = type_Be;
        Etat = etat;
        Responsable = responsable;
        Detail = detail;
        this.Nb_Support = nb_Support;
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

    public long getId_Be() {
        return Id_Be;
    }

    public void setId_Be(long id_Be) {
        Id_Be = id_Be;
    }

    public String getType_Be() {
        return Type_Be;
    }

    public void setType_Be(String type_Be) {
        Type_Be = type_Be;
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

    public byte[] getDetail() {
        return Detail;
    }

    public void setDetail(byte[] detail) {
        Detail = detail;
    }
}
