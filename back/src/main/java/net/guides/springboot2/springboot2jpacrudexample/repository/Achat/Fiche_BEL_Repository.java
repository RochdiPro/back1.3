package net.guides.springboot2.springboot2jpacrudexample.repository.Achat;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Fiche_BEL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Fiche_BEL_Repository extends JpaRepository<Fiche_BEL, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Fiche_BEL'",    nativeQuery = true)
    List<String> Lister_champs ( );
}
