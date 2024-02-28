package isi.tn.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.entities.Produit;
import isi.tn.repository.produitRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class ImplproduitService implements IproduitService{


    @Autowired
    produitRepository prepo;

    @Override
    public List<Produit> findAllProduits() {
        // TODO Auto-generated method stub
        return prepo.findAll();
    }

    @Override
    public Produit saveProduit(Produit pro) {
        // TODO Auto-generated method stub
        return prepo.save(pro);
    }
    @Override
    public List<Produit> findProduitsByName(String nomProduit) {
        return prepo.findByNomProduitContaining(nomProduit);
    }
    @Override
    public void deleteProduit(Long id) {
        prepo.deleteById(id);
    }
    @Override
    public Produit updateProduit(Long id, Produit updatedProduit) {
        Produit existingProduit = prepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found with id: " + id));

        // Update the existing produit with the provided information
        existingProduit.setNomProduit(updatedProduit.getNomProduit());
        existingProduit.setDescription(updatedProduit.getDescription());
        existingProduit.setPrixProduit(updatedProduit.getPrixProduit());
        // Update other fields as needed
        return prepo.save(existingProduit);
    }
    @Override
    public Produit patchProduit(Long id, Map<String, Object> updates) {
        Produit existingProduit = prepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found with id: " + id));

        // Apply partial updates
        updates.forEach((key, value) -> {
            switch (key) {
                case "nomProduit":
                    existingProduit.setNomProduit((String) value);
                    break;
                case "description":
                    existingProduit.setDescription((String) value);
                    break;
                case "marqueProduit":
                    existingProduit.setMarqueProduit((String) value);
                    break;
                case "prixProduit":
                    Double prixValue = Double.parseDouble((String) value);
                    existingProduit.setPrixProduit(prixValue);
                    break;
                // Add cases for other fields as needed
                default:
                    throw new IllegalArgumentException("Unknown field: " + key);
            }
        });

        return prepo.save(existingProduit); // Save and return the patched produit
    }

    @Override
    public List<Produit> findProduitsByPriceRange(double minPrice, double maxPrice) {
        return prepo.findByPrixProduitBetween(minPrice, maxPrice);
    }
}

