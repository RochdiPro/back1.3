package net.guides.springboot2.springboot2jpacrudexample.repository.Vente;

import net.guides.springboot2.springboot2jpacrudexample.model.Vente.Bon_Commande_Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bon_Commande_Client_Repository extends JpaRepository<Bon_Commande_Client, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Bon_Commande_Client'",    nativeQuery = true)
    List<String> Lister_champs ( );



}
