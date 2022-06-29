package net.guides.springboot2.springboot2jpacrudexample.service.tms;

import ch.qos.logback.core.db.ConnectionSource;
import net.guides.springboot2.springboot2jpacrudexample.model.tms.Affectation;
 import net.guides.springboot2.springboot2jpacrudexample.repository.tms.AffectationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AffectationService {

    @Autowired
    AffectationRepository affectationRepo;

    @Autowired
    DataSource dataSource;

    public List<Affectation> getAll() {
        return (List<Affectation>) affectationRepo.findAll();
    }

    public Optional<Affectation> getAffectation(Long Id) {
        return affectationRepo.findById(Id);
    }

    public Affectation createAffectation(Affectation affectation) {
        return affectationRepo.save(affectation);
    }

    public Affectation updateAffectation(Long Id, Affectation affectation) {
        Affectation updatedAffectation;
        Optional<Affectation> searchAffectation = affectationRepo.findById(Id);
        if (searchAffectation.isPresent()) {
            Affectation aff = searchAffectation.get();
            aff.setNom(affectation.getNom());
            aff.setMatricule(affectation.getMatricule());
            aff.setDateLivraison(affectation.getDateLivraison());
            aff.setEtatMission(affectation.getEtatMission());
            updatedAffectation = affectationRepo.save(aff);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedAffectation;
    }

    public Affectation majTrajet(Long Id, Affectation affectation) {
        Affectation updatedAffectation;
        Optional<Affectation> searchAffectation = affectationRepo.findById(Id);
        if (searchAffectation.isPresent()) {
            Affectation aff = searchAffectation.get();
            aff.setTrajet(affectation.getTrajet());
            updatedAffectation = affectationRepo.save(aff);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedAffectation;
    }

    public Affectation majEtatMission(Long id, String valeur) {
        try {
            String query = "update Affectation set etat_mission = ? where id = ?";
            Connection cnx = dataSource.getConnection() ;
            PreparedStatement preparedStmt = cnx.prepareStatement(query);
            preparedStmt.setString   (1, valeur);
            preparedStmt.setLong(2, id);

            preparedStmt.executeUpdate();

            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResponseEntity<Object> deleteAffectation(Long Id) {
        Optional<Affectation> affectation = affectationRepo.findById(Id);
        if (affectation.isPresent()) {
            Affectation aff = affectation.get();
            affectationRepo.delete(aff);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
    public List<Affectation> filtre(String champ, String valeur) {
        List<Affectation> liste = new ArrayList<>();
        try {
            String query = "select    id as id , idE as idE , nom as nom ,     matricule as matricule  , date_livraison as dateLivraison , trajet as trajet ,   etat_mission as etatMission" +
                    "  from Affectation where " + champ + " like '" + valeur + "%'";
            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Affectation aff = new Affectation();
                aff.setId(rs.getLong("id"));
                aff.setIdE(rs.getInt("idE"));
                aff.setNom(rs.getString("nom"));
                aff.setMatricule(rs.getString("matricule"));
                aff.setDateLivraison(rs.getDate("dateLivraison"));
                aff.setTrajet(rs.getString("trajet"));
                aff.setEtatMission(rs.getString("etatMission"));
                liste.add(aff);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }


    public List<Affectation> filtreDeuxFacteurs(String champ1, String valeur1,String champ2, String valeur2) {
        List<Affectation> liste = new ArrayList<>();
        try {
            String query = "select    id as id , idE as idE , nom as nom ,     matricule as matricule  , date_livraison as dateLivraison , trajet as trajet ,   etat_mission as etatMission" +
                    "  from Affectation where " + champ1 + " like '" + valeur1 + "%' AND "  + champ2 + " like '" + valeur2 + "%'";
            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Affectation aff = new Affectation();
                aff.setId(rs.getLong("id"));
                aff.setIdE(rs.getInt("idE"));
                aff.setNom(rs.getString("nom"));
                aff.setMatricule(rs.getString("matricule"));
                aff.setDateLivraison(rs.getDate("dateLivraison"));
                aff.setTrajet(rs.getString("trajet"));
                aff.setEtatMission(rs.getString("etatMission"));
                liste.add(aff);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }

    public List<Affectation> filtreTroisFacteurs(String champ1, String valeur1,String champ2, String valeur2,String champ3, String valeur3) {
        List<Affectation> liste = new ArrayList<>();
        try {
            String query = "select    id as id , idE as idE , nom as nom ,     matricule as matricule  , date_livraison as dateLivraison , trajet as trajet ,  etat_mission as etatMission" +
                    "  from Affectation where " + champ1 + " like '" + valeur1 + "%' AND "  + champ2 + " like '" + valeur2 + "%' AND "  + champ3 + " like '" + valeur3 + "%'";
            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Affectation aff = new Affectation();
                aff.setId(rs.getLong("id"));
                aff.setIdE(rs.getInt("idE"));
                aff.setNom(rs.getString("nom"));
                aff.setMatricule(rs.getString("matricule"));
                aff.setDateLivraison(rs.getDate("dateLivraison"));
                aff.setTrajet(rs.getString("trajet"));
                aff.setEtatMission(rs.getString("etatMission"));
                liste.add(aff);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }

}
