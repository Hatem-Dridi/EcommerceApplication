package isi.tn.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.tn.entities.Produit;
import isi.tn.repository.ProduitRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class ImplproduitService implements IproduitService{


    @Autowired
    ProduitRepository prepo;

    @Override
    public List<Produit> findAllProduits() {
        // TODO Auto-generated method stub
        return prepo.findAll();
    }

    @Override
    public Produit saveProduit(Produit pro) {
        // TODO Auto-generated method stub
        System.out.println("pro = " + pro);
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
        existingProduit.setMarqueProduit(updatedProduit.getMarqueProduit());
        existingProduit.setPrixProduit(updatedProduit.getPrixProduit());
        existingProduit.setImage(updatedProduit.getImage());
        existingProduit.setQuantite(updatedProduit.getQuantite());
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
                case "image":
                    existingProduit.setImage((String) value);
                    break;
                case "quantite":
                    Integer quantiteValue = (Integer) value;
                    existingProduit.setQuantite(quantiteValue);
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

    @Override
    public Optional<Produit> getProduit(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Produit> findProduitsByNameStartingWith(String nomProduit) {
        return prepo.findByNomProduitStartingWith(nomProduit);
    }

    @Override
    public List<Produit> findByPrixProduitBetween(String nomProduit, double minPrice, double maxPrice) {
        return prepo.findByNomProduitStartingWithAndPrixProduitBetween(nomProduit, minPrice, maxPrice);
    }


}

