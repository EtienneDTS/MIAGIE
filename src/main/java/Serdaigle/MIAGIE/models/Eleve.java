package Serdaigle.MIAGIE.models;

import jakarta.persistence.*;

@Entity
@Table(name = "eleve")
public class Eleve extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideleve", nullable = false, unique = true)
    private Integer idEleve;

    @Column(name = "nommaison", nullable = false)
    private String nomMaison;

    @Column(name = "totalpoints", nullable = false)
    private int totalPoints;

    // Getters et Setters pour les champs propres à Eleve
    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
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

    // Implémenter ici les méthodes abstraites de Personne
}
