package net.guides.springboot2.springboot2jpacrudexample.repository.RH;

import net.guides.springboot2.springboot2jpacrudexample.model.RH.Bulletin_Paie;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bulletin_de_Paie_Repository extends JpaRepository<Bulletin_Paie, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'Bulletin_Paie'",    nativeQuery = true)
    List<String> Lister_champs ( );


}
