package net.guides.springboot2.springboot2jpacrudexample.controller.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Caisse_RH;
import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Local;
import net.guides.springboot2.springboot2jpacrudexample.service.RH.Caisse_RH_Service;
import net.guides.springboot2.springboot2jpacrudexample.service.init.Fiche_local_Service;
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
public class Caisse_RH_Controller {


        @Autowired
        Caisse_RH_Service Service  ;

        @RequestMapping(value = "/Avances" ,method = RequestMethod.GET)
        public List<Caisse_RH> Caisse_RH() {
            return Service.Caisse_RHs();
        }

        @RequestMapping(value = "/Avance" ,method = RequestMethod.GET)
        public Optional<Caisse_RH> Caisse_RH(@RequestParam Long Id ) {
            return Service.Local(Id ) ;
        }

        @RequestMapping(value = "/Creer_Avance", method = RequestMethod.POST)
        public Caisse_RH Caisse_RH (@RequestParam Employe Employe , @RequestParam Date Date, @RequestParam double Avance) {
            return Service.Creer_Caisse_RH( new Caisse_RH(Employe,   Date,   Avance ));
        }


        @RequestMapping(value = "/Supprimer_Avance", method = RequestMethod.DELETE)
        public ResponseEntity<Object> Supprimer_Caisse_RH(@RequestParam Long Id_Local) {
            return Service.Supprimer_Caisse_RH(Id_Local);
        }

        @RequestMapping(value = "/Modifier_Avance", method = RequestMethod.PUT)
        public Caisse_RH Update_Caisse_RH (@RequestParam Long Id ,  @RequestParam Employe Employe , @RequestParam Date Date, @RequestParam double Avance) {
            return  Service.Modifier_Caisse_RH( Id ,new Caisse_RH(  Employe,   Date,   Avance ));
        }

        @RequestMapping(value = "/Liste_Champs_Caisse_RH", method = RequestMethod.GET)
        public  List<String> Liste_Champs_Caisse_RH ( ) {
            return Service.lister_champ();
        }


}
