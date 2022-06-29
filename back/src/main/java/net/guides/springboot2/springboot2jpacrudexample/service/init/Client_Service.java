package net.guides.springboot2.springboot2jpacrudexample.service.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Client;
import net.guides.springboot2.springboot2jpacrudexample.repository.init.Client_Repository;
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
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class Client_Service {

    @Autowired
    Client_Repository Repo;
    @Autowired
    DataSource dataSource;


    public List<Client> TousClients() {
        return (List<Client>) Repo.findAll();
    }

    public Optional<Client> Client(Long id) {
        return Repo.findById(id);
    }

   public Client Creer_Client(String nom_Client, String categorie_Fiscale, String contact, String adresse, String ville, String region, String pays, String email, String site_Web, String banque1, String banque2, String rib1, String rib2, String categorie_Client, boolean timbre_Fiscal, String representant, boolean bloque_Vente, double solde_Facture, double risque, double plafond, String code_Tva, String tel1, String tel2, String fax, String type_Piece_Identite,  String description, String n_Piece_Identite, Date date_Livraison_Identite, String n_Attestation_Exoneration, Date debut_Exoneration, Date fin_Exoneration, double reduction_Tva,  MultipartFile image) {

            try {
            Client dbFile = new Client ( nom_Client,   categorie_Fiscale,   contact,   adresse,  ville,   region,   pays,   email,   site_Web,   banque1,  banque2,   rib1,   rib2,   categorie_Client,   timbre_Fiscal,   representant,   description,   bloque_Vente,   solde_Facture,   risque,   plafond,   code_Tva,   tel1,   tel2,   fax,    type_Piece_Identite,   n_Piece_Identite,   date_Livraison_Identite ,   n_Attestation_Exoneration ,   debut_Exoneration ,   fin_Exoneration ,   reduction_Tva , image.getContentType(), image.getBytes() );
            return Repo.save(dbFile);
        } catch (IOException ex) {
                System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }


    public ResponseEntity<Object> Supprimer_Client(Long id ) {
        Optional<Client> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Client Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ() {

        return Repo.Lister_champs();
    }

    public List<Client> filtre(String champ, String valeur) {
         List<Client> liste = new ArrayList<>();
        try {
            String query = "select    Id_Clt as id_Clt ,  Nom_Client as Nom_Client ,     Categorie_Fiscale as categorie_Fiscale  ,\n" +
                    "        Contact as contact ,   Adresse as adresse ,  Ville as ville ,  Region as region ,   Pays as pays ,     Email as email ,\n" +
                    "        Site_Web as site_web ,Banque1 as banque1 ,  Banque2 as banque2 , Rib1 as rib1 ,   Rib2 as rib2 ,  Categorie_Client as categorie_Client , \n" +
                    "        Timbre_Fiscal  as timbre_Fiscale , Representant as representant , Description as description , Bloque_Vente as bloque_Vente , \n" +
                    "        Solde_Facture as solde_Facture ,  Risque as risque , Plafond as plafond , Code_Tva as code_Tva , Tel1 as tel1  ,  Tel2 as tel2 , \n" +
                    "        Fax as fax   ,Type_Piece_Identite as type_Piece_Identite ,  N_Piece_Identite as n_Piece_Identite ,\n" +
                    "        Date_Livraison_Identite as date_Livrision_Identite , N_Attestation_Exoneration as n_Attestation_Exoneration,Debut_Exoneration as debut_Exoneration ," +
                    "Fin_Exoneration as fin_Exoneration , Reduction_Tva as reduction_Tva  , Image_Type as image_Type ,   Image as image " +
                    "  from Client where " + champ + " like '" + valeur + "%'";


            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Client f = new Client();
                f.setId_Clt(rs.getLong("id_Clt"));
                f.setCategorie_Fiscale(rs.getString("categorie_Fiscale"));
                f.setType_Piece_Identite(rs.getString("type_Piece_Identite"));
                f.setNom_Client(rs.getString("Nom_Client"));
                f.setDate_Livraison_Identite(rs.getDate("date_Livrision_Identite"));
                f.setN_Piece_Identite(rs.getString("n_Piece_Identite"));
                f.setCategorie_Client(rs.getString("categorie_Client"));
                f.setSolde_Facture(rs.getDouble("solde_Facture"));
                f.setRisque(rs.getDouble("risque"));
                f.setBloque_Vente(rs.getBoolean("bloque_Vente"));
                f.setRib1(rs.getString("rib1"));
                f.setFax(rs.getString("fax"));
                f.setPlafond(rs.getDouble("plafond"));
                f.setDescription(rs.getString("description"));
                f.setTimbre_Fiscal(rs.getBoolean("timbre_Fiscale"));
                f.setTel1(rs.getString("tel1"));
                f.setDescription(rs.getString("description"));
                f.setRib2(rs.getString("rib2"));
                f.setBanque2(rs.getString("banque2"));
                f.setCode_Tva(rs.getString("code_Tva"));
                f.setRepresentant(rs.getString("representant"));
                f.setTel2(rs.getString("tel2"));
                f.setContact(rs.getString("contact"));
                f.setRegion(rs.getString("region"));
                f.setAdresse(rs.getString("adresse"));
                f.setVille(rs.getString("ville"));
                f.setPays(rs.getString("pays"));
                f.setEmail(rs.getString("email"));
                f.setSite_Web(rs.getString("site_web"));
                f.setBanque1(rs.getString("banque1"));
                f.setDate_Livraison_Identite(rs.getDate("date_Livrision_Identite"));
                f.setN_Attestation_Exoneration(rs.getString("n_Attestation_Exoneration"));
                f.setDebut_Exoneration(rs.getDate("debut_Exoneration"));
                f.setFin_Exoneration(rs.getDate("fin_Exoneration"));
                f.setImage_Type(rs.getString("image_Type"));
                f.setImage(rs.getBytes("image"));
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

    public Client image (Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }





    public Client Modifier_Client(Long id, String nom_client, String categorie_fiscale, String contact, String adresse, String ville, String region, String pays, String email, String site_web, String banque1, String banque2, String rib1, String rib2, String categorie_client, boolean timbre_fiscal, String tel1, String representant, boolean bloque_vente, double solde_facture, double risque, double plafond, String code_tva, String tel2, String faxe, String type_piece_identite, String description, String n_piece_identite, Date date_livraison_identite, String n_attestation_exoneration, Date debut_exoneration, Date fin_exoneration, double reduction_tva, MultipartFile image) {
        try {
            Client Entity = new Client ( nom_client,   categorie_fiscale,   contact,   adresse,  ville,   region,   pays,   email,   site_web,   banque1,  banque2,   rib1,   rib2,   categorie_client,   timbre_fiscal,   representant,   description,   bloque_vente,   solde_facture,   risque,   plafond,   code_tva,   tel1,   tel2,   faxe,    type_piece_identite ,   n_piece_identite ,   date_livraison_identite ,   n_attestation_exoneration ,   debut_exoneration ,   fin_exoneration ,   reduction_tva , image.getContentType(), image.getBytes() );

            Optional<Client> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Client p = searchEntity.get();
                p.setNom_Client(Entity.getNom_Client());
                p.setCategorie_Fiscale(Entity.getCategorie_Fiscale());
                p.setContact(Entity.getContact());
                p.setAdresse(Entity.getAdresse());
                p.setVille(Entity.getVille());
                p.setRegion(Entity.getRegion());
                p.setPays(Entity.getPays());
                p.setEmail(Entity.getEmail());
                p.setSite_Web(Entity.getSite_Web());
                p.setBanque1(Entity.getBanque1());
                p.setBanque2(Entity.getBanque2());
                p.setRib1(Entity.getRib1());
                p.setRib2(Entity.getRib2());
                p.setCategorie_Client(Entity.getCategorie_Client());
                p.setTimbre_Fiscal(Entity.isTimbre_Fiscal());
                p.setRepresentant(Entity.getRepresentant());
                p.setDescription(Entity.getDescription());
                p.setBloque_Vente(Entity.isBloque_Vente());
                p.setSolde_Facture(Entity.getSolde_Facture());
                p.setRisque(Entity.getRisque());
                p.setPlafond(Entity.getPlafond());
                p.setCode_Tva(Entity.getCode_Tva());
                p.setTel1(Entity.getTel1());
                p.setTel2(Entity.getTel2());
                p.setFax(Entity.getFax());
                p.setType_Piece_Identite(Entity.getType_Piece_Identite());
                p.setN_Piece_Identite(Entity.getN_Piece_Identite());
                p.setDate_Livraison_Identite(Entity.getDate_Livraison_Identite());
                p.setN_Attestation_Exoneration(Entity.getN_Attestation_Exoneration());
                p.setDebut_Exoneration(Entity.getDebut_Exoneration());
                p.setFin_Exoneration(Entity.getFin_Exoneration());
                p.setReduction_Tva(Entity.getReduction_Tva());
                p.setImage_Type(Entity.getImage_Type());
                p.setImage(Entity.getImage());
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


    public byte[] exporter (Long  Id) {
        Client f = Repo.getOne(Id);
        Element Clients = new Element("Clients");

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Element Client = new Element("Client");
            Element Id_Clt = new Element( "Id_Clt");Id_Clt.setText(f.getId_Clt()+"");
            Element Nom_Client = new Element( "Nom_Client");Nom_Client.setText(f.getNom_Client());
            Element Categorie_Fiscale = new Element( "Categorie_Fiscale");Categorie_Fiscale.setText(f.getCategorie_Fiscale());
            Element Contact = new Element( "Contact") ;Contact.setText(f.getContact());
            Element Adresse = new Element( "Adresse") ;Adresse.setText(f.getAdresse());
            Element Ville = new Element( "Ville")    ;Ville.setText(f.getVille());
            Element Region = new Element( "Region") ;Region.setText(f.getRegion());
            Element Pays = new Element( "Pays")  ;Pays.setText(f.getPays());
            Element Email = new Element("Email")  ;Email.setText(f.getEmail());
            Element Site_Web = new Element( "Site_Web")  ;Site_Web.setText(f.getSite_Web());
            Element Banque1 = new Element("Banque1");Banque1.setText(f.getBanque1());
            Element Banque2 = new Element( "Banque2") ;Banque2.setText(f.getBanque2());
            Element Rib1 = new Element("Rib1")  ;Rib1.setText(f.getRib1());
            Element Rib2 = new Element("Rib2")    ;Rib2.setText(f.getRib2());
            Element Categorie_Client = new Element("Categorie_Client")  ;Categorie_Client.setText(f.getCategorie_Client());
            Element Timbre_Fiscal = new Element( "TimbreFiscal") ;Timbre_Fiscal.setText(f.isTimbre_Fiscal()+"");
            Element Representant = new Element( "Representant");Representant.setText(f.getRepresentant());
            Element Description = new Element("Description") ;Description.setText(f.getDescription());
            Element Bloque_Vente = new Element( "Bloque_Vente") ; Bloque_Vente.setText(f.isBloque_Vente()+"");
            Element Solde_Facture = new Element("Solde_Facture");Solde_Facture.setText(f.getSolde_Facture()+"");
            Element Risque = new Element( "Risque") ;Risque.setText(f.getRisque()+"");
            Element Plafond = new Element( "Plafond") ;Plafond.setText(f.getPlafond()+"");
            Element Code_Tva = new Element( "Code_Tva")  ;Code_Tva.setText(f.getCode_Tva());
            Element Tel1 = new Element("Tel1")   ;Tel1.setText(f.getTel1());
            Element Tel2 = new Element( "Tel2") ;Tel2.setText(f.getTel2());
            Element Faxe = new Element( "Fax" ) ;Faxe.setText(f.getFax());
            Element Type_Piece_Identite = new Element( "Type_Piece_Identite")  ;Type_Piece_Identite.setText(f.getType_Piece_Identite());
            Element N_Piece_Identite = new Element( "N_Piece_Identite")  ;N_Piece_Identite.setText(f.getN_Piece_Identite());
            Element Date_Livraison_Identite = new Element("Date_Livraison_Identite");Date_Livraison_Identite.setText(dateFormat.format(f.getDate_Livraison_Identite())+"");
            Element N_Attestation_Exoneration = new Element("N_Attestation_Exoneration");N_Attestation_Exoneration.setText(f.getN_Attestation_Exoneration());
            Element Debut_Exoneration = new Element("Debut_Exoneration");Debut_Exoneration.setText(dateFormat.format(f.getDebut_Exoneration())+"");
            Element Fin_Exoneration = new Element( "Fin_Exoneration");Fin_Exoneration.setText(dateFormat.format(f.getFin_Exoneration())+"");
            Element Reduction_Tva = new Element( "Reduction_Tva");Reduction_Tva.setText(f.getReduction_Tva()+"");
            Element Image_Type = new Element( "Image_Type");Image_Type.setText(f.getImage_Type());
            Element Image = new Element("Image");Image.setText(f.getImage()+"");


            Client.addContent(Id_Clt  );
            Client.addContent( Nom_Client );
            Client.addContent(Categorie_Fiscale);
            Client.addContent(Contact  );
            Client.addContent(Adresse  );
            Client.addContent(Ville  );
            Client.addContent(Region  );
            Client.addContent(Pays  );
            Client.addContent(Email  );
            Client.addContent( Site_Web  );
            Client.addContent( Banque1 );
            Client.addContent( Banque2  );
            Client.addContent( Rib1  );
            Client.addContent( Rib2  );
            Client.addContent( Categorie_Client  );
            Client.addContent( Timbre_Fiscal  );
            Client.addContent( Representant  );
            Client.addContent( Description );
            Client.addContent( Bloque_Vente );
            Client.addContent(Solde_Facture  );
            Client.addContent(Risque );
            Client.addContent( Plafond  );
            Client.addContent(Code_Tva  );
            Client.addContent( Tel1    );
            Client.addContent( Tel2  );
            Client.addContent(Faxe  );
            Client.addContent( Type_Piece_Identite    );
            Client.addContent( N_Piece_Identite  );
            Client.addContent(Date_Livraison_Identite  );
            Client.addContent( N_Attestation_Exoneration  );
            Client.addContent( Debut_Exoneration  );
            Client.addContent(Fin_Exoneration  );
            Client.addContent( Reduction_Tva  );
            Client.addContent( Image_Type  );
            Client.addContent(Image  );

            Clients.addContent(Client  );

            Document document = new Document(Clients);
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

        Element Clients = new Element("Clients");
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            for ( int i = 0 ; i< liste.length; i++) {
                Client f = Repo.getOne( Long.parseLong(liste[i]));
                Element Client = new Element("Client");
                Element Id_Clt = new Element( "Id_Clt");Id_Clt.setText(f.getId_Clt()+"");
                Element Nom_Client = new Element( "Nom_Client");Nom_Client.setText(f.getNom_Client());
                Element Categorie_Fiscale = new Element( "Categorie_Fiscale");Categorie_Fiscale.setText(f.getCategorie_Fiscale());
                Element Contact = new Element( "Contact") ;Contact.setText(f.getContact());
                Element Adresse = new Element( "Adresse") ;Adresse.setText(f.getAdresse());
                Element Ville = new Element( "Ville")    ;Ville.setText(f.getVille());
                Element Region = new Element( "Region") ;Region.setText(f.getRegion());
                Element Pays = new Element( "Pays")  ;Pays.setText(f.getPays());
                Element Email = new Element("Email")  ;Email.setText(f.getEmail());
                Element Site_Web = new Element( "Site_Web")  ;Site_Web.setText(f.getSite_Web());
                Element Banque1 = new Element("Banque1");Banque1.setText(f.getBanque1());
                Element Banque2 = new Element( "Banque2") ;Banque2.setText(f.getBanque2());
                Element Rib1 = new Element("Rib1")  ;Rib1.setText(f.getRib1());
                Element Rib2 = new Element("Rib2")    ;Rib2.setText(f.getRib2());
                Element Categorie_Client = new Element("Categorie_Client")  ;Categorie_Client.setText(f.getCategorie_Client());
                Element Timbre_Fiscal = new Element( "TimbreFiscal") ;Timbre_Fiscal.setText(f.isTimbre_Fiscal()+"");
                Element Representant = new Element( "Representant");Representant.setText(f.getRepresentant());
                Element Description = new Element("Description") ;Description.setText(f.getDescription());
                Element Bloque_Vente = new Element( "Bloque_Vente") ; Bloque_Vente.setText(f.isBloque_Vente()+"");
                Element Solde_Facture = new Element("Solde_Facture");Solde_Facture.setText(f.getSolde_Facture()+"");
                Element Risque = new Element( "Risque") ;Risque.setText(f.getRisque()+"");
                Element Plafond = new Element( "Plafond") ;Plafond.setText(f.getPlafond()+"");
                Element Code_Tva = new Element( "Code_Tva")  ;Code_Tva.setText(f.getCode_Tva());
                Element Tel1 = new Element("Tel1")   ;Tel1.setText(f.getTel1());
                Element Tel2 = new Element( "Tel2") ;Tel2.setText(f.getTel2());
                Element Faxe = new Element( "Fax" ) ;Faxe.setText(f.getFax());
                Element Type_Piece_Identite = new Element( "Type_Piece_Identite")  ;Type_Piece_Identite.setText(f.getType_Piece_Identite());
                Element N_Piece_Identite = new Element( "N_Piece_Identite")  ;N_Piece_Identite.setText(f.getN_Piece_Identite());
                Element Date_Livraison_Identite = new Element("Date_Livraison_Identite");Date_Livraison_Identite.setText(dateFormat.format(f.getDate_Livraison_Identite())+"");
                Element N_Attestation_Exoneration = new Element("N_Attestation_Exoneration");N_Attestation_Exoneration.setText(f.getN_Attestation_Exoneration());
                Element Debut_Exoneration = new Element("Debut_Exoneration");Debut_Exoneration.setText(dateFormat.format(f.getDebut_Exoneration())+"");
                Element Fin_Exoneration = new Element( "Fin_Exoneration");Fin_Exoneration.setText(dateFormat.format(f.getFin_Exoneration())+"");
                Element Reduction_Tva = new Element( "Reduction_Tva");Reduction_Tva.setText(f.getReduction_Tva()+"");
                Element Image_Type = new Element( "Image_Type");Image_Type.setText(f.getImage_Type());
                Element Image = new Element("Image");Image.setText(f.getImage()+"");

                Client.addContent(Id_Clt  );
                Client.addContent( Nom_Client );
                Client.addContent(Categorie_Fiscale);
                Client.addContent(Contact  );
                Client.addContent(Adresse  );
                Client.addContent(Ville  );
                Client.addContent(Region  );
                Client.addContent(Pays  );
                Client.addContent(Email  );
                Client.addContent( Site_Web  );
                Client.addContent( Banque1 );
                Client.addContent( Banque2  );
                Client.addContent( Rib1  );
                Client.addContent( Rib2  );
                Client.addContent( Categorie_Client  );
                Client.addContent( Timbre_Fiscal  );
                Client.addContent( Representant  );
                Client.addContent( Description );
                Client.addContent( Bloque_Vente );
                Client.addContent(Solde_Facture  );
                Client.addContent(Risque );
                Client.addContent( Plafond  );
                Client.addContent(Code_Tva  );
                Client.addContent( Tel1    );
                Client.addContent( Tel2  );
                Client.addContent(Faxe  );
                Client.addContent( Type_Piece_Identite    );
                Client.addContent( N_Piece_Identite  );
                Client.addContent(Date_Livraison_Identite  );
                Client.addContent( N_Attestation_Exoneration  );
                Client.addContent( Debut_Exoneration  );
                Client.addContent(Fin_Exoneration  );
                Client.addContent( Reduction_Tva  );
                Client.addContent( Image_Type  );
                Client.addContent(Image  );

                Clients.addContent(Client);
            }

            Document document = new Document(Clients);
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
            Client fr = new Client();
         //   fr.setId_Clt(Long.parseLong(l.get(0).getValue()));
            fr.setNom_Client(l.get(1).getValue());
            fr.setCategorie_Fiscale(l.get(2).getValue());
            fr.setContact(l.get(3).getValue());
            fr.setAdresse(l.get(4).getValue());
            fr.setVille(l.get(5).getValue());
            fr.setRegion(l.get(6).getValue());
            fr.setPays(l.get(7).getValue());
            fr.setEmail(l.get(8).getValue());
            fr.setSite_Web(l.get(9).getValue());
            fr.setBanque1(l.get(10).getValue());
            fr.setBanque2(l.get(11).getValue());
            fr.setRib1(l.get(12).getValue());
            fr.setRib2(l.get(13).getValue());
            fr.setCategorie_Client(l.get(14).getValue());
            if(l.get(15).getValue().equals("true")){fr.setTimbre_Fiscal(true);}else{fr.setTimbre_Fiscal(false);}
            fr.setRepresentant(l.get(16).getValue());
            fr.setDescription(l.get(17).getValue());
            if(l.get(18).getValue().equals("true")){fr.setBloque_Vente(true);}else{fr.setBloque_Vente(false);}
            fr.setSolde_Facture(Double.parseDouble(l.get(19).getValue()));
            fr.setRisque(Double.parseDouble(l.get(20).getValue()));
            fr.setPlafond(Double.parseDouble(l.get(21).getValue()));
            fr.setCode_Tva(l.get(22).getValue());
            fr.setTel1(l.get(23).getValue());
            fr.setTel2(l.get(24).getValue());
            fr.setFax(l.get(25).getValue());
            fr.setType_Piece_Identite(l.get(26).getValue());
            fr.setN_Piece_Identite(l.get(27).getValue());

            try {
                DateFormat format = new SimpleDateFormat("yyyy/MM/dd" );
                Date date1 = format.parse(l.get(28).getValue());
                Date date2 = format.parse(l.get(30).getValue());
                Date date3 = format.parse(l.get(31).getValue());
                fr.setDate_Livraison_Identite(date1);
                fr.setDebut_Exoneration(date2);
                fr.setFin_Exoneration(date3);
            } catch ( Exception e) {
                e.printStackTrace();
            }
            fr.setN_Attestation_Exoneration(l.get(29).getValue());
            fr.setReduction_Tva(Double.parseDouble(l.get(32).getValue()));

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
