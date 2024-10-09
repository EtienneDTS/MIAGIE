package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "maison", schema = "miagie")
public class Maison {
    @Id
    @Column(name = "nomMaison", nullable = false, length = 50)
    private String nomMaison;

    // Relation OneToMany avec les élèves
    @OneToMany(mappedBy = "nomMaison", fetch = FetchType.LAZY)
    @JsonManagedReference
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