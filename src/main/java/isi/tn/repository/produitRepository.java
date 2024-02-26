package isi.tn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.entities.*;

import java.util.List;

@Repository
public interface produitRepository extends JpaRepository<Produit,Long> {

    List<Produit> findByPrixProduitBetween(double minPrice, double maxPrice);
}
