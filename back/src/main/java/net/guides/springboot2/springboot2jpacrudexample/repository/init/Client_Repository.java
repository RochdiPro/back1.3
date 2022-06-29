package net.guides.springboot2.springboot2jpacrudexample.repository.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Client;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Client_Repository extends JpaRepository<Client, Long> {

 @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Client'",    nativeQuery = true)
 List<String> Lister_champs ( );



}

