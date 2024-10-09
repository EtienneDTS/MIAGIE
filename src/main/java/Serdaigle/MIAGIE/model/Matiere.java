package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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