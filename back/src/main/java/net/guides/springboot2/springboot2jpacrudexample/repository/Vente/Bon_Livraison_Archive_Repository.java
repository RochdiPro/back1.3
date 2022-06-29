package net.guides.springboot2.springboot2jpacrudexample.repository.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Bon_Livraison_Archives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bon_Livraison_Archive_Repository extends JpaRepository<Bon_Livraison_Archives, Long> {

@Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Bon_Livraison_Archives'",    nativeQuery = true)
List<String> Lister_champs ( );

}