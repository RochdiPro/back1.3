package net.guides.springboot2.springboot2jpacrudexample.service.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.Chauffeur;
import net.guides.springboot2.springboot2jpacrudexample.repository.tms.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ChauffeurService {

    @Autowired
    ChauffeurRepository chauffeurRepo;

    public List<Chauffeur> getAll() {
        return (List<Chauffeur>) chauffeurRepo.findAll();
    }

    public Chauffeur createChauffeur(Chauffeur chauffeur) {
        return chauffeurRepo.save(chauffeur);
    }

    public Chauffeur updateChauffeur(Long Id, Chauffeur chauffeur) {
        Chauffeur updatedChauffeur;
        Optional<Chauffeur> searchChauffeur = chauffeurRepo.findById(Id);
        if (searchChauffeur.isPresent()) {
            Chauffeur ch = searchChauffeur.get();
            ch.setType(chauffeur.getType());
            ch.setNom(chauffeur.getNom());
            updatedChauffeur = chauffeurRepo.save(ch);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedChauffeur;
    }

    public ResponseEntity<Object> deleteChauffeur(Long Id) {
        Optional<Chauffeur> chauffeur = chauffeurRepo.findById(Id);
        if (chauffeur.isPresent()) {
            Chauffeur ch = chauffeur.get();
            chauffeurRepo.delete(ch);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

}
