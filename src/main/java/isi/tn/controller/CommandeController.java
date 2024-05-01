package isi.tn.controller;

import isi.tn.entities.Commande;
import isi.tn.service.IcommandeService;
import isi.tn.service.IproduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommandeController {


    @Autowired
    private IcommandeService commandeService;

    @GetMapping("/commandes")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }


    @PostMapping("/addcommande")
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        System.out.println("commande = " + commande);
        Commande savedCommande = commandeService.saveCommande(commande);
        System.out.println("savedCommande = " + savedCommande);
        return new ResponseEntity<>(savedCommande, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable("id") Long id) {
        return commandeService.getCommandeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable("id") Long id) {
        commandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
