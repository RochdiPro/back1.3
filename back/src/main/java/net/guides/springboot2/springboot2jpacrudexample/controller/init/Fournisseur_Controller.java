package net.guides.springboot2.springboot2jpacrudexample.controller.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Fournisseur;
import net.guides.springboot2.springboot2jpacrudexample.service.init.Fournisseur_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Fournisseur_Controller {


    @Autowired
    Fournisseur_Service Service  ;


    @RequestMapping(value = "/Fournisseurs" ,method = RequestMethod.GET)
    public List<Fournisseur> Fiche_Bon_Entree_Locals() {
        return Service.Tous();
    }



    @RequestMapping(value = "/Fournisseur", method = RequestMethod.GET)
    public Object Fournisseur(@RequestParam Long Id_Fr) {
        return  Service.Fournisseur(Id_Fr);
    }


    @PostMapping(value = "/Creer_Fournisseur")
    public Fournisseur  Creer_Fournisseur(@RequestParam String Nom_Fournisseur, @RequestParam String Categorie_Fiscale, @RequestParam  String Contact, @RequestParam  String Adresse, @RequestParam  String Ville, @RequestParam  String Region, @RequestParam  String Pays, @RequestParam  String Email, @RequestParam  String Site_Web, @RequestParam  String Banque1, @RequestParam  String Banque2, @RequestParam  String Rib1, @RequestParam  String Rib2, @RequestParam  String Categorie_Fournisseur, @RequestParam  boolean Timbre_Fiscal, @RequestParam  String Representant, @RequestParam  String Description, @RequestParam  boolean Bloque_Achat, @RequestParam  double Solde_Facture, @RequestParam  double Risque, @RequestParam  double Plafond, @RequestParam String Code_Tva, @RequestParam String Tel1, @RequestParam String Tel2, @RequestParam String Fax, @RequestParam  String Type_Piece_Identite, @RequestParam String N_Piece_Identite, @RequestParam Date Date_Livraison_Identite  , @RequestParam String N_Attestation_Exoneration , @RequestParam Date Debut_Exoneration , @RequestParam Date Fin_Exoneration , @RequestParam double Reduction_Tva , @RequestParam("Image") MultipartFile  Image) {

        return Service.Creer_Fournisseur( Nom_Fournisseur,   Categorie_Fiscale,   Contact,   Adresse,   Ville,   Region,   Pays,   Email,   Site_Web,   Banque1,   Banque2,   Rib1,   Rib2,   Categorie_Fournisseur,   Timbre_Fiscal,   Representant,   Description,   Bloque_Achat,   Solde_Facture,   Risque,   Plafond,   Code_Tva,   Tel1,   Tel2,   Fax,    Type_Piece_Identite,   N_Piece_Identite,   Date_Livraison_Identite ,   N_Attestation_Exoneration ,   Debut_Exoneration ,   Fin_Exoneration ,   Reduction_Tva , Image);
     }

    @RequestMapping(value = "/Supprimer_Fournisseur", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Fournisseur(@RequestParam Long Id_Fr) {
        return Service.Supprimer_Fournisseur(Id_Fr);
    }

    @PostMapping(value = "/Modifier_Fournisseur")
    public Fournisseur Modifier_Fournisseur (  @RequestParam Long Id_Fr,@RequestParam String Nom_Fournisseur, @RequestParam String Categorie_Fiscale, @RequestParam  String Contact, @RequestParam  String Adresse, @RequestParam  String Ville, @RequestParam  String Region, @RequestParam  String Pays, @RequestParam  String Email, @RequestParam  String Site_Web, @RequestParam  String Banque1, @RequestParam  String Banque2, @RequestParam  String Rib1, @RequestParam  String Rib2, @RequestParam  String Categorie_Fournisseur, @RequestParam  boolean Timbre_Fiscal,@RequestParam  String Representant, @RequestParam  String Description,@RequestParam  boolean Bloque_Achat,@RequestParam  double Solde_Facture, @RequestParam  double Risque, @RequestParam  double Plafond, @RequestParam String Code_Tva, @RequestParam String Tel1, @RequestParam String Tel2, @RequestParam String Fax ,   @RequestParam  String Type_Piece_Identite,@RequestParam String N_Piece_Identite,@RequestParam  Date Date_Livraison_Identite  ,@RequestParam String N_Attestation_Exoneration ,@RequestParam Date Debut_Exoneration ,@RequestParam Date Fin_Exoneration ,@RequestParam double Reduction_Tva ,   @RequestParam("Image") MultipartFile  Image) {
        return Service.Modifier_Fournisseur( Id_Fr ,Nom_Fournisseur,   Categorie_Fiscale,   Contact,   Adresse,   Ville,   Region,   Pays,   Email,   Site_Web,   Banque1,   Banque2,   Rib1,   Rib2,   Categorie_Fournisseur,   Timbre_Fiscal,   Representant,   Description,   Bloque_Achat,   Solde_Facture,   Risque,   Plafond,   Code_Tva,   Tel1,   Tel2,   Fax,    Type_Piece_Identite,   N_Piece_Identite,   Date_Livraison_Identite ,   N_Attestation_Exoneration ,   Debut_Exoneration ,   Fin_Exoneration ,   Reduction_Tva , Image);
    }


    @GetMapping("/Fournisseur_Image")
    public ResponseEntity<ByteArrayResource> Produit_Image(@RequestParam Long Id_Fr) {
        // Load file from database
        Fournisseur dbFile = Service.image(Id_Fr);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getImage_Type()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Fr() + "\"")
                .body(new ByteArrayResource(dbFile.getImage()));
    }

    @RequestMapping(value = "/Liste_Champs_Fournisseur", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Fournisseur( ) {
        return Service.lister_champ();

    }

    @RequestMapping(value = "/Filtre_Fournisseur", method = RequestMethod.GET)
    public  List<Fournisseur> filtre (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);

    }

    @GetMapping("/Exporter_Fournisseur")
    public ResponseEntity<ByteArrayResource> Exporter_Fournisseur(@RequestParam Long Id_Fr) {
        // Load file from database
        byte[] dbFile = Service.exporter(Id_Fr);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }


    @GetMapping("/Exporter_Fournisseurs")
    public ResponseEntity<ByteArrayResource> Exporter_Fournisseurs(@RequestParam String Liste ) {
        // Load file from database
        System.out.println(Liste);
        byte[] dbFile = Service.exporters(Liste);


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }

/*
    @PostMapping("/Importer_Fournisseur")
    public String Importer_Fournisseur(@RequestParam("Fournisseur") MultipartFile  Fournisseur) {
       return Service.Importer(Fournisseur);
    }*/

    @PostMapping("/Importer_Fournisseurs")
    public String  Importer_Fournisseurs(@RequestParam("Fournisseurs") MultipartFile  Fournisseurs )
    {
        return Service.Importers(Fournisseurs);
    }





}

