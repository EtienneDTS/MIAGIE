package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

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

    @Column(name = "isDirecteur")
    private Boolean isDirecteur;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomMatiere", referencedColumnName = "nomMatiere", nullable = false)
    @JsonBackReference
    private Matiere nomMatiere;

    public Professeur(String nom, String prenom, Matiere nomMatiere, Boolean isDirecteur) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomMatiere = nomMatiere;
        this.isDirecteur = isDirecteur;
    }

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

    public Boolean getIsDirecteur() {
        return isDirecteur;
    }

    public void setIsDirecteur(Boolean isDirecteur) {
        this.isDirecteur = isDirecteur;
    }
}