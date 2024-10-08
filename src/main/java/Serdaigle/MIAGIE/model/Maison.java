package Serdaigle.MIAGIE.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "maison", schema = "miagie")
public class Maison {
    @Id
    @Column(name = "nommaison", nullable = false, length = 50)
    private String nomMaison;

    public String getNomMaison() {
        return nomMaison;
    }

    public void setNomMaison(String nomMaison) {
        this.nomMaison = nomMaison;
    }

}