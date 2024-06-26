package isi.tn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.entities.*;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {

    List<Produit> findByPrixProduitBetween(double minPrice, double maxPrice);
    List<Produit> findByNomProduitContaining(String nomProduit);
    List<Produit> findByNomProduitAndPrixProduitBetween(String nomProduit, double minPrice, double maxPrice);

    List<Produit> findByNomProduitStartingWith(String nomProduit);

    List<Produit> findByNomProduitStartingWithAndPrixProduitBetween(String nomProduit, double minPrice, double maxPrice);
}
