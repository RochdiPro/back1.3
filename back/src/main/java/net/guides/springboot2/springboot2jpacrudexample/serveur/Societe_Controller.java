package net.guides.springboot2.springboot2jpacrudexample.serveur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class Societe_Controller {
    @Autowired
    Societe_Service Service  ;


    @RequestMapping(value = "/Socites" ,method = RequestMethod.GET)
    public List<Societe> Socites() {
        return Service.Socites();
    }

    @RequestMapping(value = "/Socite" ,method = RequestMethod.GET)
    public Optional<Societe> Socite(@RequestParam Long Id) {
        return Service.Socite(Id) ;
    }

    @RequestMapping(value = "/Creer_Socite", method = RequestMethod.POST)
    public Societe Creer_Socite ( @RequestParam String Login, @RequestParam String Mote_de_Passe, @RequestParam String Socite, Date Date_Debut, Date Date_Fin) {
        return Service.Creer_Socite( new Societe( Login,   Mote_de_Passe,   Socite,   Date_Debut,   Date_Fin));
    }

    @RequestMapping(value = "/Supprimer_Socite", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Local(@RequestParam Long Id ) {
        return Service.Supprimer_Socite(Id );
    }

    @RequestMapping(value = "/Modifier_Socite", method = RequestMethod.PUT)
    public Societe Update_Depot (@RequestParam Long Id , @RequestParam String Login, @RequestParam String Mote_de_Passe, @RequestParam String Socite, Date Date_Debut, Date Date_Fin) {
        return  Service.Modifier_Socite( Id ,new Societe(  Login,   Mote_de_Passe,   Socite,   Date_Debut,   Date_Fin));
    }

    @RequestMapping(value = "/Liste_Champs_Socite", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Socite ( ) {
        return Service.lister_champ();
    }

}
