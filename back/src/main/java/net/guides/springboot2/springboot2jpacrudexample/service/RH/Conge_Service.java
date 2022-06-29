package net.guides.springboot2.springboot2jpacrudexample.service.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Conge;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.repository.RH.Conge_Repository;
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
public class Conge_Service {

    @Autowired
    Conge_Repository Repo;
    @Autowired
    DataSource dataSource;

    public List<Conge> TousConges() {
        return (List<Conge>) Repo.findAll();
    }

    public Optional<Conge> Conge(Long id) {
        return Repo.findById(id);
    }

    public Conge Creer_Conge(String type, String etat, String raison, String description,   MultipartFile document, Date date_Debut, Date date_Fin, int NB_Jours,  Employe utilisateur) {

        try {
            Conge  dbFile = new Conge (  type,   etat,   raison,   description,   document.getContentType(), document.getBytes(),   date_Debut,   date_Fin,   NB_Jours,   utilisateur) ;
                return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    public Conge Modifier_Conge(Long id , String type, String etat, String raison, String description,  MultipartFile document, Date date_Debut, Date date_Fin, int NB_Jours,  Employe utilisateur) {
        try {
            Conge  Entity = new Conge (  type,   etat,   raison,   description,   document.getContentType(), document.getBytes(),   date_Debut,   date_Fin,   NB_Jours,   utilisateur) ;

            Optional<Conge> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Conge p = searchEntity.get();
                p.setType(Entity.getType());
                p.setEtat (Entity.getEtat());
                p.setRaison (Entity.getRaison());
                p.setDescription (Entity.getDescription());
                p.setDocument_Type (Entity.getDocument_Type());
                p.setDocument (Entity.getDocument());
                p.setDate_Debut (Entity.getDate_Debut());
                p.setDate_Fin (Entity.getDate_Fin());
                p.setNB_Jours (Entity.getNB_Jours());
                p.setEmploye (Entity.getEmploye());
                p.setDescription (Entity.getDescription());

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


    public ResponseEntity<Object> Supprimer_Conge(Long id ) {
        Optional<Conge> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Conge Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ() {

        return Repo.Lister_champs();
    }


    public Conge Document (Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public void Changer_Etat(Long id, String etat) {

        Optional<Conge> searchEntity = Repo.findById(id);
        if (searchEntity.isPresent()) {
            Conge p = searchEntity.get();
            p.setEtat(etat);
            Repo.save(p);
        } else {
            throw new EntityNotFoundException();
        }

    }
}
