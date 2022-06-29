package net.guides.springboot2.springboot2jpacrudexample.repository.init;

import net.guides.springboot2.springboot2jpacrudexample.model.init.Contrainte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Contrainte_Repository  extends JpaRepository<Contrainte, Long> {
    @Query(value ="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'contrainte'",    nativeQuery = true)
    List<String> Lister_champs ( );
}
