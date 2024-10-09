package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "propositionpartie", schema = "miagie")
public class Propositionpartie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProposition", nullable = false)
    private Integer id;

    @Column(name = "mise")
    private Integer mise;

    @Column(name = "refuse")
    private Boolean refuse;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideleve_vainqueur", nullable = false)
    private Eleve ideleveVainqueur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideleve_receveur", nullable = false)
    private Eleve ideleveReceveur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideleve_lanceur", nullable = false)
    private Eleve ideleveLanceur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMise() {
        return mise;
    }

    public void setMise(Integer mise) {
        this.mise = mise;
    }

    public Boolean getRefuse() {
        return refuse;
    }

    public void setRefuse(Boolean refuse) {
        this.refuse = refuse;
    }

    public Eleve getIdeleveVainqueur() {
        return ideleveVainqueur;
    }

    public void setIdeleveVainqueur(Eleve ideleveVainqueur) {
        this.ideleveVainqueur = ideleveVainqueur;
    }

    public Eleve getIdeleveReceveur() {
        return ideleveReceveur;
    }

    public void setIdeleveReceveur(Eleve ideleveReceveur) {
        this.ideleveReceveur = ideleveReceveur;
    }

    public Eleve getIdeleveLanceur() {
        return ideleveLanceur;
    }

    public void setIdeleveLanceur(Eleve ideleveLanceur) {
        this.ideleveLanceur = ideleveLanceur;
    }

}