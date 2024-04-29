package isi.tn.entities;

import java.io.Serializable;

public class ProduitCommande implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQunatite(int qunatite) {
        this.qunatite = qunatite;
    }

    public int getQunatite() {
        return qunatite;
    }

    private Long id;
    private int qunatite;

    public ProduitCommande() {
    }
}
