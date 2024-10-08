package Serdaigle.MIAGIE.models;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;

@MappedSuperclass
// Classe abstraite Personne dont vont hériter les classes Eleve et Professeur
public abstract class Personne {

    @Column(name="nom", nullable = false, unique = false)
    private String nom;

    @Column(name="prenom", nullable = false, unique = false)
    private String prenom;

    // Getters et Setters
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

    // Méthodes abstraites à ajouter
}
