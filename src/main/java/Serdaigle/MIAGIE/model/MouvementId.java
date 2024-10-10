package Serdaigle.MIAGIE.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Classe représentant une clé composite pour les mouvements d'élèves.
 * 
 * Cette clé est utilisée pour identifier de manière unique un mouvement d'élève.
 * Elle est composée de deux éléments : l'ID de l'élève (idEleve) et un identifiant
 * unique pour le mouvement (mouv).
 * 
 * @author 
 * @version 1.0
 * @since 2024-10-09
 */
@Embeddable
public class MouvementId implements java.io.Serializable {

    private static final long serialVersionUID = 6957316629164369763L;

    /**
     * L'ID de l'élève associé au mouvement.
     * Ce champ correspond à la colonne "idEleve" de la table "mouvement".
     */
    @Column(name = "idEleve", nullable = false)
    private Integer idEleve;

    /**
     * Un identifiant unique pour le mouvement.
     * Ce champ correspond à la colonne "mouv" de la table "mouvement".
     * Il est limité à 50 caractères.
     */
    @Column(name = "mouv", nullable = false, length = 50)
    private String mouv;

    /**
     * Retourne l'ID de l'élève associé à ce mouvement.
     * @return L'ID de l'élève.
     */
    public Integer getIdEleve() {
        return idEleve;
    }

    /**
     * Définit l'ID de l'élève associé à ce mouvement.
     * @param idEleve L'ID de l'élève à définir.
     */
    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    /**
     * Retourne l'identifiant unique du mouvement.
     * @return L'identifiant unique du mouvement.
     */
    public String getMouv() {
        return mouv;
    }

    /**
     * Définit l'identifiant unique du mouvement.
     * @param mouv L'identifiant à définir.
     */
    public void setMouv(String mouv) {
        this.mouv = mouv;
    }

    /**
     * Vérifie si deux objets de type `MouvementId` sont égaux.
     * 
     * @param o L'objet à comparer avec l'instance actuelle.
     * @return true si les deux objets sont égaux, sinon false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MouvementId entity = (MouvementId) o;
        return Objects.equals(this.mouv, entity.mouv) &&
                Objects.equals(this.idEleve, entity.idEleve);
    }

    /**
     * Retourne le code de hachage pour cet objet, nécessaire pour garantir
     * l'unicité dans les collections comme les sets.
     * 
     * @return Le code de hachage calculé pour cet objet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(mouv, idEleve);
    }

}
