package net.guides.springboot2.springboot2jpacrudexample.controller.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Bon_Livraison;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.service.Vente.Archive_Vente;
import net.guides.springboot2.springboot2jpacrudexample.service.Vente.Bon_Livraison_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class Bon_Livraison_Controller {
    @Autowired
    Bon_Livraison_Service Service;
    @Autowired
    Archive_Vente archive;

    @RequestMapping(value = "/Bon_Livraisons" ,method = RequestMethod.GET)
    public List<Bon_Livraison> Bon_Livraisons() {
        return Service.Bon_Livraisons();
    }

    @RequestMapping(value = "/Bon_Livraison", method = RequestMethod.GET)
    public Object Bon_Livraison (@RequestParam Long Id) {
        return  Service.Bon_Livraison(Id);
    }

    @PostMapping(value = "/Creer_Bon_Livraison")
    public Bon_Livraison Creer_Bon_Livraison (@RequestParam String Id_Clt, @RequestParam String Type, @RequestParam String Etat, @RequestParam double Total_HT_Brut, @RequestParam double Total_Remise, @RequestParam double Total_HT_Net, @RequestParam double Total_Fodec, @RequestParam double Total_Tva, @RequestParam double Total_TTC, @RequestParam double Total_Retenues, @RequestParam String Description, @RequestParam String Id_Responsable, @RequestParam String Mode_Paiement, @RequestParam MultipartFile Detail, @RequestParam double Frais_Livraison, @RequestParam Date Date_Creation)
    {
        return Service.Creer_Bon_Livraison (  Id_Clt,    Type,   Etat,   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,   Total_Retenues,   Description,  Id_Responsable,  Mode_Paiement,   Detail,   Frais_Livraison,   Date_Creation);
    }

    @RequestMapping(value = "/Supprimer_Bon_Livraison", method = RequestMethod.DELETE)
    public String Supprimer_Bon_Livraison(@RequestParam Long Id ) {
        archive.Archive_bl(Id);
        return  "ok";
    }
    @RequestMapping(value = "/Recupererr_Bon_Livraison", method = RequestMethod.GET)
    public String Recupererr_Bon_Livraison(@RequestParam Long Id , @RequestParam Long Id_Archive  ) {
        archive.desarchiver_bl(Id,Id_Archive);
        return  "ok";
    }

    @PostMapping(value = "/Modifier_Bon_Livraison")
    public Bon_Livraison Modifier_Bon_Livraison (@RequestParam Long Id ,  @RequestParam String Id_Clt,@RequestParam String Type, @RequestParam String Etat, @RequestParam double Total_HT_Brut, @RequestParam double Total_Remise, @RequestParam double Total_HT_Net,@RequestParam double Total_Fodec,@RequestParam double Total_Tva,@RequestParam double Total_TTC,@RequestParam double Total_Retenues,@RequestParam String Description,@RequestParam String Id_Responsable,@RequestParam String Mode_Paiement, @RequestParam MultipartFile Detail,@RequestParam double Frais_Livraison,@RequestParam Date Date_Creation)
    {
        return Service.Modifier_Bon_Livraison ( Id , Id_Clt,    Type,   Etat,   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,   Total_Retenues,   Description,  Id_Responsable,  Mode_Paiement,   Detail,   Frais_Livraison,   Date_Creation);
    }

    @RequestMapping(value = "/Liste_Champs_Bon_Livraison", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Bon_Livraison( ) {
        return Service.lister_champ();
    }




    @RequestMapping(value = "/Filtre_Bon_Livraison", method = RequestMethod.GET)
    public  List<Bon_Livraison> Bon_Livraison (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);
    }

    @PostMapping(value = "/Convertire_Devis_en_Bon_Livraison")
    public Bon_Livraison Convertire_Devis_en_Bon_Livraison (@RequestParam long Id_Devis , @RequestParam double Total_Retunes)
    {
        return Service.Convertire_Devis_en_Bon_Livraison (  Id_Devis ,Total_Retunes );
    }

    @PostMapping(value = "/Generate_Bon_Livraison_A_Partire_Devis")
    public Bon_Livraison Generate_Bon_Livraison_A_Partire_Devis (@RequestParam long Id_Devis, @RequestParam MultipartFile Detail , @RequestParam double Total_Retunes   )
    {
        return Service.Generate_Bon_Livraison_A_Partire_Devis (  Id_Devis ,Detail ,Total_Retunes );
    }
    @GetMapping("/Detail_Bon_Livraison")
    public ResponseEntity<ByteArrayResource> Detail_Bon_Livraison(@RequestParam Long Id_BL) {
        // Load file from database
        Bon_Livraison dbFile = Service.Detail(Id_BL);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bl() + "\"")
                .body(new ByteArrayResource(dbFile.getDetail()));
    }
    @RequestMapping(value = "/Filtre_Bon_Livraison_Par_Client_Date", method = RequestMethod.GET)
    public  List<Bon_Livraison> Filtre_Devis_Par_Client_Date (@RequestParam Long client, @RequestParam Date date) {
         return Service.Filtre_Par_Client_Date(client, date);
    }

    @RequestMapping(value = "/Filtre_Bon_Livraison_Par_Client_Date_Etat", method = RequestMethod.GET)
    public  List<Bon_Livraison> Filtre_Devis_Par_Client_Date_etat (@RequestParam Long client, @RequestParam Date date ,@RequestParam String Etat) {
        return Service.Filtre_Par_Client_Date_etat(client, date,Etat);
    }
    @RequestMapping(value = "/Filtre_Bon_Livraison_Par_Client_Date1_Date2", method = RequestMethod.GET)
    public  List<Bon_Livraison> Filtre_Devis_Par_Client_Date1_Date2 (@RequestParam Long Client, @RequestParam Date Date1 , @RequestParam Date Date2) {

        return Service.Filtre_Bon_Livraison_Par_Client_Date1_Date2(Client, Date1,Date2);
    }



    @PostMapping(value = "/Sortie_Produits_BL_Stock")
    public  String Sortie_Produits_BL_Stock (@RequestParam long Id )
    {
        return Service.Sortie_Produits_BL_Stock (Id  );
    }

    @PostMapping(value = "/Abandonner_BL")
    public  String Abandonner_BL (@RequestParam long Id )
    {
        return Service.Abandonner_BL (Id  );
    }



}