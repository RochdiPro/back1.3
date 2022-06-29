package net.guides.springboot2.springboot2jpacrudexample.service.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Bon_Livraison;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.Bon_Livraison_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.Devis_Repository;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.FileStorageException;
import net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.service.Stock.Stock_Service;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/*
ces cervices pour l' entity bl
listes des Servivces :
 * lister les bl
 * crere un bon de livraison
 * modifier un  bl
 * supprimer un bon de livraison
 * lister les champs
 * filtre standards un champs avec le valeur de table bl
 * convertire un devis directement
 * generate un bl a traver un devis get les information de devis mais une odification dans la liste des articles

 * detail bl sous frome xml
 * filtre client date
 * filtre bon l client et date et etat
 * filtre bon livraison client date 1 et date 2
 * Sortie les articles des srock avec le detail xml
 * entree les article au stock
 * Abondoner les articles des bl
 */


@Service
public class Bon_Livraison_Service {
    @Autowired
    Bon_Livraison_Repository Repo;
    @Autowired
    Devis_Repository Repo_devis;
    @Autowired
    DataSource dataSource;
    @Autowired
    Stock_Service Stock ;

   // lister les bl
    public List<Bon_Livraison> Bon_Livraisons() {
        return (List<Bon_Livraison>)  Repo.findAll();
    }
    public Optional<Bon_Livraison> Bon_Livraison(Long id ) {
        return   Repo.findById(id );
    }
   // crere un bon de livraison
    public Bon_Livraison Creer_Bon_Livraison (String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_Retenues, String description, String id_Responsable, String mode_Paiement, MultipartFile detail, double frais_Livraison, Date date_Creation)
    {
        try {
            Bon_Livraison dbFile = new Bon_Livraison (id_Clt,   type,   etat,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   total_Retenues,   description,   id_Responsable,   mode_Paiement,   detail.getBytes(),   frais_Livraison,   date_Creation) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }
  /// modifier un  bl
    public Bon_Livraison Modifier_Bon_Livraison(Long id , String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_Retenues, String description, String id_Responsable, String mode_Paiement, MultipartFile detail, double frais_Livraison, Date date_Creation)
    {
        try {
            Bon_Livraison Entity = new Bon_Livraison (id_Clt,   type,   etat,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   total_Retenues,   description,   id_Responsable,   mode_Paiement,   detail.getBytes(),   frais_Livraison,   date_Creation) ;
            Optional<Bon_Livraison> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Bon_Livraison p = searchEntity.get();
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
   //  supprimer un bon de livraison
    public ResponseEntity<Object> Supprimer_Bon_Livraison(Long id ) {
        Optional<Bon_Livraison> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Bon_Livraison Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
   // lister les champs
    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }

   // filtre standards un champs avec le valeur de table bl
    public List<Bon_Livraison> filtre(String champ, String valeur) {
        List<Bon_Livraison> liste = new ArrayList<>();
        try {
            String query = "select Id_Devis as id_devis   , Id_Bl as id_Bl  ,Id_Clt   as id_Clt,  Type as type, Etat as etat,   Total_HT_Brut as total_HT_Brut,  Total_Remise as total_Remise,\n" +
                     "        Total_HT_Net as total_HT_Net , Total_Fodec as total_Fodec, Total_Tva as total_Tva,  Total_TTC as total_TTC,\n" +
                     "        Total_Retenues as total_Retenues ,Description as description,  Id_Responsable as id_Responsable, Mode_Paiement as mode_Paiement, Detail as detail,\n" +
                    "        Frais_Livraison as frais_Livraison, Date_Creation as date_Creation  from Bon_Livraison  where  " + champ + " like '" + valeur + "%'";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Livraison f = new Bon_Livraison();
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
                f.setTotal_Retenues(rs.getDouble("total_Retenues"));
                f.setId_Bl(rs.getLong("id_Bl"));
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

    // convertire un devis directement
    public Bon_Livraison Convertire_Devis_en_Bon_Livraison(long id_devis ,double Total_Retunes) {
        Optional<Devis> d = Repo_devis.findById(id_devis);
        Devis Entity =  d.get();
        Bon_Livraison f = new Bon_Livraison();
        f.setId_Clt(Entity.getId_Clt());
        f.setType (Entity.getType());
        f.setEtat ("En Cours");
        Entity.setEtat("converti en BL");
        f.setTotal_HT_Brut(Entity.getTotal_HT_Brut());
        f.setTotal_Remise (Entity.getTotal_Remise());
        f.setTotal_HT_Net (Entity.getTotal_HT_Net());
        f.setTotal_Fodec (Entity.getTotal_Fodec ());
        f.setTotal_Tva (Entity.getTotal_Tva());
        f.setTotal_TTC (Entity.getTotal_TTC());
        f.setDescription (Entity.getDescription());
        f.setId_Responsable (Entity.getId_Responsable ());
        f.setMode_Paiement (Entity.getMode_Paiement());

        f.setFrais_Livraison (Entity.getFrais_Livraison());
        f.setDate_Creation (Entity.getDate_Creation());
        f.setTotal_Retenues(Total_Retunes);
        f.setId_Devis(id_devis);

        Element bl = new Element("Bon_Livraison");
        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
        try {
            doc = builder.build(new ByteArrayInputStream(Entity.getDetail()));
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }

        try {


            Element root = doc.getRootElement();

            Element etat   = root.getChild("Etat") ;
            Element Informations_Generales   = root.getChild("Informations-Generales") ;
            Element Total   = root.getChild("Total") ;
            Element Signaler_Probleme   = root.getChild("Signaler_Probleme") ;
            Element Produits   = root.getChild("Produits") ;
            Element Taxes   = root.getChild("Taxes") ;
            //Element Montant_TVA   = root.getChild("Montant_TVA") ;
            Element Type_Reglement   = root.getChild("Reglements") ;

            etat.detach();
            Informations_Generales.detach();
            Total.detach();
            Signaler_Probleme.detach();
            Produits.detach();
            Taxes.detach();
           // Montant_TVA.detach();
            Type_Reglement.detach();

            bl.addContent(etat);
            bl.addContent(Informations_Generales);
            bl.addContent(Total);
            bl.addContent(Signaler_Probleme);
            bl.addContent(Produits);
            bl.addContent(Taxes);
           // bl.addContent(Montant_TVA);
            bl.addContent(Type_Reglement);

        } catch (Exception e) {
            e.printStackTrace();
        }


        Document document = new Document(bl);
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try{ sortie.output(document, bout);}catch (Exception ee){}
        f.setDetail(bout.toByteArray());
        Repo.save(f);
        Repo_devis.save(Entity);
        return  f ;
    }

     // generate un bl a traver un devis get les information de devis mais une odification dans la liste des articles
    public Bon_Livraison Generate_Bon_Livraison_A_Partire_Devis(long id_devis, MultipartFile detail , double total_retunes) {
        Optional<Devis> d = Repo_devis.findById(id_devis);
        Devis Entity =  d.get();
        Bon_Livraison f = new Bon_Livraison();
        f.setId_Clt(Entity.getId_Clt());
        f.setType (Entity.getType());
        f.setEtat ("Devis_BL");
        Entity.setEtat("Devis_BL");
        f.setTotal_HT_Brut(Entity.getTotal_HT_Brut());
        f.setTotal_Remise (Entity.getTotal_Remise());
        f.setTotal_HT_Net (Entity.getTotal_HT_Net());
        f.setTotal_Fodec (Entity.getTotal_Fodec ());
        f.setTotal_Tva (Entity.getTotal_Tva());
        f.setTotal_TTC (Entity.getTotal_TTC());
        f.setDescription (Entity.getDescription());
        f.setId_Responsable (Entity.getId_Responsable ());
        f.setMode_Paiement (Entity.getMode_Paiement());
        try{f.setDetail (detail.getBytes());}catch (Exception ex){}
        f.setFrais_Livraison (Entity.getFrais_Livraison());
        f.setDate_Creation (Entity.getDate_Creation());
        f.setTotal_Retenues(total_retunes);
        f.setId_Devis(id_devis);

         Repo.save(f);
          Repo_devis.save(Entity);
         return f ;


    }

    // detail bl sous frome xml
    public Bon_Livraison Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    // 2021/08/02       date doit etre sous la forme precedante

     //  filtre client date
    public List<Bon_Livraison> Filtre_Par_Client_Date(Long client, Date date) {
        List<Bon_Livraison> liste = new ArrayList<>();
        try {
            String query = "select  Id_Bl as id_Bl ,Id_Clt   as id_Clt,  Type as type, Etat as etat,   Total_HT_Brut as total_HT_Brut,  Total_Remise as total_Remise,\n" +
                    "        Total_HT_Net as total_HT_Net , Total_Fodec as total_Fodec, Total_Tva as total_Tva,  Total_TTC as total_TTC,\n" +
                    "        Total_Retenues as total_Retenues ,Description as description,  Id_Responsable as id_Responsable, Mode_Paiement as mode_Paiement, Detail as detail,\n" +
                    "        Id_Devis as id_devis,  Frais_Livraison as frais_Livraison, Date_Creation as date_Creation  from Bon_Livraison  where Id_Clt =  '" + client+"'" ;


            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Livraison f = new Bon_Livraison();
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
                f.setTotal_Retenues(rs.getDouble("total_Retenues"));
                f.setId_Bl(rs.getLong("id_Bl"));
                f.setId_Devis(rs.getLong("id_devis"));

                if(f.getDate_Creation().getTime() >= (date.getTime()) ) {

                    liste.add(f);
                }
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }

    // filtre bon l client et date et etat
    public List<Bon_Livraison> Filtre_Par_Client_Date_etat(Long client, Date date, String etat) {
        List<Bon_Livraison> liste = new ArrayList<>();
        try {
            String query = "select  Id_Bl as id_Bl ,Id_Clt   as id_Clt,  Type as type, Etat as etat,   Total_HT_Brut as total_HT_Brut,  Total_Remise as total_Remise,\n" +
                    "        Total_HT_Net as total_HT_Net , Total_Fodec as total_Fodec, Total_Tva as total_Tva,  Total_TTC as total_TTC,\n" +
                    "        Total_Retenues as total_Retenues ,Description as description,  Id_Responsable as id_Responsable, Mode_Paiement as mode_Paiement, Detail as detail,\n" +
                    "        Id_Devis as id_devis,  Frais_Livraison as frais_Livraison, Date_Creation as date_Creation  from Bon_Livraison where   Id_Clt =  '" + client+"' and Etat = '"+etat+"'";


            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Livraison f = new Bon_Livraison();
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
                f.setTotal_Retenues(rs.getDouble("total_Retenues"));
                f.setId_Bl(rs.getLong("id_Bl"));
                f.setId_Devis(rs.getLong("id_devis"));

                if(f.getDate_Creation().getTime()>=(date.getTime()) ) {

                    liste.add(f);
                }
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }

    // filtre bon livraison client date 1 et date 2
    public List<Bon_Livraison> Filtre_Bon_Livraison_Par_Client_Date1_Date2(Long client, Date date1, Date date2) {
        List<Bon_Livraison> liste = new ArrayList<>();
        try {
            String query = "select  Id_Bl as id_Bl ,Id_Clt   as id_Clt,  Type as type, Etat as etat,   Total_HT_Brut as total_HT_Brut,  Total_Remise as total_Remise,\n" +
                    "        Total_HT_Net as total_HT_Net , Total_Fodec as total_Fodec, Total_Tva as total_Tva,  Total_TTC as total_TTC,\n" +
                    "        Description as description,  Id_Responsable as id_Responsable, Mode_Paiement as mode_Paiement, Detail as detail,\n" +
                    "        Frais_Livraison as frais_Livraison, Date_Creation as date_Creation , Id_Devis as id_devis from Bon_Livraison where Id_Clt =  '" + client+"'" ;

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Livraison f = new Bon_Livraison();
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
                f.setId_Bl(rs.getLong("id_Bl"));

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


   // Sortie les articles des srock avec le detail xml
    private void Supprimer(byte[] details) {

        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new ByteArrayInputStream(details));
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element Produits = DataSets.getChild("Produits");
        Stock.Supprimer(Produits );
    }

   //   Sortie les articles du Bl du stock
    public String Sortie_Produits_BL_Stock(long Id) {
        Optional<Bon_Livraison> searchEntity = Repo.findById(Id);
        Bon_Livraison p = searchEntity.get();
        Supprimer(p.getDetail());
      return "ok" ;
    }
  // Abondonner les article au stock
    private void Abondoner(byte[] details) {

        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new ByteArrayInputStream(details));
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element Produits = DataSets.getChild("Produits");
        Stock.Abondoner(Produits );
    }

    // Abondoner les articles des bl
    public String Abandonner_BL(long id) {
        Optional<Bon_Livraison> searchEntity = Repo.findById(id);
        Bon_Livraison p = searchEntity.get();
        Abondoner(p.getDetail());
        p.setEtat("Abandonner");

        Element bl = new Element("Bon_Livraison");
        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
        try {
            doc = builder.build(new ByteArrayInputStream(p.getDetail()));
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }

        try {


            Element root = doc.getRootElement();

            Element etat   =  new Element("Etat");etat.setText("Abandonner");
            Element Informations_Generales   = root.getChild("Informations-Generales") ;
            Element Total   = root.getChild("Total") ;
            Element Signaler_Probleme   = root.getChild("Signaler_Probleme") ;
            Element Produits   = root.getChild("Produits") ;
            Element Taxes   = root.getChild("Taxes") ;
            Element Type_Reglement   = root.getChild("Reglements") ;


            Informations_Generales.detach();
            Total.detach();
            Signaler_Probleme.detach();
            Produits.detach();
            Taxes.detach();
            Type_Reglement.detach();

            bl.addContent(etat);
            bl.addContent(Informations_Generales);
            bl.addContent(Total);
            bl.addContent(Signaler_Probleme);
            bl.addContent(Produits);
            bl.addContent(Taxes);

            bl.addContent(Type_Reglement);

        } catch (Exception e) {
            e.printStackTrace();
        }


        Document document = new Document(bl);
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try{ sortie.output(document, bout);}catch (Exception ee){}
        p.setDetail(bout.toByteArray());
        Repo.save(p);
        return  "ok" ;
    }
}
