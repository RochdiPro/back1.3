package net.guides.springboot2.springboot2jpacrudexample.repository.wms;

import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Rejet;
import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Sortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bon_Sortie_Repository extends JpaRepository<Bon_Sortie, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Bon_Sortie'",    nativeQuery = true)
    List<String> Lister_champs ( );

}