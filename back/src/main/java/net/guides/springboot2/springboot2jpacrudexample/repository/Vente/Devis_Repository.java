package net.guides.springboot2.springboot2jpacrudexample.repository.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Devis_Repository extends JpaRepository<Devis, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Devis'",    nativeQuery = true)
    List<String> Lister_champs ( );



}