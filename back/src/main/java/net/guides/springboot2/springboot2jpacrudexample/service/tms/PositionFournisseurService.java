package net.guides.springboot2.springboot2jpacrudexample.service.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.PositionFournisseur;
 import net.guides.springboot2.springboot2jpacrudexample.model.tms.Vehicule;
import net.guides.springboot2.springboot2jpacrudexample.repository.tms.PositionFournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PositionFournisseurService {

    @Autowired
    PositionFournisseurRepository positionFournisseurRepo;

    public List<PositionFournisseur> getAll() {
        return (List<PositionFournisseur>) positionFournisseurRepo.findAll();
    }

    public Optional<PositionFournisseur> getPosFournisseur(Long Id) {
        return positionFournisseurRepo.findById(Id);
    }

    public PositionFournisseur creerPositionFournisseur(PositionFournisseur posFournisseur) {
        return positionFournisseurRepo.save(posFournisseur);
    }

    public PositionFournisseur majPositionFourniseeur(Long Id, PositionFournisseur posFournisseur) {
        PositionFournisseur updatedPosFournisseur;
        Optional<PositionFournisseur> searchPosFournisseur = positionFournisseurRepo.findById(Id);
        if (searchPosFournisseur.isPresent()) {
            PositionFournisseur pos = searchPosFournisseur.get();
            pos.setLatitude(posFournisseur.getLatitude());
            pos.setLongitude(posFournisseur.getLongitude());
            updatedPosFournisseur = positionFournisseurRepo.save(pos);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedPosFournisseur;
    }

    public ResponseEntity<Object> deletePosFournisseur(Long Id) {
        Optional<PositionFournisseur> posFournisseur = positionFournisseurRepo.findById(Id);
        if (posFournisseur.isPresent()) {
            PositionFournisseur pos = posFournisseur.get();
            positionFournisseurRepo.delete(pos);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

}
