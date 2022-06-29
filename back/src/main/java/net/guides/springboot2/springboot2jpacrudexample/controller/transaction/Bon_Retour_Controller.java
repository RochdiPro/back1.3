package net.guides.springboot2.springboot2jpacrudexample.controller.transaction;

import net.guides.springboot2.springboot2jpacrudexample.model.wms.Quantite_Fiche_Technique;
import net.guides.springboot2.springboot2jpacrudexample.service.transaction.Bon_retour_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class Bon_Retour_Controller {

    @Autowired
    Bon_retour_Service Service  ;


    @RequestMapping(value = "/Bon_Retours" ,method = RequestMethod.GET)
    public List<net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Retour> Bon_Retours() {
        return Service.Bon_Retours();
    }

    @RequestMapping(value = "/Bon_Retour", method = RequestMethod.GET)
    public Object Bon_Retour(@RequestParam Long Id) {
        return  Service.Bon_Retour(Id);
    }


    @PostMapping(value = "/Creer_Bon_Retour")
    public net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Retour Creer_Bon_Retour (@RequestParam  String Id_Clt, @RequestParam  String N_Facture   , @RequestParam  String Description, @RequestParam  String Local, @RequestParam  String Id_Responsable  , @RequestParam   MultipartFile Detail )
    {
        return Service.Creer_Bon_Retour(   Id_Clt, N_Facture,  Description, Local,Id_Responsable  , Detail);
    }

    @RequestMapping(value = "/Supprimer_Bon_Retour", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Bon_Retour(@RequestParam Long Id ) {
        return Service.Supprimer_Bon_Retour(Id );
    }


  /*  @PostMapping(value = "/Modifier_Bon_Retour")
    public net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Retour Modifier_Bon_Transfert(@RequestParam Long Id , @RequestParam  String Id_Clt, @RequestParam  String N_Facture, @RequestParam  String Date, @RequestParam  double Totale, @RequestParam  double Totale_Tva, @RequestParam  String Description, @RequestParam  String Local, @RequestParam  String Id_Responsable  , @RequestParam   MultipartFile Detail )
    {
        return Service.Modifier_Bon_Retour ( Id , Id_Clt, N_Facture, Date,  Totale,Totale_Tva,Description, Local,Id_Responsable  , Detail);
    }
*/
    @RequestMapping(value = "/Liste_Champs_Bon_Retour", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Devis( ) {
        return Service.lister_champ();
    }


    @RequestMapping(value = "/Quantite_Fiche_Technique_Fiche_Bon_Retour" ,method = RequestMethod.GET)
    public List<Quantite_Fiche_Technique> Fiche_Bon_Entree_Locals(@RequestParam Long Id_Bon) {
        return Service.Quantite_Fiche_Technique(Id_Bon);
    }

    @GetMapping("/Detail_Bon_Retour")
    public ResponseEntity<ByteArrayResource> Detail_Fiche_Bon_Entree(@RequestParam Long Id_Bon) {
        // Load file from database
        net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Retour dbFile = Service.Detail(Id_Bon);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType_Detail()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bon_Retour() + "\"")
                .body(new ByteArrayResource(dbFile.getDetails()));
    }

    @RequestMapping(value = "/Filtre_Bon_Retour", method = RequestMethod.GET)
    public  List<net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Retour> Filtre_bon (@RequestParam String Champ1, @RequestParam String Valeur1 , @RequestParam String Champ2, @RequestParam String Valeur2, @RequestParam String Champ3, @RequestParam String Valeur3 ,@RequestParam String Champ4, @RequestParam String Valeur4) {
        return Service.filtre(Champ1, Valeur1,Champ2, Valeur2,Champ3, Valeur3 ,Champ4 , Valeur4);
    }

    @RequestMapping(value = "/Bon_Retour_En_Cours" ,method = RequestMethod.GET)
    public List<net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Retour> Bon_Retour_En_Cours() {
        return Service.Bon_Retour_En_Cours();
    }
    @PostMapping(value = "/Archiver_Bon_Retour" )
    public String Archiver_Bon_Retour(@RequestParam Long Id_Bon){
        return Service.Archiver_Bon_Retour(Id_Bon);
    }

}
