package isi.tn.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import isi.tn.entities.Produit;
import isi.tn.service.*;

@RestController
@RequestMapping("/api")
public class ProduitController {

    @Autowired
    IproduitService pserv;

    @GetMapping("/produits")
    public ResponseEntity<List<Produit>> getFilteredProduits(
            @RequestParam(name = "nomProduit", required = false) String nomProduit,
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice) {

        List<Produit> produits;

        if (StringUtils.hasText(nomProduit)) {
            if (minPrice != null && maxPrice != null) {
                // Filter by name and price range
                produits = pserv.findByPrixProduitBetween(nomProduit,minPrice,maxPrice);
            } else {
                // Filter by name (matching the beginning of the name)
                produits = pserv.findProduitsByNameStartingWith(nomProduit);
            }
        } else if (minPrice != null && maxPrice != null) {
            // Filter by price range
            produits = pserv.findProduitsByPriceRange(minPrice, maxPrice);
        } else {
            // If no filters are provided, return all products
            produits = pserv.findAllProduits();
        }

        return ResponseEntity.ok(produits);
    }



    @PostMapping("/addproduit")
    public List<Produit> createProduit(@Valid @RequestBody Produit pro) {
        System.out.println("pro mel service = " + pro);
        pserv.saveProduit(pro);
        List<Produit> proo = pserv.findAllProduits();
        return proo;
    }


    @DeleteMapping("/produit/{id}")
    public List<Produit> deleteProduit(@PathVariable("id") Long id) {
        pserv.deleteProduit(id);
        List<Produit> pro = pserv.findAllProduits();
        return pro;
    }
    @PutMapping("/produit/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable("id") Long id, @RequestBody Produit updatedProduit) {
        Produit updatedEntity = pserv.updateProduit(id, updatedProduit);
        return ResponseEntity.ok(updatedEntity);
    }
    @PatchMapping("/produit/{id}")
    public ResponseEntity<Produit> patchProduit(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        Produit patchedProduit = pserv.patchProduit(id, updates);
        return ResponseEntity.ok(patchedProduit);
    }
}
