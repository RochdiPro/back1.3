package net.guides.springboot2.springboot2jpacrudexample.service.Achat;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Bon_Commande;
import net.guides.springboot2.springboot2jpacrudexample.repository.Achat.Bon_Commande_Repository;
import net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Bon_Commande_Service {
    @Autowired
    Bon_Commande_Repository Repo;

    @Autowired
    DataSource dataSource;

    public List<Bon_Commande> Tous() {
        return (List<Bon_Commande>)  Repo.findAll();
    }
    public Object Fiche_Bon_Commande(Long id) {
        return Repo.findById(id);
    }

    public Bon_Commande Creer_Bon_Commande(   String id_Responsable, String id_Fr, Date date, String type_Reglement, String email, String mode_Livraison, Date date_Livraison, String contact, int marge_Jour, double court, double total_HT_Net,  double total_Fodec,  double total_Tva,  double total_TTC, String devise, String description, MultipartFile Details )
    {
       try {
            Bon_Commande dbFile = new Bon_Commande ( id_Responsable,   id_Fr,   date,   type_Reglement,   email,   mode_Livraison,   date_Livraison,   contact,   marge_Jour,   court,     devise,   description,    total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   Details.getContentType(), Details.getBytes());
            return Repo.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }

    }

    public Bon_Commande Modifier_Bon_Commande( Long Id ,  String id_Responsable, String id_Fr, Date date, String type_Reglement, String email, String mode_Livraison, Date date_Livraison, String contact, int marge_Jour, double court, double total_HT_Net,  double total_Fodec,  double total_Tva,  double total_TTC, String devise, String description, MultipartFile Details )
    {
      

        try {
            Bon_Commande Entity = new Bon_Commande ( id_Responsable,   id_Fr,   date,   type_Reglement,   email,   mode_Livraison,   date_Livraison,   contact,   marge_Jour,   court,     devise,   description,    total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   Details.getContentType(), Details.getBytes());

            Optional<Bon_Commande> searchEntity =  Repo.findById(Id);
            if (searchEntity.isPresent()) {
                Bon_Commande  p = searchEntity.get();
                p.setId_Responsable(Entity.getId_Responsable());
                p.setId_Fr  (Entity.getId_Fr()) ;
                p.setDate (Entity.getDate()) ;
                p.setType_Reglement(Entity.getType_Reglement());
                p.setEmail(Entity.getEmail());
                p.setMode_Livraison(Entity.getMode_Livraison());
                p.setDate_Livraison(Entity.getDate_Livraison());
                p.setContact(Entity.getContact());
                p.setMarge_Jour(Entity.getMarge_Jour());
                p.setCourt(Entity.getCourt());
                p.setDevise(Entity.getDevise());
                p.setDescription(Entity.getDescription());

                p.setDetails(Entity.getDetails());
                p.setType_Detail(Entity.getType_Detail());
                Entity = Repo.save(p);
            } else {
                throw new EntityNotFoundException();
            }
            return Entity;
         } catch (IOException ex) {
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }




    public  List<Bon_Commande>  filtre (String champ , String valeur ) {
        List<Bon_Commande> liste = new ArrayList<>();
        try {
            String query = "select    Id_Bon_Commande as id_Bon_Commande ,  Id_Responsable as id_Responsable, Id_Fr as id_Fr ," +
                    "        Date as date, Type_Reglement as type_Reglement, Email as email, Mode_Livraison as mode_Livraison, Date_Livraison as date_Livraison, Contact as contact, Marge_Jour as marge_Jour ,Court as court," +
                    "        Totale as totale, Devise as devise  , Description as description, Type_Detail as type_Detail,  Details as details from Bon_Commande where "+champ+" = '" + valeur + "'";
            Statement stmt = dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Commande  p = new Bon_Commande();
                p.setId_Fr  (rs.getString("id_Fr")) ;
                p.setDate (rs.getDate("date")) ;

                p.setDate (rs.getDate(" date")) ;
                p.setType_Reglement (rs.getString(" type_Reglement")) ;
                p.setEmail (rs.getString(" email")) ;
                p.setMode_Livraison (rs.getString(" mode_Livraison")) ;
                p.setDate_Livraison (rs.getDate(" date_Livraison")) ;
                p.setContact (rs.getString(" contact")) ;
                p.setMarge_Jour (rs.getInt(" marge_Jour")) ;
                p.setCourt (rs.getDouble(" court")) ;
                 p.setDevise (rs.getString(" devise")) ;
                p.setDescription (rs.getString(" description")) ;
                p.setId_Responsable (rs.getString("id_Responsable"));
                p.setType_Detail (rs.getString("type_Detail")) ;
                p.setDetails (rs.getBytes("details")) ;
                liste.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return liste ;
    }



    public ResponseEntity<Object> Supprimer_Bon_Commande(Long id) {
        Optional<Bon_Commande> Entity =  Repo.findById(id);
        if (Entity.isPresent()) {
            Bon_Commande Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){
        List<String> liste = new ArrayList<>();
        try {
            String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Bon_Commande'";
            Statement stmt = dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                liste.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return liste ;
    }


    public Bon_Commande Bon_Commande (Long id_bon) {
        return Repo.findById(id_bon)
                .orElseThrow(() -> new net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException("File not found with id " +  id_bon));
    }

    public Bon_Commande Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }
}
