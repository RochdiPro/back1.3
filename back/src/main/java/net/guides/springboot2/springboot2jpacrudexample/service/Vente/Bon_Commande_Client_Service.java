package net.guides.springboot2.springboot2jpacrudexample.service.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Bon_Commande_Client;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.Bon_Commande_Client_Repository;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.FileStorageException;
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
public class Bon_Commande_Client_Service {

    @Autowired
    Bon_Commande_Client_Repository Repo;
    @Autowired
    DataSource dataSource;

    public List<Bon_Commande_Client> Bon_Commande_Clients() {
        return (List<Bon_Commande_Client>)  Repo.findAll();
    }
    public Optional<Bon_Commande_Client> Bon_Commande_Client(Long id ) {
        return   Repo.findById(id );
    }

    public Bon_Commande_Client Creer_Bon_Commande_Client(String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_Retenues, String description, String id_Responsable, String mode_Paiement, MultipartFile detail, double frais_Livraison, Date date_Creation)
    {
        try {
            Bon_Commande_Client dbFile = new Bon_Commande_Client (id_Clt,   type,   etat,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   total_Retenues,   description,   id_Responsable,   mode_Paiement,   detail.getBytes(),   frais_Livraison,   date_Creation) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    public Bon_Commande_Client Modifier_Bon_Commande_Client(Long id , String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_Retenues, String description, String id_Responsable, String mode_Paiement, MultipartFile detail, double frais_Livraison, Date date_Creation)
    {

        try {
            Bon_Commande_Client Entity = new Bon_Commande_Client (id_Clt,   type,   etat,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   total_Retenues,   description,   id_Responsable,   mode_Paiement,   detail.getBytes(),   frais_Livraison,   date_Creation) ;
            Optional<Bon_Commande_Client> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Bon_Commande_Client p = searchEntity.get();
                p.setId_Clt (Entity.getId_Clt());
                p.setType (Entity.getType());
                p.setEtat (Entity.getEtat());
                p.setTotal_HT_Brut (Entity.getTotal_HT_Brut());
                p.setTotal_Remise (Entity.getTotal_Remise());
                p.setTotal_HT_Net (Entity.getTotal_HT_Net());
                p.setTotal_Fodec (Entity.getTotal_Fodec());
                p.setTotal_Tva (Entity.getTotal_Tva());
                p.setTotal_TTC (Entity.getTotal_TTC());
                p.setTotal_Retenues (Entity.getTotal_Retenues());
                p.setDescription (Entity.getDescription());
                p.setId_Responsable (Entity.getId_Responsable());
                p.setMode_Paiement (Entity.getMode_Paiement());
                p.setDetail (Entity.getDetail());
                p.setFrais_Livraison (Entity.getFrais_Livraison());
                p.setDate_Creation (Entity.getDate_Creation());
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

    public ResponseEntity<Object> Supprimer_Bon_Commande_Client(Long id ) {
        Optional<Bon_Commande_Client> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Bon_Commande_Client Entity_deleted = Entity.get();
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
