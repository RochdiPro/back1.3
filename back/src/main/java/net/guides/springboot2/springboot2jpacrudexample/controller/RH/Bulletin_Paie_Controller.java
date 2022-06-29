package net.guides.springboot2.springboot2jpacrudexample.controller.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Bulletin_Paie;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.service.RH.Bulletin_Paie_Service;
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
public class Bulletin_Paie_Controller {


    @Autowired
    Bulletin_Paie_Service Service  ;

    @RequestMapping(value = "/Bulletin_Paies" ,method = RequestMethod.GET)
    public List<Bulletin_Paie> Bulletin_Paies() {
        return Service.TousBulletin_Paie();
    }

    @RequestMapping(value = "/Bulletin_Paie", method = RequestMethod.GET)
    public Object Bulletin_Paie(@RequestParam Long Id) {
        return  Service.Bulletin_Paie(Id);
    }

    @PostMapping(value = "/Creer_Bulletin_Paie")
    public Bulletin_Paie  Creer_Bulletin_Paie(  @RequestParam  Date Date_de_Paie, @RequestParam  String CNSS, @RequestParam  String Situation_Familiale, @RequestParam  int Enfant_A_Charge,@RequestParam  double Salaire_de_Base, @RequestParam double Taux_Horaire,@RequestParam  double Mode_Paiement, @RequestParam  int Nombre_Heure_Absence, @RequestParam  int Nombre_Heure_Supplementaire, @RequestParam  double Prix_Heure_Supplementaire,@RequestParam  double Conge_Pris_Mois, @RequestParam  double Conge_acquis_mois, @RequestParam  double Solde_Conge, @RequestParam MultipartFile Detail,  Employe Utilisateur) {
        return Service.Creer_Bulletin_Paie(  Date_de_Paie, CNSS, Situation_Familiale, Enfant_A_Charge, Salaire_de_Base, Taux_Horaire, Mode_Paiement, Nombre_Heure_Absence, Nombre_Heure_Supplementaire, Prix_Heure_Supplementaire, Conge_Pris_Mois, Conge_acquis_mois, Solde_Conge, Detail, Utilisateur);

    }

    @RequestMapping(value = "/Supprimer_Bulletin_Paie", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Client(@RequestParam Long Id) {
        return Service.Supprimer_Bulletin_Paie (Id);
    }

    @PostMapping(value = "/Modifier_Bulletin_Paie")
    public Bulletin_Paie Modifier_Utilisateur (@RequestParam Long Id_Bulletin_Paie , @RequestParam  Date Date_de_Paie, @RequestParam  String CNSS, @RequestParam  String Situation_Familiale, @RequestParam  int Enfant_A_Charge,@RequestParam  double Salaire_de_Base, @RequestParam double Taux_Horaire,@RequestParam  double Mode_Paiement, @RequestParam  int Nombre_Heure_Absence, @RequestParam  int Nombre_Heure_Supplementaire, @RequestParam  double Prix_Heure_Supplementaire,@RequestParam  double Conge_Pris_Mois, @RequestParam  double Conge_acquis_mois, @RequestParam  double Solde_Conge, @RequestParam MultipartFile Detail,  Employe Utilisateur)
    {
        return Service.Modifier_Bulletin_Paie(   Id_Bulletin_Paie ,  Date_de_Paie,  CNSS,  Situation_Familiale,   Enfant_A_Charge,  Salaire_de_Base, Taux_Horaire, Mode_Paiement,  Nombre_Heure_Absence,   Nombre_Heure_Supplementaire,   Prix_Heure_Supplementaire, Conge_Pris_Mois,   Conge_acquis_mois,   Solde_Conge,     Detail,     Utilisateur);
    }

    @GetMapping("/Detail_Bulletin_Paie")
    public ResponseEntity<ByteArrayResource> Document_Bulletin_Paie(@RequestParam Long Id) {
        // Load file from database
        Bulletin_Paie dbFile = Service.Detail(Id );

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId() + "\"")
                .body(new ByteArrayResource(dbFile.getDetail()));
    }

    @RequestMapping(value = "/Liste_Champs_Bulletin_Paie", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Bulletin_Paie( ) {
        return Service.lister_champ();
    }

}


