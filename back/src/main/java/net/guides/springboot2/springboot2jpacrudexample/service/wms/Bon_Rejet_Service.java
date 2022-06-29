package net.guides.springboot2.springboot2jpacrudexample.service.wms;

 import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Reception;
 import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Rejet;
 import net.guides.springboot2.springboot2jpacrudexample.repository.wms.Bon_Rejet_Repository;
import net.guides.springboot2.springboot2jpacrudexample.service.Achat.FileStorageException;
import net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.io.IOException;
 import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.util.ArrayList;
 import java.util.List;
import java.util.Optional;

@Service
public class Bon_Rejet_Service {
    @Autowired
    Bon_Rejet_Repository Repo;
    @Autowired
    DataSource dataSource;

    public List<Bon_Rejet> Bon_Rejets() {
        return (List<Bon_Rejet>)  Repo.findAll();
    }
    public Optional<Bon_Rejet> Bon_Rejet(Long id ) {
        return   Repo.findById(id );
    }

    public Bon_Rejet Creer_Bon_Rejet (String local, String id_Be, String type_Be, String etat, String responsable, String reclamation, MultipartFile detail )
    {
        try {
            Bon_Rejet dbFile = new Bon_Rejet ( local,  id_Be,  type_Be,  etat,  responsable,    reclamation, detail.getBytes()) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    public Bon_Rejet Modifier_Bon_Rejet(Long id ,  String local, String id_Bon, String type, String etat, String responsable, String reclamation, MultipartFile detail)
    {
        try {
            Bon_Rejet Entity = new Bon_Rejet ( local,  id_Bon,  type,  etat,  responsable, reclamation, detail.getBytes()) ;
            Optional<Bon_Rejet> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Bon_Rejet p = searchEntity.get();
                p.setLocal(Entity.getLocal());
                p.setId_Bon(Entity.getId_Bon());
                p.setType_Bon(Entity.getType_Bon());
                p.setEtat(Entity.getEtat());
                p.setResponsable(Entity.getResponsable());
                p.setDetail(Entity.getDetail());
                p.setReclamation(Entity.getReclamation());
                p.setDate_Creation (Entity.getDate_Creation());
                Entity = Repo.save(p);
            } else {
                throw new EntityNotFoundException();
            }
            return Entity;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    public ResponseEntity<Object> Supprimer_Bon_Rejet(Long id ) {
        Optional<Bon_Rejet> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Bon_Rejet Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }
    public List<Bon_Rejet> filtre(String champ1, String valeur1, String champ2, String valeur2, String champ3, String valeur3 ) {
        List<Bon_Rejet> liste = new ArrayList<>();
        try {

            String query = "SELECT * FROM Bon_Rejet WHERE " + champ1 + " like '" + valeur1 + "%' AND "  + champ2 + " like '" + valeur2 + "%' AND "  + champ3 + " like '" + valeur3 +   "%'";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Rejet f = new Bon_Rejet();
                f.setLocal (rs.getString("Local"));
                f.setId_Bon (rs.getString("Id_Bon"));
                f.setType_Bon (rs.getString("Type_Bon"));
                f.setEtat(rs.getString("Etat"));
                f.setResponsable(rs.getString("Responsable"));
                f.setId (rs.getLong("id"));

                liste.add(f);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }
    public Bon_Rejet Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }
}
