package net.guides.springboot2.springboot2jpacrudexample.service.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Ngp;
import net.guides.springboot2.springboot2jpacrudexample.repository.init.Ngp_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Service
public class Ngp_Service {

    @Autowired
    Ngp_Repository Repo;
    @Autowired
    DataSource dataSource;


    public List<Ngp> Tous() {
        return (List<Ngp>) Repo.findAll();
    }

    public Optional<Ngp> Ngp(Long id) {
        return Repo.findById(id);
    }

    public Ngp Creer_Ngp(String nom) {

       return Repo.save(new Ngp(nom));
    }


    public ResponseEntity<Object> Supprimer_Fournisseur(Long id_Local) {
        Optional<Ngp> Entity = Repo.findById(id_Local);
        if (Entity.isPresent()) {
            Ngp Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ() {

        return Repo.Lister_champs();
    }
}


