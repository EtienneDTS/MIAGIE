package Serdaigle.MIAGIE.models;
import jakarta.persistence.*;

@Entity
@Table(name = "professeur")

public class Professeur {
    @Column(name="idprofesseur", nullable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesseur;
    @Column(name="nom", nullable = false, unique = true)
    private String nom;
    @Column(name="prenom", nullable = false, unique = true)
    private String prenom;
    // Getters et Setters
    public Integer getIdProfesseur() {
        return idProfesseur;
    }
    public void setIdProfesseur(Integer idProfesseur) {
        this.idProfesseur = idProfesseur;
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


