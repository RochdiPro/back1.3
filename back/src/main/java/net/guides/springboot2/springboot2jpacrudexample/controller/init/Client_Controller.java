package net.guides.springboot2.springboot2jpacrudexample.controller.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Client;
import net.guides.springboot2.springboot2jpacrudexample.service.init.Client_Service;
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
public class Client_Controller {


    @Autowired
    Client_Service Service  ;

    @RequestMapping(value = "/Clients" ,method = RequestMethod.GET)
    public List<Client> Clients() {
        return Service.TousClients();
    }

    @RequestMapping(value = "/Client", method = RequestMethod.GET)
    public Object Client(@RequestParam Long Id_Clt) {
        return  Service.Client(Id_Clt);
    }

    @PostMapping(value = "/Creer_Client")
    public Client  Creer_Client(  @RequestParam String Nom_Client, @RequestParam String Categorie_Fiscale, @RequestParam  String Contact, @RequestParam  String Adresse, @RequestParam  String Ville, @RequestParam  String Region, @RequestParam  String Pays,
                                  @RequestParam  String Email, @RequestParam  String Site_Web, @RequestParam  String Banque1, @RequestParam  String Banque2, @RequestParam  String Rib1, @RequestParam  String Rib2, @RequestParam  String Categorie_Client, @RequestParam  boolean Timbre_Fiscal,@RequestParam  String Representant, @RequestParam  boolean Bloque_Vente,@RequestParam  double Solde_Facture, @RequestParam  double Risque, @RequestParam  double Plafond, @RequestParam String Code_Tva, @RequestParam String Tel1, @RequestParam String Tel2, @RequestParam String Fax,   @RequestParam  String Type_Piece_Identite, @RequestParam  String Description, @RequestParam String N_Piece_Identite,@RequestParam  Date Date_Livraison_Identite  ,@RequestParam String N_Attestation_Exoneration ,@RequestParam Date Debut_Exoneration ,@RequestParam Date Fin_Exoneration ,@RequestParam double Reduction_Tva ,   @RequestParam("Image") MultipartFile Image) {
        return Service.Creer_Client( Nom_Client,   Categorie_Fiscale,   Contact,   Adresse,   Ville,   Region,   Pays,   Email,   Site_Web,   Banque1,   Banque2,   Rib1,   Rib2,   Categorie_Client,   Timbre_Fiscal,   Representant,      Bloque_Vente ,   Solde_Facture,   Risque,   Plafond,   Code_Tva,   Tel1,   Tel2,   Fax,    Type_Piece_Identite, Description,  N_Piece_Identite,   Date_Livraison_Identite ,   N_Attestation_Exoneration ,   Debut_Exoneration ,   Fin_Exoneration ,   Reduction_Tva , Image);
    }

    @RequestMapping(value = "/Supprimer_Client", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Client(@RequestParam Long Id_Clt) {
        return Service.Supprimer_Client(Id_Clt);
    }

   @PostMapping(value = "/Modifier_Client")
    public Client Modifier_Client (@RequestParam Long Id_Clt, @RequestParam String Nom_Client, @RequestParam String Categorie_Fiscale, @RequestParam  String Contact, @RequestParam  String Adresse, @RequestParam  String Ville, @RequestParam  String Region, @RequestParam  String Pays,
                                     @RequestParam  String Email, @RequestParam  String Site_Web, @RequestParam  String Banque1, @RequestParam  String Banque2, @RequestParam  String Rib1, @RequestParam  String Rib2, @RequestParam  String Categorie_Client, @RequestParam  boolean Timbre_Fiscal,@RequestParam  String Representant, @RequestParam  boolean Bloque_Vente,@RequestParam  double Solde_Facture, @RequestParam  double Risque, @RequestParam  double Plafond, @RequestParam String Code_Tva, @RequestParam String Tel1, @RequestParam String Tel2, @RequestParam String Fax,   @RequestParam  String Type_Piece_Identite, @RequestParam  String Description, @RequestParam String N_Piece_Identite,@RequestParam  Date Date_Livraison_Identite  ,@RequestParam String N_Attestation_Exoneration ,@RequestParam Date Debut_Exoneration ,@RequestParam Date Fin_Exoneration ,@RequestParam double Reduction_Tva ,   @RequestParam("Image") MultipartFile Image) {
        return Service.Modifier_Client(Id_Clt , Nom_Client, Categorie_Fiscale, Contact, Adresse, Ville, Region, Pays, Email, Site_Web, Banque1, Banque2, Rib1, Rib2, Categorie_Client, Timbre_Fiscal, Tel1, Representant, Bloque_Vente, Solde_Facture, Risque, Plafond, Code_Tva, Tel2, Fax, Type_Piece_Identite, Description, N_Piece_Identite, Date_Livraison_Identite, N_Attestation_Exoneration, Debut_Exoneration, Fin_Exoneration, Reduction_Tva, Image);
    }


    @GetMapping("/Client_Image")
    public ResponseEntity<ByteArrayResource> Client_Image(@RequestParam Long Id_Clt) {
        // Load file from database
        Client dbFile = Service.image(Id_Clt);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getImage_Type()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Clt() + "\"")
                .body(new ByteArrayResource(dbFile.getImage()));
    }

    @RequestMapping(value = "/Liste_Champs_Client", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Client( ) {
        return Service.lister_champ();
    }



    @RequestMapping(value = "/Filtre_Client", method = RequestMethod.GET)
    public  List<Client> Filtre_Client (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);
    }



    @GetMapping("/Exporter_Client")
    public ResponseEntity<ByteArrayResource> Exporter_Client(@RequestParam Long Id_Clt) {
        // Load file from database
        byte[] dbFile = Service.exporter(Id_Clt);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }

    @GetMapping("/Exporter_Clients")
    public ResponseEntity<ByteArrayResource> Exporter_Clients(@RequestParam String Liste ) {
        // Load file from database
        System.out.println(Liste);
        byte[] dbFile = Service.exporters(Liste);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }


    @PostMapping("/Importer_Clients")
    public String  Importer_Clients(@RequestParam("Clients") MultipartFile  Clients )
    {
        return Service.Importers(Clients);
    }

}

