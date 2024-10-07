package Serdaigle.MIAGIE.models;

import jakarta.persistence.*;

@Entity
@Table(name = "eleve")
public class Eleve {
    @Column(name="ideleve", nullable = false, unique = true)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEleve;

    @Column(name="nom", nullable = false, unique = true)
    private String nom;
    @Column(name="prenom", nullable = false, unique = true)
    private String prenom;
    @Column(name="nommaison", nullable = false, unique = true)
    private String nomMaison;
    @Column(name="totalpoints", nullable = false, unique = true)
    private int totalPoints;

    // Getters et Setters
    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomMaison() {
        return nomMaison;
    }

    public void setNomMaison(String nomMaison) {
        this.nomMaison = nomMaison;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
