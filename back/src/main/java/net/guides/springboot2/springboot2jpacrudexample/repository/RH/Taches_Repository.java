package net.guides.springboot2.springboot2jpacrudexample.repository.RH;

 import net.guides.springboot2.springboot2jpacrudexample.model.RH.Taches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Taches_Repository  extends JpaRepository<Taches, Long> {

    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'TAches'",    nativeQuery = true)
    List<String> Lister_champs ( );


}
