package net.guides.springboot2.springboot2jpacrudexample.service.transaction;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Fiche_BEI;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Produit;
import net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Retour;
import net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Transfert;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Quantite_Fiche_Technique;
import net.guides.springboot2.springboot2jpacrudexample.repository.init.Fiche_Produit_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.transaction.Bon_Retour_Repository;
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
import java.util.List;
import java.util.Optional;

@Service
public class Bon_retour_Service {

    @Autowired
    Bon_Retour_Repository Repo;
    @Autowired
    DataSource dataSource;

    @Autowired
    Fiche_Produit_Repository Repo_produit ;

    public List<Bon_Retour> Bon_Retours() {
        return (List<Bon_Retour>)  Repo.findAll();
    }
    public Optional<Bon_Retour> Bon_Retour(Long id ) {
        return   Repo.findById(id );
    }

    public Bon_Retour Creer_Bon_Retour ( String id_clt, String n_Facture,  String description, String local, String id_Responsable  ,   MultipartFile detail )
    {
        try {
            Bon_Retour dbFile = new Bon_Retour (      id_clt,   n_Facture,     description,   local,   id_Responsable  ,   detail.getContentType(),  detail.getBytes() ) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }


    public ResponseEntity<Object> Supprimer_Bon_Retour(Long id ) {
        Optional<Bon_Retour> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Bon_Retour Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }

    public List<Quantite_Fiche_Technique> Quantite_Fiche_Technique(Long id) {
        ArrayList<Quantite_Fiche_Technique> liste = new ArrayList<>();
        Optional<Bon_Retour> bl = Repo.findById(id);
        Bon_Retour p = bl.get();
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
                    System.out.println(e);
                    liste.add(e);
                }
            }
        }

        return liste ;
    }
    public Bon_Retour Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public List<Bon_Retour> filtre(String champ1, String valeur1, String champ2, String valeur2, String champ3, String valeur3,String champ4, String valeur4) {
        List<Bon_Retour> liste = new ArrayList<>();
        try {

            String query = "SELECT * FROM Bon_Retour WHERE " + champ1 + " like '" + valeur1 + "%' AND "  + champ2 + " like '" + valeur2 + "%' AND "  + champ3 + " like '" + valeur3 + "%' AND "+ champ4 + " like '" + valeur4 + "%'" ;

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Retour f = new Bon_Retour();

                f.setEtat(rs.getString("Etat"));
                f.setId_Bon_Retour(rs.getLong("Id_Bon_Retour"));
                f.setDescription(rs.getString("Description"));
                f.setId_Clt(rs.getString("Id_Clt"));
                f.setId_Responsable(rs.getString("Id_Responsable"));
                f.setLocal(rs.getString("Local"));
                f.setN_Facture(rs.getString("N_Facture"));

                liste.add(f);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }

    public List<Bon_Retour> Bon_Retour_En_Cours() {
        List<Bon_Retour> liste = new ArrayList<>();
        try {

            String query = "SELECT * FROM Bon_Retour  WHERE etat Not like 'Archiver%'  ";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Retour f = new Bon_Retour();
                f.setEtat(rs.getString("Etat"));
                f.setId_Bon_Retour(rs.getLong("Id_Bon_Retour"));
                f.setDescription(rs.getString("Description"));
                f.setId_Clt(rs.getString("Id_Clt"));
                f.setId_Responsable(rs.getString("Id_Responsable"));
                f.setLocal(rs.getString("Local"));
                f.setN_Facture(rs.getString("N_Facture"));

                liste.add(f);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }

    public String Archiver_Bon_Retour(Long id_bon) {
        Optional<Bon_Retour> searchEntity =  Repo.findById(id_bon);
        Bon_Retour p ;
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
