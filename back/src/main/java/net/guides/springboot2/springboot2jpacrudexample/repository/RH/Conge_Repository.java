package net.guides.springboot2.springboot2jpacrudexample.repository.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Conge_Repository extends JpaRepository<Conge, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Conge'",    nativeQuery = true)
    List<String> Lister_champs ( );



}

