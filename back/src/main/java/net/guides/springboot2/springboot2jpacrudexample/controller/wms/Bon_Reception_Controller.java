package net.guides.springboot2.springboot2jpacrudexample.controller.wms;


import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Reception;
 import net.guides.springboot2.springboot2jpacrudexample.service.wms.Bon_Reception_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
 import java.util.List;

@RestController
public class Bon_Reception_Controller {

    @Autowired
    Bon_Reception_Service Service;

    @RequestMapping(value = "/Bon_Receptions" ,method = RequestMethod.GET)
    public List<Bon_Reception> Bon_Receptions() {
        return Service.Bon_Receptions();
    }

    @RequestMapping(value = "/Bon_Receptions_En_Cours" ,method = RequestMethod.GET)
    public List<Bon_Reception> Bon_Receptions_En_Cours() {
        return Service.Bon_Receptions_En_Cours();
    }

    @RequestMapping(value = "/Bon_Reception", method = RequestMethod.GET)
    public Object Bon_Reception(@RequestParam Long Id) {
        return  Service.Bon_Reception(Id);
    }


    @PostMapping(value = "/Creer_Bon_Reception")
    public Bon_Reception Creer_Bon_Reception ( @RequestParam String Local,@RequestParam Long Id_Be, @RequestParam String Type_Be, @RequestParam String Etat, @RequestParam String Responsable,  @RequestParam MultipartFile Detail ,@RequestParam int Nb_Support)
    {

        return Service.Creer_Bon_Reception  ( Local,   Id_Be,   Type_Be,   Etat,   Responsable,   Detail ,   Nb_Support );
    }

    @RequestMapping(value = "/Supprimer_Bon_Reception", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Bon_Reception(@RequestParam Long Id ) {
        return Service.Supprimer_Bon_Reception(Id );
    }

    @PostMapping(value = "/Modifier_Bon_Reception")
    public Bon_Reception Modifier_Bon_Reception (@RequestParam Long Id ,  @RequestParam String Local,@RequestParam Long Id_Be, @RequestParam String Type_Be, @RequestParam String Etat, @RequestParam String Responsable,  @RequestParam MultipartFile Detail,@RequestParam Integer Nb_Support )
    {
        return Service.Modifier_Bon_Reception ( Id ,Local,   Id_Be,   Type_Be,   Etat,   Responsable,   Detail ,Nb_Support);
    }

    @RequestMapping(value = "/Liste_Champs_Bon_Reception", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Devis( ) {
        return Service.lister_champ();
    }


    @GetMapping("/Detail_Bon_Reception")
    public ResponseEntity<ByteArrayResource> Detail_Devis(@RequestParam Long Id) {
        // Load file from database
        Bon_Reception dbFile = Service.Detail(Id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId() + "\"")
                .body(new ByteArrayResource(dbFile.getDetail()));
    }

    @RequestMapping(value = "/Filtre_Bon_Reception", method = RequestMethod.GET)
    public  List<Bon_Reception> Filtre_bon (@RequestParam String Champ1, @RequestParam String Valeur1 ,@RequestParam String Champ2, @RequestParam String Valeur2,@RequestParam String Champ3, @RequestParam String Valeur3,@RequestParam String Champ4, @RequestParam String Valeur4) {
        return Service.filtre(Champ1, Valeur1,Champ2, Valeur2,Champ3, Valeur3,Champ4, Valeur4);
    }
}


