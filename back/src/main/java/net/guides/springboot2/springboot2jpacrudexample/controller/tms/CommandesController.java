package net.guides.springboot2.springboot2jpacrudexample.controller.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.Commandes;
import net.guides.springboot2.springboot2jpacrudexample.service.tms.CommandesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CommandesController {

    @Autowired
    CommandesService commandeService;

    @RequestMapping(value = "/commandes" ,method = RequestMethod.GET)
    public List<Commandes> commandes() {
        return commandeService.getAll();
    }

    @RequestMapping(value = "/commande/{id}" ,method = RequestMethod.GET)

    public Optional<Commandes> commande(@PathVariable Long id) {
        return commandeService.getCommande(id);
    }

    @RequestMapping(value = "/createCommande", method = RequestMethod.POST)
    public Commandes createCommande(@Valid @RequestParam Long id_mission, @RequestParam Long reference_commande, @RequestParam String expediteur, @RequestParam String adresse_expediteur, @RequestParam String contact_expediteur, @RequestParam Long tel_expediteur, @RequestParam String destinataire, @RequestParam String adresse_destinataire, @RequestParam String contact_destinataire, @RequestParam Long tel_destinataire, @RequestParam Date date_commande, @RequestParam String type, @RequestParam Long nbr_obj, @RequestParam String description, @RequestParam String articles, @RequestParam String etat, @RequestParam String positionExp, @RequestParam String positionDest) {

        return commandeService.createCommande(new Commandes(id_mission,reference_commande,expediteur,adresse_expediteur,contact_expediteur,tel_expediteur,destinataire,adresse_destinataire,contact_destinataire,tel_destinataire,date_commande,type,nbr_obj,description, articles, etat,positionExp,positionDest));
    }

    @RequestMapping(value = "/deleteCommande/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCommande(@PathVariable Long id) {
        return commandeService.deleteCommande(id);
    }

    @RequestMapping(value = "/updateCommande/{id}", method = RequestMethod.PUT)
    public Commandes updateAffectation( @RequestParam Long id , @RequestParam Long idMission, @RequestParam Long referenceCommande, @RequestParam String expediteur, @RequestParam String adresse_expediteur, @RequestParam String contact_expediteur, @RequestParam Long tel_expediteur, @RequestParam String destinataire, @RequestParam String adresse_destinataire, @RequestParam String contact_destinataire, @RequestParam Long tel_destinataire, @RequestParam Date date_commande, @RequestParam String type, @RequestParam Long nbr_obj, @RequestParam String description, @RequestParam String articles, @RequestParam String etat, @RequestParam String positionExp, @RequestParam String positionDest) {
        return commandeService.updateCommande(id, new Commandes(idMission,referenceCommande,expediteur,adresse_expediteur,contact_expediteur,tel_expediteur,destinataire,adresse_destinataire,contact_destinataire,tel_destinataire,date_commande,type,nbr_obj,description, articles, etat,positionExp,positionDest));
    }
    @RequestMapping(value = "/filtrerCommande" ,method = RequestMethod.GET)
    public List<Commandes> filtrer( @RequestParam String champ, @RequestParam String valeur) {
        return commandeService.filtre(champ,valeur);
    }
    @RequestMapping(value = "/miseajouretat/{id}", method = RequestMethod.PUT)
    public Commandes majEtat(@PathVariable Long id , @Valid @RequestParam String etat) {
        return commandeService.majEtat(id, new Commandes(etat));
    }

}
