package net.guides.springboot2.springboot2jpacrudexample.repository.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis_Archives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Devis_Archive_Repository extends JpaRepository<Devis_Archives, Long> {

    @Query(value = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Devis_Archives'", nativeQuery = true)
    List<String> Lister_champs();
}
