package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "partie", schema = "miagie")
public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartie", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idProposition", referencedColumnName = "idProposition")  // Assure-toi que le nom de la colonne est correct
    private Propositionpartie propositionPartie;

    public Integer getId() {
        return id;
    }

    public Propositionpartie getPropositionPartie() {
        return propositionPartie;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}