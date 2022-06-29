package net.guides.springboot2.springboot2jpacrudexample.service.RH;


import net.guides.springboot2.springboot2jpacrudexample.model.RH.Contrat;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.repository.RH.Contrat_Repository;
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
public class Contrat_Service {

    @Autowired
    Contrat_Repository Repo;
    @Autowired
    DataSource dataSource;

    public List<Contrat> TousContrats() {
        return (List<Contrat>) Repo.findAll();
    }

    public Optional<Contrat> Contrat(Long id) {
        return Repo.findById(id);
    }

    public Contrat Creer_Contrat( Employe employe, Date date_Debut, Date date_Fin, String type,  MultipartFile document) {
        try {
            Contrat  dbFile = new Contrat (   employe,   date_Debut,   date_Fin,   type ,  document.getBytes() ) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    public Contrat Modifier_Contrat(Long id ,Employe employe, Date date_Debut, Date date_Fin, String type,  MultipartFile document) {
        try {
            Contrat  Entity = new Contrat (   employe,   date_Debut,   date_Fin,   type ,  document.getBytes() ) ;
            Optional<Contrat> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Contrat p = searchEntity.get();
                p.setType(Entity.getType());
                p.setDate_Debut (Entity.getDate_Debut());
                p.setDate_Fin (Entity.getDate_Fin());
                p.setEmploye (Entity.getEmploye());
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


    public ResponseEntity<Object> Supprimer_Contrat(Long id ) {
        Optional<Contrat> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Contrat Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ() {
        return Repo.Lister_champs();
    }


    public Contrat Document (Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

}
