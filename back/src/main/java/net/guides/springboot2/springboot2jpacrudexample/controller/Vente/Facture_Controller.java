package net.guides.springboot2.springboot2jpacrudexample.controller.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Bon_Livraison;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Facture;
import net.guides.springboot2.springboot2jpacrudexample.service.Vente.Archive_Vente;
import net.guides.springboot2.springboot2jpacrudexample.service.Vente.Facture_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class Facture_Controller {

    @Autowired
    Facture_Service Service;

    @Autowired
    Archive_Vente archive;

    @RequestMapping(value = "/Factures" ,method = RequestMethod.GET)
    public List<Facture> Factures() {
        return Service.Factures();
    }

    @RequestMapping(value = "/Facture", method = RequestMethod.GET)
    public Object Facture(@RequestParam Long Id) {
        return  Service.Facture(Id);
    }


    @PostMapping(value = "/Creer_Facture")
    public Facture Creer_Facture (@RequestParam double Droit_timbre, @RequestParam String Id_Clt,@RequestParam String Type, @RequestParam String Etat, @RequestParam double Total_HT_Brut, @RequestParam double Total_Remise, @RequestParam double Total_HT_Net,@RequestParam double Total_Fodec,@RequestParam double Total_Tva,@RequestParam double Total_TTC,@RequestParam double Total_Retenues,@RequestParam String Description,@RequestParam String Id_Responsable,@RequestParam String Mode_Paiement,@RequestParam double Frais_Livraison,@RequestParam Date Date_Creation , @RequestParam MultipartFile Detail)
    {
        return Service.Creer_Facture (  Droit_timbre ,  Id_Clt,    Type,   Etat,   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,   Total_Retenues,   Description,  Id_Responsable,  Mode_Paiement,   Frais_Livraison,   Date_Creation ,   Detail);
    }

    @RequestMapping(value = "/Supprimer_Facture", method = RequestMethod.DELETE)
    public String  Supprimer_Facture(@RequestParam Long Id ) {

        archive.Archive_Facture(Id);
        return  "ok";
    }
    @RequestMapping(value = "/Recupererr_Facture", method = RequestMethod.GET)
    public String Recupererr_Facture(@RequestParam Long Id , @RequestParam Long Id_Archive  ) {
        archive.desarchiver_Facture(Id,Id_Archive);
        return  "ok";
    }

    @PostMapping(value = "/Modifier_Facture")
    public Facture Modifier_Facture (@RequestParam Long Id ,@RequestParam double Droit_timbre,   @RequestParam String Id_Clt,@RequestParam String Type, @RequestParam String Etat, @RequestParam double Total_HT_Brut, @RequestParam double Total_Remise, @RequestParam double Total_HT_Net,@RequestParam double Total_Fodec,@RequestParam double Total_Tva,@RequestParam double Total_TTC,@RequestParam double Total_Retenues,@RequestParam String Description,@RequestParam String Id_Responsable,@RequestParam String Mode_Paiement, @RequestParam MultipartFile Detail,@RequestParam double Frais_Livraison,@RequestParam Date Date_Creation)
    {
        return Service.Modifier_Facture ( Id ,Droit_timbre ,  Id_Clt,    Type,   Etat,   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,   Total_Retenues,   Description,  Id_Responsable,  Mode_Paiement,   Frais_Livraison,   Date_Creation ,   Detail);
    }

    @RequestMapping(value = "/Liste_Champs_Facture", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Facture( ) {
        return Service.lister_champ();
    }

    @RequestMapping(value = "/Filtre_Facture", method = RequestMethod.GET)
    public  List<Facture> Bon_Livraison (@RequestParam String Champ, @RequestParam String Valeur) {
        return  Service.filtre(Champ, Valeur);
    }

    @PostMapping(value = "/Convertire_Devis_en_Facture")
    public Facture Convertire_Devis_en_Bon_Livraison (@RequestParam long Id_Devis , @RequestParam  double Total_Retenues )
    {
        return Service.Convertire_Devis_en_Facture (  Id_Devis  ,Total_Retenues );
    }

    @PostMapping(value = "/Detail_BLs_en_Facture")
    public ResponseEntity<ByteArrayResource>  Detail_BLs_en_Facture (@RequestParam String Liste )
    {

        byte[] dbFile = Service.Convertire_BLs_en_Facture(Liste);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));

    }

    @GetMapping("/Detail_Facture")
    public ResponseEntity<ByteArrayResource> Detail_Facture(@RequestParam Long Id_Facture) {
        // Load file from database
        Facture dbFile = Service.Detail(Id_Facture);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Facture() + "\"")
                .body(new ByteArrayResource(dbFile.getDetail()));
    }


    @PostMapping(value = "/Convertire_BLs_en_Facture")
    public Facture Convertire_BLs_en_Facture (@RequestParam String Liste ,@RequestParam double Droit_timbre, @RequestParam String Id_Clt,@RequestParam String Type, @RequestParam String Etat, @RequestParam double Total_HT_Brut, @RequestParam double Total_Remise, @RequestParam double Total_HT_Net,@RequestParam double Total_Fodec,@RequestParam double Total_Tva,@RequestParam double Total_TTC,@RequestParam double Total_Retenues,@RequestParam String Description,@RequestParam String Id_Responsable,@RequestParam String Mode_Paiement,@RequestParam double Frais_Livraison,@RequestParam Date Date_Creation , @RequestParam MultipartFile Detail)
    {
        return Service.Creer_Facture_bls (  Liste,Droit_timbre ,  Id_Clt,    Type,   Etat,   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,   Total_Retenues,   Description,  Id_Responsable,  Mode_Paiement,   Frais_Livraison,   Date_Creation ,   Detail);
    }

    @PostMapping(value = "/Sortie_Produits_Facture_Stock")
    public  String Sortie_Produits_BL_Stock (@RequestParam long Id )
    {
        return Service.Sortie_Produits_BL_Stock (Id  );
    }


    @PostMapping(value = "/Abandonner_Facture")
    public  String Abandonner_Facture (@RequestParam long Id )
    {
        return Service.Abandonner_Facture (Id);
    }

}
