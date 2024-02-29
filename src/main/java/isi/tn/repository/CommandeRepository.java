package isi.tn.repository;

import isi.tn.entities.Commande;
import isi.tn.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // You can add custom query methods if needed
}


