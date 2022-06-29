package net.guides.springboot2.springboot2jpacrudexample.repository.transaction;

import net.guides.springboot2.springboot2jpacrudexample.model.transaction.Bon_Retour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bon_Retour_Repository  extends JpaRepository<Bon_Retour, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Bon_Retour'",    nativeQuery = true)
    List<String> Lister_champs ( );
}
