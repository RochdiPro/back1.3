package net.guides.springboot2.springboot2jpacrudexample.service.wms;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Reception;
import net.guides.springboot2.springboot2jpacrudexample.repository.Vente.Devis_Repository;
import net.guides.springboot2.springboot2jpacrudexample.repository.wms.Bon_Reception_Repository;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Bon_Reception_Service {
    @Autowired
    Bon_Reception_Repository Repo;
    @Autowired
    DataSource dataSource;

    public List<Bon_Reception> Bon_Receptions() {
        return (List<Bon_Reception>)  Repo.findAll();
    }
    public Optional<Bon_Reception> Bon_Reception(Long id ) {
        return   Repo.findById(id );
    }

    public Bon_Reception Creer_Bon_Reception (String local, long id_Be, String type_Be, String etat, String responsable, MultipartFile detail , int Nb_Support )
    {
        try {
            Bon_Reception dbFile = new Bon_Reception ( local,  id_Be,  type_Be,  etat,  responsable,  detail.getBytes() , Nb_Support) ;
            return Repo.save(dbFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new FileStorageException("impossible d'enregistrer le fichier    ! ", ex);
        }
    }

    public Bon_Reception Modifier_Bon_Reception(Long id ,  String local, long id_Be, String type_Be, String etat, String responsable, MultipartFile detail ,Integer Nb_Support)
    {
        try {
            Bon_Reception Entity = new Bon_Reception ( local,  id_Be,  type_Be,  etat,  responsable,  detail.getBytes() , Nb_Support) ;
            Optional<Bon_Reception> searchEntity = Repo.findById(id);
            if (searchEntity.isPresent()) {
                Bon_Reception p = searchEntity.get();
                p.setLocal(Entity.getLocal());
                p.setId_Be(Entity.getId_Be());
                p.setType_Be(Entity.getType_Be());
                p.setEtat(Entity.getEtat());
                p.setResponsable(Entity.getResponsable());
                p.setDetail(Entity.getDetail());
                p.setDate_Creation (Entity.getDate_Creation());
                p.setNb_Support(Entity.getNb_Support());
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

    public ResponseEntity<Object> Supprimer_Bon_Reception(Long id ) {
        Optional<Bon_Reception> Entity = Repo.findById(id );
        if (Entity.isPresent()) {
            Bon_Reception Entity_deleted = Entity.get();
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }

    public Bon_Reception Detail(Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public List<Bon_Reception> filtre(String champ1, String valeur1, String champ2, String valeur2, String champ3, String valeur3, String champ4, String valeur4) {
        List<Bon_Reception> liste = new ArrayList<>();
        try {

            String query = "SELECT * FROM Bon_Reception WHERE " + champ1 + " like '" + valeur1 + "%' AND "  + champ2 + " like '" + valeur2 + "%' AND "  + champ3 + " like '" + valeur3 + "%' AND "+ champ4 + " like '" + valeur4 + "%'";

            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Reception f = new Bon_Reception();
                f.setLocal (rs.getString("Local"));
                f.setId_Be (rs.getLong("Id_Be"));
                f.setType_Be (rs.getString("Type_Be"));
                f.setEtat(rs.getString("Etat"));
                f.setResponsable(rs.getString("Responsable"));
                f.setNb_Support (rs.getInt("Nb_Support"));
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

    public List<Bon_Reception> Bon_Receptions_En_Cours() {
        List<Bon_Reception> liste = new ArrayList<>();
        try {

            String query = "SELECT * FROM Bon_Reception WHERE etat Not like 'Validé%'  ";

            Connection cnx = dataSource.getConnection();
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bon_Reception f = new Bon_Reception();
                f.setLocal(rs.getString("Local"));
                f.setId_Be(rs.getLong("Id_Be"));
                f.setType_Be(rs.getString("Type_Be"));
                f.setEtat(rs.getString("Etat"));
                f.setResponsable(rs.getString("Responsable"));
                f.setNb_Support(rs.getInt("Nb_Support"));
                f.setId(rs.getLong("id"));

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

