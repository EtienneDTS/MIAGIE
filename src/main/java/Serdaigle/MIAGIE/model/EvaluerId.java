package Serdaigle.MIAGIE.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Classe représentant la clé composite pour l'entité Evaluer.
 * Cette clé composite est composée de l'ID de l'élève et du nom de la matière. 
 * Elle permet d'identifier de manière unique une évaluation faite à un élève dans une matière donnée.
 *
 * Les annotations @Embeddable indiquent que cette classe fait partie de l'entité Evaluer 
 * et sera utilisée comme clé composite dans la base de données.
 * 
 * @author 
 * @version 1.0
 * @since 2024-10-09
 */
@Embeddable
public class EvaluerId implements java.io.Serializable {

    /**
     * Identifiant de version pour la sérialisation.
     * Ce numéro permet de vérifier que la classe utilisée pour désérialiser
     * un objet est compatible avec celle qui a été utilisée pour le sérialiser.
     */
    private static final long serialVersionUID = 5268995373866791819L;

    /**
     * Identifiant de l'élève, correspondant à une colonne de la clé composite dans la base de données.
     * Il est annoté avec @Column pour indiquer qu'il sera persisté dans la base de données.
     */
    @Column(name = "idEleve", nullable = false)
    private Integer idEleve;

    /**
     * Nom de la matière dans laquelle l'élève a été évalué.
     * Ce champ fait également partie de la clé composite, et est limité à 50 caractères.
     */
    @Column(name = "nomMatiere", nullable = false, length = 50)
    private String nomMatiere;

    /**
     * Retourne l'identifiant de l'élève.
     * @return l'ID de l'élève.
     */
    public Integer getIdEleve() {
        return idEleve;
    }

    /**
     * Définit l'identifiant de l'élève.
     * @param idEleve l'ID de l'élève à associer à cette clé composite.
     */
    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    /**
     * Retourne le nom de la matière dans laquelle l'élève est évalué.
     * @return le nom de la matière.
     */
    public String getNomMatiere() {
        return nomMatiere;
    }

    /**
     * Définit le nom de la matière dans laquelle l'élève est évalué.
     * @param nomMatiere le nom de la matière à associer à cette clé composite.
     */
    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    /**
     * Vérifie l'égalité entre deux instances de EvaluerId.
     * Deux instances sont considérées comme égales si elles ont le même identifiant d'élève 
     * et le même nom de matière.
     * 
     * @param o L'objet à comparer avec l'instance actuelle.
     * @return true si les deux objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EvaluerId entity = (EvaluerId) o;
        return Objects.equals(this.idEleve, entity.idEleve) &&
               Objects.equals(this.nomMatiere, entity.nomMatiere);
    }

    /**
     * Retourne le code de hachage pour cette instance.
     * Ce code est utilisé dans les collections basées sur des tables de hachage 
     * comme HashMap ou HashSet.
     * 
     * @return Le code de hachage calculé en fonction de l'ID de l'élève et du nom de la matière.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idEleve, nomMatiere);
    }
}
