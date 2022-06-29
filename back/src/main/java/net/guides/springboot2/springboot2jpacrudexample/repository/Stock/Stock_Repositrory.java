package net.guides.springboot2.springboot2jpacrudexample.repository.Stock;

import net.guides.springboot2.springboot2jpacrudexample.model.Stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Stock_Repositrory extends JpaRepository<Stock, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'stock'",    nativeQuery = true)
    List<String> Lister_champs ( );


}