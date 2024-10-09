package Serdaigle.MIAGIE.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MouvementId entity = (MouvementId) o;
        return Objects.equals(this.mouv, entity.mouv) &&
                Objects.equals(this.idEleve, entity.idEleve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mouv, idEleve);
    }

}