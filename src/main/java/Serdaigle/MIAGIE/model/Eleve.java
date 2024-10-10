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
 * Les champs principaux incluent :
 * - idEleve : identifiant unique de l'élève
 * - totalPoints : le nombre total de points de l'élève
 * - nom et prenom : informations personnelles de l'élève
 * - nomMaison : la maison à laquelle l'élève est rattaché
 *
 * @author Serdaigle
 * @version 1.0
 * @since 2024-10-09
 */
@Entity
@Table(name = "eleve", schema = "miagie")
public class Eleve {
    
    // Déclaration de l'identifiant unique de l'élève
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEleve", nullable = false)
    private Integer idEleve;

    // Total des points de l'élève avec une valeur par défaut de 0
    @ColumnDefault("0")
    @Column(name = "totalPoints")
    private Integer totalPoints;

    // Nom de l'élève (maximum 50 caractères)
    @Column(name = "nom", length = 50)
    private String nom;

    // Prénom de l'élève (maximum 50 caractères)
    @Column(name = "prenom", length = 50)
    private String prenom;

    // Association avec la maison à laquelle l'élève appartient, chargée de manière EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nomMaison", referencedColumnName = "nomMaison", nullable = false)
    private Maison nomMaison;

    /**
     * Constructeur par défaut.
     * Ce constructeur est nécessaire pour permettre la création d'une instance de Eleve
     * sans initialisation directe des champs.
     */
    public Eleve() {
    }

    /**
     * Récupère l'identifiant unique de l'élève.
     *
     * @return l'identifiant de l'élève.
     */
    public Integer getId() {
        return idEleve;
    }

    /**
     * Définit l'identifiant unique de l'élève.
     *
     * @param id l'identifiant à assigner à l'élève.
     */
    public void setId(Integer id) {
        this.idEleve = id;
    }

    /**
     * Récupère la maison à laquelle l'élève est rattaché.
     *
     * @return la maison de l'élève.
     */
    public Maison getMaison() {
        return nomMaison;
    }

    /**
     * Récupère le nom de la maison de l'élève.
     * Cette méthode est utile si l'on souhaite accéder directement au nom de la maison.
     *
     * @return le nom de la maison sous forme de chaîne de caractères.
     */
    public String getNomMaison(){
        return nomMaison.getNomMaison();
    }

    /**
     * Définit la maison à laquelle l'élève appartient.
     *
     * @param maison la maison à assigner à l'élève.
     */
    public void setMaison(Maison maison) {
        this.nomMaison = maison;
    }

    /**
     * Récupère le total des points de l'élève.
     *
     * @return le nombre total de points.
     */
    public Integer getTotalPoints() {
        return totalPoints;
    }

    /**
     * Définit le total des points de l'élève.
     *
     * @param totalPoints le nombre de points à assigner à l'élève.
     */
    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    /**
     * Récupère le nom de l'élève.
     *
     * @return le nom de l'élève.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'élève.
     *
     * @param nom le nom à assigner à l'élève.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère le prénom de l'élève.
     *
     * @return le prénom de l'élève.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de l'élève.
     *
     * @param prenom le prénom à assigner à l'élève.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
