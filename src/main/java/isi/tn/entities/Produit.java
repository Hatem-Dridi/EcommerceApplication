package isi.tn.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
public class Produit implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="projectid")
    private Long id;
    private String nomProduit;
    private String description;
    private String marqueProduit;
    private double prixProduit;
    private String image;

    @ManyToOne
    private Commande commande;



    public Produit() {
        super();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomProduit() {
        return nomProduit;
    }
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getMarqueProduit() {
        return marqueProduit;
    }
    public void setMarqueProduit(String marqueProduit) {
        this.marqueProduit = marqueProduit;
    }
    public double getPrixProduit() {
        return prixProduit;
    }
    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }


}
