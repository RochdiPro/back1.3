package net.guides.springboot2.springboot2jpacrudexample.model.RH;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Conge")
public class Conge {

    @javax.persistence.Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "Type")
    private String Type ;

    @Column(name = "Etat")
    private String Etat = "en cours" ;

    @Column(name = "Raison")
    private String Raison ;

    @Column(name = "Description ")
    private String Description  ;

    @Column(name = "Document_Type")
    String Document_Type;

    @Lob
    private byte[] Document;

    @Column(name = "Date_Debut")
    private Date Date_Debut ;

    @Column(name = "Date_Fin")
    private Date Date_Fin ;

    @Column(name = "NB_Jours")
    private int NB_Jours ;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();


    @ManyToOne()
    @JoinColumn(name="Id_Employe", referencedColumnName = "Id_Employe", insertable = false, updatable = false)
    private Employe Employe;

    public Conge(String type, String etat, String raison, String description, String document_Type, byte[] document, Date date_Debut, Date date_Fin, int NB_Jours, net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe employe) {
        Type = type;
        Etat = etat;
        Raison = raison;
        Description = description;
        Document_Type = document_Type;
        Document = document;
        Date_Debut = date_Debut;
        Date_Fin = date_Fin;
        this.NB_Jours = NB_Jours;
        Employe = employe;
    }
    public Conge()
    {

    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public String getRaison() {
        return Raison;
    }

    public void setRaison(String raison) {
        Raison = raison;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDocument_Type() {
        return Document_Type;
    }

    public void setDocument_Type(String document_Type) {
        Document_Type = document_Type;
    }

    public byte[] getDocument() {
        return Document;
    }

    public void setDocument(byte[] document) {
        Document = document;
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

    public int getNB_Jours() {
        return NB_Jours;
    }

    public void setNB_Jours(int NB_Jours) {
        this.NB_Jours = NB_Jours;
    }



    public net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe getEmploye() {
        return Employe;
    }

    public void setEmploye(net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe employe) {
        Employe = employe;
    }
}
