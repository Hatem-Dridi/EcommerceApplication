package isi.tn.entities;

import java.io.Serializable;

public class ProduitCommande implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    private Long id;
    private int quantite;

    public ProduitCommande() {
    }
    @Override
    public String toString() {
        return "ProduitCommande{" +
                "id=" + id +
                ", qunatite='" + quantite + '\'' +
                // Add other fields as necessary
                '}';
    }
}
