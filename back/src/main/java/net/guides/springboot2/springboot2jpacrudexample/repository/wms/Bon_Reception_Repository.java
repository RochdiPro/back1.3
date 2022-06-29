package net.guides.springboot2.springboot2jpacrudexample.repository.wms;

 import net.guides.springboot2.springboot2jpacrudexample.model.wms.Bon_Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;




public interface Bon_Reception_Repository extends JpaRepository<Bon_Reception, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Bon_Reception'",    nativeQuery = true)
    List<String> Lister_champs ( );



}
