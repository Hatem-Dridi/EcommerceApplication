package isi.tn.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Commande implements Serializable {
          @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nomCommande;
        private Long userId;
    //@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
    private List<ProduitCommande> products= new ArrayList<>();


    public Commande() {
        super();
    }
    public List<ProduitCommande> getProducts() {
        return products;
    }

    public void setProducts(List<ProduitCommande> products) {
        this.products = products;
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
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}