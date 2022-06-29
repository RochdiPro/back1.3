package net.guides.springboot2.springboot2jpacrudexample.repository.tms;

import net.guides.springboot2.springboot2jpacrudexample.model.tms.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
}
