package isi.tn.service;

import java.util.List;
import java.util.Map;


import isi.tn.entities.Produit;
public interface IproduitService {

    List<Produit> findAllProduits();

    Produit saveProduit(Produit pro);
    public void deleteProduit(Long Id);
    Produit updateProduit(Long id, Produit updatedProduit);
    Produit patchProduit(Long id, Map<String, Object> updates);

}