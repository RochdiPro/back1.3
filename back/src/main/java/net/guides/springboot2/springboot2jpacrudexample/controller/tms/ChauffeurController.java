package net.guides.springboot2.springboot2jpacrudexample.controller.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.Chauffeur;
 import net.guides.springboot2.springboot2jpacrudexample.service.tms.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ChauffeurController {

    @Autowired
    ChauffeurService chauffeurService;

    @RequestMapping(value = "/chauffeur" ,method = RequestMethod.GET)
    public List<Chauffeur> chauffeur() {
        return chauffeurService.getAll();
    }

    @RequestMapping(value = "/createchauffeur", method = RequestMethod.POST)
    public Chauffeur createChauffeur(@Valid @RequestParam String nom , @RequestParam String type) {

        return chauffeurService.createChauffeur(new Chauffeur(nom,type));
    }

    @RequestMapping(value = "/deletechauffeur/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteChauffeur(@RequestParam Long id) {
        return chauffeurService.deleteChauffeur(id);
    }

    @RequestMapping(value = "/updatechauffeur/{id}", method = RequestMethod.PUT)
    public Chauffeur updateChauffeur( @RequestParam Long id ,@RequestParam String nom ,@RequestParam String type) {
        return chauffeurService.updateChauffeur(id, new Chauffeur(nom,type));
    }

}
