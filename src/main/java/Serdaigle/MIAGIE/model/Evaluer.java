package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Représente l'évaluation d'un élève dans le système MIAGIE.
 *
 * La classe Evaluer correspond à l'entité "evaluer" dans la base de données,
 * qui stocke les informations sur les notes attribuées aux élèves à une date donnée.
 * Elle utilise une clé composite pour lier un élève à une évaluation.
 *
 * @author VotreNom
 * @version 1.0
 * @since 2024-10-09
 */
@Entity
@Table(name = "evaluer", schema = "miagie")
public class Evaluer {
    @EmbeddedId
    private EvaluerId id;

    @MapsId("idEleve")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEleve", nullable = false)
    private Eleve idEleve;

    @Column(name = "note")
    private Integer note;

    @Column(name = "dateEval")
    private LocalDate dateEval;

    public EvaluerId getId() {
        return id;
    }

    public void setId(EvaluerId id) {
        this.id = id;
    }

    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public LocalDate getDateEval() {
        return dateEval;
    }

    public void setDateEval(LocalDate dateEval) {
        this.dateEval = dateEval;
    }

}