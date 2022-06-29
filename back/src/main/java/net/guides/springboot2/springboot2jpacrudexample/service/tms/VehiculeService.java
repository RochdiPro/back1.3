package net.guides.springboot2.springboot2jpacrudexample.service.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.Vehicule;
import net.guides.springboot2.springboot2jpacrudexample.repository.tms.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {

    @Autowired
    VehiculeRepository vehiculeRepo;

    @Autowired
    DataSource dataSource;

    public List<Vehicule> getAll() {
        return (List<Vehicule>) vehiculeRepo.findAll();
    }

    public Optional<Vehicule> getVehicule(Long Id) {
        return vehiculeRepo.findById(Id);
    }


    public Vehicule createVehicule(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    public Vehicule updateVehicule(Long Id, Vehicule vehicule) {
        Vehicule updatedVehicule;
        Optional<Vehicule> searchVehicule = vehiculeRepo.findById(Id);
        if (searchVehicule.isPresent()) {
            Vehicule v = searchVehicule.get();
            //v.setMatricule(vehicule.getMatricule());
            //v.setCategories(vehicule.getCategories());
            v.setKmactuel(vehicule.getKmactuel());
            v.setKmprochainentretien(vehicule.getKmprochainentretien());
            v.setConsommation(vehicule.getConsommation());
            v.setCarburant(vehicule.getCarburant());
            //v.setPrixcarburant(vehicule.getPrixcarburant());
            v.setConsommationNormale(vehicule.getConsommationNormale());
            v.setDistanceparcourie(vehicule.getDistanceparcourie());
            v.setDatevisite(vehicule.getDatevisite());
            v.setDateassurance(vehicule.getDateassurance());
            v.setDatetaxe(vehicule.getDatetaxe());
            updatedVehicule = vehiculeRepo.save(v);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedVehicule;
    }
    public Vehicule majPrixCarburant(String carburant, float valeur) {
        try {
            /*String query = "UPDATE Vehicule\n" +
                    "SET prixcarburant = '"+ valeur +"%'" +
                    "WHERE carburant like '"+ carburant +"%'";
            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            stmt.executeQuery(query);
            stmt.close();
            cnx.close();*/
            String query = "update Vehicule set prixcarburant = ? where carburant = ?";
            Connection cnx = dataSource.getConnection() ;
            PreparedStatement preparedStmt = cnx.prepareStatement(query);
            preparedStmt.setFloat   (1, valeur);
            preparedStmt.setString(2, carburant);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public Vehicule reclamationVehicule(Long Id, Vehicule vehicule) {
        Vehicule reclamationVehicule;
        Optional<Vehicule> searchVehicule = vehiculeRepo.findById(Id);
        if (searchVehicule.isPresent()) {
            Vehicule v = searchVehicule.get();
            v.setSujet(vehicule.getSujet());
            v.setDescription(vehicule.getDescription());
            reclamationVehicule = vehiculeRepo.save(v);
        } else {
            throw new EntityNotFoundException();
        }
        return reclamationVehicule;
    }
    public Vehicule updateKM(Long Id, Vehicule vehicule) {
        Vehicule KM;
        Optional<Vehicule> searchVehicule = vehiculeRepo.findById(Id);
        if (searchVehicule.isPresent()) {
            Vehicule v = searchVehicule.get();
            v.setKmactuel(vehicule.getKmactuel());
            v.setConsommation(vehicule.getConsommation());
            v.setDistanceparcourie(vehicule.getDistanceparcourie());
            KM = vehiculeRepo.save(v);
        } else {
            throw new EntityNotFoundException();
        }
        return KM;
    }

    public Vehicule majEtatVehicule(Long Id, Vehicule vehicule) {
        Vehicule etat;
        Optional<Vehicule> searchVehicule = vehiculeRepo.findById(Id);
        if (searchVehicule.isPresent()) {
            Vehicule v = searchVehicule.get();
            v.setEtatVehicule(vehicule.getEtatVehicule());
            etat = vehiculeRepo.save(v);
        } else {
            throw new EntityNotFoundException();
        }
        return etat;
    }

    public Vehicule majChargeEtSurface(Long Id, Vehicule vehicule) {
        Vehicule reste;
        Optional<Vehicule> searchVehicule = vehiculeRepo.findById(Id);
        if (searchVehicule.isPresent()) {
            Vehicule v = searchVehicule.get();
            v.setCharge_restante(vehicule.getCharge_restante());
            v.setSurface_restante(vehicule.getSurface_restante());
            reste = vehiculeRepo.save(v);
        } else {
            throw new EntityNotFoundException();
        }
        return reste;
    }

    public ResponseEntity<Object> deleteVehicule(Long Id) {
        Optional<Vehicule> vehicule = vehiculeRepo.findById(Id);
        if (vehicule.isPresent()) {
            Vehicule v = vehicule.get();
            vehiculeRepo.delete(v);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

}
