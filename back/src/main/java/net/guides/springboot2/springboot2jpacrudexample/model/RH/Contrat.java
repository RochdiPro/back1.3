package net.guides.springboot2.springboot2jpacrudexample.model.RH;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Contrat")
public class Contrat {

    @javax.persistence.Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @ManyToOne()
    @JoinColumn(name="Id_Employe", referencedColumnName = "Id_Employe", insertable = false, updatable = false)
    private Employe Employe;

    @Column(name = "Date_Debut")
    private Date Date_Debut ;

    @Column(name = "Date_Fin")
    private Date Date_Fin ;

    @Column(name = "Type")
    private String  Type ;

    @Lob
    private byte[] Detail;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();

    public Contrat( Employe employe, Date date_Debut, Date date_Fin, String type, byte[] detail) {
        Employe = employe;
        Date_Debut = date_Debut;
        Date_Fin = date_Fin;
        Type = type;
        Detail = detail;
    }

    public Contrat( ) {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe getEmploye() {
        return Employe;
    }

    public void setEmploye(net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe employe) {
        Employe = employe;
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public byte[] getDetail() {
        return Detail;
    }

    public void setDetail(byte[] detail) {
        Detail = detail;
    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }
}
