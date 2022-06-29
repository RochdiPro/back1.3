package net.guides.springboot2.springboot2jpacrudexample.service.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.*;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.*;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Service
public class Archive_Vente {

    @Autowired
    Devis_Archive_Repository Repo_Devis_Archive;

    @Autowired
    Facture_Archive_Repository Repo_Facture_Archive;

    @Autowired
    Bon_Livraison_Archive_Repository  Repo_Bl_Archive;

    @Autowired
    Devis_Repository Repo_Devis;

    @Autowired
    Facture_Repository Repo_Facture;

    @Autowired
    Bon_Livraison_Repository  Repo_Bl;

    @Autowired
    DataSource dataSource;

    // archive devis
    public String Archive_Devis(Long id ){
        try {
            Devis_Archives archive = new Devis_Archives();
            Optional<Devis> searchEntity = Repo_Devis.findById(id);
            if (searchEntity.isPresent()) {
                Devis p = searchEntity.get();
                archive.setId_Clt (p.getId_Clt());
                archive.setType (p.getType());
                archive.setEtat (p.getEtat());
                archive.setTotal_HT_Brut (p.getTotal_HT_Brut());
                archive.setTotal_Remise (p.getTotal_Remise());
                archive.setTotal_HT_Net (p.getTotal_HT_Net());
                archive.setTotal_Fodec (p.getTotal_Fodec());
                archive.setTotal_Tva (p.getTotal_Tva());
                archive.setTotal_TTC (p.getTotal_TTC());
                archive.setDescription (p.getDescription());
                archive.setId_Responsable (p.getId_Responsable());
                archive.setMode_Paiement (p.getMode_Paiement());
                archive.setDetail (p.getDetail());
                archive.setFrais_Livraison (p.getFrais_Livraison());
                archive.setDate_Creation (p.getDate_Creation());
                p.setEtat(("Archive"));
                Repo_Devis.save(p);
                Repo_Devis_Archive.save(archive);
            } else {
                throw new EntityNotFoundException();
            }
            return "ok";
        } catch ( Exception ex) {
            System.out.println(ex.getMessage());

            throw new FileStorageException("error    ! ", ex);
        }
    }

    //  desarchive Devis avec id
    public String desarchiver_Devis(Long id , Long Id_Archive){
        try {

            Optional<Devis_Archives> searchEntity2 = Repo_Devis_Archive.findById(Id_Archive);
            if (searchEntity2.isPresent()) {
                Devis_Archives Entity_deleted = searchEntity2.get();
                Repo_Devis_Archive.delete(Entity_deleted);
            } else {
                throw new EntityNotFoundException();
            }

            Optional<Devis> searchEntity = Repo_Devis.findById(id);
            if (searchEntity.isPresent()) {
                Devis p = searchEntity.get();
                p.setEtat ("désarchiver");
                Repo_Devis.save(p);

            } else {
                throw new EntityNotFoundException();
            }
            return "ok";
        } catch ( Exception ex) {
            System.out.println(ex.getMessage());

            throw new FileStorageException("error    ! ", ex);
        }
    }

    // lister les devis archives
    public List<Devis_Archives> Deviss() {
        return (List<Devis_Archives>)  Repo_Devis_Archive.findAll();
    }

    // get archive devis aprtire de id
    public Optional<Devis_Archives> Devis(Long id ) {
        return   Repo_Devis_Archive.findById(id );
    }

    // lister les Facture archives
    public List<Facture_Archives> Factures() {
        return (List<Facture_Archives>)  Repo_Facture_Archive.findAll();
    }

    // get archive Facture aprtire de id
    public Optional<Facture_Archives> Facture(Long id ) {
        return   Repo_Facture_Archive.findById(id );
    }


    // lister les bls archives
    public List<Bon_Livraison_Archives> bls() {
        return (List<Bon_Livraison_Archives>)  Repo_Bl_Archive.findAll();
    }

    // get archive bl aprtire de id
    public Optional<Bon_Livraison_Archives> bl(Long id ) {
        return   Repo_Bl_Archive.findById(id );
    }


    public String Archive_bl(Long id ){
        try {
            Bon_Livraison_Archives archive = new Bon_Livraison_Archives();
            Optional<Bon_Livraison> searchEntity = Repo_Bl.findById(id);
            if (searchEntity.isPresent()) {
                Bon_Livraison p = searchEntity.get();
                archive.setId_Clt (p.getId_Clt());
                archive.setType (p.getType());
                archive.setEtat (p.getEtat());
                archive.setTotal_HT_Brut (p.getTotal_HT_Brut());
                archive.setTotal_Remise (p.getTotal_Remise());
                archive.setTotal_HT_Net (p.getTotal_HT_Net());
                archive.setTotal_Fodec (p.getTotal_Fodec());
                archive.setTotal_Tva (p.getTotal_Tva());
                archive.setTotal_TTC (p.getTotal_TTC());
                archive.setDescription (p.getDescription());
                archive.setId_Responsable (p.getId_Responsable());
                archive.setMode_Paiement (p.getMode_Paiement());
                archive.setDetail (p.getDetail());
                archive.setFrais_Livraison (p.getFrais_Livraison());
                archive.setDate_Creation (p.getDate_Creation());
                archive.setTotal_Retenues (p.getTotal_Retenues());
                p.setEtat(("Archive"));
                Repo_Bl.save(p);
                Repo_Bl_Archive.save(archive);
            } else {
                throw new EntityNotFoundException();
            }
            return "ok";
        } catch ( Exception ex) {
            System.out.println(ex.getMessage());

            throw new FileStorageException("error    ! ", ex);
        }
    }

    public String desarchiver_bl(Long id ,Long Id_Archive){
        try {

            Optional<Bon_Livraison_Archives> searchEntity2 = Repo_Bl_Archive.findById(Id_Archive);
            if (searchEntity2.isPresent()) {
                Bon_Livraison_Archives Entity_deleted = searchEntity2.get();
                Repo_Bl_Archive.delete(Entity_deleted);
            } else {
                throw new EntityNotFoundException();
            }

            Optional<Bon_Livraison> searchEntity = Repo_Bl.findById(id);
            if (searchEntity.isPresent()) {
                Bon_Livraison p = searchEntity.get();
                p.setEtat ("désarchiver");
                Repo_Bl.save(p);

            } else {
                throw new EntityNotFoundException();
            }
            return "ok";
        } catch ( Exception ex) {
            System.out.println(ex.getMessage());

            throw new FileStorageException("error    ! ", ex);
        }
    }

    public String Archive_Facture(Long id ){
        try {
            Bon_Livraison_Archives archive = new Bon_Livraison_Archives();
            Optional<Bon_Livraison> searchEntity = Repo_Bl.findById(id);
            if (searchEntity.isPresent()) {
                Bon_Livraison p = searchEntity.get();
                archive.setId_Clt (p.getId_Clt());
                archive.setType (p.getType());
                archive.setEtat (p.getEtat());
                archive.setTotal_HT_Brut (p.getTotal_HT_Brut());
                archive.setTotal_Remise (p.getTotal_Remise());
                archive.setTotal_HT_Net (p.getTotal_HT_Net());
                archive.setTotal_Fodec (p.getTotal_Fodec());
                archive.setTotal_Tva (p.getTotal_Tva());
                archive.setTotal_TTC (p.getTotal_TTC());
                archive.setDescription (p.getDescription());
                archive.setId_Responsable (p.getId_Responsable());
                archive.setMode_Paiement (p.getMode_Paiement());
                archive.setDetail (p.getDetail());
                archive.setFrais_Livraison (p.getFrais_Livraison());
                archive.setDate_Creation (p.getDate_Creation());
                archive.setTotal_Retenues (p.getTotal_Retenues());
                p.setEtat(("Archive"));
                Repo_Bl.save(p);
                Repo_Bl_Archive.save(archive);
            } else {
                throw new EntityNotFoundException();
            }
            return "ok";
        } catch ( Exception ex) {
            System.out.println(ex.getMessage());

            throw new FileStorageException("error    ! ", ex);
        }
    }

    public String desarchiver_Facture(Long id ,Long Id_Archive){
        try {

            Optional<Bon_Livraison_Archives> searchEntity2 = Repo_Bl_Archive.findById(Id_Archive);
            if (searchEntity2.isPresent()) {
                Bon_Livraison_Archives Entity_deleted = searchEntity2.get();
                Repo_Bl_Archive.delete(Entity_deleted);
            } else {
                throw new EntityNotFoundException();
            }

            Optional<Bon_Livraison> searchEntity = Repo_Bl.findById(id);
            if (searchEntity.isPresent()) {
                Bon_Livraison p = searchEntity.get();
                p.setEtat ("désarchiver");
                Repo_Bl.save(p);

            } else {
                throw new EntityNotFoundException();
            }
            return "ok";
        } catch ( Exception ex) {
            System.out.println(ex.getMessage());

            throw new FileStorageException("error    ! ", ex);
        }
    }
}
