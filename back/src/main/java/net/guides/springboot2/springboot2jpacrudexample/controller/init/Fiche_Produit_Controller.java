package net.guides.springboot2.springboot2jpacrudexample.controller.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Produit;

import net.guides.springboot2.springboot2jpacrudexample.service.init.Fiche_Produit_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;



@RestController
public class Fiche_Produit_Controller {

    @Autowired
    Fiche_Produit_Service Service;


    @RequestMapping(value = "/Fiche_Produits" ,method = RequestMethod.GET)
    public List<Fiche_Produit> Fiche_Produits() {
        return Service.Tous();
    }

    @RequestMapping(value = "/Fiche_Produit", method = RequestMethod.GET)
    public Object Fiche_Produit(@RequestParam Long Id_Produit) {
        return  Service.Fiche_Produit(Id_Produit);
    }

    @PostMapping(value = "/Creer_Fiche_Produit")
    public Fiche_Produit Creer_Fiche_Produit(@RequestParam String Code_Barre, @RequestParam String Source, @RequestParam String Nom_Produit, @RequestParam String Type1, @RequestParam String Type2, @RequestParam String Unite, @RequestParam double Valeur_Unite, @RequestParam String Ngp, @RequestParam String Caracteristique_Technique, @RequestParam String Marque, @RequestParam String Famille, @RequestParam String Sous_Famille, @RequestParam String Pays, @RequestParam String Ville, @RequestParam String Saison, @RequestParam String Region, @RequestParam String N_Imei, @RequestParam String N_Imei2,
                                             @RequestParam double Temperature_Max, @RequestParam double Temperature_Min, @RequestParam String N_Lot, @RequestParam Date Date_Fabrication, @RequestParam Date Date_Validite, @RequestParam String N_Serie, @RequestParam String Couleur, @RequestParam String Taille, @RequestParam String Role, @RequestParam double Tva, @RequestParam String Fodec, @RequestParam("Image") MultipartFile Image, @RequestParam( "Certificat"  ) MultipartFile Certificat, @RequestParam("Rfid") MultipartFile Rfid) {

        return Service.Create_Fiche_Produit(Code_Barre, Source, Nom_Produit, Type1, Type2, Famille, Sous_Famille, Unite, Valeur_Unite, Ngp, Caracteristique_Technique, Marque, Pays, Ville, N_Imei, N_Imei2, Temperature_Max, Temperature_Min, N_Lot, Date_Fabrication, Date_Validite, Saison, Region, N_Serie, Couleur, Taille, Role, Tva, Fodec, Image.getContentType(), Certificat.getContentType(), Rfid.getContentType(), Image, Certificat, Rfid);
    }

    @PostMapping(value = "/Modifier_Fiche_Produit")
    public Fiche_Produit Modifier_Fiche_Produit(@RequestParam Long Id_Produit, @RequestParam String Code_Barre, @RequestParam String Source, @RequestParam String Nom_Produit, @RequestParam String Type1, @RequestParam String Type2, @RequestParam String Unite, @RequestParam double Valeur_Unite, @RequestParam String Ngp, @RequestParam String Caracteristique_Technique, @RequestParam String Marque, @RequestParam String Famille, @RequestParam String Sous_Famille, @RequestParam String Pays, @RequestParam String Ville, @RequestParam String Saison, @RequestParam String Region, @RequestParam String N_Imei, @RequestParam String N_Imei2,
                                                @RequestParam double Temperature_Max, @RequestParam double Temperature_Min, @RequestParam String N_Lot, @RequestParam Date Date_Fabrication, @RequestParam Date Date_Validite, @RequestParam String N_Serie, @RequestParam String Couleur, @RequestParam String Taille, @RequestParam String Role, @RequestParam double Tva, @RequestParam String Fodec, @RequestParam("Image") MultipartFile Image, @RequestParam("Certificat") MultipartFile Certificat, @RequestParam("Rfid") MultipartFile Rfid) {
        return Service.Modifier_Fiche_Produit(Id_Produit, Code_Barre, Source, Nom_Produit, Type1, Type2, Famille, Sous_Famille, Unite, Valeur_Unite, Ngp, Caracteristique_Technique, Marque, Pays, Ville, N_Imei, N_Imei2, Temperature_Max, Temperature_Min, N_Lot, Date_Fabrication, Date_Validite, Saison, Region, N_Serie, Couleur, Taille, Role, Tva, Fodec, Image.getContentType(), Certificat.getContentType(), Rfid.getContentType(), Image, Certificat, Rfid);
    }

    @RequestMapping(value = "/Supprimer_Fiche_Produit", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Fichier_Produit(@RequestParam Long Id_Produit) {
        return Service.Supprimer_Fiche_Produit(Id_Produit);
    }

    @GetMapping("/Produit_Image")
    public ResponseEntity<ByteArrayResource> Produit_Image(@RequestParam Long Id_Produit) {
        // Load file from database
        Fiche_Produit dbFile = Service.Produit_Image(Id_Produit);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getImage_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getNom_Produit() + "\"")
                .body(new ByteArrayResource(dbFile.getImage()));
    }

    @GetMapping("/Produit_Certificat")
    public ResponseEntity<ByteArrayResource> Produit_Certificat(@RequestParam Long Id_Produit) {
        // Load file from database
        Fiche_Produit dbFile = Service.Produit_Image(Id_Produit);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getCertificat_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getNom_Produit() + "\"")
                .body(new ByteArrayResource(dbFile.getCertificat()));
    }


    @GetMapping("/Produit_Rfid")
    public ResponseEntity<ByteArrayResource> Produit_Rfid(@RequestParam Long Id_Produit) {
        // Load file from database
        Fiche_Produit dbFile = Service.Produit_Image(Id_Produit);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getRfid_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getNom_Produit() + "\"")
                .body(new ByteArrayResource(dbFile.getRfid()));
    }


  @RequestMapping(value = "/Liste_Champs_Fiche_Produit", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Depot ( ) {
        return Service.lister_champ();

    }


    @RequestMapping(value = "/Filtre_Fiche_Produit", method = RequestMethod.GET)
    public  List<Fiche_Produit> filtre (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);
    }

    @RequestMapping(value = "/Filtre_Fiche_Produit_par_Code", method = RequestMethod.GET)
    public   Fiche_Produit  filtre3 ( @RequestParam String Code) {
        return Service.filtre_code("Code_Barre", Code);
    }

    @RequestMapping(value = "/Filtre_Fiche_Produit_par_Id_Nom", method = RequestMethod.GET)
    public   List<Fiche_Produit>  Filtre_Fiche_Produit_par_Id_Nom ( @RequestParam String Id , @RequestParam String Nom) {
        return Service.Filtre_Fiche_Produit_par_Id_Nom(Id,Nom);
    }

    @RequestMapping(value = "/Filtre_Fiche_Produit_par_Code2", method = RequestMethod.GET)
    public  List<Fiche_Produit>  filtre2 ( @RequestParam String Code) {
        return Service.filtre("Code_Barre", Code);
    }

    @GetMapping("/Exporter_Fiche_Produit")
    public ResponseEntity<ByteArrayResource> Exporter_Local(@RequestParam Long Id_Produit ) {
        // Load file from database
        byte[] dbFile = Service.exporter(Id_Produit );
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }

    @GetMapping("/Exporter_Fiche_Produits")
    public ResponseEntity<ByteArrayResource> Exporter_Locals(@RequestParam String Liste ) {
        // Load file from database

        byte[] dbFile = Service.exporters(Liste);


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }


    @PostMapping("/Importer_Produits")
    public String  Importer_Fournisseurs(@RequestParam("Produits") MultipartFile  Fiche_Produits )
    {
        return Service.Importers(Fiche_Produits);
    }
    @RequestMapping(value = "/Ngp_Produit", method = RequestMethod.GET)
    public  String Ref_Produit ( @RequestParam Long Id) {
        return Service.Ngp_Produit( Id);
    }

}