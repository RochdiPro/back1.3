package net.guides.springboot2.springboot2jpacrudexample.controller.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.PositionFournisseur;
import net.guides.springboot2.springboot2jpacrudexample.model.tms.Vehicule;
import net.guides.springboot2.springboot2jpacrudexample.service.tms.PositionFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PositionFournisseurController {

    @Autowired
    PositionFournisseurService positionFournisseurService;

    @RequestMapping(value = "/PositionFournisseurs" ,method = RequestMethod.GET)
    public List<PositionFournisseur> positionFournisseurs() {
        return positionFournisseurService.getAll();
    }

    @RequestMapping(value = "/PositionFournisseur/{id}" ,method = RequestMethod.GET)

    public Optional<PositionFournisseur> fournisseur(@PathVariable Long id) {
        return positionFournisseurService.getPosFournisseur(id);
    }

    @RequestMapping(value = "/CreerPositionFournisseur", method = RequestMethod.POST)
    public PositionFournisseur creerPositionFournisseur(@Valid @RequestParam Long id , @RequestParam String Lat , @RequestParam String Long) {

        return positionFournisseurService.creerPositionFournisseur(new PositionFournisseur(id,Lat,Long));
    }

    @RequestMapping(value = "/SupprimerPositionFournisseur", method = RequestMethod.DELETE)
    public ResponseEntity<Object> supprimerPosFournisseur(@RequestParam Long id) {
        return positionFournisseurService.deletePosFournisseur(id);
    }

    @RequestMapping(value = "/majPositionFournisseur", method = RequestMethod.PUT)
    public PositionFournisseur majPositionFournisseur( @RequestParam Long id ,@RequestParam String lat ,@RequestParam String lng) {
        return positionFournisseurService.majPositionFourniseeur(id, new PositionFournisseur(lat,lng));
    }


}
