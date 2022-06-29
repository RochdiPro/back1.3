package net.guides.springboot2.springboot2jpacrudexample.repository.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Employe;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Employe_Repository extends JpaRepository<Employe, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Employe'",    nativeQuery = true)
    List<String> Lister_champs ( );


}