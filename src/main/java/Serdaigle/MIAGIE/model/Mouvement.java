package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

/**
 * Représente un mouvement associé à un élève dans le système MIAGIE.
 * 
 * La classe Mouvement est mappée à la table "mouvement" dans le schéma "miagie".
 * Chaque mouvement est lié à un élève et utilise une clé composite pour garantir
 * l'unicité de chaque mouvement. Cette clé est gérée via la classe `MouvementId`.
 * 
 * @author 
 * @version 1.0
 * @since 2024-10-09
 */
@Entity
@Table(name = "mouvement", schema = "miagie")
public class Mouvement {

    /**
     * Clé composite pour identifier de manière unique un mouvement d'élève.
     * La clé est définie via la classe `MouvementId`.
     */
    @EmbeddedId
    private MouvementId id;

    /**
     * L'élève associé à ce mouvement.
     * Ce champ est une relation de plusieurs à un avec l'entité `Eleve`.
     * Utilise la clé étrangère `idEleve` pour faire référence à l'élève.
     */
    @MapsId("idEleve")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEleve", nullable = false)
    private Eleve idEleve;

    /**
     * Le timestamp associé au mouvement. Il est stocké sous forme de chaîne de caractères
     * avec une longueur maximale de 50 caractères.
     */
    @Column(name = "timestampp", length = 50)
    private String timestampp;

    /**
     * Retourne la clé composite du mouvement.
     * @return La clé composite du mouvement.
     */
    public MouvementId getId() {
        return id;
    }

    /**
     * Définit la clé composite du mouvement.
     * @param id La clé composite à définir.
     */
    public void setId(MouvementId id) {
        this.id = id;
    }

    /**
     * Retourne l'élève associé à ce mouvement.
     * @return L'élève associé.
     */
    public Eleve getIdEleve() {
        return idEleve;
    }

    /**
     * Définit l'élève associé à ce mouvement.
     * @param idEleve L'élève à associer.
     */
    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    /**
     * Retourne le timestamp du mouvement.
     * @return Le timestamp du mouvement.
     */
    public String getTimestampp() {
        return timestampp;
    }

    /**
     * Définit le timestamp du mouvement.
     * @param timestampp Le timestamp à définir.
     */
    public void setTimestampp(String timestampp) {
        this.timestampp = timestampp;
    }
}
