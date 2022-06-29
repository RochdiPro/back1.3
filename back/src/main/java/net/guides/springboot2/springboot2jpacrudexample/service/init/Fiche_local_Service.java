package net.guides.springboot2.springboot2jpacrudexample.service.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Client;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Local;
import net.guides.springboot2.springboot2jpacrudexample.repository.init.Fiche_Local_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.Stock.Stock_Repositrory;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.FileStorageException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
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
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
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
public class Fiche_local_Service {
    @Autowired
    Fiche_Local_Repository Repo;

    @Autowired
    Stock_Repositrory Repo2;

    @Autowired
    DataSource dataSource;
    public List<Fiche_Local> Locals() {
        return (List<Fiche_Local>)  Repo.findAll();
    }
    public Optional<Fiche_Local> Local(Long id_Local) {
        return   Repo.findById(id_Local);
    }

    public Fiche_Local Creer_Local(String nom_Local, String categorie_Local, String description_Local, double largeur, double profondeur, double hauteur, String adresse, String responsable, String tel, String fax, String email, String nature_Contrat, Date date_Debut, Date date_Fin, double frais, String nature_Frais, double latitude, double longitude, Double surface,  MultipartFile detail )
    {
        try {
            Fiche_Local dbFile = new Fiche_Local(nom_Local, categorie_Local, description_Local, largeur, profondeur, hauteur, adresse, responsable, tel, fax, email, nature_Contrat, date_Debut, date_Fin, frais, nature_Frais, latitude, longitude, surface, detail.getContentType(), detail.getBytes()) ;
            Ajouter_local(nom_Local);
            return Repo.save(dbFile);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
            }
        }


       public Fiche_Local Modifier_Local( Long id , String nom_Local, String categorie_Local, String description_Local, double largeur, double profondeur, double hauteur, String adresse, String responsable, String tel, String fax, String email, String nature_Contrat, Date date_Debut, Date date_Fin, double frais, String nature_Frais, double latitude, double longitude,double surface,   MultipartFile detail)
        {
            try {
                Fiche_Local Entity = new Fiche_Local(nom_Local, categorie_Local, description_Local, largeur, profondeur, hauteur, adresse, responsable, tel, fax, email, nature_Contrat, date_Debut, date_Fin, frais, nature_Frais, latitude, longitude,surface ,detail.getContentType(), detail.getBytes()) ;

                Optional<Fiche_Local> searchEntity = Repo.findById(id);
                if (searchEntity.isPresent()) {
                    Fiche_Local p = searchEntity.get();
                    p.setNom_Local ((Entity.getNom_Local()));
                    p.setCategorie_Local (Entity.getCategorie_Local());
                    p.setDescription_Local (Entity.getDescription_Local());
                    p.setLargeur (Entity.getLargeur());
                    p.setProfondeur (Entity.getProfondeur());
                    p.setHauteur (Entity.getHauteur());
                    p.setAdresse (Entity.getAdresse());
                    p.setResponsable (Entity.getResponsable());
                    p.setTel (Entity.getTel());
                    p.setFax (Entity.getFax());
                    p.setEmail (Entity.getEmail());
                    p.setNature_Contrat (Entity.getNature_Contrat());
                    p.setDate_Debut (Entity.getDate_Debut());
                    p.setDate_Fin (Entity.getDate_Fin());
                    p.setFrais (Entity.getFrais());
                    p.setNature_Frais (Entity.getNature_Frais());
                    p.setLatitude (Entity.getLatitude());
                    p.setLongitude (Entity.getLongitude());
                    p.setSurface(Entity.getSurface());
                    p.setDetail_Type (Entity.getDetail_Type());
                    p.setDetail (Entity.getDetail());
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




    public ResponseEntity<Object> Supprimer_Local(Long id_Local) {
        Optional<Fiche_Local>  Entity =  Repo.findById(id_Local);
        if (Entity.isPresent()) {
            Fiche_Local Entity_deleted = Entity.get();
         //   Supprimer_local (Entity.getNom_Local());
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }

    public  List<Fiche_Local>  filtre (   String champ , String valeur ) {
        List<Fiche_Local> liste = new ArrayList<>();
        try {
            String query = "select Id_Local as id_Local,  Nom_Local as nom_Local, Categorie_Local as categorie_Local,  Description_Local as description_Local  from fiche_local where "+champ+" like '" + valeur + "%'";
            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Fiche_Local d = new Fiche_Local();

                d.setId_Local(Long.valueOf(rs.getString("id_Local")));
                d.setNom_Local(rs.getString("nom_Local"));
                d.setCategorie_Local(rs.getString("categorie_Local"));
                d.setDescription_Local(rs.getString("description_Local"));
                liste.add(d);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return liste ;
    }

    void Ajouter_local (String nom )
    {
        try {
             Statement stmt = dataSource.getConnection().createStatement();
            String sql = "ALTER TABLE STOCK ADD " + nom + " int  ";
            stmt.executeUpdate(sql );
            System.out.println("bien .");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    void Supprimer_local (String nom)
    {
        try {
            Statement stmt = dataSource.getConnection().createStatement();
            String sql = "ALTER TABLE STOCK DROP COLUMN " + nom + "  ";
            stmt.executeUpdate(sql );
            System.out.println("bien .");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public byte[] exporter (Long  Id) {

        Fiche_Local f = Repo.getOne(Id);
        Element locals = new Element("locals");
        try {
            Element local = new Element("local");
            Element Id_Local = new Element( "Id_Local");Id_Local.setText(f.getId_Local()+"");
            Element Nom_Local = new Element( "Nom_Local");Nom_Local.setText(f.getNom_Local());
            Element Categorie_Local = new Element( "Categorie_Fiscale");Categorie_Local.setText(f.getCategorie_Local());
            Element Description_Local = new Element( "Contact") ;Description_Local.setText(f.getDescription_Local());

            local.addContent(Id_Local  );
            local.addContent( Nom_Local  );
            local.addContent(Categorie_Local);
            local.addContent(Description_Local  );

            locals.addContent(local);
            Document document = new Document(locals);
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            sortie.output(document, bout);
            return bout.toByteArray();


        } catch (FileNotFoundException e) {
            e.printStackTrace();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
        // .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public byte[] exporters (  String  liste1) {

        String[] liste = liste1.split("/");

        Element locals = new Element("locals");


        for ( int i = 0 ; i< liste.length; i++) {

            Fiche_Local f = Repo.getOne( Long.parseLong(liste[i]));
            Element local = new Element("local");
            Element Id_Local = new Element("Id_Local"); Id_Local.setText(f.getId_Local() + "");
            Element Nom_Local = new Element("Nom_Local"); Nom_Local.setText(f.getNom_Local());
            Element Categorie_Local = new Element( "Categorie_Fiscale");Categorie_Local.setText(f.getCategorie_Local());
            Element Description_Local = new Element( "Contact") ;Description_Local.setText(f.getDescription_Local());

            local.addContent(Id_Local  );
            local.addContent( Nom_Local  );
            local.addContent(Categorie_Local);
            local.addContent(Description_Local  );

            locals.addContent(local);
        }
        try {
            Document document = new Document(locals);
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            sortie.output(document, bout);
            return bout.toByteArray();


        } catch (FileNotFoundException e) {
            e.printStackTrace();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
     }


    public String Importers ( MultipartFile file   )
    {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;

        try {
            document = saxBuilder.build(file.getInputStream());
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        List<Element> be = DataSets.getChildren();

        for (Element four : be) {

            List<Element> l = four.getChildren();
            Fiche_Local fr = new Fiche_Local();
            // fr.setId_Local(Long.parseLong(l.get(0).getValue()));
            fr.setNom_Local(l.get(1).getValue());
            fr.setCategorie_Local(l.get(2).getValue());
            fr.setDescription_Local( l.get(3).getValue());
            Repo.save(fr);
        }
        return  "ok";
    }

}
