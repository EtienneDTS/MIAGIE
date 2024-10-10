package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

/**
 * Classe représentant un professeur dans le système MIAGIE.
 * Un professeur est associé à une matière et a des informations
 * sur son nom et prénom.
 * 
 * @version 1.0
 * @since 2024-10-10
 */
@Entity
@Table(name = "professeur", schema = "miagie")
public class Professeur {

    /**
     * Identifiant unique pour chaque professeur.
     * Cet identifiant est auto-généré lors de l'insertion dans la base de données.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesseur", nullable = false)
    private Integer id;

    /**
     * Le nom du professeur (maximum 50 caractères).
     */
    @Column(name = "nom", length = 50)
    private String nom;

    /**
     * Le prénom du professeur (maximum 50 caractères).
     */
    @Column(name = "prenom", length = 50)
    private String prenom;

    /**
     * La matière enseignée par le professeur.
     * Relation Many-to-One avec l'entité `Matiere`, fetchée de manière lazy (chargée à la demande).
     */
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomMatiere", referencedColumnName = "nomMatiere", nullable = false)
    @JsonBackReference
    private Matiere nomMatiere;

    /**
     * Constructeur complet de la classe Professeur.
     * 
     * @param nom       Le nom du professeur.
     * @param prenom    Le prénom du professeur.
     * @param nomMatiere La matière enseignée par le professeur.
     */
    public Professeur(String nom, String prenom, Matiere nomMatiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomMatiere = nomMatiere;
    }

    /**
     * Constructeur par défaut requis pour les frameworks.
     */
    public Professeur() {

    }

    /**
     * Retourne l'identifiant du professeur.
     * 
     * @return L'identifiant unique du professeur.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modifie l'identifiant du professeur.
     * 
     * @param id L'identifiant unique à définir.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retourne le nom du professeur.
     * 
     * @return Le nom du professeur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du professeur.
     * 
     * @param nom Le nouveau nom du professeur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prénom du professeur.
     * 
     * @return Le prénom du professeur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prénom du professeur.
     * 
     * @param prenom Le nouveau prénom du professeur.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne la matière enseignée par le professeur.
     * 
     * @return L'objet Matiere associé au professeur.
     */
    public Matiere getNomMatiere() {
        return this.nomMatiere;
    }

    /**
     * Modifie la matière enseignée par le professeur.
     * 
     * @param nomMatiere La nouvelle matière enseignée par le professeur.
     */
    public void setNomMatiere(Matiere nomMatiere) {
        this.nomMatiere = nomMatiere;
    }
}
