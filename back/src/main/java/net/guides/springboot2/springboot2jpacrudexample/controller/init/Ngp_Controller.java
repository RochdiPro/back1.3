package net.guides.springboot2.springboot2jpacrudexample.controller.init;

 import net.guides.springboot2.springboot2jpacrudexample.model.init.Ngp;

import net.guides.springboot2.springboot2jpacrudexample.service.init.Ngp_Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 import java.util.List;

@RestController
public class Ngp_Controller {
    @Autowired
    Ngp_Service Service  ;

    @RequestMapping(value = "/Ngps" ,method = RequestMethod.GET)
    public List<Ngp> Ngps() {
        return Service.Tous();
    }

    @RequestMapping(value = "/Ngp", method = RequestMethod.GET)
    public Object Ngp(@RequestParam Long Id_Fr) {
        return  Service.Ngp(Id_Fr);
    }


    @PostMapping(value = "/Creer_Ngp")
    public Ngp  Creer_Ngp(@RequestParam String Nom)
    {
        return Service.Creer_Ngp(Nom);
    }

    @RequestMapping(value = "/Supprimer_Ngp", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Ngp(@RequestParam Long Id) {
        return Service.Supprimer_Fournisseur(Id);
    }

    @RequestMapping(value = "/Liste_Champs_Ngp", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Ngp( ) {
        return Service.lister_champ();

    }

}
