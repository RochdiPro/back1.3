package net.guides.springboot2.springboot2jpacrudexample.repository.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Caisse_RH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Caisse_RH_Repository extends JpaRepository<Caisse_RH, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Caisse_RH'",    nativeQuery = true)
    List<String> Lister_champs ( );



}


