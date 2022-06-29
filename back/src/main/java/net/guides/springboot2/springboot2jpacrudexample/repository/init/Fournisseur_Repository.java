package net.guides.springboot2.springboot2jpacrudexample.repository.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Fournisseur;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Fournisseur_Repository extends JpaRepository<Fournisseur, Long> {

 @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Fournisseur'",    nativeQuery = true)
 List<String> Lister_champs ( );





}

