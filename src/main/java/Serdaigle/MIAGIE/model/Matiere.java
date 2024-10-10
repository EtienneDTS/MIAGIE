package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Représente une matière dans le système MIAGIE.
 * 
 * La classe Matiere est mappée à la table "matiere" dans la base de données. 
 * Chaque matière est identifiée par un nom unique qui sert de clé primaire.
 * 
 * @author 
 * @version 1.0
 * @since 2024-10-09
 */
@Entity
@Table(name = "matiere", schema = "miagie")
public class Matiere {

    /**
     * Nom de la matière.
     * Ce champ constitue la clé primaire de l'entité Matiere dans la base de données.
     * Il est unique et ne peut pas être nul. La longueur maximale du nom est de 50 caractères.
     */
    @Id
    @Column(name = "nomMatiere", nullable = false, length = 50)
    private String nomMatiere;

    /**
     * Constructeur par défaut.
     */
    public Matiere() {
    }

    /**
     * Constructeur avec paramètre.
     * Permet de créer une instance de Matiere avec un nom spécifié.
     * Utilise @JsonCreator pour faciliter la désérialisation à partir d'un JSON.
     * 
     * @param nomMatiere Le nom de la matière.
     */
    @JsonCreator
    public Matiere(@JsonProperty("nomMatiere") String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    /**
     * Retourne le nom de la matière.
     * @return Le nom de la matière.
     */
    public String getNomMatiere() {
        return nomMatiere;
    }

    /**
     * Définit le nom de la matière.
     * @param nomMatiere Le nom de la matière à associer.
     */
    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

}
