package net.guides.springboot2.springboot2jpacrudexample.model.tms;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Commandes")
public class Commandes {
    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "id_mission")
    Long idMission;

    @Column(name = "reference_commande")
    Long referenceCommande;

    @Column(name = "expediteur")
    String expediteur;

    @Column(name = "adresse_expediteur")
    String adresse_expediteur;

    @Column(name = "contact_expediteur")
    String contact_expediteur;

    @Column(name = "tel_expediteur")
    Long tel_expediteur;

    @Column(name = "destinataire")
    String destinataire;

    @Column(name = "adresse_destinataire")
    String adresse_destinataire;

    @Column(name = "contact_destinataire")
    String contact_destinataire;

    @Column(name = "tel_destinataire")
    Long tel_destinataire;

    @Column(name = "date_commande")
    Date date_commande;

    @Column(name = "type_commande")
    String type;

    @Column(name = "nbr_obj")
    Long nbr_obj;

    @Column(name = "description")
    String description;

    @Column(name = "articles")
    String articles;

    @Column(name = "etat")
    String etat;

    @Column(name = "position_expediteur")
    String positionExp;

    @Column(name = "position_destinataire")
    String positionDest;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getIdMission() {
        return idMission;
    }

    public void setIdMission(Long idMission) {
        this.idMission = idMission;
    }

    public Long getReferenceCommande() {
        return referenceCommande;
    }

    public void setReferenceCommande(Long referenceCommande) {
        this.referenceCommande = referenceCommande;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getAdresse_expediteur() {
        return adresse_expediteur;
    }

    public void setAdresse_expediteur(String adresse_expediteur) {
        this.adresse_expediteur = adresse_expediteur;
    }

    public String getContact_expediteur() {
        return contact_expediteur;
    }

    public void setContact_expediteur(String contact_expediteur) {
        this.contact_expediteur = contact_expediteur;
    }

    public Long getTel_expediteur() {
        return tel_expediteur;
    }

    public void setTel_expediteur(Long tel_expediteur) {
        this.tel_expediteur = tel_expediteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getAdresse_destinataire() {
        return adresse_destinataire;
    }

    public void setAdresse_destinataire(String adresse_destinataire) {
        this.adresse_destinataire = adresse_destinataire;
    }

    public String getContact_destinataire() {
        return contact_destinataire;
    }

    public void setContact_destinataire(String contact_destinataire) {
        this.contact_destinataire = contact_destinataire;
    }

    public Long getTel_destinataire() {
        return tel_destinataire;
    }

    public void setTel_destinataire(Long tel_destinataire) {
        this.tel_destinataire = tel_destinataire;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getNbr_obj() {
        return nbr_obj;
    }

    public void setNbr_obj(Long nbr_obj) {
        this.nbr_obj = nbr_obj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticles() {
        return articles;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPositionExp() {
        return positionExp;
    }

    public void setPositionExp(String positionExp) {
        this.positionExp = positionExp;
    }

    public String getPositionDest() {
        return positionDest;
    }

    public void setPositionDest(String positionDest) {
        this.positionDest = positionDest;
    }

    public Commandes(Long idMission, Long referenceCommande, String expediteur, String adresse_expediteur, String contact_expediteur, Long tel_expediteur, String destinataire, String adresse_destinataire, String contact_destinataire, Long tel_destinataire, Date date_commande, String type, Long nbr_obj, String description, String articles, String etat, String positionExp, String positionDest) {
        this.idMission = idMission;
        this.referenceCommande = referenceCommande;
        this.expediteur = expediteur;
        this.adresse_expediteur = adresse_expediteur;
        this.contact_expediteur = contact_expediteur;
        this.tel_expediteur = tel_expediteur;
        this.destinataire = destinataire;
        this.adresse_destinataire = adresse_destinataire;
        this.contact_destinataire = contact_destinataire;
        this.tel_destinataire = tel_destinataire;
        this.date_commande = date_commande;
        this.type = type;
        this.nbr_obj = nbr_obj;
        this.description = description;
        this.articles = articles;
        this.etat = etat;
        this.positionExp = positionExp;
        this.positionDest = positionDest;
    }

    public Commandes(String etat) {
        this.etat = etat;
    }

    public Commandes() {
    }
}
