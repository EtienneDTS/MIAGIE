package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

/**
 * Représente un élève dans le système MIAGIE.
 *
 * La classe Eleve correspond à l'entité "eleve" dans la base de données.
 * Elle contient les informations personnelles de l'élève ainsi qu'une référence
 * à la maison à laquelle il appartient.
 *
 * @author Serdaigle
 * @version 1.0
 * @since 2024-10-09
 */
@Entity
@Table(name = "eleve", schema = "miagie")
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEleve", nullable = false)
    private Integer idEleve;

    @ColumnDefault("0")
    @Column(name = "totalPoints")
    private Integer totalPoints;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nomMaison", referencedColumnName = "nomMaison", nullable = false)
    private Maison nomMaison;

    /**
     * Constructeur par défaut.
     */
    public Eleve() {
    }
    /**
     * blabla
     * @return
     */
    public Integer getId() {
        return idEleve;
    }

    public void setId(Integer id) {
        this.idEleve = id;
    }

    public Maison getMaison() {
        return nomMaison;
    }

    public String getNomMaison(){
        return nomMaison.getNomMaison();
    }

    public void setMaison(Maison maison) {
        this.nomMaison = maison;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
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

}