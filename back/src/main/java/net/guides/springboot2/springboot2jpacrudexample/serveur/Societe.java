package net.guides.springboot2.springboot2jpacrudexample.serveur;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Societe")
public class Societe {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "Login")
    private String Login ;

    @Column(name = "Mote_de_passe")
    private String Mote_de_passe  ;

    @Column(name = "Socite ")
    private String Socite  ;

    @Column(name = "Date_Debut")
    private Date Date_debut  ;

    @Column(name = "Date_Fin")
    private Date Date_Fin  ;

    public Societe(String login, String mote_de_passe, String socite, Date date_debut, Date date_Fin) {
        Login = login;
        Mote_de_passe = mote_de_passe;
        Socite = socite;
        Date_debut = date_debut;
        Date_Fin = date_Fin;
    }

    public Societe( ) {

    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getMote_de_passe() {
        return Mote_de_passe;
    }

    public void setMote_de_passe(String mote_de_passe) {
        Mote_de_passe = mote_de_passe;
    }

    public String getSocite() {
        return Socite;
    }

    public void setSocite(String socite) {
        Socite = socite;
    }

    public Date getDate_debut() {
        return Date_debut;
    }

    public void setDate_debut(Date date_debut) {
        Date_debut = date_debut;
    }

    public Date getDate_Fin() {
        return Date_Fin;
    }

    public void setDate_Fin(Date date_Fin) {
        Date_Fin = date_Fin;
    }
}
