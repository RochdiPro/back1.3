package net.guides.springboot2.springboot2jpacrudexample.controller.RH;


import net.guides.springboot2.springboot2jpacrudexample.model.RH.Conge;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.service.RH.Conge_Service;
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
public class Conge_Controller {

        @Autowired
        Conge_Service Service  ;

    @RequestMapping(value = "/Conges" ,method = RequestMethod.GET)
    public List<Conge> Conges() {
        return Service.TousConges();
    }

    @RequestMapping(value = "/Conge", method = RequestMethod.GET)
    public Object Client(@RequestParam Long Id) {
        return  Service.Conge(Id);
    }

    @PostMapping(value = "/Changer_Etat_Conge")
    public   void Changer_Etat( @RequestParam Long Id ,@RequestParam String Etat  ) {
          Service.Changer_Etat(Id,Etat);
    }


    @PostMapping(value = "/Creer_Conge")
    public Conge  Creer_Conge(   @RequestParam String Type, @RequestParam String Raison, String Etat,  @RequestParam  String Description, @RequestParam  Date Date_Debut  , @RequestParam Date Date_Fin , @RequestParam Employe Employe , @RequestParam int NB_Jours  , @RequestParam("Document") MultipartFile Document) {
          return Service.Creer_Conge( Type,  Etat,   Raison,  Description,  Document,   Date_Debut,   Date_Fin,   NB_Jours,   Employe);
    }

    @RequestMapping(value = "/Supprimer_Conge", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Client(@RequestParam Long Id) {
        return Service.Supprimer_Conge (Id);
    }

   @PostMapping(value = "/Modifier_Conge")
   public Conge Modifier_Client (@RequestParam Long Id, @RequestParam String Type, @RequestParam String Raison, @RequestParam  String Etat, @RequestParam  String Description, @RequestParam  Date Date_Debut  , @RequestParam Date Date_Fin , @RequestParam Employe Employe , @RequestParam int NB_Jours  , @RequestParam("Document") MultipartFile Document) {
        return Service.Modifier_Conge(  Id ,   Type,  Etat,   Raison,  Description,  Document,   Date_Debut,   Date_Fin,   NB_Jours,   Employe)  ;
   }

    @GetMapping("/Document_Conge")
    public ResponseEntity<ByteArrayResource> Document_Conge(@RequestParam Long Id) {
        // Load file from database
        Conge dbFile = Service.Document(Id );

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getDocument_Type()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId() + "\"")
                .body(new ByteArrayResource(dbFile.getDocument()));
    }

    @RequestMapping(value = "/Liste_Champs_Conge", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Client( ) {
        return Service.lister_champ();
    }




    }

