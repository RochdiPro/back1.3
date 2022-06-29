package net.guides.springboot2.springboot2jpacrudexample.controller.Achat;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Fiche_BEI;
import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Fiche_BEL;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Quantite_Fiche_Technique;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.Fiche_BEI_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.soap.Detail;
import java.util.Date;
import java.util.List;

@RestController
public class Fiche_BEI_Controller {

    @Autowired
    Fiche_BEI_Service Service;
    private MultipartFile Details;


    @RequestMapping(value = "/Fiche_Bon_Entree_Importations", method = RequestMethod.GET)
    public List<Fiche_BEI> Fiche_Bon_Entree_Importations() {
        return Service.Tous();
    }


    @RequestMapping(value = "/Fiche_Bon_Entree_Importation", method = RequestMethod.GET)
    public Object fiche_Importation(@RequestParam Long Id_Bon) {
        return Service.Fiche_Bon_Entree_Importation(Id_Bon);
    }


    @PostMapping(value = "/Creer_Fiche_Bon_Entree_Importation"     )
    public Fiche_BEI Creer_Fiche_Bon_Entree_Importation(@RequestParam String Id_Fr,  @RequestParam String Mode_Paiement,  @RequestParam double Charge_Transport,  @RequestParam double Autre_Charge_Fixe,  @RequestParam String Ag_Transport,
                                                        @RequestParam String Type,  @RequestParam String N_Facture,      @RequestParam double Totale_Declare, @RequestParam double Total_Fodec,
                                                        @RequestParam double Total_Tva,@RequestParam String Etat,@RequestParam String Description,@RequestParam String Local ,  @RequestParam String Id_Responsable, @RequestParam double Total_R_HT ,
                                                        @RequestParam String Titre,  @RequestParam String Transfert,  @RequestParam String Lc,   @RequestParam String Fed,
                                                        @RequestParam String Mode_Livraison,  @RequestParam String Type_Livraison,  @RequestParam double Charge_Transitaire,  @RequestParam double Charge_Banque,  @RequestParam double Charge_Magasin,
                                                        @RequestParam double Pinalite,  @RequestParam String Ag_Transitaire,  @RequestParam double Totale_Taxe,  @RequestParam String N_Preforma,
                                                        @RequestParam Date Date_Proforma,  @RequestParam Date Date_Facture,  @RequestParam Date Date_Livraison, @RequestParam  Date Date_Paiement,  @RequestParam Date Date_Be,  @RequestParam double Charge_Transport_Importation,
                                                        @RequestParam double Charge_Assurance_Importation, @RequestParam double Court,  @RequestParam String Devise,  @RequestParam boolean Transport_Inclut, @RequestParam MultipartFile Details , @RequestParam MultipartFile Doc_Banque , @RequestParam MultipartFile Doc_Importation , @RequestParam MultipartFile Doc_Transitaire , @RequestParam MultipartFile Doc_Transport ) {

        return Service.Creer_Fiche_Bon_Entree_Importation  (Id_Responsable, Id_Fr,  Mode_Paiement, Charge_Transport,  Autre_Charge_Fixe,  Ag_Transport,  Type,  N_Facture,   Etat, Description, Local, Titre,  Transfert, Lc, Fed,  Mode_Livraison, Type_Livraison,  Charge_Transitaire, Charge_Banque, Charge_Magasin,  Ag_Transitaire, N_Preforma,  Date_Proforma, Date_Facture, Date_Livraison,Date_Paiement, Date_Be,   Charge_Transport_Importation, Charge_Assurance_Importation,  Court,  Devise,  Transport_Inclut,Total_Fodec,  Total_Tva,    Total_R_HT, Totale_Declare,  Totale_Taxe, Total_Tva,  Pinalite, Details ,  Doc_Banque , Doc_Importation , Doc_Transitaire , Doc_Transport);

    }

    @GetMapping("/Detail_Fiche_Bon_Entree_Importation")
    public ResponseEntity<ByteArrayResource> Detail_Fiche_Bon_Entree(@RequestParam Long Id_Bon) {
        // Load file from database
        Fiche_BEI dbFile = Service.Detail(Id_Bon);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType_Detail()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bon() + "\"")
                .body(new ByteArrayResource(dbFile.getDetails()));
    }

    @GetMapping("/Document_Banque_Fiche_Bon_Entree_Importation")
    public ResponseEntity<ByteArrayResource> Document_Banque_Fiche_Bon_Entree_Importation(@RequestParam Long Id_Bon) {
        // Load file from database
        Fiche_BEI dbFile = Service.Detail(Id_Bon);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType_Doc_Banque()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bon() + "\"")
                .body(new ByteArrayResource(dbFile.getDoc_Banque()));
    }

    @GetMapping("/Document_Importation_Fiche_Bon_Entree_Importation")
    public ResponseEntity<ByteArrayResource> Document_Importation_Fiche_Bon_Entree_Importation(@RequestParam Long Id_Bon) {
        // Load file from database
        Fiche_BEI dbFile = Service.Detail(Id_Bon);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType_Doc_Importation()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bon() + "\"")
                .body(new ByteArrayResource(dbFile.getDoc_Importation()));
    }

    @GetMapping("/Document_Transitaire_Fiche_Bon_Entree_Importation")
    public ResponseEntity<ByteArrayResource> Document_Transitaire_Fiche_Bon_Entree_Importation(@RequestParam Long Id_Bon) {
        // Load file from database
        Fiche_BEI dbFile = Service.Detail(Id_Bon);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType_Doc_Transitaire()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bon() + "\"")
                .body(new ByteArrayResource(dbFile.getDoc_Transitaire()));
    }

    @GetMapping("/Document_Transport_Fiche_Bon_Entree_Importation")
    public ResponseEntity<ByteArrayResource> Document_Transport_Fiche_Bon_Entree_Importation(@RequestParam Long Id_Bon) {
        // Load file from database
        Fiche_BEI dbFile = Service.Detail(Id_Bon);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType_Doc_Transport()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bon() + "\"")
                .body(new ByteArrayResource(dbFile.getDoc_Transport()));
    }





    @RequestMapping(value = "/Supprimer_Fiche_Bon_Entree_Importation", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete_Bon_Entree_Importation(@RequestParam Long Id_Bon) {
        return Service.Supprimer_Fiche_Bon_Entree_Importation(Id_Bon);
    }

    @RequestMapping(value = "/Liste_Champs_Fiche_Bon_Entree_Importation", method = RequestMethod.GET)
    public List<String> Liste_Champs () {
        return Service.lister_champ();
    }


   @PostMapping(value = "/Modifier_Fiche_Bon_Entree_Importation")
    public Fiche_BEI Modifier_Fiche_Bon_Entree_Importation(  @RequestParam long Id_Bon , @RequestParam String Id_Fr,  @RequestParam String Mode_Paiement,  @RequestParam double Charge_Transport,  @RequestParam double Autre_Charge_Fixe,  @RequestParam String Ag_Transport,
                                                             @RequestParam String Type,  @RequestParam String N_Facture,      @RequestParam double Totale_Declare, @RequestParam double Total_Fodec,
                                                             @RequestParam double Total_Tva,@RequestParam String Etat,@RequestParam String Description,@RequestParam String Local ,  @RequestParam String Id_Responsable, @RequestParam double Total_R_HT ,
                                                             @RequestParam String Titre,  @RequestParam String Transfert,  @RequestParam String Lc,   @RequestParam String Fed,
                                                             @RequestParam String Mode_Livraison,  @RequestParam String Type_Livraison,  @RequestParam double Charge_Transitaire,  @RequestParam double Charge_Banque,  @RequestParam double Charge_Magasin,
                                                             @RequestParam double Pinalite,  @RequestParam String Ag_Transitaire,  @RequestParam double Totale_Taxe,  @RequestParam String N_Preforma,
                                                             @RequestParam Date Date_Proforma,  @RequestParam Date Date_Facture,  @RequestParam Date Date_Livraison, @RequestParam  Date Date_Paiement,  @RequestParam Date Date_Be,  @RequestParam double Charge_Transport_Importation,
                                                             @RequestParam double Charge_Assurance_Importation, @RequestParam double Court,  @RequestParam String Devise,  @RequestParam boolean Transport_Inclut, @RequestParam MultipartFile Details ,  MultipartFile Doc_Banque ,  MultipartFile Doc_Importation ,  MultipartFile Doc_Transitaire ,   MultipartFile Doc_Transport ) {

       return Service.Modifier_Fiche_Bon_Entree_Importation(Id_Bon ,Id_Responsable, Id_Fr,  Mode_Paiement, Charge_Transport,  Autre_Charge_Fixe,  Ag_Transport,  Type,  N_Facture,   Etat, Description, Local, Titre,  Transfert, Lc, Fed,  Mode_Livraison, Type_Livraison,  Charge_Transitaire, Charge_Banque, Charge_Magasin,  Ag_Transitaire, N_Preforma,  Date_Proforma, Date_Facture, Date_Livraison,Date_Paiement, Date_Be,   Charge_Transport_Importation, Charge_Assurance_Importation,  Court,  Devise,  Transport_Inclut,Total_Fodec,  Total_Tva,    Total_R_HT, Totale_Declare,  Totale_Taxe, Total_Tva,  Pinalite, Details ,  Doc_Banque , Doc_Importation , Doc_Transitaire , Doc_Transport);

   }

    @RequestMapping(value = "/Filtre_Fiche_Bon_Entree_Importation", method = RequestMethod.GET)
    public List<Fiche_BEI> filtre(@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);

    }

    @RequestMapping(value = "/Quantite_Fiche_Technique_Fiche_Bon_Entree_Importation" ,method = RequestMethod.GET)
    public List<Quantite_Fiche_Technique> Fiche_Bon_Entree_Locals(@RequestParam Long Id_Bon) {
        return Service.Quantite_Fiche_Technique(Id_Bon);
    }

    @PostMapping(value = "/Entree_Fiche_Bon_Entree_Importation_Au_Stock")
    public String Entree_Stock ( @RequestParam Long Id_Bon)
    {
        return Service.Entree_Fiche_Bon_Entree_iMPORTATION_Au_Stock (Id_Bon  );
    }

    @PostMapping(value = "/Archiver_Fiche_Bon_Entree_Importation")
    public String Archiver_Fiche_Bon_Entree_Importation( @RequestParam Long Id_Bon)
    {
        return Service.Archiver_Fiche_Bon_Entree_Importation (Id_Bon  );
    }

    @RequestMapping(value = "/Fiche_Bon_Entree_Importation_En_Cours", method = RequestMethod.GET)
    public  List<Fiche_BEI> Fiche_Bon_Entree_Local_En_Cours ( ) {
        return Service.Fiche_Bon_Entree_Importation_En_Cours( );
    }
}