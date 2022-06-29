package net.guides.springboot2.springboot2jpacrudexample.service.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Caisse_RH;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Local;
import net.guides.springboot2.springboot2jpacrudexample.repository.RH.Caisse_RH_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.RH.Contrat_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


@Service
public class Caisse_RH_Service {

    @Autowired
    Caisse_RH_Repository Repo;
    @Autowired
    DataSource dataSource;

    public List<Caisse_RH> Caisse_RHs() {
        return (List<Caisse_RH>)  Repo.findAll();
    }
    public Optional<Caisse_RH> Local(Long id) {
        return   Repo.findById(id);
    }

    public Caisse_RH Creer_Caisse_RH(Caisse_RH Entity) {
        return  Repo.save( Entity);
    }

    public Caisse_RH Modifier_Caisse_RH(Long id_Local, Caisse_RH Entity) {
        Caisse_RH updated;
        Optional<Caisse_RH> searchEntity =  Repo.findById(id_Local);
        if (searchEntity.isPresent()) {
            Caisse_RH p = searchEntity.get();
            p.setEmploye(Entity.getEmploye());
            p.setDate(Entity.getDate());
            p.setAvance(Entity.getAvance());
            Entity = Repo.save(p);
        } else {
            throw new EntityNotFoundException();
        }
        return Entity;
    }

    public ResponseEntity<Object> Supprimer_Caisse_RH(Long id_Local) {
        Optional<Caisse_RH>  Entity =  Repo.findById(id_Local);
        if (Entity.isPresent()) {
            Caisse_RH Entity_deleted = Entity.get();
            //   Supprimer_local (Entity.getNom_Local());
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }
}
