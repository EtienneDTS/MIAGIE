package Serdaigle.MIAGIE.model;

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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nomMatiere", referencedColumnName = "nomMatiere", nullable = false)
    private String nomMatiere;

    public Professeur(String nom, String prenom, String nomMatiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomMatiere = nomMatiere;
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

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

}