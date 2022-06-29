package net.guides.springboot2.springboot2jpacrudexample.controller.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.service.Vente.Archive_Vente;
import net.guides.springboot2.springboot2jpacrudexample.service.Vente.Devis_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Devis_Controller {

    @Autowired
    Devis_Service Service;

    @Autowired
    Archive_Vente archive;

    @RequestMapping(value = "/Deviss" ,method = RequestMethod.GET)
    public List<Devis> Deviss() {
        return Service.Deviss();
    }

    @RequestMapping(value = "/Devis", method = RequestMethod.GET)
    public Object Devis(@RequestParam Long Id) {
        return  Service.Devis(Id);
    }


    @PostMapping(value = "/Creer_Devis")
    public Devis Creer_Devis ( @RequestParam String Id_Clt,@RequestParam String Type, @RequestParam String Etat, @RequestParam double Total_HT_Brut, @RequestParam double Total_Remise, @RequestParam double Total_HT_Net,@RequestParam double Total_Fodec,@RequestParam double Total_Tva,@RequestParam double Total_TTC, @RequestParam String Description,@RequestParam String Id_Responsable,@RequestParam String Mode_Paiement, @RequestParam MultipartFile Detail,@RequestParam double Frais_Livraison )
    {
            return Service.Creer_Devis (  Id_Clt,    Type,   Etat,   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,      Description,  Id_Responsable,  Mode_Paiement,   Detail,   Frais_Livraison );
    }

    @RequestMapping(value = "/Supprimer_Devis", method = RequestMethod.DELETE)
    public String Supprimer_Devis(@RequestParam Long Id ) {
        archive.Archive_Devis(Id);
        return  "ok";
    }

    @RequestMapping(value = "/Recupererr_Devis", method = RequestMethod.GET)
    public String Recupererr_Devis(@RequestParam Long Id , @RequestParam Long Id_Archive  ) {
        archive.desarchiver_Devis(Id,Id_Archive);
        return  "ok";
    }


    @PostMapping(value = "/Modifier_Devis")
    public Devis Modifier_Devis (@RequestParam Long Id ,  @RequestParam String Id_Clt,@RequestParam String Type, @RequestParam String Etat, @RequestParam double Total_HT_Brut, @RequestParam double Total_Remise, @RequestParam double Total_HT_Net,@RequestParam double Total_Fodec,@RequestParam double Total_Tva,@RequestParam double Total_TTC ,@RequestParam String Description,@RequestParam String Id_Responsable,@RequestParam String Mode_Paiement, @RequestParam MultipartFile Detail,@RequestParam double Frais_Livraison )
    {
        return Service.Modifier_Devis ( Id , Id_Clt,    Type,   Etat,   Total_HT_Brut,   Total_Remise,   Total_HT_Net,   Total_Fodec,   Total_Tva,   Total_TTC,    Description,  Id_Responsable,  Mode_Paiement,   Detail,   Frais_Livraison );
    }

    @RequestMapping(value = "/Liste_Champs_Devis", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Devis( ) {
        return Service.lister_champ();
    }


    @RequestMapping(value = "/Filtre_Devis", method = RequestMethod.GET)
    public  List<Devis> Filtre_Client (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);
    }

    @GetMapping("/Detail_Devis")
    public ResponseEntity<ByteArrayResource> Detail_Devis(@RequestParam Long Id_Devis) {
        // Load file from database
        Devis dbFile = Service.Detail(Id_Devis);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Devis() + "\"")
                .body(new ByteArrayResource(dbFile.getDetail()));
    }

    @RequestMapping(value = "/Filtre_Devis_Par_Client_Date", method = RequestMethod.GET)
    public  List<Devis> Filtre_Devis_Par_Client_Date (@RequestParam Long client, @RequestParam Date date) {

        return Service.Filtre_Par_Client_Date(client, date);
    }

    @RequestMapping(value = "/Filtre_Devis_Par_Client_Date_Etat", method = RequestMethod.GET)
    public  List<Devis> Filtre_Devis_Par_Client_Date_etat (@RequestParam Long client, @RequestParam Date date ,@RequestParam String Etat) {

        return Service.Filtre_Par_Client_Date_etat(client, date,Etat);
    }

    @RequestMapping(value = "/Filtre_Devis_Par_Client_Date1_Date2", method = RequestMethod.GET)
    public  List<Devis> Filtre_Devis_Par_Client_Date1_Date2 (@RequestParam Long client, @RequestParam Date date1 , @RequestParam Date date2) {

        return Service.Filtre_Devis_Par_Client_Date1_Date2(client, date1,date2);
    }
}

