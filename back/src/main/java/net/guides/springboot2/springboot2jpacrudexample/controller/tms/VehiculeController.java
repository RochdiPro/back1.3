package net.guides.springboot2.springboot2jpacrudexample.controller.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.Vehicule;
import net.guides.springboot2.springboot2jpacrudexample.service.tms.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class VehiculeController {

    @Autowired
    VehiculeService vehiculeService;

    @RequestMapping(value = "/vehicules" ,method = RequestMethod.GET)
    public List<Vehicule> vehicule() {
        return vehiculeService.getAll();
    }

    @RequestMapping(value = "/vehicule/{id}" ,method = RequestMethod.GET)

    public Optional<Vehicule> vehicule(@PathVariable Long id) {
        return vehiculeService.getVehicule(id);
    }

    @RequestMapping(value = "/createvehicule", method = RequestMethod.POST)
    public Vehicule createVehicule(@Valid @RequestParam String matricule , @RequestParam String marque , @RequestParam String modele , @RequestParam String couleur , @RequestParam String categories, @RequestParam int kmactuel, @RequestParam int kmprochainentretien, @RequestParam int consommation, @RequestParam String carburant, @RequestParam float prixcarburant, @RequestParam float consommationNormale, @RequestParam float charge_utile, @RequestParam float longueur, @RequestParam float largeur, @RequestParam float hauteur, @RequestParam float charge_restante, @RequestParam float surface_restante, @RequestParam Date datevisite, @RequestParam Date dateassurance, @RequestParam Date datetaxe,@RequestParam String sujet, @RequestParam String description, @RequestParam String etatVehicule) {

        return vehiculeService.createVehicule(new Vehicule(matricule, marque, modele, couleur, categories, kmactuel, kmprochainentretien, consommation, carburant, prixcarburant, consommationNormale, charge_utile, longueur, largeur, hauteur, charge_restante, surface_restante, datevisite, dateassurance, datetaxe,sujet,description,etatVehicule));
    }

    @RequestMapping(value = "/deletevehicule/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteVehicule(@PathVariable Long id) {
        return vehiculeService.deleteVehicule(id);
    }

    @RequestMapping(value = "/updatevehicule/{id}", method = RequestMethod.PUT)
    public Vehicule updateVehicule(@PathVariable Long id , @Valid @RequestParam int kmactuel, @RequestParam int kmprochainentretien, @RequestParam int consommation, @RequestParam String carburant, @RequestParam int consommationNormale, @RequestParam int distanceparcourie, @RequestParam Date datevisite, @RequestParam Date dateassurance, @RequestParam Date datetaxe) {
        return vehiculeService.updateVehicule(id, new Vehicule(kmactuel, kmprochainentretien, consommation, carburant, consommationNormale, distanceparcourie, datevisite, dateassurance, datetaxe));
    }
    @RequestMapping(value = "/updatePrixCarburant", method = RequestMethod.PUT)
    public Vehicule majPrixCarburant(@Valid @RequestParam String carburant, @RequestParam float valeur) {
        return vehiculeService.majPrixCarburant(carburant,valeur);
    }

    @RequestMapping(value = "/reclamationvehicule/{id}", method = RequestMethod.PUT)
    public Vehicule reclamationVehicule(@PathVariable Long id , @Valid @RequestParam String sujet,@RequestParam String description) {
        return vehiculeService.reclamationVehicule(id, new Vehicule(sujet,description));
    }
    @RequestMapping(value = "/miseajourkm/{id}", method = RequestMethod.PUT)
    public Vehicule updateKM(@PathVariable Long id , @Valid @RequestParam int kmactuel ,@RequestParam int consommation ,@RequestParam int distanceparcourie) {
        return vehiculeService.updateKM(id, new Vehicule(kmactuel,consommation,distanceparcourie));
    }

    @RequestMapping(value = "/miseajourEtatVehicule", method = RequestMethod.PUT)
    public Vehicule majEtatVehicule(@RequestParam Long id , @Valid @RequestParam String etatVehicule) {
        return vehiculeService.majEtatVehicule(id, new Vehicule(etatVehicule));
    }
    @RequestMapping(value = "/miseajourChargeEtSurface", method = RequestMethod.PUT)
    public Vehicule majChargeEtSurface(@RequestParam Long id , @Valid @RequestParam Float charge_restante, @RequestParam Float surface_restante) {
        return vehiculeService.majChargeEtSurface(id, new Vehicule(charge_restante,surface_restante));
    }


}
