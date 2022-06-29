package net.guides.springboot2.springboot2jpacrudexample.controller.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.Affectation;
import net.guides.springboot2.springboot2jpacrudexample.model.tms.Vehicule;
import net.guides.springboot2.springboot2jpacrudexample.service.tms.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AffectationController {

    @Autowired
    AffectationService affectationService;

    @RequestMapping(value = "/affectations" ,method = RequestMethod.GET)
    public List<Affectation> affectations() {
        return affectationService.getAll();
    }

    @RequestMapping(value = "/affectation/{id}" ,method = RequestMethod.GET)

    public Optional<Affectation> affectation(@PathVariable Long id) {
        return affectationService.getAffectation(id);
    }

    @RequestMapping(value = "/createAffectation", method = RequestMethod.POST)
    public Affectation createAffectation(@Valid @RequestParam Integer idE, @RequestParam String nom , @RequestParam String matricule, @RequestParam Date dateLivraison, @RequestParam String trajet, @RequestParam String etatMission) {

        return affectationService.createAffectation(new Affectation(idE,nom,matricule,dateLivraison,trajet,etatMission));
    }

    @RequestMapping(value = "/deleteAffectation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAffectation(@RequestParam Long id) {
        return affectationService.deleteAffectation(id);
    }

    @RequestMapping(value = "/updateAffectation/{id}", method = RequestMethod.PUT)
    public Affectation updateAffectation( @RequestParam Long id , @RequestParam Integer idE ,@RequestParam String nom, @RequestParam String matricule, @RequestParam Date dateLivraison, @RequestParam String etatMission) {
        return affectationService.updateAffectation(id, new Affectation(idE,nom,matricule,dateLivraison,etatMission));
    }

    @RequestMapping(value = "/majTrajetMission", method = RequestMethod.PUT)
    public Affectation majTrajetMission( @RequestParam Long id, @RequestParam String trajet) {
        return affectationService.majTrajet(id, new Affectation(trajet));
    }

    @RequestMapping(value = "/majEtatMission", method = RequestMethod.PUT)
    public Affectation majEtatMission(@Valid @RequestParam Long id, @RequestParam String valeur) {
        return affectationService.majEtatMission(id,valeur);
    }

    @RequestMapping(value = "/filtrerMission" ,method = RequestMethod.GET)
    public List<Affectation> filtrer( @RequestParam String champ, @RequestParam String valeur) {
        return affectationService.filtre(champ,valeur);
    }

    @RequestMapping(value = "/filtrerMission2" ,method = RequestMethod.GET)
    public List<Affectation> filtrerDeuxFacteurs( @RequestParam String champ1, @RequestParam String valeur1, @RequestParam String champ2, @RequestParam String valeur2) {
        return affectationService.filtreDeuxFacteurs(champ1,valeur1,champ2,valeur2);
    }

    @RequestMapping(value = "/filtrerMission3" ,method = RequestMethod.GET)
    public List<Affectation> filtrerTroisFacteurs( @RequestParam String champ1, @RequestParam String valeur1, @RequestParam String champ2, @RequestParam String valeur2, @RequestParam String champ3, @RequestParam String valeur3) {
        return affectationService.filtreTroisFacteurs(champ1,valeur1,champ2,valeur2,champ3,valeur3);
    }
}
