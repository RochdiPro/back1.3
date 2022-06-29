package net.guides.springboot2.springboot2jpacrudexample.model.tms;

import javax.persistence.*;

@Entity
@Table(name = "Chauffeur")
public class Chauffeur {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "nom")
    String nom;


    @Column(name = "typepermis")
    String type;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Chauffeur (String nom , String type){this.nom =nom;this.type =type;}

    public Chauffeur(){}
}
