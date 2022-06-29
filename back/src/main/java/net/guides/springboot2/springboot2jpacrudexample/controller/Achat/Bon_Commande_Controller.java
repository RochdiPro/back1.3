package net.guides.springboot2.springboot2jpacrudexample.controller.Achat;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Bon_Commande;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.Bon_Commande_Service;
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
public class Bon_Commande_Controller {

    @Autowired
    Bon_Commande_Service Service;

    @RequestMapping(value = "/Bon_Commandes" ,method = RequestMethod.GET)
    public List<Bon_Commande> Bon_Commandes() {
        return Service.Tous();
    }


    @RequestMapping(value = "/Bon_Commande", method = RequestMethod.GET)
    public Object Fiche_Produit(@RequestParam Long Id_Bon) {
        return  Service.Bon_Commande(Id_Bon);
    }



    @PostMapping(value = "/Creer_Bon_Commande")
    public Bon_Commande Creer_Fiche_Bon_Entree_Local (    @RequestParam  String Id_Responsable, @RequestParam  String Id_Fr,  @RequestParam Date Date,  @RequestParam String Type_Reglement, @RequestParam  String Email, @RequestParam  String Mode_Livraison,@RequestParam  Date Date_Livraison,@RequestParam  String Contact, @RequestParam  int Marge_Jour, @RequestParam  double Court, @RequestParam  double  Total_HT_Net, @RequestParam  double Total_Fodec, @RequestParam  double Total_Tva,@RequestParam  double Total_TTC, @RequestParam  String Devise, @RequestParam  String Description,  @RequestParam ("Details") MultipartFile Details) {
        return Service.Creer_Bon_Commande(Id_Responsable, Id_Fr, Date, Type_Reglement, Email, Mode_Livraison, Date_Livraison, Contact, Marge_Jour, Court, Total_HT_Net, Total_Fodec, Total_Tva, Total_TTC, Devise, Description, Details);
    }

    @RequestMapping(value = "/Supprimer_Bon_Commande", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete_Bon_Entree_Locale(@RequestParam Long Id_Bon) {
        return Service.Supprimer_Bon_Commande(Id_Bon);
    }

     @PostMapping(value = "/Modifier_Bon_Commande")
    public Bon_Commande Modifier_Fiche_Bon_Entree_Local (@RequestParam Long Id_Bon ,  @RequestParam  String Id_Responsable, @RequestParam  String Id_Fr,  @RequestParam Date Date,  @RequestParam String Type_Reglement, @RequestParam  String Email, @RequestParam  String Mode_Livraison,@RequestParam  Date Date_Livraison,@RequestParam  String Contact, @RequestParam  int Marge_Jour, @RequestParam  double Court, @RequestParam  double  Total_HT_Net, @RequestParam  double Total_Fodec, @RequestParam  double Total_Tva,@RequestParam  double Total_TTC, @RequestParam  String Devise, @RequestParam  String Description,  @RequestParam ("Details") MultipartFile Details) {
        return Service.Modifier_Bon_Commande ( Id_Bon, Id_Responsable, Id_Fr, Date, Type_Reglement, Email, Mode_Livraison, Date_Livraison, Contact, Marge_Jour, Court, Total_HT_Net, Total_Fodec, Total_Tva, Total_TTC, Devise, Description, Details);
     }

     @GetMapping("/Detail_Bon_Commande")
    public ResponseEntity<ByteArrayResource> Produit_Image(@RequestParam Long Id_Bon) {
        // Load file from database
        Bon_Commande dbFile = Service.Detail(Id_Bon);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType_Detail()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bon_Commande() + "\"")
                .body(new ByteArrayResource(dbFile.getDetails()));
    }

    @RequestMapping(value = "/Liste_Champs_Bon_Commande", method = RequestMethod.GET)
    public  List<String> Liste_Champs  ( ) {
        return Service.lister_champ();

    }

    /*
    @RequestMapping(value = "/Filtre_Bon_Commande", method = RequestMethod.GET)
    public  List<Bon_Commande> filtre (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);

    }*/

}
