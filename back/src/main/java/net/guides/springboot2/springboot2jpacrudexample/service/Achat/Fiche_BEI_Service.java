package net.guides.springboot2.springboot2jpacrudexample.service.Achat;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Fiche_BEI;
import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Fiche_BEL;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Produit;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Quantite_Fiche_Technique;
import net.guides.springboot2.springboot2jpacrudexample.repository.Achat.Fiche_BEI_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.init.Fiche_Produit_Repository;
import net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.service.Stock.Stock_Service;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@Service
public class Fiche_BEI_Service {

    @Autowired
    Fiche_BEI_Repository Repo;

    @Autowired
    DataSource dataSource;

    @Autowired
    Fiche_Produit_Repository Repo_produit ;


    @Autowired
    Stock_Service Stock ;


    public List<Fiche_BEI> Tous() {
        return (List<Fiche_BEI>)  Repo.findAll();
    }

    public Object Fiche_Bon_Entree_Importation(Long id) {
        return Repo.findById(id);
    }


    public Fiche_BEI Creer_Fiche_Bon_Entree_Importation(String id_Responsable, String id_Fr, String mode_Paiement, double charge_Transport, double autre_Charge_Fixe, String ag_Transport, String  type, String n_Facture, String etat, String  description, String  local, String  titre, String transfert, String  lc, String  fed, String mode_Livraison, String  type_Livraison, double charge_Transitaire, double charge_Banque, double  charge_Magasin, String ag_Transitaire, String  n_Preforma, Date date_Proforma, Date date_Facture, Date  date_Livraison, Date date_Paiement, Date date_Be, double charge_Transport_Importation, double  charge_Assurance_Importation, double court, String  devise, boolean transport_Inclut,  double  total_Fodec, double total_Tva, double total_R_HT, double  totale_Declare, double totale_Taxe, double  totale_Tva, double pinalite, MultipartFile  details ,   MultipartFile Doc_Banque ,   MultipartFile Doc_Importation , MultipartFile Doc_Transitaire ,  MultipartFile Doc_Transport)
    {
        try {

            Fiche_BEI dbFile = new Fiche_BEI (  id_Responsable,   id_Fr,   mode_Paiement,   charge_Transport,   autre_Charge_Fixe,   ag_Transport,   type,   n_Facture,    etat,   description,   local,   titre,   transfert,   lc,   fed,   mode_Livraison,   type_Livraison,   charge_Transitaire,   charge_Banque,   charge_Magasin,   ag_Transitaire,   n_Preforma,   date_Proforma,   date_Facture,   date_Livraison,   date_Paiement,   date_Be,   charge_Transport_Importation,   charge_Assurance_Importation,   court,   devise,   transport_Inclut ,   total_Fodec,   total_Tva,      total_R_HT,    totale_Declare,   totale_Taxe,   totale_Tva,   pinalite,   details.getContentType() ,   details.getBytes(),   Doc_Banque.getContentType() ,   Doc_Banque.getBytes(),   Doc_Importation.getContentType() ,   Doc_Importation.getBytes(),   Doc_Transitaire.getContentType() ,   Doc_Transitaire.getBytes(),   Doc_Transport.getContentType() ,   Doc_Transport.getBytes()) ;
                return Repo.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }

     }


    public Fiche_BEI Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public ResponseEntity<Object> Supprimer_Fiche_Bon_Entree_Importation(Long id) {
        Optional<Fiche_BEI> Entity =  Repo.findById(id);
        if (Entity.isPresent()) {
            Fiche_BEI Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }


    public Fiche_BEI Modifier_Fiche_Bon_Entree_Importation( Long  Id , String id_Responsable, String id_Fr, String mode_Paiement, double charge_Transport, double autre_Charge_Fixe, String ag_Transport, String  type, String n_Facture, String etat, String  description, String  local, String  titre, String transfert, String  lc, String  fed, String mode_Livraison, String  type_Livraison, double charge_Transitaire, double charge_Banque, double  charge_Magasin, String ag_Transitaire, String  n_Preforma, Date date_Proforma, Date date_Facture, Date  date_Livraison, Date date_Paiement, Date date_Be, double charge_Transport_Importation, double  charge_Assurance_Importation, double court, String  devise, boolean transport_Inclut,  double  total_Fodec, double total_Tva, double total_R_HT, double  totale_Declare, double totale_Taxe, double  totale_Tva, double pinalite, MultipartFile  details ,   MultipartFile Doc_Banque ,   MultipartFile Doc_Importation , MultipartFile Doc_Transitaire ,  MultipartFile Doc_Transport)
    { try {
            Fiche_BEI Entity = new Fiche_BEI (  id_Responsable,   id_Fr,   mode_Paiement,   charge_Transport,   autre_Charge_Fixe,   ag_Transport,   type,   n_Facture,    etat,   description,   local,   titre,   transfert,   lc,   fed,   mode_Livraison,   type_Livraison,   charge_Transitaire,   charge_Banque,   charge_Magasin,   ag_Transitaire,   n_Preforma,   date_Proforma,   date_Facture,   date_Livraison,   date_Paiement,   date_Be,   charge_Transport_Importation,   charge_Assurance_Importation,   court,   devise,   transport_Inclut ,   total_Fodec,   total_Tva,      total_R_HT,    totale_Declare,   totale_Taxe,   totale_Tva,   pinalite,   details.getContentType() ,   details.getBytes()) ;
            Optional<Fiche_BEI> searchEntity =  Repo.findById(Id);
            if (searchEntity.isPresent()) {
                Fiche_BEI  p = searchEntity.get();
                p.setId_Responsable(Entity.getId_Responsable());
                p.setId_Fr(Entity.getId_Fr()) ;
                p.setMode_Paiement(Entity.getMode_Paiement()) ;
                p.setCharge_Transport (Entity.getCharge_Transport()) ;
                p.setAutre_Charge_Fixe (Entity.getAutre_Charge_Fixe()) ;
                p.setAg_Transport (Entity.getAg_Transport ()) ;
                p.setType (Entity.getType()) ;
                p.setN_Facture (Entity.getN_Facture ()) ;
                p.setEtat(Entity.getEtat());
                p.setDescription (Entity.getDescription()) ;
                p.setLocal(Entity.getLocal());
                p.setTitre (Entity.getTitre());
                p.setTransfert(Entity.getTransfert());
                p.setLc (Entity.getLc());
                p.setFed (Entity.getFed());
                p.setDetails(Entity.getDetails());
                p.setType_Detail(Entity.getType_Detail());
                p.setTotale_Tva (Entity.getTotale_Tva()) ;
                p.setEtat (Entity.getEtat());
                p.setMode_Livraison(Entity.getMode_Livraison());
                p.setType_Livraison (Entity.getType_Livraison());
                p.setCharge_Transitaire (Entity.getCharge_Transitaire());
                p.setCharge_Banque (Entity.getCharge_Banque());
                p.setCharge_Magasin(Entity.getCharge_Magasin());
                p.setAg_Transitaire(Entity.getAg_Transitaire());
                p.setN_Preforma (Entity.getN_Preforma());
                p.setDate_Proforma (Entity.getDate_Proforma());
                p.setDate_Facture(Entity.getDate_Facture());
                p.setDate_Livraison (Entity.getDate_Livraison());
                p.setDate_Paiement (Entity.getDate_Paiement());
                p.setDate_Be (Entity.getDate_Be());
                p.setCharge_Transport_Importation (Entity.getCharge_Transport_Importation());
                p.setCharge_Assurance_Importation (Entity.getCharge_Assurance_Importation());
                p.setCours (Entity.getCours());
                p.setDevise (Entity.getDevise());
                p.setTransport_Inclut (Entity.isTransport_Inclut());
                p.setTotal_Fodec (Entity.getTotal_Fodec());
                p.setTotal_Tva (Entity.getTotal_Tva());
                p.setTotal_R_HT (Entity.getTotal_R_HT());
                p.setTotale_Declare (Entity.getTotale_Declare());
                p.setTotale_Taxe (Entity.getTotale_Taxe());
                p.setTotale_Tva (Entity.getTotale_Tva());
                p.setPenalite (Entity.getPenalite());
                p.setType_Detail (Entity.getType_Detail());
                p.setDetails (Entity.getDetails());
                if (Doc_Banque!=null)
                {
                    p.setDoc_Banque(Doc_Banque.getBytes());
                    p.setType_Doc_Banque(Doc_Banque.getContentType());
                }
                if (Doc_Banque!=null)
                {
                    p.setDoc_Importation(Doc_Importation.getBytes());
                    p.setType_Doc_Importation(Doc_Importation.getContentType());
            }
                if (Doc_Transitaire!=null)
                {
                    p.setDoc_Transitaire(Doc_Transitaire.getBytes());
                    p.setType_Doc_Transitaire(Doc_Transitaire.getContentType());
                }
                if (Doc_Transport!=null)
                {
                    p.setDoc_Transport(Doc_Transport.getBytes());
                    p.setType_Doc_Transport(Doc_Transport.getContentType());
                }
                Entity = Repo.save(p);
            } else {
                throw new EntityNotFoundException();
            }
            return Entity;
        } catch (IOException ex) {
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }




    public  List<Fiche_BEI>  filtre (String champ , String valeur ) {
        List<Fiche_BEI> liste = new ArrayList<>();
        try {
            String query = "select Id_Bon as id_bon , Id_Responsable as id_Responsable, Id_Fr as id_Fr, Mode_Paiement as mode_Paiement,  Charge_Transport as charge_Transport," +
                    " Autre_Charge_Fixe as autre_Charge_Fixe,  Ag_Transport as ag_Transport, Type as type,   N_Facture as n_Facture," +
                    " Etat as etat, Description as description, Local as local,  Titre as titre,  Transfert as transfert,  Lc as lc," +
                    " Fed as fed, Mode_Livraison as mode_Livraison,  Type_Livraison as type_Livraison,  Charge_Transitaire as charge_Transitaire," +
                    " Charge_Banque as charge_Banque, Charge_Magasin as charge_Magasin, Ag_Transitaire as ag_Transitaire," +
                    " N_Preforma as n_Preforma, Date_Proforma as   date_Proforma , Date_Facture as date_Facture,Date_Livraison as date_Livraison, Date_Paiement as date_Paiement," +

                    " Date_Be as  date_Be, Charge_Transport_Importation as charge_Transport_Importation, Charge_Assurance_Importation as charge_Assurance_Importation," +
                    " Cours as cours,  Devise as devise,  Transport_Inclut  as transport_Inclut,  Total_Fodec as total_Fodec, Total_Tva as total_Tva,Total_R_HT as total_R_HT," +

                    " Totale_Declare as totale_Declare,Totale_Taxe as totale_Taxe, Totale_Tva as totale_Tva, Penalite as penalite, Type_Detail as type_Detail," +
                    "Details as details, Type_Doc_Banque as type_Doc_Banque, Doc_Banque  as Doc_Banque, Type_Doc_Importation as type_Doc_Importation," +
                    "  Doc_Importation as Doc_Importation,  Type_Doc_Transitaire as type_Doc_Transitaire,  Doc_Transitaire as Doc_Transitaire,  Type_Doc_Transport as type_Doc_Transport," +
                    " Doc_Transport as Doc_Transport from Fiche_BEI where "+champ+" = '" + valeur + "'";
            Statement stmt = dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Fiche_BEI  p = new Fiche_BEI();

                p.setId_Bon(rs.getLong("id_bon"));
                p.setId_Fr  (rs.getString("id_Fr")) ;
                p.setMode_Paiement(rs.getString("mode_Paiement")) ;
                p.setCharge_Transport (rs.getDouble("charge_Transport")) ;
                p.setAutre_Charge_Fixe (rs.getDouble("autre_Charge_Fixe")) ;
                p.setAg_Transport (rs.getString("ag_Transport")) ;
                p.setType (rs.getString("type")) ;
                p.setN_Facture (rs.getString("n_Facture")) ;
                p.setDate_Be (rs.getDate("date_Be"));
                p.setTotal_Fodec (rs.getDouble("total_Fodec")) ;
                p.setTotal_Tva (rs.getDouble("total_Tva")) ;
                p.setTotal_R_HT (rs.getDouble("total_R_HT")) ;
                p.setEtat (rs.getString("etat"));
                p.setDescription (rs.getString("description"));
                p.setLocal (rs.getString("local"));
                p.setId_Responsable (rs.getString("id_Responsable"));
                p.setType_Detail (rs.getString("type_Detail")) ;
                p.setDetails (rs.getBytes("details")) ;
                liste.add(p);
            }
        } catch ( Exception e) {
             System.out.println(e.getMessage());
        }
        return liste ;
    }




    public Fiche_BEI Fiche_BEI(Long id_bon) {
        return Repo.findById(id_bon)
                .orElseThrow(() -> new net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException("File not found with id " +  id_bon));
    }


    public List<Quantite_Fiche_Technique> Quantite_Fiche_Technique(Long id) {
        ArrayList<Quantite_Fiche_Technique> liste = new ArrayList<>();
        Optional<Fiche_BEI> bl = Repo.findById(id);
        Fiche_BEI p = bl.get();
        byte[] doc2 = p.getDetails();
        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
        try {
            doc = builder.build(new ByteArrayInputStream(doc2));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element rootElement = doc.getRootElement();
        Element produits = rootElement.getChild("Produits");
        Element Produits_Simples = produits.getChild("Produits_Simples");
        Element Produits_4Gs = produits.getChild("Produits_4Gs");
        Element Produits_serie = produits.getChild("Produits_Serie");
        Element Produits_nlot = produits.getChild("Produits_N_Lot");

        System.out.println(Produits_nlot);
        if (Produits_Simples!=null) {
            for (Element elm : Produits_Simples.getChildren()) {
                {
                    Optional<Fiche_Produit> searchEntity = Repo_produit.findById(Long.parseLong(elm.getChild("Id").getValue()));
                    Fiche_Produit produit = searchEntity.get();

                    Quantite_Fiche_Technique e = new Quantite_Fiche_Technique(Long.parseLong(elm.getChild("Id").getValue()), Integer.parseInt(elm.getChild("Qte").getValue()), produit.getCaracteristique_Technique(),produit.getNom_Produit());
                    liste.add(e);

                }
            }
        }
        if (Produits_4Gs!=null){
            for (Element elm : Produits_4Gs.getChildren()) {
                {
                    Optional<Fiche_Produit> searchEntity = Repo_produit.findById(Long.parseLong(elm.getChild("Id").getValue()));
                    Fiche_Produit produit = searchEntity.get();
                    Quantite_Fiche_Technique e = new Quantite_Fiche_Technique(Long.parseLong(elm.getChild("Id").getValue()), Integer.parseInt(elm.getChild("Qte").getValue()), produit.getCaracteristique_Technique(),produit.getNom_Produit());
                    liste.add(e);
                }
            }
        }
        if (Produits_serie!=null) {
            for (Element elm : Produits_serie.getChildren()) {
                {
                    Optional<Fiche_Produit> searchEntity = Repo_produit.findById(Long.parseLong(elm.getChild("Id").getValue()));
                    Fiche_Produit produit = searchEntity.get();
                    Quantite_Fiche_Technique e = new Quantite_Fiche_Technique(Long.parseLong(elm.getChild("Id").getValue()), Integer.parseInt(elm.getChild("Qte").getValue()), produit.getCaracteristique_Technique(),produit.getNom_Produit());
                    liste.add(e);
                }
            }
        }
        if (Produits_nlot!=null) {
            for (Element elm : Produits_nlot.getChildren()) {
                {
                    Optional<Fiche_Produit> searchEntity = Repo_produit.findById(Long.parseLong(elm.getChild("Id").getValue()));
                    Fiche_Produit produit = searchEntity.get();
                    Quantite_Fiche_Technique e = new Quantite_Fiche_Technique(Long.parseLong(elm.getChild("Id").getValue()), Integer.parseInt(elm.getChild("Qte").getValue()), produit.getCaracteristique_Technique(),produit.getNom_Produit());
                    liste.add(e);
                }
            }
        }
        return liste ;
    }

    public String Entree_Fiche_Bon_Entree_iMPORTATION_Au_Stock(Long id_bon) {

        Optional<Fiche_BEI> searchEntity = Repo.findById(id_bon);
        Fiche_BEI p;
        if (searchEntity.isPresent()) {
            p = searchEntity.get();
            Entree(p.getDetails());
            p.setEtat("Affecter");
            Repo.save(p);
            return "ok";
        } else {
            throw new EntityNotFoundException();
        }
    }

    private void Entree(byte[] details) {

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
        Stock.Ajouter_importation(Produits );
    }

    public String Archiver_Fiche_Bon_Entree_Importation(Long id_bon) {
        Optional<Fiche_BEI> searchEntity =  Repo.findById(id_bon);
        Fiche_BEI p ;
        if (searchEntity.isPresent()) {
            p=searchEntity.get() ;
            p.setEtat ("Archiver") ;
            Repo.save(p);
            return "ok";
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<Fiche_BEI> Fiche_Bon_Entree_Importation_En_Cours() {
        List<Fiche_BEI> liste = new ArrayList<>();
        try {
            String query = "select Id_Bon as id_bon , Id_Responsable as id_Responsable, Id_Fr as id_Fr, Mode_Paiement as mode_Paiement,  Charge_Transport as charge_Transport," +
                    " Autre_Charge_Fixe as autre_Charge_Fixe,  Ag_Transport as ag_Transport, Type as type,   N_Facture as n_Facture," +
                    " Etat as etat, Description as description, Local as local,  Titre as titre,  Transfert as transfert,  Lc as lc," +
                    " Fed as fed, Mode_Livraison as mode_Livraison,  Type_Livraison as type_Livraison,  Charge_Transitaire as charge_Transitaire," +
                    " Charge_Banque as charge_Banque, Charge_Magasin as charge_Magasin, Ag_Transitaire as ag_Transitaire," +
                    " N_Preforma as n_Preforma, Date_Proforma as   date_Proforma , Date_Facture as date_Facture,Date_Livraison as date_Livraison, Date_Paiement as date_Paiement," +

                    " Date_Be as  date_Be, Charge_Transport_Importation as charge_Transport_Importation, Charge_Assurance_Importation as charge_Assurance_Importation," +
                    " Cours as cours,  Devise as devise,  Transport_Inclut  as transport_Inclut,  Total_Fodec as total_Fodec, Total_Tva as total_Tva,Total_R_HT as total_R_HT," +

                    " Totale_Declare as totale_Declare,Totale_Taxe as totale_Taxe, Totale_Tva as totale_Tva, Penalite as penalite, Type_Detail as type_Detail," +
                    "Details as details, Type_Doc_Banque as type_Doc_Banque, Doc_Banque  as Doc_Banque, Type_Doc_Importation as type_Doc_Importation," +
                    "  Doc_Importation as Doc_Importation,  Type_Doc_Transitaire as type_Doc_Transitaire,  Doc_Transitaire as Doc_Transitaire,  Type_Doc_Transport as type_Doc_Transport," +
                    " Doc_Transport as Doc_Transport from Fiche_BEI WHERE etat Not like 'Archiver%'  ";
            Statement stmt = dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Fiche_BEI  p = new Fiche_BEI();

                p.setId_Bon(rs.getLong("id_bon"));
                p.setId_Fr  (rs.getString("id_Fr")) ;
                p.setMode_Paiement(rs.getString("mode_Paiement")) ;
                p.setCharge_Transport (rs.getDouble("charge_Transport")) ;
                p.setAutre_Charge_Fixe (rs.getDouble("autre_Charge_Fixe")) ;
                p.setAg_Transport (rs.getString("ag_Transport")) ;
                p.setType (rs.getString("type")) ;
                p.setN_Facture (rs.getString("n_Facture")) ;
                p.setDate_Be (rs.getDate("date_Be"));
                p.setTotal_Fodec (rs.getDouble("total_Fodec")) ;
                p.setTotal_Tva (rs.getDouble("total_Tva")) ;
                p.setTotal_R_HT (rs.getDouble("total_R_HT")) ;
                p.setEtat (rs.getString("etat"));
                p.setDescription (rs.getString("description"));
                p.setLocal (rs.getString("local"));
                p.setId_Responsable (rs.getString("id_Responsable"));
                p.setType_Detail (rs.getString("type_Detail")) ;
                p.setDetails (rs.getBytes("details")) ;
                liste.add(p);
            }
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        return liste ;
    }
}
