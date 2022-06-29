package net.guides.springboot2.springboot2jpacrudexample.service.Achat;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Fiche_BEL;
import net.guides.springboot2.springboot2jpacrudexample.model.Donnee.Categorie_Type1;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Produit;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Reception;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Quantite_Fiche_Technique;
import net.guides.springboot2.springboot2jpacrudexample.repository.Achat.Fiche_BEL_Repository;
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

@Service
public class Fiche_BEL_Service {

    @Autowired
    Fiche_BEL_Repository Repo;

    @Autowired
    Fiche_Produit_Repository Repo_produit ;

    @Autowired
    Stock_Service Stock ;

    @Autowired
    DataSource dataSource;

    public List<Fiche_BEL> Tous() {
        return (List<Fiche_BEL>)  Repo.findAll();
    }

    public Object Fiche_Bon_Entree_Local(Long id_produit) {
        return Repo.findById(id_produit);
    }


    public Fiche_BEL Creer_Fiche_Bon_Entree_Local(String id_Fr, String mode_Paiement, double charge_Transport, double autre_Charge_Fixe, String ag_Transport, String type, String n_Facture, Date date_BEL, String etat, String description, String local, String id_Responsable, String type_Detail, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_R_HT, double total_R_TTC, MultipartFile details )
    {
        Fiche_BEL Entity = null;
        try {
            Entity = new Fiche_BEL(  id_Fr,   mode_Paiement,   charge_Transport,   autre_Charge_Fixe,   ag_Transport,   type,   n_Facture,   date_BEL,   etat,   description,   local,   id_Responsable,   type_Detail,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   total_R_HT,   total_R_TTC,   details.getBytes() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Repo.save(Entity);
    }

    public Fiche_BEL Modifier_Fiche_Bon_Entree_Local(Long Id ,String id_Fr, String mode_Paiement, double charge_Transport, double autre_Charge_Fixe, String ag_Transport, String type, String n_Facture, Date date_BEL, String etat, String description, String local, String id_Responsable, String type_Detail, double total_HT_Brut, double total_Remise, double total_HT_Net, double total_Fodec, double total_Tva, double total_TTC, double total_R_HT, double total_R_TTC, MultipartFile details )
    {
        Fiche_BEL Entity = null;
        try {
            Entity = new Fiche_BEL(  id_Fr,   mode_Paiement,   charge_Transport,   autre_Charge_Fixe,   ag_Transport,   type,   n_Facture,   date_BEL,   etat,   description,   local,   id_Responsable,   type_Detail,   total_HT_Brut,   total_Remise,   total_HT_Net,   total_Fodec,   total_Tva,   total_TTC,   total_R_HT,   total_R_TTC,    details.getBytes() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        Optional<Fiche_BEL> searchEntity =  Repo.findById(Id);
        if (searchEntity.isPresent()) {
            Fiche_BEL  p = searchEntity.get();
            p.setId_Fr  (Entity.getId_Fr()) ;
            p.setMode_Paiement(Entity.getMode_Paiement()) ;
            p.setCharge_Transport (Entity.getCharge_Transport()) ;
            p.setAutre_Charge_Fixe (Entity.getAutre_Charge_Fixe()) ;
            p.setAg_Transport (Entity.getAg_Transport ()) ;
            p.setType (Entity.getType()) ;
            p.setN_Facture (Entity.getN_Facture ()) ;
            p.setDate_BEL (Entity.getDate_BEL());
            p.setDetails(Entity.getDetails());
            p.setType_Detail(Entity.getType_Detail());
            p.setEtat (Entity.getEtat()) ;
            p.setDescription (Entity.getDescription());
            p.setTotal_HT_Brut(Entity.getTotal_HT_Brut());
            p.setTotal_Remise(Entity.getTotal_Remise());
            p.setTotal_HT_Net (Entity.getTotal_HT_Net());
            p.setTotal_Fodec (Entity.getTotal_Fodec());
            p.setTotal_Tva (Entity.getTotal_Tva());
            p.setTotal_TTC(Entity.getTotal_TTC());
            p.setTotal_R_HT (Entity.getTotal_R_HT());
            p.setTotal_R_TTC (Entity.getTotal_R_TTC());
            p.setLocal (Entity.getLocal());
            Entity = Repo.save(p);
        } else {
            throw new EntityNotFoundException();
        }
        return Entity;
    }

    public ResponseEntity<Object> Supprimer_Fiche_Bon_Entree_Local(Long id) {
        Optional<Fiche_BEL> Entity =  Repo.findById(id);
        if (Entity.isPresent()) {
            Fiche_BEL Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }


    public  List<Fiche_BEL>  filtre (String champ , String valeur ) {
        List<Fiche_BEL> liste = new ArrayList<>();
        try {
            String query = "select    Id_Bon_Entree_Local as id_Bon_Entree_Local , Id_Fr as id_Fr ,    Mode_Paiement as mode_Paiement ," +
                    "        Charge_Transport as charge_Transport, Autre_Charge_Fixe as autre_Charge_Fixe,  Ag_Transport as ag_Ttransport," +
                    "        Type as type, N_Facture as n_Facture, Date_BEL as date,   " +
                   " Id_Responsable as id_Responsable ,Type_Detail as type_Detail ,  Details as details,"+
                    "  Total_HT_Brut = total_HT_Brut ,Total_Remise as  total_Remise ,  Total_HT_Net as total_HT_Net , Total_Fodec as  total_Fodec ,"+
                    "  Total_Tva as  total_Tva , Total_TTC as  total_TTC , Total_R_HT as  total_R_HT , Total_R_TTC as  total_R_TTC ,"+
                    "  Etat as etat , Description as des , Local as local from Fiche_BEL where "+champ+" = '" + valeur + "'";
            Statement stmt = dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Fiche_BEL  p = new Fiche_BEL();
                p.setId_Bon_Entree_Local(rs.getLong("id_Bon_Entree_Local"));
                p.setId_Fr  (rs.getString("id_Fr")) ;
                p.setMode_Paiement(rs.getString("mode_Paiement")) ;
                p.setCharge_Transport (rs.getDouble("charge_Transport")) ;
                p.setAutre_Charge_Fixe (rs.getDouble("autre_Charge_Fixe")) ;
                p.setAg_Transport (rs.getString("ag_Ttransport")) ;
                p.setType (rs.getString("type")) ;
                p.setN_Facture (rs.getString("n_Facture")) ;
                p.setDate_BEL (rs.getDate("date"));
                p.setTotal_HT_Brut(rs.getDouble("total_HT_Brut")) ;
                p.setTotal_Remise (rs.getDouble("total_Remise")) ;
                p.setTotal_HT_Net (rs.getDouble("total_HT_Net"));
                p.setTotal_Fodec (rs.getDouble("total_Fodec")) ;
                p.setTotal_Tva (rs.getDouble("total_Tva")) ;
                p.setTotal_TTC (rs.getDouble("total_TTC")) ;
                p.setTotal_R_HT (rs.getDouble("total_R_HT")) ;
                p.setTotal_R_TTC (rs.getDouble("total_R_TTC")) ;
                p.setEtat (rs.getString("etat")); ;
                p.setDescription (rs.getString("des")); ;;
                p.setLocal (rs.getString("local")); ;
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

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }


    public Fiche_BEL Fiche_BEL(Long id_bon) {
        return Repo.findById(id_bon)
                .orElseThrow(() -> new net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException("File not found with id " +  id_bon));
    }

    public Fiche_BEL Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public String Archiver_Fiche_Bon_Entree_Local(Long id_bon) {
        Optional<Fiche_BEL> searchEntity =  Repo.findById(id_bon);
        Fiche_BEL p ;
        if (searchEntity.isPresent()) {
             p=searchEntity.get() ;
            p.setEtat ("Archiver") ;
            Repo.save(p);
            return "ok";
        } else {
            throw new EntityNotFoundException();
        }
    }

    public String Entree_Fiche_Bon_Entree_Local_Au_Stock(Long id_bon) {
        Optional<Fiche_BEL> searchEntity =  Repo.findById(id_bon);
        Fiche_BEL p ;
        if (searchEntity.isPresent()) {
            p=searchEntity.get() ;
            Entree (p.getDetails());
            p.setEtat ("Affecter") ;
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
        Stock.Ajouter(Produits );
    }

    public List<Quantite_Fiche_Technique> Quantite_Fiche_Technique( Long id) {
        ArrayList<Quantite_Fiche_Technique> liste = new ArrayList<>();
        Optional<Fiche_BEL> bl = Repo.findById(id);
        Fiche_BEL p = bl.get();
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
        Element Produits_serie = produits.getChild("Produits_Series");
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
        //String xmlData = new String(doc); System.out.println(xmlData);

        return liste ;

    }

    public List<Fiche_BEL> Fiche_Bon_Entree_Local_En_Cours() {
        List<Fiche_BEL> liste = new ArrayList<>();
        try {

            String query = "  select    Id_Bon_Entree_Local as id_Bon_Entree_Local , Id_Fr as id_Fr ,    Mode_Paiement as mode_Paiement ," +
            "        Charge_Transport as charge_Transport, Autre_Charge_Fixe as autre_Charge_Fixe,  Ag_Transport as ag_Ttransport," +
                    "        Type as type, N_Facture as n_Facture, Date_BEL as date,   " +
                    " Id_Responsable as id_Responsable ,Type_Detail as type_Detail ,  Details as details,"+
                    "  Total_HT_Brut = total_HT_Brut ,Total_Remise as  total_Remise ,  Total_HT_Net as total_HT_Net , Total_Fodec as  total_Fodec ,"+
                    "  Total_Tva as  total_Tva , Total_TTC as  total_TTC , Total_R_HT as  total_R_HT , Total_R_TTC as  total_R_TTC ,"+
                    "  Etat as etat , Description as des , Local as local from Fiche_BEL WHERE etat Not like 'Archiver%'  ";
            Statement stmt = dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Fiche_BEL  p = new Fiche_BEL();
                p.setId_Bon_Entree_Local(rs.getLong("id_Bon_Entree_Local"));
                p.setId_Fr  (rs.getString("id_Fr")) ;
                p.setMode_Paiement(rs.getString("mode_Paiement")) ;
                p.setCharge_Transport (rs.getDouble("charge_Transport")) ;
                p.setAutre_Charge_Fixe (rs.getDouble("autre_Charge_Fixe")) ;
                p.setAg_Transport (rs.getString("ag_Ttransport")) ;
                p.setType (rs.getString("type")) ;
                p.setN_Facture (rs.getString("n_Facture")) ;
                p.setDate_BEL (rs.getDate("date"));
                p.setTotal_HT_Brut(rs.getDouble("total_HT_Brut")) ;
                p.setTotal_Remise (rs.getDouble("total_Remise")) ;
                p.setTotal_HT_Net (rs.getDouble("total_HT_Net"));
                p.setTotal_Fodec (rs.getDouble("total_Fodec")) ;
                p.setTotal_Tva (rs.getDouble("total_Tva")) ;
                p.setTotal_TTC (rs.getDouble("total_TTC")) ;
                p.setTotal_R_HT (rs.getDouble("total_R_HT")) ;
                p.setTotal_R_TTC (rs.getDouble("total_R_TTC")) ;
                p.setEtat (rs.getString("etat")); ;
                p.setDescription (rs.getString("des")); ;;
                p.setLocal (rs.getString("local")); ;
                p.setId_Responsable (rs.getString("id_Responsable"));
                p.setType_Detail (rs.getString("type_Detail")) ;
                p.setDetails (rs.getBytes("details")) ;
                liste.add(p);
            }
            stmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }
}
