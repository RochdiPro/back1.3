package net.guides.springboot2.springboot2jpacrudexample.controller.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Conge;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Taches;
import net.guides.springboot2.springboot2jpacrudexample.service.RH.Conge_Service;
import net.guides.springboot2.springboot2jpacrudexample.service.RH.Taches_Service;
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
public class Taches_Controller{

    @Autowired
    Taches_Service Service  ;

    @RequestMapping(value = "/Taches" ,method = RequestMethod.GET)
    public List<Taches> Taches() {
        return Service.TousTaches();
    }

    @RequestMapping(value = "/Tache", method = RequestMethod.GET)
    public Object Taches(@RequestParam Long Id) {
        return  Service.Taches(Id);
    }

    @PostMapping(value = "/Changer-Etat-Tache")
    public   void Changer_Etat( @RequestParam Long Id ,@RequestParam String Etat  ) {
        Service.Changer_Etat(Id,Etat);
    }


    @PostMapping(value = "/Creer_Tache")
    public Taches  Creer_Conge(  @RequestParam  String Description,  @RequestParam Employe Employe  ) {
        return Service.Creer_Taches(   Description,     Employe);
    }

    @RequestMapping(value = "/Supprimer_Tache", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Client(@RequestParam Long Id) {
        return Service.Supprimer_Taches (Id);
    }

    @PostMapping(value = "/Modifier_Tache")
    public Taches Modifier_Tache(@RequestParam Long Id,  @RequestParam  String Etat, @RequestParam  String Description,   @RequestParam Employe Employe ) {
        return Service.Modifier_Taches(  Id ,     Etat,      Description,      Employe)  ;
    }

    @RequestMapping(value = "/Liste_Champs_Tache", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Tache( ) {
        return Service.lister_champ();
    }




}

