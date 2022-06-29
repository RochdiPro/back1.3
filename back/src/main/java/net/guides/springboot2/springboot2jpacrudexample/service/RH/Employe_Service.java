package net.guides.springboot2.springboot2jpacrudexample.service.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Client;
import net.guides.springboot2.springboot2jpacrudexample.repository.RH.Employe_Repository;
 import net.guides.springboot2.springboot2jpacrudexample.service.Achat.FileStorageException;
import net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException;
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
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class Employe_Service {


    @Autowired
    Employe_Repository Repo;
    @Autowired
    DataSource dataSource;

    public List<Employe> TousEmployes() {
        return (List< Employe>) Repo.findAll();
    }

    public Optional<Employe>  Employe(Long id) {
        return Repo.findById(id);
    }

    public  Employe Creer_Employe(String role, int acces, String nom,   Date date_de_naissance,Date date_de_embauche ,String banque, String rib, String tel, String pays, String ville, String email, String adresse,String type_Piece_Identite, String n_Piece_Identite, Date date_Piece_Identite, String description, MultipartFile image ,String cnss , String situation_Familiale , int enfant_A_Charge ,   Date date_de_Permis , String permis , String categorie_Permis , String local) {

        try {
            Employe dbFile = new Employe (   role,   acces,   nom,     date_de_naissance,  date_de_embauche ,  banque,   rib,   tel,    pays,   ville,   email, adresse,  type_Piece_Identite,   n_Piece_Identite,  date_Piece_Identite , description,    image.getContentType() , image.getBytes(),cnss ,situation_Familiale , enfant_A_Charge ,   date_de_Permis ,   permis ,   categorie_Permis,  local) ;
                return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    public Employe  Modifier_Employe(Long id ,String role, int acces, String nom,   Date date_de_naissance,Date date_de_embauche ,String banque, String rib, String tel, String pays, String ville, String email, String adresse,String type_Piece_Identite, String n_Piece_Identite, Date date_Piece_Identite, String description, MultipartFile image ,String cnss , String situation_Familiale , int enfant_A_Charge ,  Date date_de_Permis , String permis , String categorie_Permis,String local) {

        try {
            Employe Entity = new Employe (   role,   acces,   nom,      date_de_naissance,  date_de_embauche ,  banque,   rib,   tel,    pays,   ville,   email, adresse,  type_Piece_Identite,   n_Piece_Identite,  date_Piece_Identite , description,    image.getContentType() , image.getBytes(),cnss ,situation_Familiale ,enfant_A_Charge ,   date_de_Permis ,   permis ,   categorie_Permis,  local) ;

            Optional<Employe> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Employe p = searchEntity.get();
                p.setRole(Entity.getRole());
                p.setAcces  (Entity.getAcces());
                p.setNom   (Entity.getNom());
                p.setDate_de_naissance  (Entity.getDate_de_naissance());
                p.setDate_de_embauche   (Entity.getDate_de_embauche());
                p.setBanque (Entity.getBanque());
                p.setRib (Entity.getRib());
                p.setTel (Entity.getTel());
                p.setDescription (Entity.getDescription());
                p.setType_Piece_Identite(Entity.getType_Piece_Identite());
                p.setN_Piece_Identite(Entity.getN_Piece_Identite());
                p.setImage_Type(Entity.getImage_Type());
                p.setImage(Entity.getImage());
                p.setPays(Entity.getPays());
                p.setVille(Entity.getVille());
                p.setAdresse(Entity.getAdresse());
                p.setDate_Piece_Identite(Entity.getDate_Piece_Identite());
                p.setEmail(Entity.getEmail());
                p.setCnss(Entity.getCnss());
                p.setSituation_Familiale(Entity.getSituation_Familiale());
                p.setEnfant_A_Charge(Entity.getEnfant_A_Charge());
                p.setLocal(Entity.getLocal());
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
    public ResponseEntity<Object> Supprimer_Employe(Long id ) {
        Optional< Employe> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Employe Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ() {

        return Repo.Lister_champs();
    }


    public  Employe image (Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public List<Employe> filtre(String champ, String valeur) {


        List<Employe> liste = new ArrayList<>();
        try {
            String query = "select Id_Employe as id_Employe ,Role as role , Acces as acces ,  Nom as nom, Date_de_naissance as  date_de_naissance," +
                    " Date_de_embauche as date_de_embauche ,   Date_Piece_Identite as date_Piece_Identite ,  Banque as banque," +
                    "          Rib as rib,     Tel as tel,    Pays as pays,   Ville as ville,    Email as email,   Adresse as adresse," +
                    "           Type_Piece_Identite as type_Piece_Identite,  N_Piece_Identite as n_Piece_Identite,   Description as description," +
                    "           Image_Type as image_Type,  Image as image ,     Permis as permis ,    Categorie_Permis as categorie_Permis ,  Date_de_Permis as date_de_permis" +
                    "           from employe  where " + champ + " like '" + valeur + "%'";


            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Employe f = new Employe();
                f.setId_Employe (rs.getLong("id_Employe"));
                f.setRole  (rs.getString("role"));
                f.setAcces  (rs.getInt("acces"));
                f.setNom  (rs.getString("nom"));
                f.setDate_de_naissance  (rs.getDate("date_de_naissance"));
                f.setDate_de_embauche  (rs.getDate("date_de_embauche"));
                f.setDate_Piece_Identite  (rs.getDate("date_Piece_Identite"));
                f.setBanque  (rs.getString("banque"));
                f.setRib  (rs.getString("rib"));
                f.setTel  (rs.getString("tel"));
                f.setPays  (rs.getString("pays"));
                f.setVille  (rs.getString("ville"));
                f.setEmail  (rs.getString("email"));
                f.setAdresse  (rs.getString("adresse"));
                f.setType_Piece_Identite  (rs.getString("type_Piece_Identite"));
                f.setN_Piece_Identite  (rs.getString("n_Piece_Identite"));
                f.setImage_Type(rs.getString("image_Type"));
                f.setImage(rs.getBytes("image"));
                f.setPermis(rs.getString("permis"));
                f.setCategorie_Permis(rs.getString("categorie_Permis"));
                f.setDate_de_Permis(rs.getDate("date_de_permis"));
                liste.add(f);

            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());

            throwables.printStackTrace();
        }
        return liste;
    }


    public byte[] exporter (Long  Id) {
        Employe f = Repo.getOne(Id);
        Element Employes = new Element("Employes");

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Element Employe = new Element("Employe");
            Element id = new Element("Id");id.setText(f.getId_Employe()+"");
            Element Role = new Element( "Role");Role.setText(f.getRole()+"");
            Element Acces = new Element( "Acces");Acces.setText(f.getAcces()+"");
            Element Nom = new Element( "Nom");Nom.setText(f.getNom()+"");

            Element Date_de_naissance = new Element( "Date_de_naissance");Date_de_naissance.setText(dateFormat.format(f.getDate_de_naissance())+"");
            Element Date_de_embauche = new Element( "Date_de_embauche");Date_de_embauche.setText(dateFormat.format(f.getDate_de_embauche())+"");
            Element Date_Piece_Identite = new Element( "Date_Piece_Identite");Date_Piece_Identite.setText(dateFormat.format(f.getDate_Piece_Identite())+"");
            Element Date_de_Permis = new Element( "Date_de_Permis");Date_de_Permis.setText(dateFormat.format(f.getDate_de_Permis())+"");

            Element Banque = new Element( "Banque");Banque.setText(f.getBanque()+"");
            Element Rib = new Element( "Rib");Rib.setText(f.getRib()+"");
            Element Tel = new Element( "Tel");Tel.setText(f.getTel()+"");
            Element Pays = new Element( "Pays");Pays.setText(f.getPays()+"");
            Element Ville = new Element( "Ville");Ville.setText(f.getVille()+"");
            Element Email = new Element( "Email");Email.setText(f.getEmail()+"");
            Element Adresse = new Element( "Adresse");Adresse.setText(f.getAdresse()+"");
            Element Type_Piece_Identite = new Element( "Type_Piece_Identite");Type_Piece_Identite.setText(f.getType_Piece_Identite()+"");
            Element N_Piece_Identite = new Element( "N_Piece_Identite");N_Piece_Identite.setText(f.getN_Piece_Identite()+"");
            Element Description = new Element( "Description");Description.setText(f.getDescription()+"");
            Element Image_Type = new Element( "Image_Type");Image_Type.setText(f.getImage_Type()+"");
            Element Image = new Element( "Image");Image.setText(f.getImage()+"");
            Element Cnss = new Element( "Cnss");Cnss.setText(f.getCnss()+"");
            Element Situation_Familiale = new Element( "Situation_Familiale");Situation_Familiale.setText(f.getSituation_Familiale()+"");
            Element Enfant_A_Charge = new Element( "Enfant_A_Charge");Enfant_A_Charge.setText(f.getEnfant_A_Charge()+"");
            Element Permis = new Element( "Permis");Permis.setText(f.getPermis()+"");
            Element Categorie_Permis  = new Element( "Categorie_Permis");Categorie_Permis.setText(f.getCategorie_Permis()+"");




            Employe.addContent(  id );
            Employe.addContent(  Role );
            Employe .addContent( Acces );
            Employe .addContent( Nom );

            Employe .addContent( Date_de_naissance );
            Employe .addContent( Date_de_embauche );
            Employe .addContent( Date_Piece_Identite );
            Employe .addContent( Date_de_Permis  );

            Employe .addContent( Banque );
            Employe.addContent(  Rib );
            Employe .addContent( Tel );
            Employe.addContent(  Pays );
            Employe .addContent( Ville );
            Employe .addContent( Email );
            Employe.addContent(  Adresse );
            Employe.addContent(  Type_Piece_Identite );
            Employe .addContent( N_Piece_Identite);
            Employe .addContent( Description );
            Employe .addContent( Image_Type );
            Employe .addContent( Image );
            Employe.addContent(  Cnss );
            Employe.addContent(  Situation_Familiale);
            Employe.addContent(  Enfant_A_Charge );
            Employe .addContent( Permis );
            Employe .addContent( Categorie_Permis  );
            Employes.addContent(Employe  );

            Document document = new Document(Employes);
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

        Element Employes = new Element("Employes");

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            for ( int i = 0 ; i< liste.length; i++) {

                Employe f = Repo.getOne( Long.parseLong(liste[i]));
                Element Employe = new Element("Employe");
                Element id = new Element("Id");id.setText(f.getId_Employe()+"");
                Element Role = new Element( "Role");Role.setText(f.getRole()+"");
                Element Acces = new Element( "Acces");Acces.setText(f.getAcces()+"");
                Element Nom = new Element( "Nom");Nom.setText(f.getNom()+"");

                Element Date_de_naissance = new Element( "Date_de_naissance");Date_de_naissance.setText(dateFormat.format(f.getDate_de_naissance())+"");
                Element Date_de_embauche = new Element( "Date_de_embauche");Date_de_embauche.setText(dateFormat.format(f.getDate_de_embauche())+"");
                Element Date_Piece_Identite = new Element( "Date_Piece_Identite");Date_Piece_Identite.setText(dateFormat.format(f.getDate_Piece_Identite())+"");
                Element Date_de_Permis = new Element( "Date_de_Permis");Date_de_Permis.setText(dateFormat.format(f.getDate_de_Permis())+"");

                Element Banque = new Element( "Banque");Banque.setText(f.getBanque()+"");
                Element Rib = new Element( "Rib");Rib.setText(f.getRib()+"");
                Element Tel = new Element( "Tel");Tel.setText(f.getTel()+"");
                Element Pays = new Element( "Pays");Pays.setText(f.getPays()+"");
                Element Ville = new Element( "Ville");Ville.setText(f.getVille()+"");
                Element Email = new Element( "Email");Email.setText(f.getEmail()+"");
                Element Adresse = new Element( "Adresse");Adresse.setText(f.getAdresse()+"");
                Element Type_Piece_Identite = new Element( "Type_Piece_Identite");Type_Piece_Identite.setText(f.getType_Piece_Identite()+"");
                Element N_Piece_Identite = new Element( "N_Piece_Identite");N_Piece_Identite.setText(f.getN_Piece_Identite()+"");
                Element Description = new Element( "Description");Description.setText(f.getDescription()+"");
                Element Image_Type = new Element( "Image_Type");Image_Type.setText(f.getImage_Type()+"");
                Element Image = new Element( "Image");Image.setText(f.getImage()+"");
                Element Cnss = new Element( "Cnss");Cnss.setText(f.getCnss()+"");
                Element Situation_Familiale = new Element( "Situation_Familiale");Situation_Familiale.setText(f.getSituation_Familiale()+"");
                Element Enfant_A_Charge = new Element( "Enfant_A_Charge");Enfant_A_Charge.setText(f.getEnfant_A_Charge()+"");
                Element Permis = new Element( "Permis");Permis.setText(f.getPermis()+"");
                Element Categorie_Permis  = new Element( "Categorie_Permis");Categorie_Permis.setText(f.getCategorie_Permis()+"");


                Employe.addContent(  id );
                Employe.addContent(  Role );
                Employe .addContent( Acces );
                Employe .addContent( Nom );

                Employe .addContent( Date_de_naissance );
                Employe .addContent( Date_de_embauche );
                Employe .addContent( Date_Piece_Identite );
                Employe .addContent( Date_de_Permis  );

                Employe .addContent( Banque );
                Employe.addContent(  Rib );
                Employe .addContent( Tel );
                Employe.addContent(  Pays );
                Employe .addContent( Ville );
                Employe .addContent( Email );
                Employe.addContent(  Adresse );
                Employe.addContent(  Type_Piece_Identite );
                Employe .addContent( N_Piece_Identite);
                Employe .addContent( Description );
                Employe .addContent( Image_Type );
                Employe .addContent( Image );
                Employe.addContent(  Cnss );
                Employe.addContent(  Situation_Familiale);
                Employe.addContent(  Enfant_A_Charge );
                Employe .addContent( Permis );
                Employe .addContent( Categorie_Permis  );

                Employes.addContent(Employe);
            }

            Document document = new Document(Employes);
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
            Employe fr = new Employe();

            //   fr.setId_Clt(Long.parseLong(l.get(0).getValue()));
            fr.setRole(l.get(1).getValue());
            fr.setAcces(Integer.parseInt(l.get(2).getValue()));
            fr.setNom(l.get(3).getValue());
            fr.setAdresse(l.get(4).getValue());
            fr.setVille(l.get(5).getValue());
            fr.setPays(l.get(7).getValue());
            fr.setBanque(l.get(8).getValue());
            fr.setRib(l.get(9).getValue());
            fr.setTel(l.get(10).getValue());
            fr.setPays(l.get(11).getValue());
            fr.setVille(l.get(12).getValue());
            fr.setEmail(l.get(13).getValue());
            fr.setAdresse(l.get(14).getValue());
            fr.setType_Piece_Identite( (l.get(15).getValue()));
            fr.setN_Piece_Identite(  (l.get(16).getValue()));
            fr.setDescription(  (l.get(17).getValue()));
            fr.setImage_Type( (l.get(18).getValue()));
            fr.setCnss(l.get(20).getValue());
            fr.setSituation_Familiale(l.get(21).getValue());
            fr.setEnfant_A_Charge(Integer.parseInt(l.get(22).getValue()));
            fr.setPermis(l.get(23).getValue());
            fr.setCategorie_Permis(l.get(24).getValue());

            try {
                DateFormat format = new SimpleDateFormat("yyyy/MM/dd" );
                Date date1 = format.parse(l.get(4).getValue());
                Date date2 = format.parse(l.get(5).getValue());
                Date date3 = format.parse(l.get(6).getValue());
                Date date4 = format.parse(l.get(7).getValue());
                fr.setDate_de_naissance(date1);
                fr.setDate_de_embauche(date2);
                fr.setDate_Piece_Identite(date3);
                fr.setDate_de_Permis(date4);
            } catch ( Exception e) {
                e.printStackTrace();
            }
            try {
                File file1 = new File("./src/vide.jpg");
                fr.setImage(readContentIntoByteArray(file1));
                fr.setImage_Type("image/jpeg");
            } catch (Exception e) {
            }
            Repo.save(fr);
        }
        return  "ok";
    }


    private static byte[] readContentIntoByteArray(File file)
    {
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int) file.length()];
        try
        {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            for (int i = 0; i < bFile.length; i++)
            {
                //  System.out.print((char) bFile[i]);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bFile;
    }

}
