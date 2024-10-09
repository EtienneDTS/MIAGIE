package Serdaigle.MIAGIE.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Classe représentant une clé composite pour les mouvements d'élèves.
 * Cette classe est utilisée pour identifier de manière unique un mouvement associé à un élève.
 */
@Embeddable
public class MouvementId implements java.io.Serializable {
    private static final long serialVersionUID = 6957316629164369763L;
    @Column(name = "idEleve", nullable = false)
    private Integer idEleve;

    @Column(name = "mouv", nullable = false, length = 50)
    private String mouv;

    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public String getMouv() {
        return mouv;
    }

    public void setMouv(String mouv) {
        this.mouv = mouv;
    }

    /**
     * Vérifie si deux objets sont égaux.
     *
     * @param o L'objet a comparé.
     * @return true si les objets sont égaux, sinon false.
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
     * Retourne un code de hachage pour l'objet.
     *
     * @return Le code de hachage de l'objet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(mouv, idEleve);
    }

}