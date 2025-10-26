package CRUD;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Article {
    private String id;
    private String nom;
    private String fabriquant;
    private double prix;
    private int quantite;

    public Article() {}

    public Article(String id, String nom, String fabriquant, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.fabriquant = fabriquant;
        this.prix = prix;
        this.quantite = quantite;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement
    public String getFabriquant() {
        return fabriquant;
    }

    public void setFabriquant(String fabriquant) {
        this.fabriquant = fabriquant;
    }

    @XmlElement
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @XmlElement
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}