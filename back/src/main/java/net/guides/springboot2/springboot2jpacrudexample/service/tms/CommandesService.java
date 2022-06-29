package net.guides.springboot2.springboot2jpacrudexample.service.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.Commandes;
import net.guides.springboot2.springboot2jpacrudexample.repository.tms.CommandesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommandesService {
    @Autowired
    CommandesRepository commandesRepo;

    @Autowired
    DataSource dataSource;

    public List<Commandes> getAll() {
        return (List<Commandes>) commandesRepo.findAll();
    }

    public Optional<Commandes> getCommande(Long Id) {
        return commandesRepo.findById(Id);
    }

    public Commandes createCommande(Commandes commande) {
        return commandesRepo.save(commande);
    }

    public Commandes updateCommande(Long Id, Commandes commande) {
        Commandes updatedCommande;
        Optional<Commandes> searchCommande = commandesRepo.findById(Id);
        if (searchCommande.isPresent()) {
            Commandes com = searchCommande.get();
            com.setIdMission(commande.getIdMission());
            com.setReferenceCommande(commande.getReferenceCommande());
            com.setExpediteur(commande.getExpediteur());
            com.setAdresse_expediteur(commande.getAdresse_expediteur());
            com.setContact_expediteur(commande.getContact_expediteur());
            com.setTel_expediteur(commande.getTel_expediteur());
            com.setDestinataire(commande.getDestinataire());
            com.setAdresse_destinataire(commande.getAdresse_destinataire());
            com.setContact_destinataire(commande.getContact_destinataire());
            com.setTel_destinataire(commande.getTel_destinataire());
            com.setDate_commande(commande.getDate_commande());
            com.setType(commande.getType());
            com.setNbr_obj(commande.getNbr_obj());
            com.setDescription(commande.getDescription());
            com.setArticles(commande.getArticles());
            com.setEtat(commande.getEtat());
            com.setPositionExp(commande.getPositionExp());
            com.setPositionDest(commande.getPositionDest());
            updatedCommande = commandesRepo.save(com);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedCommande;
    }
    public Commandes majEtat(Long Id, Commandes commande) {
        Commandes com;
        Optional<Commandes> searchCommande = commandesRepo.findById(Id);
        if (searchCommande.isPresent()) {
            Commandes c = searchCommande.get();
            c.setEtat(commande.getEtat());
            com = commandesRepo.save(c);
        } else {
            throw new EntityNotFoundException();
        }
        return com;
    }

    public ResponseEntity<Object> deleteCommande(Long Id) {
        Optional<Commandes> commande = commandesRepo.findById(Id);
        if (commande.isPresent()) {
            Commandes com = commande.get();
            commandesRepo.delete(com);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
    public List<Commandes> filtre(String champ, String valeur) {
        List<Commandes> liste = new ArrayList<>();
        try {
            String query = "select    id as id , id_mission as idMission , reference_commande as referenceCommande "+
                    ", expediteur as expediteur , adresse_expediteur as adresseExpediteur , contact_expediteur as contactExpediteur , tel_expediteur as telExpediteur "+
                    ", destinataire as destinataire , adresse_destinataire as adresseDestinataire , contact_destinataire as contactDestinataire , tel_destinataire as telDestinataire "+
                    ", date_commande as dateCommande , type_commande as type , nbr_obj as nbrObj , description as description , articles as articles , etat as etat , position_expediteur as positionExp , position_destinataire as positionDest" +
                    "  from Commandes where " + champ + " like '" + valeur + "%'";
            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Commandes com = new Commandes();
                com.setId(rs.getLong("id"));
                com.setIdMission(rs.getLong("idMission"));
                com.setReferenceCommande(rs.getLong("referenceCommande"));
                com.setExpediteur(rs.getString("expediteur"));
                com.setAdresse_expediteur(rs.getString("adresseExpediteur"));
                com.setContact_expediteur(rs.getString("contactExpediteur"));
                com.setTel_expediteur(rs.getLong("telExpediteur"));
                com.setDestinataire(rs.getString("destinataire"));
                com.setAdresse_destinataire(rs.getString("adresseDestinataire"));
                com.setContact_destinataire(rs.getString("contactDestinataire"));
                com.setTel_destinataire(rs.getLong("telDestinataire"));
                com.setDate_commande(rs.getDate("dateCommande"));
                com.setType(rs.getString("type"));
                com.setNbr_obj(rs.getLong("nbrObj"));
                com.setDescription(rs.getString("description"));
                com.setArticles(rs.getString("articles"));
                com.setEtat(rs.getString("etat"));
                com.setPositionExp(rs.getString("positionExp"));
                com.setPositionDest(rs.getString("positionDest"));
                liste.add(com);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }
}
