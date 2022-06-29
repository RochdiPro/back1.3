package net.guides.springboot2.springboot2jpacrudexample.controller.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.PositionClient;
import net.guides.springboot2.springboot2jpacrudexample.model.tms.PositionFournisseur;
import net.guides.springboot2.springboot2jpacrudexample.service.tms.PositionClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PositionClientController {

    @Autowired
    PositionClientService positionClientService;

    @RequestMapping(value = "/PositionClients" ,method = RequestMethod.GET)
    public List<PositionClient> positionClients() {
        return positionClientService.getAll();
    }

    @RequestMapping(value = "/PositionClient/{id}" ,method = RequestMethod.GET)

    public Optional<PositionClient> client(@PathVariable Long id) {
        return positionClientService.getPosClient(id);
    }

    @RequestMapping(value = "/CreerPositionClient", method = RequestMethod.POST)
    public PositionClient creerPositionCleint(@Valid @RequestParam Long id , @RequestParam String Lat , @RequestParam String Long) {

        return positionClientService.creerPositionClient(new PositionClient(id,Lat,Long));
    }

    @RequestMapping(value = "/SupprimerPositionClient", method = RequestMethod.DELETE)
    public ResponseEntity<Object> supprimerPosClient(@RequestParam Long id) {
        return positionClientService.deletePosClient(id);
    }

    @RequestMapping(value = "/majPositionClient", method = RequestMethod.PUT)
    public PositionClient majPositionClient( @RequestParam Long id ,@RequestParam String lat ,@RequestParam String lng) {
        return positionClientService.majPositionClient(id, new PositionClient(lat,lng));
    }
}
