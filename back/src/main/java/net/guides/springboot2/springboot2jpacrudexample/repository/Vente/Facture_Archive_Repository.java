package net.guides.springboot2.springboot2jpacrudexample.repository.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Facture;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Facture_Archives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Facture_Archive_Repository  extends JpaRepository<Facture_Archives, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Facture_Archives'",    nativeQuery = true)
    List<String> Lister_champs ( );



}