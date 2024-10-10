package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "ideleve_vainqueur", nullable = true)
    private Eleve ideleveVainqueur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideleve_receveur", nullable = false)
    private Eleve ideleveReceveur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideleve_lanceur", nullable = false)
    private Eleve ideleveLanceur;



    public Propositionpartie(Eleve eSource, Eleve eDest, int mise) {
        this.ideleveLanceur = eSource;
        this.ideleveReceveur = eDest;
        this.mise = mise;
        this.refuse = false;
    }
    public Propositionpartie() {
    }



    public Integer getId() {
        return id;
    }


    public Integer getMise() {
        return mise;
    }

    public Boolean getRefuse() {
        return refuse;
    }


    public void setRefuse(Boolean refuse) {
        this.refuse = refuse;
    }




    public Eleve getEleveReceveur() {
        return ideleveReceveur;
    }


    public Eleve getEleveLanceur() {
        return ideleveLanceur;
    }


}