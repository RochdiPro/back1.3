package net.guides.springboot2.springboot2jpacrudexample.repository.Achat;

import net.guides.springboot2.springboot2jpacrudexample.model.Achat.Bon_Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bon_Commande_Repository extends JpaRepository<Bon_Commande, Long> {
}

