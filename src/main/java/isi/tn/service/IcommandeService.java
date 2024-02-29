package isi.tn.service;

import isi.tn.entities.Commande;

import java.util.List;
import java.util.Optional;

import isi.tn.entities.Produit;
import isi.tn.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface IcommandeService {
    List<Commande> findAllCommandes();

    List<Commande> getAllCommandes();
    Commande saveCommande(Commande commande);
    Optional<Commande> getCommandeById(Long id);
    void deleteCommande(Long id);
}


