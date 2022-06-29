package net.guides.springboot2.springboot2jpacrudexample.controller.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.service.RH.Employe_Service;
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
public class Employe_Controller {

        @Autowired
        Employe_Service Service  ;

        @RequestMapping(value = "/Employees" ,method = RequestMethod.GET)
        public List<Employe> Employes() {
            return Service.TousEmployes();
        }

        @RequestMapping(value = "/Employee", method = RequestMethod.GET)
        public Object Employe(@RequestParam Long Id) {
            return  Service.Employe(Id);
        }

        @PostMapping(value = "/Creer_Employee")
        public Employe  Creer_Utilisateur(@RequestParam String Role, @RequestParam int Acces, @RequestParam  String Nom,   @RequestParam  String Description, @RequestParam Date Date_de_naissance  , @RequestParam Date Date_de_embauche , @RequestParam String Banque, @RequestParam String Rib, @RequestParam String  Tel, @RequestParam String Pays, @RequestParam String Ville, @RequestParam String Email, @RequestParam String Adresse, @RequestParam String Type_Piece_Identite, @RequestParam String N_Piece_Identite  , @RequestParam("Image") MultipartFile Image, @RequestParam Date Date_Piece_Identite , @RequestParam String Cnss , @RequestParam String Situation_Familiale ,@RequestParam int Enfant_A_Charge , @RequestParam Date Date_de_Permis ,@RequestParam String Permis ,@RequestParam String Categorie_Permis,@RequestParam String Local) {
            return Service.Creer_Employe(Role, Acces,Nom,  Date_de_naissance,Date_de_embauche ,Banque, Rib,     Tel, Pays,Ville, Email, Adresse ,Type_Piece_Identite, N_Piece_Identite , Date_Piece_Identite,   Description,   Image ,  Cnss ,   Situation_Familiale ,   Enfant_A_Charge ,    Date_de_Permis ,   Permis ,   Categorie_Permis ,Local);
        }

        @RequestMapping(value = "/Supprimer_Employe", method = RequestMethod.DELETE)
        public ResponseEntity<Object> Supprimer_Client(@RequestParam Long Id) {
            return Service.Supprimer_Employe (Id);
        }

        @PostMapping(value = "/Modifier_Employee")
        public Employe Modifier_Utilisateur (@RequestParam Long Id , @RequestParam String Role, @RequestParam int Acces, @RequestParam  String Nom  ,@RequestParam  String Description, @RequestParam Date Date_de_naissance  , @RequestParam Date Date_de_embauche , @RequestParam String Banque, @RequestParam String Rib, @RequestParam String  Tel, @RequestParam String Pays, @RequestParam String Ville, @RequestParam String Email, @RequestParam String Adresse, @RequestParam String Type_Piece_Identite, @RequestParam String N_Piece_Identite  , @RequestParam("Image") MultipartFile Image, @RequestParam Date Date_Piece_Identite , @RequestParam String Cnss , @RequestParam String Situation_Familiale ,@RequestParam int Enfant_A_Charge , @RequestParam Date Date_de_Permis ,@RequestParam String Permis ,@RequestParam String Categorie_Permis,@RequestParam String Local) {
            return Service.Modifier_Employe(Id,Role, Acces,Nom,  Date_de_naissance,Date_de_embauche ,Banque, Rib,     Tel, Pays,Ville, Email, Adresse ,Type_Piece_Identite, N_Piece_Identite , Date_Piece_Identite,   Description,   Image ,   Cnss ,   Situation_Familiale ,   Enfant_A_Charge ,    Date_de_Permis ,   Permis ,   Categorie_Permis,Local);
        }

        @GetMapping("/Image_Employee")
        public ResponseEntity<ByteArrayResource> Document_Conge(@RequestParam Long Id) {
            // Load file from database
            Employe dbFile = Service.image(Id );

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(dbFile.getImage_Type()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Employe() + "\"")
                    .body(new ByteArrayResource(dbFile.getImage()));
        }

        @RequestMapping(value = "/Liste_Champs_Employee", method = RequestMethod.GET)
        public  List<String> Liste_Champs_Employe( ) {
            return Service.lister_champ();
        }

    @RequestMapping(value = "/Filtre_Employee", method = RequestMethod.GET)
    public  List<Employe> Filtre_Employe (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);
    }


    @GetMapping("/Exporter_Employe")
    public ResponseEntity<ByteArrayResource> Exporter_Employe(@RequestParam Long Id) {
        // Load file from database
        byte[] dbFile = Service.exporter(Id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }

    @GetMapping("/Exporter_Employes")
    public ResponseEntity<ByteArrayResource> Exporter_Employes(@RequestParam String Liste ) {
        // Load file from database

        byte[] dbFile = Service.exporters(Liste);


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }

    @PostMapping("/Importer_Employes")
    public String  Importer_Clients(@RequestParam("Employes") MultipartFile  Clients )
    {
        return Service.Importers(Clients);
    }

    }
