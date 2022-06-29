package net.guides.springboot2.springboot2jpacrudexample.model.RH;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Taches")
public class Taches {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "Etat")
    private String Etat ;

    @Column(name = "Type")
    private String Type ;

    @Column(name = "Description")
    private String Description ;

    @ManyToOne()
    @JoinColumn(name="Id_Employe", referencedColumnName = "Id_Employe", insertable = false, updatable = false)
    private Employe Employe;

    Date Date_Creation=java.util.Calendar.getInstance().getTime();


    public Taches(  String description, net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe employe) {
        Description = description;
        Employe = employe;
    }

    public Taches() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getType() { return Type; }

    public void setType(String type) {  Type = type; }

    public net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe getEmploye() {
        return Employe;
    }

    public void setEmploye(net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe employe) {
        Employe = employe;
    }

    public Date getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        Date_Creation = date_Creation;
    }
}
