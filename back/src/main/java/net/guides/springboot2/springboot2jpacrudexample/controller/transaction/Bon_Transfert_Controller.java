package net.guides.springboot2.springboot2jpacrudexample.controller.transaction;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Transfert;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Reception;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Quantite_Fiche_Technique;
import net.guides.springboot2.springboot2jpacrudexample.service.transaction.Bon_Transfert_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class Bon_Transfert_Controller {

    @Autowired
    Bon_Transfert_Service Service  ;


    @RequestMapping(value = "/Bon_Transferts" ,method = RequestMethod.GET)
    public List<Bon_Transfert> Bon_Transferts() {
        return Service.Bon_Transferts();
    }

    @RequestMapping(value = "/Bon_Transfert", method = RequestMethod.GET)
    public Object Bon_Transfert(@RequestParam Long Id) {
        return  Service.Bon_Transfert(Id);
    }


    @PostMapping(value = "/Creer_Bon_Transfert")
    public Bon_Transfert Creer_Devis (@RequestParam String Responsable, @RequestParam  String Description, @RequestParam  String Local_Source, @RequestParam  String Local_Destination ,@RequestParam MultipartFile Detail   )
    {
        return Service.Creer_Bon_Transfert (   Responsable,   Description , Local_Source,  Local_Destination,  Detail );
    }

    @RequestMapping(value = "/Supprimer_Bon_Transfert", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Bon_Transfert(@RequestParam Long Id ) {
        return Service.Supprimer_Bon_Transfert(Id );
    }


    @PostMapping(value = "/Modifier_Bon_Transfert")
    public Bon_Transfert Modifier_Bon_Transfert(@RequestParam Long Id ,@RequestParam String  Responsable, @RequestParam  String Description, @RequestParam  String Local_Source, @RequestParam  String Local_Destination ,@RequestParam MultipartFile Detail   )
    {
        return Service.Modifier_Bon_Transfert ( Id ,    Responsable   ,Description , Local_Source,  Local_Destination,  Detail );
    }

    @RequestMapping(value = "/Liste_Champs_Bon_Transfert", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Devis( ) {
        return Service.lister_champ();
    }


    @RequestMapping(value = "/Quantite_Fiche_Technique_Fiche_Bon_Transfert" ,method = RequestMethod.GET)
    public List<Quantite_Fiche_Technique> Fiche_Bon_Entree_Locals(@RequestParam Long Id_Bon) {
        return Service.Quantite_Fiche_Technique(Id_Bon);
    }
    @GetMapping("/Detail_Bon_Transfert")
    public ResponseEntity<ByteArrayResource> Detail_Fiche_Bon_Entree(@RequestParam Long Id_Bon) {
        // Load file from database
       Bon_Transfert dbFile = Service.Detail(Id_Bon);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType_Detail()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Bon_Transfert() + "\"")
                .body(new ByteArrayResource(dbFile.getDetails()));
    }

    @RequestMapping(value = "/Filtre_Bon_Transfert", method = RequestMethod.GET)
    public  List<Bon_Transfert> Filtre_bon (@RequestParam String Champ1, @RequestParam String Valeur1 , @RequestParam String Champ2, @RequestParam String Valeur2, @RequestParam String Champ3, @RequestParam String Valeur3) {
        return Service.filtre(Champ1, Valeur1,Champ2, Valeur2,Champ3, Valeur3 );
    }

    @RequestMapping(value = "/Bon_Transfert_En_Cours" ,method = RequestMethod.GET)
    public List<Bon_Transfert> Bon_Transfert_En_Cours() {
        return Service.Bon_Transfert_En_Cours();
    }
    @PostMapping(value = "/Archiver_Bon_Transfert" )
    public String Archiver_Bon_Transfert(@RequestParam Long Id_Bon){
        return Service.Archiver_Bon_Transfert(Id_Bon);
    }
}

