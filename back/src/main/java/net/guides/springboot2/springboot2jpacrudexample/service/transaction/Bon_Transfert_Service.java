package net.guides.springboot2.springboot2jpacrudexample.service.transaction;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Produit;
import net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Retour;
import net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Transfert;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Reception;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Quantite_Fiche_Technique;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.Devis_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.init.Fiche_Produit_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.transaction.Bon_Transfert_Repository;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.FileStorageException;
import net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Bon_Transfert_Service {
    @Autowired
    Bon_Transfert_Repository Repo;
    @Autowired
    DataSource dataSource;

    @Autowired
    Fiche_Produit_Repository Repo_produit ;

    public List<Bon_Transfert> Bon_Transferts() {
        return (List<Bon_Transfert>)  Repo.findAll();
    }
    public Optional<Bon_Transfert> Bon_Transfert(Long id ) {
        return   Repo.findById(id );
    }

    public Bon_Transfert Creer_Bon_Transfert (     String  Responsable,  String description, String local_Source, String local_Destination,    MultipartFile detail )
    {
        try {
            Bon_Transfert dbFile = new Bon_Transfert (       Responsable,       description,   local_Source,   local_Destination,  detail.getContentType(),  detail.getBytes() ) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    public  Bon_Transfert Modifier_Bon_Transfert (Long id_Bon_Transfert, String  Responsable, String description, String local_Source, String local_Destination,    MultipartFile detail )
    {
        try {
            Bon_Transfert Entity = new Bon_Transfert (  id_Bon_Transfert,    Responsable,      description,   local_Source,   local_Destination,  detail.getContentType(),  detail.getBytes() ) ;
            Optional<Bon_Transfert> searchEntity = Repo.findById(id_Bon_Transfert);
            if (searchEntity.isPresent()) {
                Bon_Transfert p = searchEntity.get();
             /*   p.setId_Clt (Entity.getId_Clt());
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
                Entity = Repo.save(p);*/
            } else {
                throw new EntityNotFoundException();
            }
            return Entity;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    public ResponseEntity<Object> Supprimer_Bon_Transfert(Long id ) {
        Optional<Bon_Transfert> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Bon_Transfert Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }

    public Bon_Transfert Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public List<Quantite_Fiche_Technique> Quantite_Fiche_Technique(Long id) {
        ArrayList<Quantite_Fiche_Technique> liste = new ArrayList<>();
        Optional<Bon_Transfert> bl = Repo.findById(id);
        Bon_Transfert p = bl.get();
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
        System.out.println(doc);
        Element produits = rootElement.getChild("Produits");
        Element Produits_Simples = produits.getChild("Produits_Simples");
        Element Produits_4Gs = produits.getChild("Produits_4Gs");
        Element Produits_serie = produits.getChild("Produits_Series");

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

        return liste ;
    }


    public List<Bon_Transfert> filtre(String champ1, String valeur1, String champ2, String valeur2, String champ3, String valeur3) {
        List<Bon_Transfert> liste = new ArrayList<>();
        try {

            String query = "SELECT * FROM Bon_Transfert WHERE " + champ1 + " like '" + valeur1 + "%' AND "  + champ2 + " like '" + valeur2 + "%' AND "  + champ3 + " like '" + valeur3 + "%'  ";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Transfert f = new Bon_Transfert();
                f.setLocal_Destination (rs.getString("local_Destination"));
                f.setLocal_Source (rs.getString("local_Source"));
                f.setEtat(rs.getString("Etat"));
                f.setResponsable(rs.getString("Responsable"));
                f.setId_Bon_Transfert (rs.getLong("id_Bon_Transfert"));

                liste.add(f);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }


    public List<Bon_Transfert> Bon_Transfert_En_Cours() {

            List<Bon_Transfert> liste = new ArrayList<>();
            try {

                String query = "SELECT * FROM Bon_Transfert  WHERE etat Not like 'Archiver%'  ";
                Connection cnx = dataSource.getConnection() ;
                Statement stmt = cnx.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Bon_Transfert f = new Bon_Transfert();
                    f.setLocal_Destination (rs.getString("local_Destination"));
                    f.setLocal_Source (rs.getString("local_Source"));
                    f.setEtat(rs.getString("Etat"));
                    f.setResponsable(rs.getString("Responsable"));
                    f.setId_Bon_Transfert (rs.getLong("id_Bon_Transfert"));

                    liste.add(f);
                }
                stmt.close();
                cnx.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return liste;
    }

    public String Archiver_Bon_Transfert(Long id_bon) {
        Optional<Bon_Transfert> searchEntity =  Repo.findById(id_bon);
        Bon_Transfert p ;
        if (searchEntity.isPresent()) {
            p=searchEntity.get() ;
            p.setEtat ("Archiver") ;
            Repo.save(p);
            return "ok";
        } else {
            throw new EntityNotFoundException();
        }
    }
}


