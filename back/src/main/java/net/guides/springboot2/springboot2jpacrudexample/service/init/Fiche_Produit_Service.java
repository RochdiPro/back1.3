package net.guides.springboot2.springboot2jpacrudexample.service.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Produit;
import net.guides.springboot2.springboot2jpacrudexample.repository.init.Fiche_Produit_Repository;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Fiche_Produit_Service {

    @Autowired
    Fiche_Produit_Repository Repo;

    @Autowired
    DataSource dataSource;

    public Fiche_Produit Create_Fiche_Produit(String code_barre, String source, String nom_produit, String type1, String type2, String famille, String sous_famille, String unite, double valeur_unite, String ngp, String caracteristique_technique, String marque, String pays, String ville, String n_imei, String n_imei2, double temperature_max, double temperature_min, String n_Lot, Date date_fabrication, Date date_validite, String saison, String region, String n_serie, String couleur, String taille, String role, double tva, String fodec, String contentType, String contentType1, String contentType2, MultipartFile image, MultipartFile certificat, MultipartFile rfid) {
        try {
            Fiche_Produit dbFile = new Fiche_Produit(code_barre, source, nom_produit, type1, type2, famille, sous_famille, unite, valeur_unite, ngp, caracteristique_technique, marque, pays, ville, n_imei, n_imei2, temperature_max, temperature_min, n_Lot, date_fabrication, date_validite, saison, region, n_serie, couleur, taille, role, tva, fodec, image.getContentType(), certificat.getContentType(), rfid.getContentType(), image.getBytes(), certificat.getBytes(), rfid.getBytes());
            return Repo.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("impossible d'enregistrer le fichier  " + nom_produit + "  ! ", ex);
        }
    }

    public Fiche_Produit Modifier_Fiche_Produit(Long id, String code_barre, String source, String nom_produit, String type1, String type2, String famille, String sous_famille, String unite, double valeur_unite, String ngp, String caracteristique_technique, String marque, String pays, String ville, String n_imei, String n_imei2, double temperature_max, double temperature_min, String n_Lot, Date date_fabrication, Date date_validite, String saison, String region, String n_serie, String couleur, String taille, String role, double tva, String fodec, String contentType, String contentType1, String contentType2, MultipartFile image, MultipartFile certificat, MultipartFile rfid) {
        try {
            Fiche_Produit  Entity = new Fiche_Produit(code_barre, source, nom_produit, type1, type2, famille, sous_famille, unite, valeur_unite, ngp, caracteristique_technique, marque, pays, ville, n_imei, n_imei2, temperature_max, temperature_min, n_Lot, date_fabrication, date_validite, saison, region, n_serie, couleur, taille, role, tva, fodec, image.getContentType(), certificat.getContentType(), rfid.getContentType(), image.getBytes(), certificat.getBytes(), rfid.getBytes());

            Optional<Fiche_Produit> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Fiche_Produit p = searchEntity.get();
                p.setNom_Produit(Entity.getNom_Produit());
                p.setFamille(Entity.getFamille());
                p.setSource(Entity.getSource());
                p.setType1(Entity.getType1());
                p.setType2(Entity.getType2());
                p.setUnite(Entity.getUnite());
                p.setValeur_Unite(Entity.getValeur_Unite());
                p.setNgp(Entity.getNgp());
                p.setRfid(Entity.getRfid());
                p.setCaracteristique_Technique(Entity.getCaracteristique_Technique());
                p.setMarque(Entity.getMarque());
                p.setFamille(Entity.getFamille());
                p.setSous_Famille(Entity.getSous_Famille());
                p.setImage(Entity.getImage());
                p.setPays(Entity.getPays());
                p.setVille(Entity.getVille());
                p.setCouleur(Entity.getCouleur());
                p.setN_Serie(Entity.getN_Serie());
                p.setTaille(Entity.getTaille());
                p.setCode_Barre(Entity.getCode_Barre());
                p.setTemperature_Max(Entity.getTemperature_Max());
                p.setTemperature_Min(Entity.getTemperature_Min());
                p.setRegion(Entity.getRegion());
                p.setSaison(Entity.getSaison());
                p.setRole(Entity.getRole());
                p.setN_Lot(Entity.isN_Lot());
                p.setN_Imei(Entity.getN_Imei());
                p.setN_Imei2(Entity.getN_Imei2());
                p.setDate_Fabrication(Entity.getDate_Fabrication());
                p.setDate_Validite(Entity.getDate_Validite());
                p.setTva(Entity.getTva());
                p.setFodec(Entity.getFodec());
                p.setCertificat(Entity.getCertificat());
                p.setImage_type(Entity.getImage_type());
                p.setCertificat_type(Entity.getCertificat_type());
                p.setRfid_type(Entity.getRfid_type());
                Entity = Repo.save(p);
            } else {
                throw new EntityNotFoundException();
            }
        return Entity;
        } catch (IOException ex) {
            throw new FileStorageException("impossible d'enregistrer le fichier  " + nom_produit + "  ! ", ex);
        }

    }

    public ResponseEntity<Object> Supprimer_Fiche_Produit(Long id) {
        Optional<Fiche_Produit> Entity =  Repo.findById(id);
        if (Entity.isPresent()) {
            Fiche_Produit Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public Fiche_Produit Produit_Image(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public List<Fiche_Produit> Tous() {
        return (List<Fiche_Produit>)  Repo.findAll();
    }


    public Object Fiche_Produit(Long id_produit) {
        return Repo.findById(id_produit);
    }

    public List<String> lister_champ() {

        return Repo.Lister_champs() ;    }

    public List<Fiche_Produit> filtre(String champ, String valeur) {
        List<Fiche_Produit> liste = new ArrayList<>();
        try {
            String query = "select Id_Produit as id_Produit,  Code_Barre as code_Barre,Source as source,Nom_Produit as nom_Produit," +
                    "        Type1  as type1, Type2 as type2, Famille as famille,Sous_Famille as sous_Famille,Unite as unite, Valeur_Unite as valeur_Unite," +
                    "        Ngp as ngp , Caracteristique_Technique as caracteristique_Technique, Marque as marque, " +
                    "        Pays as pays, Ville as ville, N_Imei as n_Imei, N_Imei2 as n_Imei2,Temperature_Max as temperateur_Max, Temperature_Min as temperateur_Min," +
                    "        Image_type as image_type ,  Certificat_type as certificat_type, Rfid_type as rfid_type,Image as image,Certificat as certificat, Rfid as rfid,"+
                    "        N_Lot as n_Lot, Date_Fabrication as date_Fabrication, Date_Validite as date_Validite,Saison as saison," +
                    "        Region as region,N_serie as n_serie, Couleur as couleur,Taille as taille,Role as role,Tva as tva,Fodec as fodec from Fiche_Produit where "+champ+" like   '" + valeur + "%'";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                Fiche_Produit p = new Fiche_Produit();
                p.setId_Produit(rs.getLong("id_Produit"));
                p.setCode_Barre((rs.getString("code_Barre")));
                p.setNom_Produit(rs.getString("nom_Produit"));
                p.setSource(rs.getString("source"));
                p.setType1(rs.getString("type1"));
                p.setType2 (rs.getString("type2"));
                p.setUnite (rs.getString("unite"));
                p.setValeur_Unite (rs.getDouble("valeur_Unite"));
                p.setNgp (rs.getString("ngp"));
                p.setRfid (rs.getBytes("rfid"));
                p.setRfid_type(rs.getString("rfid_type"));
                p.setCaracteristique_Technique (rs.getString("caracteristique_Technique"));
                p.setMarque (rs.getString("marque"));
                p.setFamille (rs.getString("famille"));
                p.setSous_Famille (rs.getString("sous_Famille"));
                p.setImage (rs.getBytes("image"));
                p.setImage_type(rs.getString("image_type"));
                p.setPays (rs.getString("pays"));
                p.setVille (rs.getString("ville"));
                p.setCouleur(rs.getString("couleur"));
                p.setN_Serie(rs.getString("n_serie"));
                p.setTaille(rs.getString("taille"));
                p.setCode_Barre(rs.getString("code_Barre"));
                p.setTemperature_Max(rs.getDouble("temperateur_Max"));
                p.setTemperature_Min(rs.getDouble("temperateur_Min"));
                p.setRegion(rs.getString("region"));
                p.setSaison(rs.getString("saison"));
                p.setRole(rs.getString("role"));
                p.setN_Lot(rs.getString("n_Lot"));
                p.setN_Imei(rs.getString("n_Imei"));
                p.setN_Imei2(rs.getString("n_Imei2"));
                p.setDate_Fabrication(rs.getDate("date_Fabrication"));
                p.setDate_Validite(rs.getDate("date_Validite"));
                p.setTva(rs.getDouble("tva"));
                p.setFodec(rs.getString("fodec"));
                p.setCertificat_type(rs.getString("certificat_type"));

                liste.add(p);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return liste ;
    }


    public  Fiche_Produit  filtre_code(String champ, String valeur) {
        Fiche_Produit p = null;
        try {
            String query = "select Id_Produit as id_Produit,  Code_Barre as code_Barre,Source as source,Nom_Produit as nom_Produit," +
                    "        Type1  as type1, Type2 as type2, Famille as famille,Sous_Famille as sous_Famille,Unite as unite, Valeur_Unite as valeur_Unite," +
                    "        Ngp as ngp , Caracteristique_Technique as caracteristique_Technique, Marque as marque, " +
                    "        Pays as pays, Ville as ville, N_Imei as n_Imei, N_Imei2 as n_Imei2,Temperature_Max as temperateur_Max, Temperature_Min as temperateur_Min," +
                    "        Image_type as image_type ,  Certificat_type as certificat_type, Rfid_type as rfid_type,Image as image,Certificat as certificat, Rfid as rfid,"+
                    "        N_Lot as n_Lot, Date_Fabrication as date_Fabrication, Date_Validite as date_Validite,Saison as saison," +
                    "        Region as region,N_serie as n_serie, Couleur as couleur,Taille as taille,Role as role,Tva as tva,Fodec as fodec from Fiche_Produit where "+champ+" =   '" + valeur + "'";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                 p = new Fiche_Produit();
                p.setId_Produit(rs.getLong("id_Produit"));
                p.setCode_Barre((rs.getString("code_Barre")));
                p.setNom_Produit(rs.getString("nom_Produit"));
                p.setSource(rs.getString("source"));
                p.setType1(rs.getString("type1"));
                p.setType2 (rs.getString("type2"));
                p.setUnite (rs.getString("unite"));
                p.setValeur_Unite (rs.getDouble("valeur_Unite"));
                p.setNgp (rs.getString("ngp"));
                p.setRfid (rs.getBytes("rfid"));
                p.setRfid_type(rs.getString("rfid_type"));
                p.setCaracteristique_Technique (rs.getString("caracteristique_Technique"));
                p.setMarque (rs.getString("marque"));
                p.setFamille (rs.getString("famille"));
                p.setSous_Famille (rs.getString("sous_Famille"));
                p.setImage (rs.getBytes("image"));
                p.setImage_type(rs.getString("image_type"));
                p.setPays (rs.getString("pays"));
                p.setVille (rs.getString("ville"));
                p.setCouleur(rs.getString("couleur"));
                p.setN_Serie(rs.getString("n_serie"));
                p.setTaille(rs.getString("taille"));
                p.setCode_Barre(rs.getString("code_Barre"));
                p.setTemperature_Max(rs.getDouble("temperateur_Max"));
                p.setTemperature_Min(rs.getDouble("temperateur_Min"));
                p.setRegion(rs.getString("region"));
                p.setSaison(rs.getString("saison"));
                p.setRole(rs.getString("role"));
                p.setN_Lot(rs.getString("n_Lot"));
                p.setN_Imei(rs.getString("n_Imei"));
                p.setN_Imei2(rs.getString("n_Imei2"));
                p.setDate_Fabrication(rs.getDate("date_Fabrication"));
                p.setDate_Validite(rs.getDate("date_Validite"));
                p.setTva(rs.getDouble("tva"));
                p.setFodec(rs.getString("fodec"));
                p.setCertificat_type(rs.getString("certificat_type"));


            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p ;
    }


    public byte[] exporter(Long Id) {
        Fiche_Produit f = Repo.getOne(Id);
        Element Produits = new Element("Produits");

        try {
            Element Produit = new Element("Produit");
            Element Id_Produit = new Element("Id_Produit");
            Id_Produit.setText(f.getId_Produit() + "");
            Element Code_Barre = new Element("Code_Barre");
            Code_Barre.setText(f.getCode_Barre() + "");
            Element Source = new Element("Source");
            Source.setText(f.getSource() + "");
            Element Nom_Produit = new Element("nom_Produit");
            Nom_Produit.setText(f.getNom_Produit() + "");
            Element Type1 = new Element("type1");
            Type1.setText(f.getType1() + "");
            Element Type2 = new Element("type2");
            Type2.setText(f.getType2() + "");
            Element Famille = new Element("famille");
            Famille.setText(f.getFamille() + "");
            Element Sous_Famille = new Element("Sous_Famille");
            Sous_Famille.setText(f.getSous_Famille() + "");
            Element Unite = new Element("unite");
            Unite.setText(f.getUnite() + "");
            Element Valeur_Unite = new Element("valeur_Unite");
            Valeur_Unite.setText(f.getValeur_Unite() + "");
            Element Ngp = new Element("ngp");
            Ngp.setText(f.getNgp() + "");
            Element Rfid = new Element("rfid");
            Rfid.setText(f.getRfid() + "");
            Element Caracteristique_Technique = new Element("caracteristique_Technique");
            Caracteristique_Technique.setText(f.getCaracteristique_Technique() + "");
            Element Marque = new Element("marque");
            Marque.setText(f.getMarque() + "");
            Element Pays = new Element("pays");
            Pays.setText(f.getPays() + "");
            Element Ville = new Element("ville");
            Ville.setText(f.getVille() + "");
            Element N_Imei = new Element("n_Imei");
            N_Imei.setText(f.getN_Imei() + "");
            Element N_Imei2 = new Element("n_Imei2");
            N_Imei2.setText(f.getN_Imei2() + "");
            Element Temperature_Max = new Element("temperature_Max");
            Temperature_Max.setText(f.getTemperature_Max() + "");
            Element Temperature_Min = new Element("temperature_Min");
            Temperature_Min.setText(f.getTemperature_Min() + "");
            Element N_Lot = new Element("n_lot");
            N_Lot.setText(f.isN_Lot() + "");
            Element Date_Fabrication = new Element("date_Fabrication");
            Date_Fabrication.setText(f.getDate_Fabrication() + "");
            Element Date_Validite = new Element("date_Validite");
            Date_Validite.setText(f.getDate_Validite() + "");
            Element Saison = new Element("saison");
            Saison.setText(f.getSaison() + "");
            Element Region = new Element("region");
            Region.setText(f.getRegion() + "");
            Element N_Serie = new Element("n_serie");
            N_Serie.setText(f.getN_Serie() + "");
            Element Couleur = new Element("couleur");
            Couleur.setText(f.getCouleur() + "");
            Element Taille = new Element("taille");
            Taille.setText(f.getTaille() + "");
            Element Role = new Element("role");
            Role.setText(f.getRole() + "");
            Element Tva = new Element("tva");
            Tva.setText(f.getTva() + "");
            Element Fodec = new Element("fodec");
            Fodec.setText(f.getFodec() + "");
            Element Certificat = new Element("certificat");

            Certificat.setText(f.getCertificat() + "");
            Produit.addContent(Id_Produit);
            Produit.addContent(Code_Barre);
            Produit.addContent(Source);
            Produit.addContent(Nom_Produit);
            Produit.addContent(Type1);
            Produit.addContent(Type2);
            Produit.addContent(Famille);
            Produit.addContent(Sous_Famille);
            Produit.addContent(Unite);
            Produit.addContent(Valeur_Unite);
            Produit.addContent(Ngp);
            Produit.addContent(Rfid);
            Produit.addContent(Caracteristique_Technique);
            Produit.addContent(Marque);
            Produit.addContent(Pays);
            Produit.addContent(Ville);
            Produit.addContent(N_Imei);
            Produit.addContent(N_Imei2);
            Produit.addContent(Temperature_Max);
            Produit.addContent(Temperature_Min);
            Produit.addContent(N_Lot);
            Produit.addContent(Date_Fabrication);
            Produit.addContent(Date_Validite);
            Produit.addContent(Saison);
            Produit.addContent(Region);
            Produit.addContent(N_Serie);
            Produit.addContent(Couleur);
            Produit.addContent(Taille);
            Produit.addContent(Role);
            Produit.addContent(Tva);
            Produit.addContent(Fodec);
            Produit.addContent(Certificat);

            Produits.addContent(Produit);
            Document document = new Document(Produits);
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

    public byte[] exporters(String liste1) {

        String[] liste = liste1.split("/");

        Element Produits = new Element("Produits");


        for (int i = 0; i < liste.length; i++) {

            Fiche_Produit f = Repo.getOne(Long.parseLong(liste[i]));

            Element Produit = new Element("Produit");
            Element Id_Produit = new Element("Id_Produit");
            Id_Produit.setText(f.getId_Produit() + "");
            Element Code_Barre = new Element("Code_Barre");
            Code_Barre.setText(f.getCode_Barre() + "");
            Element Source = new Element("Source");
            Source.setText(f.getSource() + "");
            Element Nom_Produit = new Element("nom_Produit");
            Nom_Produit.setText(f.getNom_Produit() + "");
            Element Type1 = new Element("type1");
            Type1.setText(f.getType1() + "");
            Element Type2 = new Element("type2");
            Type2.setText(f.getType2() + "");
            Element Famille = new Element("famille");
            Famille.setText(f.getFamille() + "");
            Element Sous_Famille = new Element("Sous_Famille");
            Sous_Famille.setText(f.getSous_Famille() + "");
            Element Unite = new Element("unite");
            Unite.setText(f.getUnite() + "");
            Element Valeur_Unite = new Element("valeur_Unite");
            Valeur_Unite.setText(f.getValeur_Unite() + "");
            Element Ngp = new Element("ngp");
            Ngp.setText(f.getNgp() + "");
            Element Rfid = new Element("rfid");
            Rfid.setText(f.getRfid() + "");
            Element Caracteristique_Technique = new Element("caracteristique_Technique");
            Caracteristique_Technique.setText(f.getCaracteristique_Technique() + "");
            Element Marque = new Element("marque");
            Marque.setText(f.getMarque() + "");
            Element Pays = new Element("pays");
            Pays.setText(f.getPays() + "");
            Element Ville = new Element("ville");
            Ville.setText(f.getVille() + "");
            Element N_Imei = new Element("n_Imei");
            N_Imei.setText(f.getN_Imei() + "");
            Element N_Imei2 = new Element("n_Imei2");
            N_Imei2.setText(f.getN_Imei2() + "");
            Element Temperature_Max = new Element("temperature_Max");
            Temperature_Max.setText(f.getTemperature_Max() + "");
            Element Temperature_Min = new Element("temperature_Min");
            Temperature_Min.setText(f.getTemperature_Min() + "");
            Element N_Lot = new Element("n_lot");
            N_Lot.setText(f.isN_Lot() + "");
            Element Date_Fabrication = new Element("date_Fabrication");
            Date_Fabrication.setText(f.getDate_Fabrication() + "");
            Element Date_Validite = new Element("date_Validite");
            Date_Validite.setText(f.getDate_Validite() + "");
            Element Saison = new Element("saison");
            Saison.setText(f.getSaison() + "");
            Element Region = new Element("region");
            Region.setText(f.getRegion() + "");
            Element N_Serie = new Element("n_serie");
            N_Serie.setText(f.getN_Serie() + "");
            Element Couleur = new Element("couleur");
            Couleur.setText(f.getCouleur() + "");
            Element Taille = new Element("taille");
            Taille.setText(f.getTaille() + "");
            Element Role = new Element("role");
            Role.setText(f.getRole() + "");
            Element Tva = new Element("tva");
            Tva.setText(f.getTva() + "");
            Element Fodec = new Element("fodec");
            Fodec.setText(f.getFodec() + "");
            Element Certificat = new Element("certificat");
            Certificat.setText(f.getCertificat() + "");


            Produit.addContent(Id_Produit);
            Produit.addContent(Code_Barre);
            Produit.addContent(Source);
            Produit.addContent(Nom_Produit);
            Produit.addContent(Type1);
            Produit.addContent(Type2);
            Produit.addContent(Famille);
            Produit.addContent(Sous_Famille);
            Produit.addContent(Unite);
            Produit.addContent(Valeur_Unite);
            Produit.addContent(Ngp);
            Produit.addContent(Rfid);
            Produit.addContent(Caracteristique_Technique);
            Produit.addContent(Marque);
            Produit.addContent(Pays);
            Produit.addContent(Ville);
            Produit.addContent(N_Imei);
            Produit.addContent(N_Imei2);
            Produit.addContent(Temperature_Max);
            Produit.addContent(Temperature_Min);
            Produit.addContent(N_Lot);
            Produit.addContent(Date_Fabrication);
            Produit.addContent(Date_Validite);
            Produit.addContent(Saison);
            Produit.addContent(Region);
            Produit.addContent(N_Serie);
            Produit.addContent(Couleur);
            Produit.addContent(Taille);
            Produit.addContent(Role);
            Produit.addContent(Tva);
            Produit.addContent(Fodec);
            Produit.addContent(Certificat);

            Produits.addContent(Produit);
        }
        try {
            Document document = new Document(Produits);
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
            Fiche_Produit fr = new Fiche_Produit();
            // fr.setId_Produit(l.get(0).getValue());
            fr.setCode_Barre(l.get(1).getValue());
            fr.setSource(l.get(2).getValue());
            fr.setNom_Produit(l.get(3).getValue());
            fr.setType1(l.get(4).getValue());
            fr.setType2(l.get(5).getValue());
            fr.setFamille(l.get(6).getValue());
            fr.setSous_Famille(l.get(7).getValue());
            fr.setUnite(l.get(8).getValue());
            fr.setValeur_Unite(Double.parseDouble(l.get(9).getValue()));
            fr.setNgp(l.get(10).getValue());

            fr.setCaracteristique_Technique(l.get(12).getValue());
            fr.setMarque(l.get(13).getValue());
            fr.setPays(l.get(14).getValue());
            fr.setVille(l.get(15).getValue());
            fr.setN_Imei(l.get(16).getValue());
            fr.setN_Imei2(l.get(17).getValue());

            fr.setTemperature_Max(Double.parseDouble(l.get(18).getValue()));
            fr.setTemperature_Min(Double.parseDouble(l.get(19).getValue()));
            fr.setN_Lot(l.get(20).getValue());

            try {
                String[] sDate1 = l.get(21).getValue().split(" 00:00:00"); //long date1= null;
                String[] sDate2 = l.get(22).getValue().split(" 00:00:00");

                Date date1 = new Date(Date.parse(sDate1[0]));
                Date date2 = new Date(Date.parse(sDate2[0]));

                fr.setDate_Fabrication(date1);
                fr.setDate_Validite(date2);
            } catch ( Exception e) {
                e.printStackTrace();
            }

            fr.setSaison(l.get(23).getValue());
            fr.setRegion(l.get(24).getValue());
            fr.setN_Serie(l.get(25).getValue());
            fr.setCouleur(l.get(26).getValue());
            fr.setTaille(l.get(27).getValue());
            fr.setRole(l.get(28).getValue());
            fr.setTva(Double.parseDouble(l.get(29).getValue()));
            fr.setFodec(l.get(30).getValue());

            try {
                File file1 = new File("./src/vide.jpg");
                fr.setImage(readContentIntoByteArray(file1));
                fr.setImage_type("image/jpeg");
                fr.setRfid(readContentIntoByteArray(file1));
                fr.setRfid_type("image/jpeg");
                fr.setCertificat(readContentIntoByteArray(file1));
                fr.setCertificat_type("image/jpeg");
            } catch (Exception e) {
            }
            //fr.setCertificat(l.get(1).getValue());
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

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bFile;
    }


    public String Ngp_Produit(Long id) {
        Optional<Fiche_Produit> searchEntity =  Repo.findById(id);
        if (searchEntity.isPresent()) {
            Fiche_Produit s = searchEntity.get();
            return s.getNgp();
        }
        return null ;
    }


    public List<Fiche_Produit> Filtre_Fiche_Produit_par_Id_Nom(String id, String nom) {
        List<Fiche_Produit> liste = new ArrayList<>();
        try {
            String query = "select Id_Produit as id_Produit,  Code_Barre as code_Barre,Source as source,Nom_Produit as nom_Produit," +
                    "        Type1  as type1, Type2 as type2, Famille as famille,Sous_Famille as sous_Famille,Unite as unite, Valeur_Unite as valeur_Unite," +
                    "        Ngp as ngp , Caracteristique_Technique as caracteristique_Technique, Marque as marque, " +
                    "        Pays as pays, Ville as ville, N_Imei as n_Imei, N_Imei2 as n_Imei2,Temperature_Max as temperateur_Max, Temperature_Min as temperateur_Min," +
                    "        Image_type as image_type ,  Certificat_type as certificat_type, Rfid_type as rfid_type,Image as image,Certificat as certificat, Rfid as rfid,"+
                    "        N_Lot as n_Lot, Date_Fabrication as date_Fabrication, Date_Validite as date_Validite,Saison as saison," +
                    "        Region as region,N_serie as n_serie, Couleur as couleur,Taille as taille,Role as role,Tva as tva,Fodec as fodec from Fiche_Produit where Id_Produit like   '" + id + "%'  AND  Nom_Produit like   '" + nom + "%'";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                Fiche_Produit p = new Fiche_Produit();
                p.setId_Produit(rs.getLong("id_Produit"));
                p.setCode_Barre((rs.getString("code_Barre")));
                p.setNom_Produit(rs.getString("nom_Produit"));
                p.setSource(rs.getString("source"));
                p.setType1(rs.getString("type1"));
                p.setType2 (rs.getString("type2"));
                p.setUnite (rs.getString("unite"));
                p.setValeur_Unite (rs.getDouble("valeur_Unite"));
                p.setNgp (rs.getString("ngp"));
                p.setRfid (rs.getBytes("rfid"));
                p.setRfid_type(rs.getString("rfid_type"));
                p.setCaracteristique_Technique (rs.getString("caracteristique_Technique"));
                p.setMarque (rs.getString("marque"));
                p.setFamille (rs.getString("famille"));
                p.setSous_Famille (rs.getString("sous_Famille"));
                p.setImage (rs.getBytes("image"));
                p.setImage_type(rs.getString("image_type"));
                p.setPays (rs.getString("pays"));
                p.setVille (rs.getString("ville"));
                p.setCouleur(rs.getString("couleur"));
                p.setN_Serie(rs.getString("n_serie"));
                p.setTaille(rs.getString("taille"));
                p.setCode_Barre(rs.getString("code_Barre"));
                p.setTemperature_Max(rs.getDouble("temperateur_Max"));
                p.setTemperature_Min(rs.getDouble("temperateur_Min"));
                p.setRegion(rs.getString("region"));
                p.setSaison(rs.getString("saison"));
                p.setRole(rs.getString("role"));
                p.setN_Lot(rs.getString("n_Lot"));
                p.setN_Imei(rs.getString("n_Imei"));
                p.setN_Imei2(rs.getString("n_Imei2"));
                p.setDate_Fabrication(rs.getDate("date_Fabrication"));
                p.setDate_Validite(rs.getDate("date_Validite"));
                p.setTva(rs.getDouble("tva"));
                p.setFodec(rs.getString("fodec"));
                p.setCertificat_type(rs.getString("certificat_type"));

                liste.add(p);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return liste ;
    }
}