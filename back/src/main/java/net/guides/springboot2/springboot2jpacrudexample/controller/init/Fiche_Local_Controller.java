package net.guides.springboot2.springboot2jpacrudexample.controller.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Local;
import net.guides.springboot2.springboot2jpacrudexample.service.init.Fiche_local_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class Fiche_Local_Controller {

    @Autowired
    Fiche_local_Service  Service  ;

   @RequestMapping(value = "/Locals" ,method = RequestMethod.GET)
    public List<Fiche_Local> Locals() {
        return Service.Locals();
    }

    @RequestMapping(value = "/Local" ,method = RequestMethod.GET)
    public Optional<Fiche_Local> Depot(@RequestParam Long Id_Local) {
        return Service.Local(Id_Local) ;
    }

    @RequestMapping(value = "/Creer_Local", method = RequestMethod.POST)
    public Fiche_Local Creer_Local ( @RequestParam String Nom_Local , @RequestParam String Categorie_Local, @RequestParam String Description_Local ,  @RequestParam double Largeur ,
                                     @RequestParam  double Profondeur , @RequestParam  double Hauteur , @RequestParam  String Adresse, @RequestParam String Responsable, @RequestParam String Tel, @RequestParam String Fax,
                                     @RequestParam String Email, @RequestParam String Nature_Contrat,@RequestParam Date Date_Debut, @RequestParam java.util.Date Date_Fin,@RequestParam double Frais,@RequestParam String Nature_Frais,
                                     @RequestParam double Latitude,@RequestParam double Longitude,@RequestParam double Surface, @RequestParam  MultipartFile Detail)
    {
        return Service.Creer_Local( Nom_Local,Categorie_Local,Description_Local , Largeur ,Profondeur ,Hauteur, Adresse,  Responsable,   Tel,   Fax, Email,   Nature_Contrat,  Date_Debut,  Date_Fin,  Frais,  Nature_Frais, Latitude,  Longitude, Surface,  Detail);
    }


    @RequestMapping(value = "/Supprimer_Local", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Local(@RequestParam Long Id_Local) {
        return Service.Supprimer_Local(Id_Local);
    }

    @RequestMapping(value = "/Modifier_Local", method = RequestMethod.PUT)
    public Fiche_Local Update_Depot (@RequestParam Long Id_Local, @RequestParam String Nom_Local , @RequestParam String Categorie_Local, @RequestParam String Description_Local ,  @RequestParam double Largeur ,
                                     @RequestParam  double Profondeur , @RequestParam  double Hauteur , @RequestParam  String Adresse, @RequestParam String Responsable, @RequestParam String Tel, @RequestParam String Fax,
                                     @RequestParam String Email, @RequestParam String Nature_Contrat,@RequestParam Date Date_Debut, @RequestParam java.util.Date Date_Fin,@RequestParam double Frais,@RequestParam String Nature_Frais,
                                     @RequestParam double Latitude,@RequestParam double Longitude,@RequestParam double Surface, @RequestParam  MultipartFile Detail)
    {
    return  Service.Modifier_Local( Id_Local,Nom_Local,Categorie_Local,Description_Local , Largeur ,Profondeur ,Hauteur, Adresse,  Responsable,   Tel,   Fax,
            Email,   Nature_Contrat,  Date_Debut,  Date_Fin,  Frais,  Nature_Frais, Latitude,  Longitude,  Surface, Detail);
    }

    @RequestMapping(value = "/Liste_Champs_Local", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Local ( ) {
        return Service.lister_champ();
    }

    @RequestMapping(value = "/Filtre_Fiche_Local", method = RequestMethod.GET)
    public  List<Fiche_Local> filtre (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);

    }


    @GetMapping("/Exporter_Local")
    public ResponseEntity<ByteArrayResource> Exporter_Local(@RequestParam Long Id ) {
        // Load file from database
        byte[] dbFile = Service.exporter(Id );

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }

    @GetMapping("/Exporter_Locals")
    public ResponseEntity<ByteArrayResource> Exporter_Locals(@RequestParam String Liste ) {
        // Load file from database
        System.out.println(Liste);
        byte[] dbFile = Service.exporters(Liste);


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }



    @PostMapping("/Importer_Locals")
    public String  Importer_Locals(@RequestParam("Locals") MultipartFile  Locals )
    {
        return Service.Importers(Locals);
    }


}
