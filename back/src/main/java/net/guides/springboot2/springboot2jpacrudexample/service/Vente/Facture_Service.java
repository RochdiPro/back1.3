package net.guides.springboot2.springboot2jpacrudexample.service.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Bon_Livraison;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Facture;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.Bon_Livraison_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.Devis_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.Facture_Repository;
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
import org.springframework.mock.web.DelegatingServletInputStream;
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
ces cervices pour l' entity Facture
listes des Servivces :
 * lister les Facture
 * crere un Facture
 * modifier un Facture
 * supprimer un Facture
 * lister les champs Facture
 * filtre standards un champs avec le valeur de table Facture
 * convertire un devis directement en Facture
  * convertire un bls   en Facture
 * detail Facture sous frome xml
 * filtre bon livraison client date 1 et date 2
 * Sortie les articles des srock avec le detail xml
 * Abondonner les article au stock
 * Abondoner les articles des bl
 */

@Service
public class Facture_Service {
    @Autowired
    Facture_Repository Repo;
    @Autowired
    DataSource dataSource;
    @Autowired
    Devis_Repository Repo_devis;
    @Autowired
    Bon_Livraison_Repository Repo_BL;

    @Autowired
    Stock_Service Stock ;

   // lister  les factures de entity facture
    public List<Facture> Factures() {
        return (List<Facture>)  Repo.findAll();
    }
    // get facture by id
    public Optional<Facture> Facture(Long id ) {
        return   Repo.findById(id );
    }
   // creer un facture
    public Facture Creer_Facture(double droit_timbre,  String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_Retenues, String description, String id_Responsable, String mode_Paiement  , double frais_Livraison, Date date_Creation ,MultipartFile detail)
    {
        try {
            Facture dbFile = new Facture (  droit_timbre,   id_Clt,   type,   etat,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   total_Retenues,   description,   id_Responsable,   mode_Paiement,   detail.getBytes() ,   frais_Livraison,   date_Creation) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }
   // creer facture d'un ensembles des bls
    public Facture Creer_Facture_bls(String Liste,double droit_timbre,  String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_Retenues, String description, String id_Responsable, String mode_Paiement  , double frais_Livraison, Date date_Creation ,MultipartFile detail)
    {
        try {
            Facture dbFile = new Facture ( Liste, droit_timbre,   id_Clt,   type,   etat,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   total_Retenues,   description,   id_Responsable,   mode_Paiement,   detail.getBytes() ,   frais_Livraison,   date_Creation) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }
 // modifer facture
    public Facture Modifier_Facture(Long id ,double droit_timbre,  String id_Clt, String type, String etat, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_Retenues, String description, String id_Responsable, String mode_Paiement  , double frais_Livraison, Date date_Creation ,MultipartFile detail)
    {
        try {
            Facture Entity = new Facture (  droit_timbre,  id_Clt,   type,   etat,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   total_Retenues,   description,   id_Responsable,   mode_Paiement,   detail.getBytes() ,   frais_Livraison,   date_Creation) ;

            Optional<Facture> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Facture p = searchEntity.get();
                p.setDroit_timbre(Entity.getDroit_timbre());
                p.setListe_BL(Entity.getListe_BL());
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
    // supprimer facture
    public ResponseEntity<Object> Supprimer_Facture(Long id ) {
        Optional<Facture> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Facture Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    // lister les champs lacals
    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }


    // filtre standard champs valeur pour le entity facture
    public List<Facture> filtre(String champ, String valeur) {
        List<Facture> liste = new ArrayList<>();
        try {
            String query = "select  Id_Facture as id_Facture , Liste_BL as liste_BL,Id_Clt   as id_Clt,  Type as type, Etat as etat,   Total_HT_Brut as total_HT_Brut,  Total_Remise as total_Remise,\n" +
                    "        Total_HT_Net as total_HT_Net , Total_Fodec as total_Fodec, Total_Tva as total_Tva,  Total_TTC as total_TTC,\n" +
                    "        Total_Retenues as total_Retenues ,Description as description,  Id_Responsable as id_Responsable, Mode_Paiement as mode_Paiement, Detail as detail,\n" +
                    "        Frais_Livraison as frais_Livraison, Date_Creation as date_Creation  from Facture where " + champ + " like '" + valeur + "%'";


            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Facture f = new Facture();
               // f.setDroit_timbre(rs.getDouble("Droit_timbre"));
               // f.setListe_BL(rs.getString(""));
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
                f.setId_Facture(rs.getLong("id_Facture"));
                liste.add(f);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }


    // convertire un devis en facture
    public Facture Convertire_Devis_en_Facture(long id_devis , double Total_Retenues ) {
        Optional<Devis> d = Repo_devis.findById(id_devis);
        Devis Entity =  d.get();
        Facture f = new Facture();
        f.setId_Clt(Entity.getId_Clt());
        f.setType (Entity.getType());
        f.setEtat ("En Cours");
        Entity.setEtat("Converti en Facture");
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
        f.setTotal_Retenues( Total_Retenues);


        Element bl = new Element("Facture");
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


    // convertire un bl en facture
    public byte[] Convertire_BLs_en_Facture(String liste1) {


        String[] liste = liste1.split("/");
        Element Liste_Produit = new Element("Liste_Produit");

        ArrayList<Long> liste_des_ID_simple = new ArrayList<>();
        ArrayList<Long> liste_des_ID_4g = new ArrayList<>();
        ArrayList<Long> liste_des_ID_series = new ArrayList<>();



        ArrayList<Element> Array_liste_n_p_simple =new ArrayList<>();
        ArrayList<Element> Array_liste_n_p_Serie =new ArrayList<>();
        ArrayList<Element> Array_liste_n_p_4g =new ArrayList<>();

        for (int i = 0; i < liste.length; i++) {

            Long id = Long.valueOf(liste[i]);
            Optional<Bon_Livraison> d = Repo_BL.findById(id);
            Bon_Livraison Entity =  d.get();
            Element liste_p_simple =null;
            Element liste_p_4g =null;
            Element liste_p_serie =null;
            Element total =null;
            Element liste_p = null;
            SAXBuilder builder = new SAXBuilder();
            Document doc = null;
            try {
                doc = builder.build(new ByteArrayInputStream(Entity.getDetail()));
            } catch ( Exception e) {
                System.out.println(e.getMessage());
            }
            try {


             Element root =  doc.getRootElement();

             liste_p_simple = root.getChild("Produits").getChild("Produits_Simples") ;
             liste_p_4g = root.getChild("Produits").getChild("Produits_4Gs") ;
             liste_p_serie = root.getChild("Produits").getChild("Produits_Series") ;
            total=root.getChild("Total");
            liste_p =root.getChild("Produits") ;


            /*
            produit simple
             */
             List<Element>  liste_produits = liste_p_simple.getChildren();
             boolean test = false ;
             for (Element p : liste_produits) {
                 if(liste_des_ID_simple.size()==0)
                 {
                     liste_des_ID_simple.add(Long.parseLong(p.getChild("Id").getText()));
                     Element vp = new Element("Produit");
                     vp.addContent(new Element("Id").setText(p.getChild("Id").getText()));

                     vp.addContent(new Element("Nom").setText(p.getChild("Nom").getText()));
                     vp.addContent(new Element("PrixUTTC").setText(p.getChild("PrixUTTC").getText()));
                     vp.addContent(new Element("Total_HT").setText(p.getChild("Total_HT").getText()));
                     vp.addContent(new Element("Remise").setText(p.getChild("Remise").getText()));
                     vp.addContent(new Element("n_Serie").setText(p.getChild("n_Serie").getText()));
                     vp.addContent(new Element("n_Imei").setText(p.getChild("n_Imei").getText()));
                     ///    vp.addContent(new Element("produits_simple").setText(p.getChild("produits_simple").getText()));
                     vp.addContent(new Element("Signaler_probleme").setText(p.getChild("Signaler_probleme").getText()));
                     vp.addContent(new Element("Qte").setText(p.getChild("Qte").getText()));
                     vp.addContent(new Element("Tva").setText(p.getChild("Tva").getText()));
                     vp.addContent(new Element("Montant_Tva").setText(p.getChild("Montant_Tva").getText()));
                     vp.addContent(new Element("fodec").setText(p.getChild("fodec").getText()));
//                     vp.addContent(new Element("charge").setText(p.getChild("charge").getText()));
                     vp.addContent(new Element("PrixU").setText(p.getChild("PrixU").getText()));
                    // n_liste_p_simple.addContent(vp);
                     Array_liste_n_p_simple.add(vp);
                 }
                 else{
                 for (int j = 0; j < liste_des_ID_simple.size(); j++) {
                     if (p.getChild("Id").getText().equals(liste_des_ID_simple.get(j)+"")) {
                         for (Element pk : Array_liste_n_p_simple){
                             if(pk.getChild("Id").getText().equals(p.getChild("Id").getText()))
                             {
                                 int nn = Integer.parseInt(pk.getChild("Qte").getText()) +  Integer.parseInt(p.getChild("Qte").getText()) ;
                                 pk.getChild("Qte").setText(nn+"");
                             }
                         }
                     }
                     else
                     {
                         liste_des_ID_simple.add(Long.parseLong(p.getChild("Id").getText()));
                         Element vp = new Element("Produit");
                         vp.addContent(new Element("Id").setText(p.getChild("Id").getText()));
                         vp.addContent(new Element("Nom").setText(p.getChild("Nom").getText()));
                         vp.addContent(new Element("PrixUTTC").setText(p.getChild("PrixUTTC").getText()));
                         vp.addContent(new Element("Total_HT").setText(p.getChild("Total_HT").getText()));
                         vp.addContent(new Element("Remise").setText(p.getChild("Remise").getText()));
                         vp.addContent(new Element("n_Serie").setText(p.getChild("n_Serie").getText()));
                         vp.addContent(new Element("n_Imei").setText(p.getChild("n_Imei").getText()));
                          vp.addContent(new Element("Signaler_probleme").setText(p.getChild("Signaler_probleme").getText()));
                         vp.addContent(new Element("Qte").setText(p.getChild("Qte").getText()));
                         vp.addContent(new Element("Tva").setText(p.getChild("Tva").getText()));
                         vp.addContent(new Element("Montant_Tva").setText(p.getChild("Montant_Tva").getText()));
                         vp.addContent(new Element("fodec").setText(p.getChild("fodec").getText()));
                   //      vp.addContent(new Element("charge").setText(p.getChild("charge").getText()));
                         vp.addContent(new Element("PrixU").setText(p.getChild("PrixU").getText()));

                         Array_liste_n_p_simple.add(vp);
                     }
                     }
                 }
             }
             /*
            produit 4g
             */

            liste_produits = liste_p_4g.getChildren();

            for (Element p : liste_produits) {
                System.out.println(p);
                if(liste_des_ID_4g.size()==0)
                {
                    liste_des_ID_4g.add(Long.parseLong(p.getChild("Id").getText()));

                    Element vp = new Element("Produit");
                    vp.addContent(new Element("Id").setText(p.getChild("Id").getText()));
                    vp.addContent(new Element("Nom").setText(p.getChild("Nom").getText()));
                    vp.addContent(new Element("PrixUTTC").setText(p.getChild("PrixUTTC").getText()));
                    vp.addContent(new Element("Total_HT").setText(p.getChild("Total_HT").getText()));
                    vp.addContent(new Element("Remise").setText(p.getChild("Remise").getText()));
                    vp.addContent(new Element("n_Serie").setText(p.getChild("n_Serie").getText()));
                    vp.addContent(new Element("n_Imei").setText(p.getChild("n_Imei").getText()));
                   // vp.addContent(new Element("produits_simple").setText(p.getChild("produits_simple").getText()));
                    vp.addContent(new Element("Signaler_probleme").setText(p.getChild("Signaler_probleme").getText()));
                    vp.addContent(new Element("Qte").setText(p.getChild("Qte").getText()));
                    vp.addContent(new Element("Tva").setText(p.getChild("Tva").getText()));
                    vp.addContent(new Element("Montant_Tva").setText(p.getChild("Montant_Tva").getText()));
                    vp.addContent(new Element("fodec").setText(p.getChild("fodec").getText()));
//                    vp.addContent(new Element("Charge").setText(p.getChild("Charge").getText()));
                    vp.addContent(new Element("PrixU").setText(p.getChild("PrixU").getText()));
                    List<Element>  liste_produits_4gs =  new ArrayList<>();
                    for (Element p4g : p.getChild("Produit_4Gs").getChildren()) {
                        Element vp4g = new Element("Produit_4G");
                        vp4g.addContent(new Element("N_Serie").setText(p4g.getChild("N_Serie").getText()));
                        vp4g.addContent(new Element("E1").setText(p4g.getChild("E1").getText()));
                        vp4g.addContent(new Element("E2").setText(p4g.getChild("E2").getText()));
                        liste_produits_4gs.add(vp4g);
                    }
                    Element produitss = new Element("Produit_4Gs");
                    produitss.addContent(liste_produits_4gs);
                    vp.addContent(produitss);
                    Array_liste_n_p_4g.add(vp);
                }
                else{
                    for (int j = 0; j < liste_des_ID_4g.size(); j++) {
                        if (p.getChild("Id").getText().equals(liste_des_ID_4g.get(j)+"")) {
                            for (Element pk : Array_liste_n_p_4g){
                                if(pk.getChild("Id").getText().equals(p.getChild("Id").getText()))
                                {
                                    int nn = Integer.parseInt(pk.getChild("Qte").getText()) +  Integer.parseInt(p.getChild("Qte").getText()) ;
                                    pk.getChild("Qte").setText(nn+"");
                                    List<Element>  l4gs =  new ArrayList<>();
                                    for (Element p4g : p.getChild("Produit_4Gs").getChildren()) {
                                        Element vp4g = new Element("Produit_4G");
                                        vp4g.addContent(new Element("N_Serie").setText(p4g.getChild("N_Serie").getText()));
                                        vp4g.addContent(new Element("E1").setText(p4g.getChild("E1").getText()));
                                        vp4g.addContent(new Element("E2").setText(p4g.getChild("E2").getText()));
                                        l4gs.add(vp4g);
                                    }
                                     for (Element p4g2 : pk.getChild("Produit_4Gs").getChildren()) {
                                        Element vp4g = new Element("Produit_4G");
                                        vp4g.addContent(new Element("N_Serie").setText(p4g2.getChild("N_Serie").getText()));
                                        vp4g.addContent(new Element("E1").setText(p4g2.getChild("E1").getText()));
                                        vp4g.addContent(new Element("E2").setText(p4g2.getChild("E2").getText()));
                                        l4gs.add(vp4g);
                                    }
                                    pk.getChild("Produit_4Gs").setContent(l4gs);
                                    //vp.addContent(liste_produits_4gs);

                                }
                            }
                        }
                        else
                        {
                            Element vp = new Element("Produit");
                            vp.addContent(new Element("Id").setText(p.getChild("Id").getText()));
                            vp.addContent(new Element("Nom").setText(p.getChild("Nom").getText()));
                            vp.addContent(new Element("PrixUTTC").setText(p.getChild("PrixUTTC").getText()));
                            vp.addContent(new Element("Total_HT").setText(p.getChild("Total_HT").getText()));
                            vp.addContent(new Element("Remise").setText(p.getChild("Remise").getText()));
                            vp.addContent(new Element("n_Serie").setText(p.getChild("n_Serie").getText()));
                            vp.addContent(new Element("n_Imei").setText(p.getChild("n_Imei").getText()));
//                            vp.addContent(new Element("produits_simple").setText(p.getChild("produits_simple").getText()));
                            vp.addContent(new Element("Signaler_probleme").setText(p.getChild("Signaler_probleme").getText()));
                            vp.addContent(new Element("Qte").setText(p.getChild("Qte").getText()));
                            vp.addContent(new Element("Tva").setText(p.getChild("Tva").getText()));
                            vp.addContent(new Element("Montant_Tva").setText(p.getChild("Montant_Tva").getText()));
                            vp.addContent(new Element("fodec").setText(p.getChild("fodec").getText()));
//                            vp.addContent(new Element("Charge").setText(p.getChild("Charge").getText()));
                            vp.addContent(new Element("PrixU").setText(p.getChild("PrixU").getText()));
                            List<Element>  liste_produits_4gs =  new ArrayList<>();
                            for (Element p4g : p.getChild("Produit_4Gs").getChildren()) {
                                Element vp4g = new Element("Produit_4G");
                                vp4g.addContent(new Element("N_Serie").setText(p4g.getChild("N_Serie").getText()));
                                vp4g.addContent(new Element("E1").setText(p4g.getChild("E1").getText()));
                                vp4g.addContent(new Element("E2").setText(p4g.getChild("E2").getText()));
                                liste_produits_4gs.add(vp4g);
                            }
                            Element produitss = new Element("Produit_4Gs");
                            produitss.addContent(liste_produits_4gs);
                            vp.addContent(produitss);
                            Array_liste_n_p_4g.add(vp);
                        }
                    }
                }
            }


/*
produit  serie
 */

             liste_produits = liste_p_serie.getChildren();

            for (Element p : liste_produits) {

                if(liste_des_ID_series.size()==0)
                {
                    liste_des_ID_series.add(Long.parseLong(p.getChild("Id").getText()));
                    Element vp = new Element("Produit");
                    vp.addContent(new Element("Id").setText(p.getChild("Id").getText()));
                    vp.addContent(new Element("Nom").setText(p.getChild("Nom").getText()));
                    vp.addContent(new Element("PrixUTTC").setText(p.getChild("PrixUTTC").getText()));
                    vp.addContent(new Element("Total_HT").setText(p.getChild("Total_HT").getText()));
                    vp.addContent(new Element("Remise").setText(p.getChild("Remise").getText()));
                    vp.addContent(new Element("n_Serie").setText(p.getChild("n_Serie").getText()));
                    vp.addContent(new Element("n_Imei").setText(p.getChild("n_Imei").getText()));
                   // vp.addContent(new Element("produits_simple").setText(p.getChild("produits_simple").getText()));
                    vp.addContent(new Element("Signaler_probleme").setText(p.getChild("Signaler_probleme").getText()));
                    vp.addContent(new Element("Qte").setText(p.getChild("Qte").getText()));
                    vp.addContent(new Element("Tva").setText(p.getChild("Tva").getText()));
                    vp.addContent(new Element("Montant_Tva").setText(p.getChild("Montant_Tva").getText()));
                    vp.addContent(new Element("fodec").setText(p.getChild("fodec").getText()));
//                    vp.addContent(new Element("Charge").setText(p.getChild("Charge").getText()));
                    vp.addContent(new Element("PrixU").setText(p.getChild("PrixU").getText()));
                   // List<Element>  liste_produits_serie =  new ArrayList<>();
                   // System.out.println(p.getChild("N_Series").getChildren());
                    Element vpse = new Element("N_Series");
                    for (Element ps : p.getChild("N_Series").getChildren()) {
                        vpse.addContent(new Element("N_Serie").setText(ps.getText()));

                    }
                    vp.addContent(vpse);
                   // vp.addContent(liste_produits_serie);
                    Array_liste_n_p_Serie.add(vp);
                }
                else{
                for (int j = 0; j < liste_des_ID_series.size(); j++) {
                    System.out.println(p.getChild("Id").getText()+" -- "+(liste_des_ID_series.get(j)+""));

                    if (p.getChild("Id").getText().equals(liste_des_ID_series.get(j)+"")) {
                        for (Element pk : Array_liste_n_p_Serie){
                            if(pk.getChild("Id").getText().equals(p.getChild("Id").getText()))
                            {
                                int nn = Integer.parseInt(pk.getChild("Qte").getText()) +  Integer.parseInt(p.getChild("Qte").getText()) ;
                                pk.getChild("Qte").setText(nn+"");
                                List<Element>  lserie =  new ArrayList<>();
                                for (Element ps : p.getChild("N_Series").getChildren()) {
                                    lserie.add(new Element("N_Serie").setText(ps.getText()));

                                }

                                 for (Element ps : pk.getChild("N_Series").getChildren()) {
                                     lserie.add(new Element("N_Serie").setText(ps.getText()));
                                }
                                pk.getChild("N_Series").setContent(lserie);


                            }
                        }
                    }
                    else
                    {
                        liste_des_ID_series.add(Long.parseLong(p.getChild("Id").getText()));
                        Element vp = new Element("Produit");
                        vp.addContent(new Element("Id").setText(p.getChild("Id").getText()));
                        vp.addContent(new Element("Nom").setText(p.getChild("Nom").getText()));
                        vp.addContent(new Element("PrixUTTC").setText(p.getChild("PrixUTTC").getText()));
                        vp.addContent(new Element("Total_HT").setText(p.getChild("Total_HT").getText()));
                        vp.addContent(new Element("Remise").setText(p.getChild("Remise").getText()));
                        vp.addContent(new Element("n_Serie").setText(p.getChild("n_Serie").getText()));
                        vp.addContent(new Element("n_Imei").setText(p.getChild("n_Imei").getText()));
                        // vp.addContent(new Element("produits_simple").setText(p.getChild("produits_simple").getText()));
                        vp.addContent(new Element("Signaler_probleme").setText(p.getChild("Signaler_probleme").getText()));
                        vp.addContent(new Element("Qte").setText(p.getChild("Qte").getText()));
                        vp.addContent(new Element("Tva").setText(p.getChild("Tva").getText()));
                        vp.addContent(new Element("Montant_Tva").setText(p.getChild("Montant_Tva").getText()));
                        vp.addContent(new Element("fodec").setText(p.getChild("fodec").getText()));
                  //      vp.addContent(new Element("Charge").setText(p.getChild("Charge").getText()));
                        vp.addContent(new Element("PrixU").setText(p.getChild("PrixU").getText()));
                        Element vpse = new Element("N_Series");
                        for (Element ps : p.getChild("N_Series").getChildren()) {
                            vpse.addContent(new Element("N_Serie").setText(ps.getText()));
                        }
                        vp.addContent(vpse);
                        Array_liste_n_p_Serie.add(vp);
                    }
                }
                }

            }
           // n_liste_p_4g.detach();
           // n_liste_p_serie.detach();
           // n_liste_p_simple.detach();

           // N_Produits.addContent(n_liste_p_4g);
           // N_Produits.addContent(n_liste_p_serie);
           // N_Produits.addContent(n_liste_p_simple);

        } catch (Exception e) {
            e.printStackTrace();
        }


            Element id_bl = new Element( "Id_BL")  ;id_bl.setText(liste[i]);
            Element BL = new Element( "BL")  ;
            BL.addContent(id_bl);
            liste_p.detach();
            total.detach();

            BL.addContent(liste_p );
            BL.addContent(total);
            Liste_Produit.addContent(BL);

        }
        Element N_Produits = new Element("Produits");
        Element n_liste_p_simple =new Element("Produits_Simples");
        Element n_liste_p_4g =new Element("Produits_4Gs");
        Element n_liste_p_serie = new Element("Produits_Series");
        for(int m =0 ; m< Array_liste_n_p_simple.size();m++)
        {
            n_liste_p_simple.addContent(Array_liste_n_p_simple.get(m));
        }
        for(int m =0 ; m< Array_liste_n_p_4g.size();m++)
        {
            n_liste_p_4g.addContent(Array_liste_n_p_4g.get(m));
        }
        for(int m =0 ; m< Array_liste_n_p_Serie.size();m++)
        {
            n_liste_p_serie.addContent(Array_liste_n_p_Serie.get(m));
        }
        N_Produits.addContent(n_liste_p_simple);
        N_Produits.addContent(n_liste_p_4g);
        N_Produits.addContent(n_liste_p_serie);

        Element Facture = new Element("Facture");
        Facture.addContent(N_Produits);
        Facture.addContent(Liste_Produit);
        Document document = new Document(Facture);
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try{ sortie.output(document, bout);}catch (Exception ee){}
        return bout.toByteArray();
    }


    // detail facture sous format xml
    public Facture Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
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
        Optional<Facture> searchEntity = Repo.findById(Id);
        Facture p = searchEntity.get();
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
    public String Abandonner_Facture(long id) {
       // Optional<Facture> searchEntity = Repo.findById(id);
       // Facture p = searchEntity.get();
      //  Abondoner(p.getDetail());
        //return "ok" ;
        Optional<Facture> searchEntity = Repo.findById(id);
        Facture p = searchEntity.get();
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
