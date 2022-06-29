package net.guides.springboot2.springboot2jpacrudexample.repository.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Contrainte;
import net.guides.springboot2.springboot2jpacrudexample.model.init.Ngp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Ngp_Repository extends JpaRepository<Ngp, Long> {
    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'ngp'",    nativeQuery = true)
    List<String> Lister_champs ( );

}
