package isi.tn.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Commande implements Serializable {
          @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nomCommande;
        private Long userId;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Produit> products;


    public Commande() {
        super();
    }
    public List<Produit> getProducts() {
        return products;
    }

    public void setProducts(List<Produit> products) {
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
