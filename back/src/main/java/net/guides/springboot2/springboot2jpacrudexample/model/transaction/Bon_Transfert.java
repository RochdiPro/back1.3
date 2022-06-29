package net.guides.springboot2.springboot2jpacrudexample.model.transaction;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Bon_Transfert")
public class Bon_Transfert {

    @Id
    @Column(name = "Id_Bon_Transfert")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Bon_Transfert;

    @Column(name = "Responsable")
    private String Responsable;

    @Column(name = "Date")
    Date Date_Creation=java.util.Calendar.getInstance().getTime();

    @Column(name = "Description")
    private String Description;

    @Column(name = "Local_Source")
    private String Local_Source;

    @Column(name = "Local_Destination")
    private String Local_Destination;

    @Column(name = "Type_Detail")
    private String Type_Detail;

    @Column(name = "Etat")
    private String Etat ="En Cours";

    @Lob
    private byte[] Details ;

    public Bon_Transfert(Long id_Bon_Transfert, String id_Responsable,   String description, String local_Source, String local_Destination, String type_Detail, byte[] details) {
        Id_Bon_Transfert = id_Bon_Transfert;
        Responsable = id_Responsable;
        Description = description;
        Local_Source = local_Source;
        Local_Destination = local_Destination;
        Type_Detail = type_Detail;
        Details = details;
    }
    public Bon_Transfert(  String id_Responsable , String description, String local_Source, String local_Destination, String type_Detail, byte[] details) {

        Responsable = id_Responsable;
        Description = description;
        Local_Source = local_Source;
        Local_Destination = local_Destination;
        Type_Detail = type_Detail;
        Details = details;
    }

    public Bon_Transfert( ) {

    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public Long getId_Bon_Transfert() {
        return Id_Bon_Transfert;
    }

    public void setId_Bon_Transfert(Long id_Bon_Transfert) {
        Id_Bon_Transfert = id_Bon_Transfert;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String id_Responsable) {
        Responsable = id_Responsable;
    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocal_Source() {
        return Local_Source;
    }

    public void setLocal_Source(String local_Source) {
        Local_Source = local_Source;
    }

    public String getLocal_Destination() {
        return Local_Destination;
    }

    public void setLocal_Destination(String local_Destination) {
        Local_Destination = local_Destination;
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
}
