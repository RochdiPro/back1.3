package net.guides.springboot2.springboot2jpacrudexample.controller.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Bon_Commande_Client;
import net.guides.springboot2.springboot2jpacrudexample.service.Vente.Bon_Commande_Client_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
@RestController
public class Bon_Commande_Client_Controller {
    @Autowired
    Bon_Commande_Client_Service Service;


    @RequestMapping(value = "/Bon_Commande_Clients" ,method = RequestMethod.GET)
    public List<Bon_Commande_Client> Bon_Commande_Clients() {
        return Service.Bon_Commande_Clients();
    }

    @RequestMapping(value = "/Bon_Commande_Client", method = RequestMethod.GET)
    public Object Bon_Commande_Client(@RequestParam Long Id ) {
        return  Service.Bon_Commande_Client(Id );
    }


    @PostMapping(value = "/Creer_Bon_Commande_Client")
    public Bon_Commande_Client Creer_Bon_Commande_Client (@RequestParam String Id_Clt, @RequestParam String Type, @RequestParam String Etat, @RequestParam double Total_HT_Brut, @RequestParam double Total_Remise, @RequestParam double Total_HT_Net, @RequestParam double Total_Fodec, @RequestParam double Total_Tva, @RequestParam double Total_TTC, @RequestParam double Total_Retenues, @RequestParam String Description, @RequestParam String Id_Responsable, @RequestParam String Mode_Paiement, @RequestParam MultipartFile Detail, @RequestParam double Frais_Livraison, @RequestParam Date Date_Creation)
    {
        return Service.Creer_Bon_Commande_Client (  Id_Clt,    Type,   Etat,   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,   Total_Retenues,   Description,  Id_Responsable,  Mode_Paiement,   Detail,   Frais_Livraison,   Date_Creation);
    }

    @RequestMapping(value = "/Supprimer_Bon_Commande_Client", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Devis(@RequestParam Long Id ) {
        return Service.Supprimer_Bon_Commande_Client(Id );
    }


    @PostMapping(value = "/Modifier_Bon_Commande_Client")
    public Bon_Commande_Client Modifier_Devis (@RequestParam Long Id ,  @RequestParam String Id_Clt,@RequestParam String Type, @RequestParam String Etat, @RequestParam double Total_HT_Brut, @RequestParam double Total_Remise, @RequestParam double Total_HT_Net,@RequestParam double Total_Fodec,@RequestParam double Total_Tva,@RequestParam double Total_TTC,@RequestParam double Total_Retenues,@RequestParam String Description,@RequestParam String Id_Responsable,@RequestParam String Mode_Paiement, @RequestParam MultipartFile Detail,@RequestParam double Frais_Livraison,@RequestParam Date Date_Creation)
    {
        return Service.Modifier_Bon_Commande_Client ( Id , Id_Clt,    Type,   Etat,   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,   Total_Retenues,   Description,  Id_Responsable,  Mode_Paiement,   Detail,   Frais_Livraison,   Date_Creation);
    }

    @RequestMapping(value = "/Liste_Champs_Bon_Commande_Client", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Devis( ) {
        return Service.lister_champ();
    }
}
