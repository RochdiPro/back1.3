package net.guides.springboot2.springboot2jpacrudexample.serveur;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Societe_Service {
    @Autowired
    Societe_Repository Repo;

    @Autowired
    DataSource dataSource;
    public List<Societe> Socites() {
        return (List<Societe>)  Repo.findAll();
    }
    public Optional<Societe> Socite(Long id_Local) {
        return   Repo.findById(id_Local);
    }

    public Societe Creer_Socite(Societe Entity) {
        return  Repo.save( Entity);
    }

    public Societe Modifier_Socite(Long id_Local, Societe Entity) {
        Societe updated;
        Optional<Societe> searchEntity =  Repo.findById(id_Local);
        if (searchEntity.isPresent()) {
            Societe p = searchEntity.get();
          //  p.setLogin(Entity.getCategorie_Local());

            Entity = Repo.save(p);
        } else {
            throw new EntityNotFoundException();
        }
        return Entity;
    }

    public ResponseEntity<Object> Supprimer_Socite(Long id) {
        Optional<Societe>  Entity =  Repo.findById(id);
        if (Entity.isPresent()) {
            Societe Entity_deleted = Entity.get();
            //   Supprimer_local (Entity.getNom_Local());
            Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }

    public  List<Fiche_Local>  filtre (   String champ , String valeur ) {
        List<Fiche_Local> liste = new ArrayList<>();
        try {
            String query = "select Id_Local as id_Local,  Nom_Local as nom_Local, Categorie_Local as categorie_Local,  Description_Local as description_Local  from fiche_local where "+champ+" like '" + valeur + "%'";
            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Fiche_Local d = new Fiche_Local();

                d.setId_Local(Long.valueOf(rs.getString("id_Local")));
                d.setNom_Local(rs.getString("nom_Local"));
                d.setCategorie_Local(rs.getString("categorie_Local"));
                d.setDescription_Local(rs.getString("description_Local"));
                liste.add(d);
            }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return liste ;
    }







}
