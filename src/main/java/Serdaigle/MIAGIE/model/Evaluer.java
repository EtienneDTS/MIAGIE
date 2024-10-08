package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evaluer", schema = "miagie")
public class Evaluer {
    @EmbeddedId
    private EvaluerId id;

    @MapsId("idEleve")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideleve", nullable = false)
    private Eleve idEleve;

    @Column(name = "note")
    private Integer note;

    @Column(name = "dateeval")
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