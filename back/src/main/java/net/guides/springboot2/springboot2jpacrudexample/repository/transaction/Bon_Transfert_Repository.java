package net.guides.springboot2.springboot2jpacrudexample.repository.transaction;

import net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bon_Transfert_Repository extends JpaRepository<Bon_Transfert, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Bon_Transfert'",    nativeQuery = true)
    List<String> Lister_champs ( );

}

