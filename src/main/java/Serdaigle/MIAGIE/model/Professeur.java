package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

/**
 * Classe représentant un professeur dans le système MIAGIE.
 * Un professeur est associé à une matière et a des informations
 * sur son nom et prénom.
 */
@Entity
@Table(name = "professeur", schema = "miagie")
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesseur", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomMatiere", referencedColumnName = "nomMatiere", nullable = false)
    @JsonBackReference
    private Matiere nomMatiere;

    /**
     * Constructeur de la classe Professeur.
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
     * Constructeur par défaut de la classe Professeur.
     */
    public Professeur() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Matiere getNomMatiere() {
        return this.nomMatiere;
    }

    public void setNomMatiere(Matiere nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

}