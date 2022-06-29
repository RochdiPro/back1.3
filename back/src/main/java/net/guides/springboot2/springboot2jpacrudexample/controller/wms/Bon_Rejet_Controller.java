package net.guides.springboot2.springboot2jpacrudexample.controller.wms;

import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Reception;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Rejet;
import net.guides.springboot2.springboot2jpacrudexample.service.wms.Bon_Reception_Service;
import net.guides.springboot2.springboot2jpacrudexample.service.wms.Bon_Rejet_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
public class Bon_Rejet_Controller {

    @Autowired
    Bon_Rejet_Service Service;

    @RequestMapping(value = "/Bon_Rejets" ,method = RequestMethod.GET)
    public List<Bon_Rejet> Bon_Receptions() {
        return Service.Bon_Rejets();
    }

    @RequestMapping(value = "/Bon_Rejet", method = RequestMethod.GET)
    public Object Bon_Rejet(@RequestParam Long Id) {
        return  Service.Bon_Rejet(Id);
    }


    @PostMapping(value = "/Creer_Bon_Rejet")
    public Bon_Rejet Creer_Bon_Reception ( @RequestParam String Local,@RequestParam String Id_Bon, @RequestParam String Type_Bon, @RequestParam String Etat, @RequestParam String Responsable,@RequestParam String Reclamations,   @RequestParam MultipartFile Detail )
    {
        return Service.Creer_Bon_Rejet  ( Local,   Id_Bon,   Type_Bon,   Etat,   Responsable,  Reclamations, Detail );
    }

    @RequestMapping(value = "/Supprimer_Bon_Rejet", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Bon_Reception(@RequestParam Long Id ) {
        return Service.Supprimer_Bon_Rejet(Id );
    }


    @PostMapping(value = "/Modifier_Bon_Rejet")
    public Bon_Rejet Modifier_Bon_Reception (@RequestParam Long Id ,  @RequestParam String Local,@RequestParam String Id_Bon, @RequestParam String Type_Be, @RequestParam String Etat, @RequestParam String Responsable,  @RequestParam String Reclamations, @RequestParam MultipartFile Detail )
    {
        return Service.Modifier_Bon_Rejet ( Id   , Local,   Id_Bon,   Type_Be,   Etat,   Responsable,  Reclamations, Detail );
    }


        @RequestMapping(value = "/Liste_Champs_Bon_Rejet", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Devis( ) {
        return Service.lister_champ();
    }


    @RequestMapping(value = "/Filtre_Bon_Rejet", method = RequestMethod.GET)
    public  List<Bon_Rejet> Filtre_Client (@RequestParam String Champ1, @RequestParam String Valeur1 ,@RequestParam String Champ2, @RequestParam String Valeur2,@RequestParam String Champ3, @RequestParam String Valeur3) {
        return Service.filtre(Champ1, Valeur1,Champ2, Valeur2,Champ3, Valeur3);
    }

    @GetMapping("/Detail_Bon_Rejet")
    public ResponseEntity<ByteArrayResource> Detail_Devis(@RequestParam Long Id ) {
        // Load file from database
        Bon_Rejet dbFile = Service.Detail(Id );

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId() + "\"")
                .body(new ByteArrayResource(dbFile.getDetail()));
    }
}

