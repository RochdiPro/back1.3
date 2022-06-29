package net.guides.springboot2.springboot2jpacrudexample.service.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Fiche_BEL;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Fournisseur;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.Devis_Repository;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.FileStorageException;
import net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/*
ces cervices pour l' entity Devis
listes des Servivces :
 * lister les Devis
 * crere un Devis
 * modifier un  Devis
 * supprimer un Devis
 * lister les champs
 * filtre standards un champs avec le valeur de table Devis


 * detail Devis sous frome xml
 * filtre client date
 * filtre bon l client et date et etat
 * filtre bon livraison client date 1 et date 2


 */
@Service
public class Devis_Service {

    @Autowired
    Devis_Repository Repo;
    @Autowired
    DataSource dataSource;
    // lister les devis
    public List<Devis> Deviss() {
        return (List<Devis>)  Repo.findAll();
    }

    // get devis aprtire de id
    public Optional<Devis> Devis(Long id ) {
        return   Repo.findById(id );
    }

    // creer un devis
     public Devis Creer_Devis (String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC , String description, String id_Responsable, String mode_Paiement, MultipartFile detail, double frais_Livraison)
    {
        try {
            Devis dbFile = new Devis (id_Clt,   type,   etat,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,      description,   id_Responsable,   mode_Paiement,   detail.getBytes(),   frais_Livraison ) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    // modifier un devis
    public Devis Modifier_Devis(Long id , String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC,   String description, String id_Responsable, String mode_Paiement, MultipartFile detail, double frais_Livraison )
    {
        try {
            Devis Entity = new Devis (id_Clt,   type,   etat,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,      description,   id_Responsable,   mode_Paiement,   detail.getBytes(),   frais_Livraison ) ;
            Optional<Devis> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Devis p = searchEntity.get();
                p.setId_Clt (Entity.getId_Clt());
                p.setType (Entity.getType());
                p.setEtat (Entity.getEtat());
                p.setTotal_HT_Brut (Entity.getTotal_HT_Brut());
                p.setTotal_Remise (Entity.getTotal_Remise());
                p.setTotal_HT_Net (Entity.getTotal_HT_Net());
                p.setTotal_Fodec (Entity.getTotal_Fodec());
                p.setTotal_Tva (Entity.getTotal_Tva());
                p.setTotal_TTC (Entity.getTotal_TTC());

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
   /// supprimer un devis
    public ResponseEntity<Object> Supprimer_Devis(Long id ) {
        Optional<Devis> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Devis Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
  /// lister les champs de devis
    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }

    //  filtre standard champs valeur pour le entity devis
    public List<Devis> filtre(String champ, String valeur) {
        List<Devis> liste = new ArrayList<>();
        try {
            String query = "select  Id_Clt   as id_Clt,  Type as type, Etat as etat,   Total_HT_Brut as total_HT_Brut,  Total_Remise as total_Remise,\n" +
                    "        Total_HT_Net as total_HT_Net , Total_Fodec as total_Fodec, Total_Tva as total_Tva,  Total_TTC as total_TTC,\n" +
                    "        Description as description,  Id_Responsable as id_Responsable, Mode_Paiement as mode_Paiement, Detail as detail,\n" +
                    "        Frais_Livraison as frais_Livraison, Date_Creation as date_Creation , Id_Devis as id_devis from Devis where " + champ + " like '" + valeur + "%'";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Devis f = new Devis();
                f.setId_Clt (rs.getString("id_Clt"));
                f.setType (rs.getString("type"));
                f.setEtat (rs.getString("etat"));
                f.setTotal_HT_Brut(rs.getDouble("total_HT_Brut"));
                f.setTotal_Remise (rs.getDouble("total_Remise"));
                f.setTotal_HT_Net (rs.getDouble("total_HT_Net"));
                f.setTotal_Fodec (rs.getDouble("total_Fodec"));
                f.setTotal_Tva (rs.getDouble("total_Tva"));
                f.setTotal_TTC (rs.getDouble("total_TTC"));
                f.setDescription (rs.getString("description"));
                f.setId_Responsable (rs.getString("id_Responsable"));
                f.setMode_Paiement (rs.getString("mode_Paiement"));
                f.setDetail (rs.getBytes("detail"));
                f.setFrais_Livraison (rs.getDouble("frais_Livraison"));
                f.setDate_Creation (rs.getDate("date_Creation"));
                f.setId_Devis(rs.getLong("id_devis"));
                liste.add(f);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }


    // detail devis sous la form xml
    public Devis Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }
   // filtre devis client date
    public List<Devis> Filtre_Par_Client_Date(Long client, Date date) {
        List<Devis> liste = new ArrayList<>();
        try {
            String query = "select  Id_Clt   as id_Clt,  Type as type, Etat as etat,   Total_HT_Brut as total_HT_Brut,  Total_Remise as total_Remise,\n" +
                    "        Total_HT_Net as total_HT_Net , Total_Fodec as total_Fodec, Total_Tva as total_Tva,  Total_TTC as total_TTC,\n" +
                    "        Description as description,  Id_Responsable as id_Responsable, Mode_Paiement as mode_Paiement, Detail as detail,\n" +
                    "        Frais_Livraison as frais_Livraison, Date_Creation as date_Creation , Id_Devis as id_devis from Devis where Id_Clt =  '" + client+"'" ;

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                    Devis f = new Devis();
                    f.setId_Clt(rs.getString("id_Clt"));
                    f.setType(rs.getString("type"));
                    f.setEtat(rs.getString("etat"));
                    f.setTotal_HT_Brut(rs.getDouble("total_HT_Brut"));
                    f.setTotal_Remise(rs.getDouble("total_Remise"));
                    f.setTotal_HT_Net(rs.getDouble("total_HT_Net"));
                    f.setTotal_Fodec(rs.getDouble("total_Fodec"));
                    f.setTotal_Tva(rs.getDouble("total_Tva"));
                    f.setTotal_TTC(rs.getDouble("total_TTC"));
                    f.setDescription(rs.getString("description"));
                    f.setId_Responsable(rs.getString("id_Responsable"));
                    f.setMode_Paiement(rs.getString("mode_Paiement"));
                    f.setDetail(rs.getBytes("detail"));
                    f.setFrais_Livraison(rs.getDouble("frais_Livraison"));
                    f.setDate_Creation(rs.getDate("date_Creation"));
                    f.setId_Devis(rs.getLong("id_devis"));
                    if(f.getDate_Creation().getTime()>=(date.getTime()) ) {

                        liste.add(f);
                    }
            }
            stmt.close();
            cnx.close();
        } catch (  Exception e) {
          System.out.println(e.getMessage());
        }

        return liste;
    }
    // filtre devis client date et etat
    public List<Devis> Filtre_Par_Client_Date_etat(Long client, Date date ,String etat) {
        List<Devis> liste = new ArrayList<>();
        try {
            String query = "select  Id_Clt   as id_Clt,  Type as type, Etat as etat,   Total_HT_Brut as total_HT_Brut,  Total_Remise as total_Remise,\n" +
                    "        Total_HT_Net as total_HT_Net , Total_Fodec as total_Fodec, Total_Tva as total_Tva,  Total_TTC as total_TTC,\n" +
                    "        Description as description,  Id_Responsable as id_Responsable, Mode_Paiement as mode_Paiement, Detail as detail,\n" +
                    "        Frais_Livraison as frais_Livraison, Date_Creation as date_Creation , Id_Devis as id_devis from Devis where Id_Clt =  '" + client+"' and Etat = '"+etat+"'" ;

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Devis f = new Devis();
                f.setId_Clt(rs.getString("id_Clt"));
                f.setType(rs.getString("type"));
                f.setEtat(rs.getString("etat"));
                f.setTotal_HT_Brut(rs.getDouble("total_HT_Brut"));
                f.setTotal_Remise(rs.getDouble("total_Remise"));
                f.setTotal_HT_Net(rs.getDouble("total_HT_Net"));
                f.setTotal_Fodec(rs.getDouble("total_Fodec"));
                f.setTotal_Tva(rs.getDouble("total_Tva"));
                f.setTotal_TTC(rs.getDouble("total_TTC"));
                f.setDescription(rs.getString("description"));
                f.setId_Responsable(rs.getString("id_Responsable"));
                f.setMode_Paiement(rs.getString("mode_Paiement"));
                f.setDetail(rs.getBytes("detail"));
                f.setFrais_Livraison(rs.getDouble("frais_Livraison"));
                f.setDate_Creation(rs.getDate("date_Creation"));
                f.setId_Devis(rs.getLong("id_devis"));
                if(f.getDate_Creation().getTime()>=(date.getTime()) ) {

                    liste.add(f);
                }
            }
            stmt.close();
            cnx.close();
        } catch (  Exception e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }
    // filtre devis client date 1 et date2
    public List<Devis> Filtre_Devis_Par_Client_Date1_Date2(Long client, Date date1, Date date2) {
        List<Devis> liste = new ArrayList<>();
        try {
            String query = "select  Id_Clt   as id_Clt,  Type as type, Etat as etat,   Total_HT_Brut as total_HT_Brut,  Total_Remise as total_Remise,\n" +
                    "        Total_HT_Net as total_HT_Net , Total_Fodec as total_Fodec, Total_Tva as total_Tva,  Total_TTC as total_TTC,\n" +
                    "        Description as description,  Id_Responsable as id_Responsable, Mode_Paiement as mode_Paiement, Detail as detail,\n" +
                    "        Frais_Livraison as frais_Livraison, Date_Creation as date_Creation , Id_Devis as id_devis from Devis where Id_Clt =  '" + client+"'" ;

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Devis f = new Devis();
                f.setId_Clt(rs.getString("id_Clt"));
                f.setType(rs.getString("type"));
                f.setEtat(rs.getString("etat"));
                f.setTotal_HT_Brut(rs.getDouble("total_HT_Brut"));
                f.setTotal_Remise(rs.getDouble("total_Remise"));
                f.setTotal_HT_Net(rs.getDouble("total_HT_Net"));
                f.setTotal_Fodec(rs.getDouble("total_Fodec"));
                f.setTotal_Tva(rs.getDouble("total_Tva"));
                f.setTotal_TTC(rs.getDouble("total_TTC"));
                f.setDescription(rs.getString("description"));
                f.setId_Responsable(rs.getString("id_Responsable"));
                f.setMode_Paiement(rs.getString("mode_Paiement"));
                f.setDetail(rs.getBytes("detail"));
                f.setFrais_Livraison(rs.getDouble("frais_Livraison"));
                f.setDate_Creation(rs.getDate("date_Creation"));
                f.setId_Devis(rs.getLong("id_devis"));
                if(f.getDate_Creation().getTime()>=(date1.getTime()) && f.getDate_Creation().getTime()<=(date2.getTime()) ) {

                    liste.add(f);
                }
            }
            stmt.close();
            cnx.close();
        } catch (  Exception e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }
}
