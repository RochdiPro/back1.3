package net.guides.springboot2.springboot2jpacrudexample.controller.Stock;

import net.guides.springboot2.springboot2jpacrudexample.controller.Stock.type.Detail_Produit_Json;
import net.guides.springboot2.springboot2jpacrudexample.controller.Stock.type.Detail_Stock_Local;
import net.guides.springboot2.springboot2jpacrudexample.model.Stock.Stock;
import net.guides.springboot2.springboot2jpacrudexample.service.Stock.Stock_Service;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Stock_Controller {

    @Autowired
    Stock_Service Service  ;

    @RequestMapping(value = "/Stocks" ,method = RequestMethod.GET)
    public List<Stock> Locals() {
        return Service.Stocks();
    }


    @RequestMapping(value = "/Stock" ,method = RequestMethod.GET)
    public Optional<Stock> Stock (@RequestParam Long Id) {
        return Service.Stock(Id) ;
    }


    @RequestMapping(value = "/Supprimer_Stock", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Supprimer_Stock(@RequestParam Long Id) {
        return Service.Supprimer_Stock(Id);
    }

    @RequestMapping(value = "/Modifier_Stock", method = RequestMethod.PUT)
    public  String Modifier_Stock (@RequestParam String Nom_Local ,  @RequestParam("Details") MultipartFile Details) {
        Service.Modifier_Stock( Nom_Local,Details );
        return "ok";
    }

    @RequestMapping(value = "/Liste_Champs_Stock", method = RequestMethod.GET)
    public  List<String> Liste_Champs_Stock ( ) {
        return Service.lister_champ();
    }


    @RequestMapping(value = "/Filtre_Stock", method = RequestMethod.GET)
    public  List<Stock> Filtre_Stock (@RequestParam String Champ, @RequestParam String Valeur) {
        return Service.filtre(Champ, Valeur);
    }

    @GetMapping("/Detail_Produit")
    public ResponseEntity<ByteArrayResource> Detail_Produit(@RequestParam Long Id) {
        // Load file from database
        Stock dbFile = Service.Detail(Id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/xml"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getId_Produit() + "\"")
                .body(new ByteArrayResource(dbFile.getDetails()));
    }

    @GetMapping("/Detail_Produit_4G_En_Json")
    public ArrayList<Detail_Produit_Json> Detail_Produit_En_Json(@RequestParam Long Id) {
        // Load file from database
        Stock dbFile = Service.Detail(Id);
        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
        ArrayList<Detail_Produit_Json> liste_detail_produit_json = new ArrayList<>();

        try {
            doc = builder.build(new ByteArrayInputStream(dbFile.getDetails()));
            Element root = doc.getRootElement();
            for (Element p : root.getChildren()) {
                Detail_Produit_Json dp = new Detail_Produit_Json ();
                dp.setN_Serie(p.getChild("N_Serie").getText());
                dp.setE1(p.getChild("E1").getText());
                dp.setE2(p.getChild("E2").getText());
                dp.setFornisseur(p.getChild("Fornisseur").getText());
                dp.setLocal(p.getChild("Local").getText());
                liste_detail_produit_json.add(dp);
            }

        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        return  liste_detail_produit_json ;
    }

    @GetMapping("/Detail_Produit_Nserie_En_Json")
    public ArrayList<Detail_Produit_Json> Detail_Produit_Nserie_En_Json(@RequestParam Long Id) {
        // Load file from database

        Stock dbFile = Service.Detail(Id);
        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
        ArrayList<Detail_Produit_Json> liste_detail_produit_json = new ArrayList<>();
        try {
            doc = builder.build(new ByteArrayInputStream(dbFile.getDetails()));
            Element root = doc.getRootElement();

            for (Element p : root.getChildren()) {
                System.out.println(p );
                Detail_Produit_Json dp = new Detail_Produit_Json ();
                dp.setN_Serie(p.getChild("Numero").getText());
                try {
                    dp.setFornisseur(p.getChild("Fornisseur").getText());
                }catch(Exception e){
                    dp.setFornisseur("retour client ");
                    System.out.println(e.getMessage());}
                dp.setLocal(p.getChild("Local").getText());
                System.out.println(dp.getN_Serie());
                liste_detail_produit_json.add(dp);
            }
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        return  liste_detail_produit_json ;
    }

    @GetMapping("/Produit_en_Stock")
    public String Produit_en_Stock(@RequestParam Long Id) {
        return  Service.Produit_en_Stock(Id);
    }
    @RequestMapping(value = "/Prix_Produit", method = RequestMethod.GET)
    public  double Prix_Produit (@RequestParam Long Id ) {
        return Service.Prix_Produit(  Id);
    }

    @RequestMapping(value = "/Ancien_Prix_Produit", method = RequestMethod.GET)
    public  double Ancien_Prix_Produit (@RequestParam Long Id ) {
        return Service.Ancien_Prix(  Id);
    }

    @RequestMapping(value = "/Ref_Produit", method = RequestMethod.GET)
    public  String Ref_Produit ( @RequestParam Long Id) {
        return Service.Ref_Produit( Id);
    }


    @RequestMapping(value = "/Modifier_Prix_Produit", method = RequestMethod.POST)
    public String Modifier_Prix_Produit ( @RequestParam long Id ,  @RequestParam double Prix) {
        Service.Modifier_Prix_Produit(  Id,Prix );
        return "ok";
    }

    @RequestMapping(value = "/Modifier_Ancien_Prix_Produit", method = RequestMethod.POST)
    public String Modifier_Ancien_Prix_Produit ( @RequestParam long Id ,  @RequestParam double Prix) {
        Service.Modifier_Ancien_Prix_Produit(  Id,Prix );
        return "ok";
    }

    @RequestMapping(value = "/Modifier_Valeur_Produit", method = RequestMethod.POST)
    public String Modifier_Valeur_Produit ( @RequestParam long Id ,  @RequestParam double Valeur) {
        Service.Modifier_Valeur_Produit(  Id,Valeur );
        return "ok";
    }

    @RequestMapping(value = "/Quantite_Produit_Par_Stock_En_Local", method = RequestMethod.GET)
    public  Integer Quantite_Produit_Par_Stock_En_Local ( @RequestParam Long Id ,@RequestParam String  Local) {
        return Service.Quantite_Produit_Par_Stock_En_Local( Id , Local);
    }

    @RequestMapping(value = "/Liste_Produits_En_Local", method = RequestMethod.GET)
    public ArrayList<Detail_Stock_Local> Liste_Produits_En_Local (@RequestParam String  Local) {
        ArrayList<Detail_Stock_Local> l = Service.Liste_Produits_En_Local(Local);
      /*  for (int i = 0 ; i < l.size() ; i++ ) {
            System.out.println(l.get(i).getQte_Local());
        }*/
        return  l;
    }

    @RequestMapping(value = "/Detail_Produit_par_Numero_Serie", method = RequestMethod.GET)
    public  Detail_Produit_Json  Detail_Produit_par_Numero_Serie (@RequestParam Long Id ,@RequestParam String  N_Serie) {

        Stock dbFile = Service.Detail(Id);

        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
        Detail_Produit_Json dp = null;
        try {
            doc = builder.build(new ByteArrayInputStream(dbFile.getDetails()));
            Element root = doc.getRootElement();
            for (Element p : root.getChildren()) {
               if ((p.getChild("N_Serie").getText()).equals(N_Serie)) {
                    dp = new Detail_Produit_Json();

                    dp.setN_Serie(p.getChild("N_Serie").getText());
                    dp.setE1(p.getChild("E1").getText());
                    dp.setE2(p.getChild("E2").getText());
                    dp.setFornisseur(p.getChild("Fornisseur").getText());
                    dp.setLocal(p.getChild("Local").getText());
                }
            }
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        return  dp ;

    }

}
