package net.guides.springboot2.springboot2jpacrudexample.repository.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Fiche_Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Fiche_Local_Repository extends JpaRepository<Fiche_Local, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'fiche_local'",    nativeQuery = true)
    List<String> Lister_champs ( );
}
