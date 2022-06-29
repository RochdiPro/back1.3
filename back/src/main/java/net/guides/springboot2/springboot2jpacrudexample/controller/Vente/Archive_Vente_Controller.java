package net.guides.springboot2.springboot2jpacrudexample.controller.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Bon_Livraison_Archives;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Facture_Archives;
import net.guides.springboot2.springboot2jpacrudexample.service.Vente.Archive_Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis_Archives;

import java.util.List;
import java.util.Optional;

@RestController
public class Archive_Vente_Controller {

    @Autowired
    Archive_Vente archive;


    //****  devis *** ///
    @RequestMapping(value = "/Desarchiver_Devis" ,method = RequestMethod.GET)
    public String Desarchiver_Devis(@RequestParam Long Id , @RequestParam Long  Id_Archive) {
        return archive.desarchiver_Devis(Id ,Id_Archive );
    }

    @RequestMapping(value = "/Archives_Deviss" ,method = RequestMethod.GET)
    public List<Devis_Archives> Archives_Deviss( ) {
        return archive.Deviss();
    }

    @RequestMapping(value = "/Archives_Devis" ,method = RequestMethod.GET)
    public Optional<Devis_Archives> Archives_Devis(@RequestParam Long Id) {
        return archive.Devis(Id);
    }


    //****  Facture *** ///
    @RequestMapping(value = "/Desarchiver_Facture" ,method = RequestMethod.GET)
    public String Desarchiver_Facture(@RequestParam Long Id , @RequestParam Long  Id_Archive) {
        return archive.desarchiver_Facture(Id ,Id_Archive);
    }

    @RequestMapping(value = "/Archives_Factures" ,method = RequestMethod.GET)
    public List<Facture_Archives> Archives_Factures( ) {
        return archive.Factures();
    }

    @RequestMapping(value = "/Archives_Facture" ,method = RequestMethod.GET)
    public Optional<Facture_Archives> Archives_Facture(@RequestParam Long Id) {
        return archive.Facture(Id);
    }


    //****  bl  *** ///

    @RequestMapping(value = "/Desarchiver_Bon_Livraison" ,method = RequestMethod.GET)
    public String Desarchiver_Bon_Livraison(@RequestParam Long Id , @RequestParam Long  Id_Archive) {
        return archive.desarchiver_bl(Id ,Id_Archive);
    }

    @RequestMapping(value = "/Archives_Bon_Livraisons" ,method = RequestMethod.GET)
    public List<Bon_Livraison_Archives> Bon_Livraisons( ) {
        return archive.bls();
    }

    @RequestMapping(value = "/Archives_Bon_Livraison" ,method = RequestMethod.GET)
    public Optional<Bon_Livraison_Archives> Bon_Livraison(@RequestParam Long Id) {
        return archive.bl(Id);
    }
}
