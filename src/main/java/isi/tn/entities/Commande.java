package isi.tn.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Commande implements Serializable {
          @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nomCommande;


    public Commande() {
        super();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomCommande() {
        return nomCommande;
    }
    public void setNomCommande(String nomCommande) {
        this.nomCommande = nomCommande;
    }
}
