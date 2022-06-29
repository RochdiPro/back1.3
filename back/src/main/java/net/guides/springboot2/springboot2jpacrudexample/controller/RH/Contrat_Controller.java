package net.guides.springboot2.springboot2jpacrudexample.controller.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Conge;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Contrat;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.service.RH.Conge_Service;
import net.guides.springboot2.springboot2jpacrudexample.service.RH.Contrat_Service;
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
public class Contrat_Controller {

        @Autowired
        Contrat_Service Service  ;

        @RequestMapping(value = "/Contrats" ,method = RequestMethod.GET)
        public List<Contrat> Contrats() {
            return Service.TousContrats();
        }

        @RequestMapping(value = "/Contrat", method = RequestMethod.GET)
        public Object Contrat(@RequestParam Long Id) {
            return  Service.Contrat(Id);
        }

        @PostMapping(value = "/Creer_Contrat")
        public Contrat  Creer_Conge(@RequestParam Employe Employe, @RequestParam  Date Date_Debut , @RequestParam  Date Date_Fin, @RequestParam  String Description, @RequestParam String Type  , @RequestParam("Document") MultipartFile Document) {
            return Service.Creer_Contrat(   Employe,   Date_Debut,   Date_Fin,   Type,    Document);
        }

        @RequestMapping(value = "/Supprimer_Contrat", method = RequestMethod.DELETE)
        public ResponseEntity<Object> Supprimer_Client(@RequestParam Long Id) {
            return Service.Supprimer_Contrat (Id);
        }

        @PostMapping(value = "/Modifier_Contrat")
        public Contrat Modifier_Client (@RequestParam Long Id, @RequestParam Employe Employe, @RequestParam  Date Date_Debut , @RequestParam  Date Date_Fin, @RequestParam  String Description, @RequestParam String Type  , @RequestParam("Document") MultipartFile Document)  {
            return Service.Modifier_Contrat(  Id ,   Employe,   Date_Debut,   Date_Fin,   Type,    Document)  ;
        }

        @GetMapping("/Document_Contrat")
        public ResponseEntity<ByteArrayResource> Document_Contrat(@RequestParam Long Id) {
            // Load file from database
            Contrat dbFile = Service.Document(Id );

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("application/pdf"))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId() + "\"")
                    .body(new ByteArrayResource(dbFile.getDetail()));
        }

        @RequestMapping(value = "/Liste_Champs_Contrat", method = RequestMethod.GET)
        public  List<String> Liste_Champs_Contrat( ) {
            return Service.lister_champ();
        }

    }
