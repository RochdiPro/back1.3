package net.guides.springboot2.springboot2jpacrudexample.service.wms;

import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Rejet;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Sortie;
import net.guides.springboot2.springboot2jpacrudexample.repository.wms.Bon_Rejet_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.wms.Bon_Sortie_Repository;
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
public class Bon_Sortie_Service {
        @Autowired
        Bon_Sortie_Repository Repo;
        @Autowired
        DataSource dataSource;

        public List<Bon_Sortie> Bon_Sorties() {
            return (List<Bon_Sortie>)  Repo.findAll();
        }
        public Optional<Bon_Sortie> Bon_Sortie(Long id ) {
            return   Repo.findById(id );
        }

        public Bon_Sortie Creer_Bon_Sortie (String local , String responsable, String reclamation, MultipartFile detail )
        {
            try {
                Bon_Sortie dbFile = new Bon_Sortie ( local,   responsable,    reclamation, detail.getBytes()) ;
                return Repo.save(dbFile);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
            }
        }

        public Bon_Sortie Modifier_Bon_Sortie(Long id ,  String local,  String responsable, String reclamation, MultipartFile detail)
        {
            try {
                Bon_Sortie Entity = new Bon_Sortie ( local,   responsable, reclamation, detail.getBytes()) ;
                Optional<Bon_Sortie> searchEntity = Repo.findById(id);
                if (searchEntity.isPresent()) {
                    Bon_Sortie p = searchEntity.get();
                    p.setLocal(Entity.getLocal());
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

        public ResponseEntity<Object> Supprimer_Bon_Sortie(Long id ) {
            Optional<Bon_Sortie> Entity = Repo.findById(id );
            if (Entity.isPresent()) {
                Bon_Sortie Entity_deleted = Entity.get();
                Repo.delete(Entity_deleted);
            } else {
                throw new EntityNotFoundException();
            }
            return ResponseEntity.ok().build();
        }

        public List<String> lister_champ (){

            return Repo.Lister_champs() ;
        }

    public Bon_Sortie Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }
    public List<Bon_Sortie> filtre(String champ1, String valeur1, String champ2, String valeur2, String champ3, String valeur3 ) {
        List<Bon_Sortie> liste = new ArrayList<>();
        try {

            String query = "SELECT * FROM Bon_Sortie WHERE " + champ1 + " like '" + valeur1 + "%' AND "  + champ2 + " like '" + valeur2 + "%' AND "  + champ3 + " like '" + valeur3 +   "%'";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Sortie f = new Bon_Sortie();
                f.setLocal (rs.getString("Local"));
                f.setResponsable(rs.getString("Responsable"));
                f.setId (rs.getLong("id"));
                f.setReclamation(rs.getString("reclamation"));

                liste.add(f);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste;
    }

    }


