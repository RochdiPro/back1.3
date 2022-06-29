package net.guides.springboot2.springboot2jpacrudexample.service.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Contrainte;
import net.guides.springboot2.springboot2jpacrudexample.repository.init.Contrainte_Repository;
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
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class Contrainte_Service {
    @Autowired
    Contrainte_Repository Repo;

    public List<Contrainte> getAll() {
        return (List<Contrainte>) Repo.findAll();
    }

    public Contrainte Create_Contrainte(Contrainte Entity) {
        return Repo.save(Entity);
    }

    public Contrainte Update_Contrainte(Long code, Contrainte Entity) {
        Contrainte updated = null;
        Optional<Contrainte> searchEntity = Repo.findById(code);
        if (searchEntity.isPresent()) {
            Contrainte p = searchEntity.get();
            p.setNom_Contrainte(Entity.getNom_Contrainte());
            p.setNom_Produit(Entity.isNom_Produit());
            p.setFamille(Entity.isFamille());
            p.setSource(Entity.isSource());
            p.setType1(Entity.isType1());
            p.setType2(Entity.isType2());
            p.setUnite(Entity.isUnite());
            p.setValeur_Unite(Entity.isValeur_Unite());
            p.setNgp(Entity.isNgp());
            p.setRfid(Entity.isRfid());
            p.setCaracteristique_Technique(Entity.isCaracteristique_Technique());
            p.setMarque(Entity.isMarque());
            p.setFamille(Entity.isFamille());
            p.setSous_Famille(Entity.isSous_Famille());
            p.setSrc_Img(Entity.isSrc_Img());
            p.setPays(Entity.isPays());
            p.setVille(Entity.isVille());
            p.setCouleur(Entity.isCouleur());
            p.setN_Serie(Entity.isN_Serie());
            p.setTaille(Entity.isTaille());
            p.setCode_Barre(Entity.isCode_Barre());
            p.setTemperature_Max(Entity.isTemperature_Max());
            p.setTemperature_Min(Entity.isTemperature_Min());
            p.setRegion(Entity.isRegion());
            p.setSaison(Entity.isSaison());
            p.setRole(Entity.isRole());
            p.setN_Lot(Entity.isN_Lot());
            p.setN_Imei(Entity.isN_Imei());
            p.setN_Imei2(Entity.isN_Imei2());
            p.setDate_Fabrication(Entity.isDate_Fabrication());
            p.setDate_Validite(Entity.isDate_Validite());
            p.setTva(Entity.isTva());
            p.setFodec(Entity.isFodec());
            p.setCertificat(Entity.isCertificat());
            updated = Repo.save(p);
        } else {
            throw new EntityNotFoundException();
        }
        return updated;
    }

    public ResponseEntity<Object> Delete_Contrainte(Long code) {
        Optional<Contrainte> Entity = Repo.findById(code);
        if (Entity.isPresent()) {
            Contrainte Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public Object Contrainte(Long code) {
        return Repo.findById(code);
    }

    public byte[] exporter(Long Id) {
        Contrainte f = Repo.getOne(Id);
        Element Contraintes = new Element("Contraintes");
        try {
            Element Contrainte = new Element("Contrainte");
            Element Id_Contrainte = new Element("Id_Contrainte");
            Id_Contrainte.setText(f.getId_Contrainte() + "");
            Element Nom_Contrainte = new Element("Nom_Contrainte");
            Nom_Contrainte.setText(f.getNom_Contrainte());
            Element Code_Barre = new Element("Code_Barre");
            Code_Barre.setText(f.isCode_Barre() + "");
            Element Source = new Element("Source");
            Source.setText(f.isSource() + "");
            Element Nom_Produit = new Element("nom_Produit");
            Nom_Produit.setText(f.isNom_Produit() + "");
            Element Type1 = new Element("type1");
            Type1.setText(f.isType1() + "");
            Element Type2 = new Element("type2");
            Type2.setText(f.isType2() + "");
            Element Famille = new Element("famille");
            Famille.setText(f.isFamille() + "");
            Element Sous_Famille = new Element("Sous_Famille");
            Sous_Famille.setText(f.isSous_Famille() + "");
            Element Unite = new Element("unite");
            Unite.setText(f.isUnite() + "");
            Element Valeur_Unite = new Element("valeur_Unite");
            Valeur_Unite.setText(f.isValeur_Unite() + "");
            Element Ngp = new Element("ngp");
            Ngp.setText(f.isNgp() + "");
            Element Rfid = new Element("rfid");
            Rfid.setText(f.isRfid() + "");
            Element Caracteristique_Technique = new Element("caracteristique_Technique");
            Caracteristique_Technique.setText(f.isCaracteristique_Technique() + "");
            Element Marque = new Element("marque");
            Marque.setText(f.isMarque() + "");
            Element Src_Img = new Element("src_Img");
            Src_Img.setText(f.isSrc_Img() + "");
            Element Pays = new Element("pays");
            Pays.setText(f.isPays() + "");
            Element Ville = new Element("ville");
            Ville.setText(f.isVille() + "");
            Element N_Imei = new Element("n_Imei");
            N_Imei.setText(f.isN_Imei() + "");
            Element N_Imei2 = new Element("n_Imei2");
            N_Imei2.setText(f.isN_Imei2() + "");
            Element Temperature_Max = new Element("temperature_Max");
            Temperature_Max.setText(f.isTemperature_Max() + "");
            Element Temperature_Min = new Element("temperature_Min");
            Temperature_Min.setText(f.isTemperature_Min() + "");
            Element N_Lot = new Element("n_lot");
            N_Lot.setText(f.isN_Lot() + "");
            Element Date_Fabrication = new Element("date_Fabrication");
            Date_Fabrication.setText(f.isDate_Fabrication() + "");
            Element Date_Validite = new Element("date_Validite");
            Date_Validite.setText(f.isDate_Validite() + "");
            Element Saison = new Element("saison");
            Saison.setText(f.isSaison() + "");
            Element Region = new Element("region");
            Region.setText(f.isRegion() + "");
            Element N_Serie = new Element("n_serie");
            N_Serie.setText(f.isN_Serie() + "");
            Element Couleur = new Element("couleur");
            Couleur.setText(f.isCouleur() + "");
            Element Taille = new Element("taille");
            Taille.setText(f.isTaille() + "");
            Element Role = new Element("role");
            Role.setText(f.isRole() + "");
            Element Tva = new Element("tva");
            Tva.setText(f.isTva() + "");
            Element Fodec = new Element("fodec");
            Fodec.setText(f.isFodec() + "");
            Element Certificat = new Element("certificat");
            Certificat.setText(f.isCertificat() + "");


            Contrainte.addContent(Nom_Contrainte);
            Contrainte.addContent(Id_Contrainte);
            Contrainte.addContent(Code_Barre);
            Contrainte.addContent(Source);
            Contrainte.addContent(Nom_Produit);
            Contrainte.addContent(Type1);
            Contrainte.addContent(Type2);
            Contrainte.addContent(Famille);
            Contrainte.addContent(Sous_Famille);
            Contrainte.addContent(Unite);
            Contrainte.addContent(Valeur_Unite);
            Contrainte.addContent(Ngp);
            Contrainte.addContent(Rfid);
            Contrainte.addContent(Caracteristique_Technique);
            Contrainte.addContent(Marque);
            Contrainte.addContent(Src_Img);
            Contrainte.addContent(Pays);
            Contrainte.addContent(Ville);
            Contrainte.addContent(N_Imei);
            Contrainte.addContent(N_Imei2);
            Contrainte.addContent(Temperature_Max);
            Contrainte.addContent(Temperature_Min);
            Contrainte.addContent(N_Lot);
            Contrainte.addContent(Date_Fabrication);
            Contrainte.addContent(Date_Validite);
            Contrainte.addContent(Saison);
            Contrainte.addContent(Region);
            Contrainte.addContent(N_Serie);
            Contrainte.addContent(Couleur);
            Contrainte.addContent(Taille);
            Contrainte.addContent(Role);
            Contrainte.addContent(Tva);
            Contrainte.addContent(Fodec);
            Contrainte.addContent(Certificat);

            Contraintes.addContent(Contrainte);

            Document document = new Document(Contraintes);
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

        Element Contraintes = new Element("Contraintes");


        for (int i = 0; i < liste.length; i++) {

            Contrainte f = Repo.getOne(Long.parseLong(liste[i]));
            Element Contrainte = new Element("Contrainte");
            Element Id_Contrainte = new Element("Id_Contrainte");
            Id_Contrainte.setText(f.getId_Contrainte() + "");
            Element Nom_Contrainte = new Element("Nom_Contrainte");
            Nom_Contrainte.setText(f.getNom_Contrainte());
            Element Code_Barre = new Element("Code_Barre");
            Code_Barre.setText(f.isCode_Barre() + "");
            Element Source = new Element("Source");
            Source.setText(f.isSource() + "");
            Element Nom_Produit = new Element("nom_Produit");
            Nom_Produit.setText(f.isNom_Produit() + "");
            Element Type1 = new Element("type1");
            Type1.setText(f.isType1() + "");
            Element Type2 = new Element("type2");
            Type2.setText(f.isType2() + "");
            Element Famille = new Element("famille");
            Famille.setText(f.isFamille() + "");
            Element Sous_Famille = new Element("Sous_Famille");
            Sous_Famille.setText(f.isSous_Famille() + "");
            Element Unite = new Element("unite");
            Unite.setText(f.isUnite() + "");
            Element Valeur_Unite = new Element("valeur_Unite");
            Valeur_Unite.setText(f.isValeur_Unite() + "");
            Element Ngp = new Element("ngp");
            Ngp.setText(f.isNgp() + "");
            Element Rfid = new Element("rfid");
            Rfid.setText(f.isRfid() + "");
            Element Caracteristique_Technique = new Element("caracteristique_Technique");
            Caracteristique_Technique.setText(f.isCaracteristique_Technique() + "");
            Element Marque = new Element("marque");
            Marque.setText(f.isMarque() + "");
            Element Src_Img = new Element("src_Img");
            Src_Img.setText(f.isSrc_Img() + "");
            Element Pays = new Element("pays");
            Pays.setText(f.isPays() + "");
            Element Ville = new Element("ville");
            Ville.setText(f.isVille() + "");
            Element N_Imei = new Element("n_Imei");
            N_Imei.setText(f.isN_Imei() + "");
            Element N_Imei2 = new Element("n_Imei2");
            N_Imei2.setText(f.isN_Imei2() + "");
            Element Temperature_Max = new Element("temperature_Max");
            Temperature_Max.setText(f.isTemperature_Max() + "");
            Element Temperature_Min = new Element("temperature_Min");
            Temperature_Min.setText(f.isTemperature_Min() + "");
            Element N_Lot = new Element("n_lot");
            N_Lot.setText(f.isN_Lot() + "");
            Element Date_Fabrication = new Element("date_Fabrication");
            Date_Fabrication.setText(f.isDate_Fabrication() + "");
            Element Date_Validite = new Element("date_Validite");
            Date_Validite.setText(f.isDate_Validite() + "");
            Element Saison = new Element("saison");
            Saison.setText(f.isSaison() + "");
            Element Region = new Element("region");
            Region.setText(f.isRegion() + "");
            Element N_Serie = new Element("n_serie");
            N_Serie.setText(f.isN_Serie() + "");
            Element Couleur = new Element("couleur");
            Couleur.setText(f.isCouleur() + "");
            Element Taille = new Element("taille");
            Taille.setText(f.isTaille() + "");
            Element Role = new Element("role");
            Role.setText(f.isRole() + "");
            Element Tva = new Element("tva");
            Tva.setText(f.isTva() + "");
            Element Fodec = new Element("fodec");
            Fodec.setText(f.isFodec() + "");
            Element Certificat = new Element("certificat");
            Certificat.setText(f.isCertificat() + "");


            Contrainte.addContent(Nom_Contrainte);
            Contrainte.addContent(Id_Contrainte);
            Contrainte.addContent(Code_Barre);
            Contrainte.addContent(Source);
            Contrainte.addContent(Nom_Produit);
            Contrainte.addContent(Type1);
            Contrainte.addContent(Type2);
            Contrainte.addContent(Famille);
            Contrainte.addContent(Sous_Famille);
            Contrainte.addContent(Unite);
            Contrainte.addContent(Valeur_Unite);
            Contrainte.addContent(Ngp);
            Contrainte.addContent(Rfid);
            Contrainte.addContent(Caracteristique_Technique);
            Contrainte.addContent(Marque);
            Contrainte.addContent(Src_Img);
            Contrainte.addContent(Pays);
            Contrainte.addContent(Ville);
            Contrainte.addContent(N_Imei);
            Contrainte.addContent(N_Imei2);
            Contrainte.addContent(Temperature_Max);
            Contrainte.addContent(Temperature_Min);
            Contrainte.addContent(N_Lot);
            Contrainte.addContent(Date_Fabrication);
            Contrainte.addContent(Date_Validite);
            Contrainte.addContent(Saison);
            Contrainte.addContent(Region);
            Contrainte.addContent(N_Serie);
            Contrainte.addContent(Couleur);
            Contrainte.addContent(Taille);
            Contrainte.addContent(Role);
            Contrainte.addContent(Tva);
            Contrainte.addContent(Fodec);
            Contrainte.addContent(Certificat);

            Contraintes.addContent(Contrainte);
        }
        try {
            Document document = new Document(Contraintes);
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
            Contrainte fr = new Contrainte();
            // fr.setId_Local(Long.parseLong(l.get(0).getValue()));

            fr.setId_Contrainte(Long.valueOf(l.get(1).getValue()));
            if (l.get(2).getValue().equals("true")) { fr.setCode_Barre(true); } else {fr.setCode_Barre(false); }
            if (l.get(3).getValue().equals("true")) { fr.setNom_Produit(true); } else {fr.setNom_Produit(false); }
            if (l.get(4).getValue().equals("true")) { fr.setType1(true); } else {fr.setType1(false); }
            if (l.get(5).getValue().equals("true")) { fr.setType2(true); } else {fr.setType2(false); }
            if (l.get(6).getValue().equals("true")) { fr.setFamille (true); } else {fr.setFamille(false); }
            if (l.get(7).getValue().equals("true")) { fr.setSous_Famille (true); } else {fr.setSous_Famille(false); }
            if (l.get(8).getValue().equals("true")) { fr.setUnite (true); } else {fr.setUnite(false); }
            if (l.get(9).getValue().equals("true")) { fr.setValeur_Unite (true); } else {fr.setValeur_Unite(false); }
            if (l.get(10).getValue().equals("true")) { fr.setNgp (true); } else {fr.setNgp(false); }
            if (l.get(11).getValue().equals("true")) { fr.setRfid (true); } else {fr.setRfid(false); }
            if (l.get(12).getValue().equals("true")) { fr.setCaracteristique_Technique (true); } else {fr.setCaracteristique_Technique(false); }
            if (l.get(13).getValue().equals("true")) { fr.setMarque (true); } else {fr.setMarque(false); }
            if (l.get(14).getValue().equals("true")) { fr.setSrc_Img (true); } else {fr.setSrc_Img(false); }
            if (l.get(15).getValue().equals("true")) { fr.setPays (true); } else {fr.setPays(false); }
            if (l.get(16).getValue().equals("true")) { fr.setVille (true); } else {fr.setVille(false); }
            if (l.get(17).getValue().equals("true")) { fr.setN_Imei (true); } else {fr.setN_Imei(false); }
            if (l.get(18).getValue().equals("true")) { fr.setN_Imei2 (true); } else {fr.setN_Imei2(false); }

            if (l.get(6).getValue().equals("true")) { fr.setTemperature_Max (true); } else {fr.setTemperature_Max(false); }
            if (l.get(7).getValue().equals("true")) { fr.setTemperature_Min (true); } else {fr.setTemperature_Min(false); }
            if (l.get(8).getValue().equals("true")) { fr.setN_Lot  (true); } else {fr.setN_Lot(false); }
            if (l.get(9).getValue().equals("true")) { fr.setDate_Fabrication (true); } else {fr.setDate_Fabrication(false); }
            if (l.get(10).getValue().equals("true")) { fr.setDate_Validite (true); } else {fr.setDate_Validite(false); }
            if (l.get(11).getValue().equals("true")) { fr.setSaison(true); } else {fr.setSaison(false); }
            if (l.get(12).getValue().equals("true")) { fr.setRegion  (true); } else {fr.setRegion(false); }
            if (l.get(13).getValue().equals("true")) { fr.setCouleur (true); } else {fr.setCouleur(false); }
            if (l.get(14).getValue().equals("true")) { fr.setTaille (true); } else {fr.setTaille(false); }
            if (l.get(15).getValue().equals("true")) { fr.setRole (true); } else {fr.setRole(false); }
            if (l.get(16).getValue().equals("true")) { fr.setTva (true); } else {fr.setTva(false); }
            if (l.get(17).getValue().equals("true")) { fr.setFodec (true); } else {fr.setFodec(false); }
            if (l.get(18).getValue().equals("true")) { fr.setCertificat (true); } else {fr.setCertificat(false); }

            Repo.save(fr);
        }
        return  "ok";
    }
}


