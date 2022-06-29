package net.guides.springboot2.springboot2jpacrudexample.repository.wms;

import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Rejet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bon_Rejet_Repository extends JpaRepository<Bon_Rejet, Long> {

@Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Bon_Rejet'",    nativeQuery = true)
List<String> Lister_champs ( );

}
