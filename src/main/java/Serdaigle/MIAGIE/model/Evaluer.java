package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Représente l'évaluation d'un élève dans le système MIAGIE.
 *
 * La classe Evaluer correspond à l'entité "evaluer" dans la base de données, 
 * qui stocke les informations sur les évaluations attribuées aux élèves à une date donnée. 
 * Cette entité est liée à une clé composite pour relier un élève à une évaluation spécifique.
 * 
 * Les champs incluent :
 * - id : la clé composite qui contient les identifiants nécessaires pour lier une évaluation à un élève
 * - idEleve : référence à l'élève évalué
 * - note : la note attribuée à l'élève
 * - dateEval : la date à laquelle l'évaluation a été effectuée
 * 
 * @author 
 * @version 1.0
 * @since 2024-10-09
 */
@Entity
@Table(name = "evaluer", schema = "miagie")
public class Evaluer {

    /**
     * Constructeur par défaut.
     * Ce constructeur est nécessaire pour permettre la création d'une instance de Evaluer
     * sans initialisation directe des champs. 
     */
    public Evaluer() {}

    /**
     * Clé composite représentant l'identifiant de l'évaluation.
     * Elle est composée de plusieurs clés, notamment celle de l'élève et de l'évaluation.
     */
    @EmbeddedId
    private EvaluerId id;

    /**
     * Association avec l'entité Eleve. 
     * Cette annotation @MapsId lie la clé étrangère idEleve dans la clé composite EvaluerId.
     * Le fetch est défini en EAGER pour que l'élève soit chargé en même temps que l'évaluation.
     */
    @MapsId("idEleve")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idEleve", nullable = false)
    private Eleve idEleve;

    /**
     * La note attribuée à l'élève pour cette évaluation.
     */
    @Column(name = "note")
    private Integer note;

    /**
     * La date à laquelle l'évaluation a eu lieu.
     * Le type LocalDate représente une date sans heure.
     */
    @Column(name = "dateEval")
    private LocalDate dateEval;

    /**
     * Retourne l'identifiant composite de l'évaluation.
     * @return l'identifiant composite EvaluerId.
     */
    public EvaluerId getId() {
        return id;
    }

    /**
     * Définit l'identifiant composite de l'évaluation.
     * @param id l'identifiant à attribuer.
     */
    public void setId(EvaluerId id) {
        this.id = id;
    }

    /**
     * Retourne l'élève lié à cette évaluation.
     * @return l'élève évalué.
     */
    public Eleve getIdEleve() {
        return idEleve;
    }

    /**
     * Définit l'élève lié à cette évaluation.
     * @param idEleve l'élève à associer à l'évaluation.
     */
    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    /**
     * Retourne la note attribuée à l'élève.
     * @return la note de l'évaluation.
     */
    public Integer getNote() {
        return note;
    }

    /**
     * Définit la note attribuée à l'élève.
     * @param note la note à attribuer.
     */
    public void setNote(Integer note) {
        this.note = note;
    }

    /**
     * Retourne la date à laquelle l'évaluation a été effectuée.
     * @return la date de l'évaluation.
     */
    public LocalDate getDateEval() {
        return dateEval;
    }

    /**
     * Définit la date à laquelle l'évaluation a eu lieu.
     * @param dateEval la date à attribuer à l'évaluation.
     */
    public void setDateEval(LocalDate dateEval) {
        this.dateEval = dateEval;
    }

}
