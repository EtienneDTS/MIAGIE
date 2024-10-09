package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

/**
 * Représente un mouvement associé à un élève dans le système.
 * Cette classe utilise une clé composite pour identifier de manière unique
 * un mouvement d'élève.
 */
@Entity
@Table(name = "mouvement", schema = "miagie")
public class Mouvement {
    @EmbeddedId
    private MouvementId id;

    @MapsId("idEleve")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEleve", nullable = false)
    private Eleve idEleve;

    @Column(name = "timestampp", length = 50)
    private String timestampp;

    public MouvementId getId() {
        return id;
    }

    public void setId(MouvementId id) {
        this.id = id;
    }

    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    public String getTimestampp() {
        return timestampp;
    }

    public void setTimestampp(String timestampp) {
        this.timestampp = timestampp;
    }

}