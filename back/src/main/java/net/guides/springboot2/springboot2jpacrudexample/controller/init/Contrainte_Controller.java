package net.guides.springboot2.springboot2jpacrudexample.controller.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Contrainte;
import net.guides.springboot2.springboot2jpacrudexample.service.init.Contrainte_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class Contrainte_Controller {
    @Autowired
    Contrainte_Service Service;

    @RequestMapping(value = "/Contraintes", method = RequestMethod.GET)
    public List<Contrainte> Contraintes() {
        return Service.getAll();
    }

    @RequestMapping(value = "/Creer_Contrainte", method = RequestMethod.POST)
    public Contrainte Creer_Contrainte( @RequestParam Long Id_Contrainte,@RequestParam String Nom_Contrainte, @RequestParam boolean Code_Barre, @RequestParam boolean Source, @RequestParam boolean Nom_Produit, @RequestParam boolean Type1, @RequestParam boolean Type2,
                                        @RequestParam boolean Famille, @RequestParam boolean Sous_Famille, @RequestParam boolean Unite,@RequestParam boolean Valeur_Unite,
                                        @RequestParam boolean Ngp, @RequestParam boolean Rfid, @RequestParam boolean Caracteristique_Technique, @RequestParam boolean Marque, @RequestParam boolean Src_Img,
                                        @RequestParam boolean Pays, @RequestParam boolean Ville, @RequestParam boolean N_Imei, @RequestParam boolean N_Imei2, @RequestParam boolean Temperature_Max,
                                        @RequestParam boolean Temperature_Min, @RequestParam boolean N_Lot, @RequestParam boolean Date_Fabrication, @RequestParam boolean Date_Validite, @RequestParam boolean Saison,
                                        @RequestParam boolean Region, @RequestParam boolean N_Serie, @RequestParam boolean Couleur, @RequestParam boolean Taille, @RequestParam boolean Role, @RequestParam boolean Tva ,@RequestParam boolean Fodec ,@RequestParam boolean Certificat)  {

             return Service.Create_Contrainte(new Contrainte(Id_Contrainte, Nom_Contrainte, Code_Barre,  Source,  Nom_Produit,   Type1, Type2,   Famille,   Sous_Famille,
              Unite,   Valeur_Unite,   Ngp,   Rfid,   Caracteristique_Technique, Marque,   Src_Img,   Pays,   Ville,   N_Imei,   N_Imei2,
              Temperature_Max,   Temperature_Min,   N_Lot,   Date_Fabrication,  Date_Validite,   Saison,   Region,   N_Serie,   Couleur,   Taille, Role,   Tva ,Fodec , Certificat) );
        }

    @RequestMapping(value = "/Supprimer_Contrainte", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Produit(@RequestParam Long Id_Contrainte) {
        return Service.Delete_Contrainte  (Id_Contrainte);
    }

    @RequestMapping(value = "/Modifier_Contrainte", method = RequestMethod.PUT)
    public Contrainte update_produit (@RequestParam Long Id_Contrainte, @RequestParam String Nom_Contrainte, @RequestParam boolean Code_Barre, @RequestParam boolean Source, @RequestParam boolean Nom_Produit, @RequestParam boolean Type1, @RequestParam boolean Type2,
                                      @RequestParam boolean Famille, @RequestParam boolean Sous_Famille, @RequestParam boolean Unite, @RequestParam boolean Valeur_Unite,
                                      @RequestParam boolean Ngp, @RequestParam boolean Rfid, @RequestParam boolean Caracteristique_Technique, @RequestParam boolean Marque, @RequestParam boolean Src_Img,
                                      @RequestParam boolean Pays, @RequestParam boolean Ville, @RequestParam boolean N_Imei, @RequestParam boolean N_Imei2, @RequestParam boolean Temperature_Max,
                                      @RequestParam boolean Temperature_Min, @RequestParam boolean N_Lot, @RequestParam boolean Date_Fabrication, @RequestParam boolean Date_Validite, @RequestParam boolean Saison,
                                      @RequestParam boolean Region, @RequestParam boolean N_Serie, @RequestParam boolean Couleur, @RequestParam boolean Taille, @RequestParam boolean Role, @RequestParam boolean Tva , @RequestParam boolean Fodec ,@RequestParam boolean Certificat)  {

        return Service.Update_Contrainte (Id_Contrainte , new Contrainte(Id_Contrainte,Nom_Contrainte,  Code_Barre,  Source,  Nom_Produit,   Type1, Type2,   Famille,   Sous_Famille, Unite,   Valeur_Unite,   Ngp,   Rfid,   Caracteristique_Technique, Marque,   Src_Img,   Pays,   Ville,   N_Imei,   N_Imei2,
                                              Temperature_Max,   Temperature_Min,   N_Lot,   Date_Fabrication,  Date_Validite,   Saison,   Region,   N_Serie,   Couleur,   Taille, Role,   Tva , Fodec , Certificat) );

    }

    @RequestMapping(value = "/Contrainte", method = RequestMethod.GET)
    public Object Produit(@RequestParam Long Id_Contrainte) {
        return  Service.Contrainte(Id_Contrainte);
    }




    @GetMapping("/Exporter_Contrainte")
    public ResponseEntity<ByteArrayResource> Exporter_Contrainte(@RequestParam Long Id ) {
        // Load file from database
        byte[] dbFile = Service.exporter(Id );

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }

    @GetMapping("/Exporter_Contraintes")
    public ResponseEntity<ByteArrayResource> Exporter_Contraintes(@RequestParam String Liste ) {
        // Load file from database
        System.out.println(Liste);
        byte[] dbFile = Service.exporters(Liste);


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=")
                .body(new ByteArrayResource(dbFile));
    }




    @PostMapping("/Importer_Contraintes")
    public String  Importer_Contraintes(@RequestParam("Contraintes") MultipartFile  Contraintes )
    {
        return Service.Importers(Contraintes);
    }

}

