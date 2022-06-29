package net.guides.springboot2.springboot2jpacrudexample.service.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Bulletin_Paie;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.repository.RH.Bulletin_de_Paie_Repository;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.FileStorageException;
import net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Bulletin_Paie_Service {
    @Autowired
    Bulletin_de_Paie_Repository Repo;
    @Autowired
    DataSource dataSource;

    public List<Bulletin_Paie> TousBulletin_Paie() {
        return (List< Bulletin_Paie>) Repo.findAll();
    }

    public Optional< Bulletin_Paie> Bulletin_Paie(Long id) {
        return Repo.findById(id);
    }

    public  Bulletin_Paie Creer_Bulletin_Paie (Date date_de_Paie, String CNSS, String situation_Familiale, int enfant_A_Charge, double salaire_de_Base, double taux_Horaire, double mode_Paiement, int nombre_Heure_Absence, int nombre_Heure_Supplementaire, double prix_Heure_Supplementaire, double conge_Pris_Mois, double conge_acquis_mois, double solde_Conge, MultipartFile detail,  Employe utilisateur) {

        try {
            Bulletin_Paie dbFile = new Bulletin_Paie (   date_de_Paie,   CNSS,   situation_Familiale,   enfant_A_Charge,   salaire_de_Base,   taux_Horaire,   mode_Paiement,   nombre_Heure_Absence,   nombre_Heure_Supplementaire,   prix_Heure_Supplementaire,   conge_Pris_Mois,   conge_acquis_mois,   solde_Conge,   detail .getBytes(),    utilisateur) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }


    public Bulletin_Paie  Modifier_Bulletin_Paie(Long id , Date date_de_Paie, String CNSS, String situation_Familiale, int enfant_A_Charge, double salaire_de_Base, double taux_Horaire, double mode_Paiement, int nombre_Heure_Absence, int nombre_Heure_Supplementaire, double prix_Heure_Supplementaire, double conge_Pris_Mois, double conge_acquis_mois, double solde_Conge, MultipartFile detail,  Employe utilisateur) {

        try {
            Bulletin_Paie Entity = new Bulletin_Paie (   date_de_Paie,   CNSS,   situation_Familiale,   enfant_A_Charge,   salaire_de_Base,   taux_Horaire,   mode_Paiement,   nombre_Heure_Absence,   nombre_Heure_Supplementaire,   prix_Heure_Supplementaire,   conge_Pris_Mois,   conge_acquis_mois,   solde_Conge,   detail .getBytes(),    utilisateur) ;
            Optional<Bulletin_Paie> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Bulletin_Paie p = searchEntity.get();
                p.setDate_de_Paie (Entity.getDate_de_Paie());
                p.setCNSS(Entity.getCNSS());
                p.setSituation_Familiale (Entity.getSituation_Familiale());
                p.setEnfant_A_Charge (Entity.getEnfant_A_Charge());
                p.setSalaire_de_Base (Entity.getSalaire_de_Base());
                p.setTaux_Horaire (Entity.getTaux_Horaire());
                p.setMode_Paiement (Entity.getMode_Paiement());
                p.setNombre_Heure_Absence (Entity.getNombre_Heure_Absence());
                p.setNombre_Heure_Supplementaire (Entity.getNombre_Heure_Supplementaire());
                p.setPrix_Heure_Supplementaire (Entity.getPrix_Heure_Supplementaire());
                p.setConge_Pris_Mois (Entity.getConge_Pris_Mois());
                p.setConge_acquis_mois(Entity.getConge_acquis_mois());
                p.setSolde_Conge (Entity.getSolde_Conge());
                p.setDetail (Entity.getDetail());
                p.setUtilisateur(Entity.getUtilisateur());
                Entity = Repo.save(p);
            } else {
                throw new EntityNotFoundException();
            }
            return Entity;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }


    public ResponseEntity<Object> Supprimer_Bulletin_Paie(Long id ) {
        Optional< Bulletin_Paie> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Bulletin_Paie Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ() {

        return Repo.Lister_champs();
    }


    public  Bulletin_Paie Detail (Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

}
