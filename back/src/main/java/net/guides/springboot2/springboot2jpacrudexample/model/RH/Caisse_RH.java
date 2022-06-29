package net.guides.springboot2.springboot2jpacrudexample.model.RH;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Caisse_RH")
public class Caisse_RH {

    @javax.persistence.Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @ManyToOne()
    @JoinColumn(name="Id_Employe", referencedColumnName = "Id_Employe", insertable = false, updatable = false)
    private Employe Employe;

    @Column(name = "Date")
    private Date Date ;

    @Column(name = "Avance")
    double Avance ;

    public Caisse_RH(net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe employe, java.util.Date date, double avance) {
        Employe = employe;
        Date = date;
        Avance = avance;
    }

    public Caisse_RH () {

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

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public double getAvance() {
        return Avance;
    }

    public void setAvance(double avance) {
        Avance = avance;
    }
}
