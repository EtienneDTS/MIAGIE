package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

/**
 * Classe représentant une proposition de partie dans le système MIAGIE.
 * Une proposition de partie contient des informations sur les élèves impliqués et la mise.
 * 
 * @version 1.0
 * @since 2024-10-10
 */
@Entity
@Table(name = "propositionpartie", schema = "miagie")
public class Propositionpartie {
    
    /**
     * Identifiant unique pour chaque proposition de partie.
     * Cet identifiant est auto-généré lors de l'insertion dans la base de données.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProposition", nullable = false)
    private Integer id;

    /**
     * La mise associée à la proposition de partie.
     */
    @Column(name = "mise")
    private Integer mise;

    /**
     * Indique si la proposition a été refusée ou non.
     */
    @Column(name = "refuse")
    private Boolean refuse;

    /**
     * L'élève qui est le vainqueur de la proposition.
     * Relation Many-to-One avec l'entité `Eleve`.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideleve_vainqueur", nullable = false)
    private Eleve ideleveVainqueur;

    /**
     * L'élève qui reçoit la proposition.
     * Relation Many-to-One avec l'entité `Eleve`.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideleve_receveur", nullable = false)
    private Eleve ideleveReceveur;

    /**
     * L'élève qui lance la proposition.
     * Relation Many-to-One avec l'entité `Eleve`.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideleve_lanceur", nullable = false)
    private Eleve ideleveLanceur;

    /**
     * Retourne l'identifiant de la proposition de partie.
     * 
     * @return L'identifiant unique de la proposition.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modifie l'identifiant de la proposition de partie.
     * 
     * @param id L'identifiant unique à définir.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retourne la mise de la proposition.
     * 
     * @return La mise associée à la proposition.
     */
    public Integer getMise() {
        return mise;
    }

    /**
     * Modifie la mise de la proposition.
     * 
     * @param mise La nouvelle mise à définir.
     */
    public void setMise(Integer mise) {
        this.mise = mise;
    }

    /**
     * Retourne l'état de refus de la proposition.
     * 
     * @return True si la proposition est refusée, sinon false.
     */
    public Boolean getRefuse() {
        return refuse;
    }

    /**
     * Modifie l'état de refus de la proposition.
     * 
     * @param refuse True pour indiquer un refus, sinon false.
     */
    public void setRefuse(Boolean refuse) {
        this.refuse = refuse;
    }

    /**
     * Retourne l'élève vainqueur de la proposition.
     * 
     * @return L'objet Eleve représentant le vainqueur.
     */
    public Eleve getIdeleveVainqueur() {
        return ideleveVainqueur;
    }

    /**
     * Modifie l'élève vainqueur de la proposition.
     * 
     * @param ideleveVainqueur L'élève à définir comme vainqueur.
     */
    public void setIdeleveVainqueur(Eleve ideleveVainqueur) {
        this.ideleveVainqueur = ideleveVainqueur;
    }

    /**
     * Retourne l'élève receveur de la proposition.
     * 
     * @return L'objet Eleve représentant le receveur.
     */
    public Eleve getIdeleveReceveur() {
        return ideleveReceveur;
    }

    /**
     * Modifie l'élève receveur de la proposition.
     * 
     * @param ideleveReceveur L'élève à définir comme receveur.
     */
    public void setIdeleveReceveur(Eleve ideleveReceveur) {
        this.ideleveReceveur = ideleveReceveur;
    }

    /**
     * Retourne l'élève lanceur de la proposition.
     * 
     * @return L'objet Eleve représentant le lanceur.
     */
    public Eleve getIdeleveLanceur() {
        return ideleveLanceur;
    }

    /**
     * Modifie l'élève lanceur de la proposition.
     * 
     * @param ideleveLanceur L'élève à définir comme lanceur.
     */
    public void setIdeleveLanceur(Eleve ideleveLanceur) {
        this.ideleveLanceur = ideleveLanceur;
    }
}
