package Serdaigle.MIAGIE.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Classe représentant la clé composite pour l'entité Évaluer.
 * Cette clé est composée de l'ID de l'élève et du nom de la matière.
 */
@Embeddable
public class EvaluerId implements java.io.Serializable {
    private static final long serialVersionUID = 5268995373866791819L;
    @Column(name = "idEleve", nullable = false)
    private Integer idEleve;

    @Column(name = "nomMatiere", nullable = false, length = 50)
    private String nomMatiere;

    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    /**
     * Vérifie l'égalité entre deux instances de EvaluerId.
     *
     * @param o L'objet a comparé avec l'instance actuelle.
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
     * Retourne le code de hachage pour l'instance actuelle.
     *
     * @return Le code de hachage calculé.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idEleve, nomMatiere);
    }

}