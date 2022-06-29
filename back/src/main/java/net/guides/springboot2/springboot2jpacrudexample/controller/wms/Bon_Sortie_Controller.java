package net.guides.springboot2.springboot2jpacrudexample.controller.wms;

import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Rejet;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Sortie;
import net.guides.springboot2.springboot2jpacrudexample.service.wms.Bon_Rejet_Service;
import net.guides.springboot2.springboot2jpacrudexample.service.wms.Bon_Sortie_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
public class Bon_Sortie_Controller {

    @Autowired
    Bon_Sortie_Service Service;

    @RequestMapping(value = "/Bon_Sorties" ,method = RequestMethod.GET)
    public List<Bon_Sortie> Bon_Sorties() {
        return Service.Bon_Sorties();
    }

    @RequestMapping(value = "/Bon_Sortie", method = RequestMethod.GET)
    public Object Bon_Sortie(@RequestParam Long Id) {
        return  Service.Bon_Sortie(Id);
    }


    @PostMapping(value = "/Creer_Bon_Sortie")
    public Bon_Sortie Creer_Bon_Sortie( @RequestParam String Local , @RequestParam String Responsable,@RequestParam String Reclamations,   @RequestParam MultipartFile Detail )
    {
        return Service.Creer_Bon_Sortie  ( Local,      Responsable,  Reclamations, Detail );
    }

    @RequestMapping(value = "/Supprimer_Bon_Sortie", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Bon_Sortie(@RequestParam Long Id ) {
        return Service.Supprimer_Bon_Sortie(Id );
    }


    @PostMapping(value = "/Modifier_Bon_Sortie")
    public Bon_Sortie Modifier_Bon_Reception (@RequestParam Long Id ,  @RequestParam String Local , @RequestParam String Responsable,  @RequestParam String Reclamations, @RequestParam MultipartFile Detail )
    {
        return Service.Modifier_Bon_Sortie ( Id   , Local,      Responsable,  Reclamations, Detail );
    }


    @RequestMapping(value = "/Liste_Champs_Bon_Sortie", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Bon_Sortie( ) {
        return Service.lister_champ();
    }


    @GetMapping("/Detail_Bon_Sortie")
    public ResponseEntity<ByteArrayResource> Detail_Devis(@RequestParam Long Id ) {
        // Load file from database
        Bon_Sortie dbFile = Service.Detail(Id );

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId() + "\"")
                .body(new ByteArrayResource(dbFile.getDetail()));
    }

    @RequestMapping(value = "/Filtre_Bon_Sortie", method = RequestMethod.GET)
    public  List<Bon_Sortie> Filtre_Bon_Sortie (@RequestParam String Champ1, @RequestParam String Valeur1 ,@RequestParam String Champ2, @RequestParam String Valeur2,@RequestParam String Champ3, @RequestParam String Valeur3) {
        return Service.filtre(Champ1, Valeur1,Champ2, Valeur2,Champ3, Valeur3);
    }
}

