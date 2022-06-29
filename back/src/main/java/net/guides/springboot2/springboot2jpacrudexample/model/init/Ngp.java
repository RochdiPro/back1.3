package net.guides.springboot2.springboot2jpacrudexample.model.init;


import javax.persistence.*;

@Entity
@Table(name = "Ngp")
public class Ngp {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "Nom")
    private String Nom ;


    public Ngp(String nom) {
        Nom = nom;
    }
    public Ngp() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
