package net.guides.springboot2.springboot2jpacrudexample.controller.Achat;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Fiche_BEL;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Quantite_Fiche_Technique;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.Fiche_BEL_Service;
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
public class Fiche_BEL_Controller {
    @Autowired
    Fiche_BEL_Service Service;

    @RequestMapping(value = "/Quantite_Fiche_Technique_Fiche_Bon_Entree_Local" ,method = RequestMethod.GET)
    public List<Quantite_Fiche_Technique> Fiche_Bon_Entree_Locals(@RequestParam Long Id_Bon) {
        return Service.Quantite_Fiche_Technique(Id_Bon);
    }

    @RequestMapping(value = "/Fiche_Bon_Entree_Locals" ,method = RequestMethod.GET)
    public List<Fiche_BEL> Fiche_Bon_Entree_Locals() {
        return Service.Tous();
    }



    @RequestMapping(value = "/Fiche_Bon_Entree_Local", method = RequestMethod.GET)
    public Object Fiche_Produit(@RequestParam Long Id_Bon) {
        return  Service.Fiche_BEL(Id_Bon);
    }


        @PostMapping(value = "/Creer_Fiche_Bon_Entree_Local")
        public Fiche_BEL Creer_Fiche_Bon_Entree_Local ( @RequestParam String Id_Fr,  @RequestParam String Mode_Paiement,  @RequestParam double Charge_Transport,  @RequestParam double Autre_Charge_Fixe,  @RequestParam String Ag_Ttransport,  @RequestParam String Type,  @RequestParam String N_Facture,     @RequestParam Date Date_BEL,  @RequestParam String Etat,@RequestParam String Description,@RequestParam String Local ,  @RequestParam String id_Responsable,  @RequestParam("Details") MultipartFile  Details ,  @RequestParam double Total_HT_Brut,  @RequestParam double Total_Remise, @RequestParam double Total_HT_Net, @RequestParam double Total_Fodec,  @RequestParam double Total_Tva,  @RequestParam double Total_TTC, @RequestParam double Total_R_HT, @RequestParam  double Total_R_TTC) {

            return Service.Creer_Fiche_Bon_Entree_Local (Id_Fr,   Mode_Paiement,   Charge_Transport ,   Autre_Charge_Fixe ,   Ag_Ttransport,   Type,   N_Facture,      Date_BEL,     Etat,   Description,   Local , id_Responsable, Details.getContentType(),   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,   Total_R_HT,   Total_R_TTC, Details  );
        }

        @RequestMapping(value = "/Supprimer_Fiche_Bon_Entree_Local", method = RequestMethod.DELETE)
        public ResponseEntity<Object> Delete_Bon_Entree_Locale(@RequestParam Long Id_Bon) {
            return Service.Supprimer_Fiche_Bon_Entree_Local(Id_Bon);
        }
        

    @PostMapping(value = "/Modifier_Fiche_Bon_Entree_Local")
    public Fiche_BEL Modifier_Fiche_Bon_Entree_Local (@RequestParam Long Id_Bon,  @RequestParam String Id_Fr,  @RequestParam String Mode_Paiement,  @RequestParam double Charge_Transport,  @RequestParam double Autre_Charge_Fixe,  @RequestParam String Ag_Ttransport,  @RequestParam String Type,  @RequestParam String N_Facture,     @RequestParam Date Date_BEL,  @RequestParam String Etat,@RequestParam String Description,@RequestParam String Local ,  @RequestParam String id_Responsable,  @RequestParam("Details") MultipartFile  Details ,  @RequestParam double Total_HT_Brut,  @RequestParam double Total_Remise, @RequestParam double Total_HT_Net, @RequestParam double Total_Fodec,  @RequestParam double Total_Tva,  @RequestParam double Total_TTC, @RequestParam double Total_R_HT, @RequestParam  double Total_R_TTC) {

        return Service.Modifier_Fiche_Bon_Entree_Local ( Id_Bon,Id_Fr,   Mode_Paiement,   Charge_Transport ,   Autre_Charge_Fixe ,   Ag_Ttransport,   Type,   N_Facture,      Date_BEL,     Etat,   Description,   Local , id_Responsable, Details.getContentType(),   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,   Total_R_HT,   Total_R_TTC, Details  );
    }


    @GetMapping("/Detail_Fiche_Bon_Entree_Local")
    public ResponseEntity<ByteArrayResource> Detail_Fiche_Bon_Entree_Local(@RequestParam Long Id_Bon) {
        // Load file from database
        Fiche_BEL dbFile = Service.Detail(Id_Bon);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType_Detail()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bon_Entree_Local() + "\"")
                .body(new ByteArrayResource(dbFile.getDetails()));
    }

    @RequestMapping(value = "/Liste_Champs_Fiche_Bon_Entree_Local", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Depot ( ) {
        return Service.lister_champ();
    }


    @RequestMapping(value = "/Filtre_Fiche_Bon_Entree_Local", method = RequestMethod.GET)
    public  List<Fiche_BEL> filtre (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);
    }

    @PostMapping(value = "/Entree_Fiche_Bon_Entree_Local_Au_Stock")
    public String Entree_Stock ( @RequestParam Long Id_Bon)
    {
        return Service.Entree_Fiche_Bon_Entree_Local_Au_Stock (Id_Bon  );
    }



    @PostMapping(value = "/Archiver_Fiche_Bon_Entree_Local")
    public String Archiver_Fiche_Bon_Entree_Local ( @RequestParam Long Id_Bon)
    {
        return Service.Archiver_Fiche_Bon_Entree_Local (Id_Bon  );
    }

    @RequestMapping(value = "/Fiche_Bon_Entree_Local_En_Cours", method = RequestMethod.GET)
    public  List<Fiche_BEL> Fiche_Bon_Entree_Local_En_Cours ( ) {
        return Service.Fiche_Bon_Entree_Local_En_Cours( );
    }

}
