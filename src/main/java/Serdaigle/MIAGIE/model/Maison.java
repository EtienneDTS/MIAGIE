package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

/**
 * Classe représentant une maison dans le système MIAGIE.
 * Une maison peut avoir plusieurs élèves qui lui sont associés.
 */
@Entity
@Table(name = "maison", schema = "miagie")
public class Maison {
    @Id
    @Column(name = "nomMaison", nullable = false, length = 50)
    private String nomMaison;

    @OneToMany(mappedBy = "nomMaison", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnore
    private List<Eleve> eleves;

    public String getNomMaison() {
        return nomMaison;
    }

    public void setNomMaison(String nomMaison) {
        this.nomMaison = nomMaison;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

}