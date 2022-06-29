package net.guides.springboot2.springboot2jpacrudexample.service.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Taches;
import net.guides.springboot2.springboot2jpacrudexample.repository.RH.Taches_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;

import java.util.List;
import java.util.Optional;


@Service
public class Taches_Service {

    @Autowired
    Taches_Repository Repo;
    @Autowired
    DataSource dataSource;

    public List<Taches> TousTaches() {
        return (List<Taches>) Repo.findAll();
    }

    public Optional<Taches> Taches(Long id) {
        return Repo.findById(id);
    }

    public Taches Creer_Taches(String description,   Employe employe) {

        return  Repo.save(new Taches(description ,employe));
    }

    public Taches Modifier_Taches(Long id ,   String etat, String description,   Employe employe)
    {
        Taches  Entity = new Taches (      description,    employe) ;

            Optional<Taches> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Taches p = searchEntity.get();
                p.setEtat (etat);
                p.setDescription (Entity.getDescription());
                p.setEmploye (Entity.getEmploye());
                Entity = Repo.save(p);
            } else {
                throw new EntityNotFoundException();
            }
            return Entity;
    }


    public ResponseEntity<Object> Supprimer_Taches(Long id ) {
        Optional<Taches> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Taches Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ() {

        return Repo.Lister_champs();
    }

    public void Changer_Etat(Long id, String etat) {

        Optional<Taches> searchEntity = Repo.findById(id);
        if (searchEntity.isPresent()) {
            Taches p = searchEntity.get();
            p.setEtat(etat);
            Repo.save(p);
        } else {
            throw new EntityNotFoundException();
        }

    }
}
