package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

/**
 * Classe représentant une partie dans le système MIAGIE.
 * Chaque partie possède un identifiant unique, généré automatiquement.
 * 
 * @author 
 * @version 1.0
 * @since 2024-10-10
 */
@Entity
@Table(name = "partie", schema = "miagie")
public class Partie {

    /**
     * Identifiant unique de la partie. Il est généré automatiquement par la base de données
     * lorsque la partie est insérée dans la table "partie".
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartie", nullable = false)
    private Integer id;

    /**
     * Retourne l'identifiant unique de la partie.
     * 
     * @return L'identifiant unique de la partie.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique de la partie.
     * Cette méthode est généralement utilisée par le framework et non manuellement,
     * car l'ID est généré automatiquement.
     * 
     * @param id L'identifiant unique de la partie.
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
