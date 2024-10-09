package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

/**
 * Classe représentant une partie dans le système MIAGIE.
 * Chaque partie possède un identifiant unique.
 */
@Entity
@Table(name = "partie", schema = "miagie")
public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartie", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}