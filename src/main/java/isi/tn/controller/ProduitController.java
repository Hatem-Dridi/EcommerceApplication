package isi.tn.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import isi.tn.entities.Produit;
import isi.tn.service.*;

@RestController
@RequestMapping("/api")
public class ProduitController {

    @Autowired
    IproduitService pserv;

    @GetMapping("/produits")
    public List<Produit> getAllProject() {
        List<Produit> pro = pserv.findAllProduits();

        return pro;

    }

    @PostMapping("/addproduit")
    public Produit createProduit(@Valid @RequestBody Produit pro) {
        return pserv.saveProduit(pro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable("id") Long id) {
        pserv.deleteProduit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable("id") Long id, @RequestBody Produit updatedProduit) {
        Produit updatedEntity = pserv.updateProduit(id, updatedProduit);
        return ResponseEntity.ok(updatedEntity);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Produit> patchProduit(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        Produit patchedProduit = pserv.patchProduit(id, updates);
        return ResponseEntity.ok(patchedProduit);
    }
}
