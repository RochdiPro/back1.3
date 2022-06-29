package net.guides.springboot2.springboot2jpacrudexample.service.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.PositionClient;
import net.guides.springboot2.springboot2jpacrudexample.model.tms.PositionFournisseur;
import net.guides.springboot2.springboot2jpacrudexample.repository.tms.PositionClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PositionClientService {

    @Autowired
    PositionClientRepository positionClientRepo;

    public List<PositionClient> getAll() {
        return (List<PositionClient>) positionClientRepo.findAll();
    }

    public Optional<PositionClient> getPosClient(Long Id) {
        return positionClientRepo.findById(Id);
    }

    public PositionClient creerPositionClient(PositionClient posClient) {
        return positionClientRepo.save(posClient);
    }

    public PositionClient majPositionClient(Long Id, PositionClient posClient) {
        PositionClient updatedPosClient;
        Optional<PositionClient> searchPosClient = positionClientRepo.findById(Id);
        if (searchPosClient.isPresent()) {
            PositionClient pos = searchPosClient.get();
            pos.setLatitude(posClient.getLatitude());
            pos.setLongitude(posClient.getLongitude());
            updatedPosClient = positionClientRepo.save(pos);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedPosClient;
    }

    public ResponseEntity<Object> deletePosClient(Long Id) {
        Optional<PositionClient> posClient = positionClientRepo.findById(Id);
        if (posClient.isPresent()) {
            PositionClient pos = posClient.get();
            positionClientRepo.delete(pos);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
}
