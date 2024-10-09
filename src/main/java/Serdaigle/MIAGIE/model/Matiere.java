package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Représente une matière dans le système.
 * La matière est identifiée par son nom unique.
 */
@Entity
@Table(name = "matiere", schema = "miagie")

public class Matiere {
    @Id
    @Column(name = "nomMatiere", nullable = false, length = 50)
    private String nomMatiere;

    public Matiere() {
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

}