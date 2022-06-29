package net.guides.springboot2.springboot2jpacrudexample.serveur;

 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Societe_Repository extends JpaRepository<Societe, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Societe'",    nativeQuery = true)
    List<String> Lister_champs ( );
}