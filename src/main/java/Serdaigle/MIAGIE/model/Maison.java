package Serdaigle.MIAGIE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

/**
 * Classe représentant une maison dans le système MIAGIE.
 * Chaque maison regroupe un ensemble d'élèves qui lui sont affiliés.
 * 
 * La classe Maison est mappée à la table "maison" dans la base de données. 
 * Elle est liée à l'entité Eleve via une relation un-à-plusieurs (OneToMany).
 * 
 * @author 
 * @version 1.0
 * @since 2024-10-09
 */
@Entity
@Table(name = "maison", schema = "miagie")
public class Maison {

    /**
     * Nom de la maison.
     * Ce champ constitue la clé primaire de l'entité Maison dans la base de données.
     * Il est unique pour chaque maison et ne peut pas être nul. La longueur maximale du nom est de 50 caractères.
     */
    @Id
    @Column(name = "nomMaison", nullable = false, length = 50)
    private String nomMaison;

    /**
     * Liste des élèves appartenant à cette maison.
     * 
     * La relation est définie par la clé étrangère "nomMaison" dans l'entité Eleve. 
     * liste récupérée paresseusement (fetch = FetchType.LAZY) pour éviter 
     * de charger les données des élèves tant qu'elles ne sont pas explicitement demandées.
     * La relation utilise l'annotation CascadeType.ALL pour propager les opérations 
     * de persistance (INSERT, UPDATE, DELETE) aux élèves associés.
     * 
     * La relation marquée avec @JsonManagedReference pour éviter les 
     * problèmes de sérialisation cyclique lors de l'utilisation de Jackson.
     * L'annotation @JsonIgnore permet d'ignorer la liste des élèves lors de la sérialisation JSON, 
     * afin de ne pas exposer ces informations dans les réponses API.
     */
    @OneToMany(mappedBy = "nomMaison", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnore
    private List<Eleve> eleves;

    /**
     * Retourne le nom de la maison.
     * @return Le nom de la maison.
     */
    public String getNomMaison() {
        return nomMaison;
    }

    /**
     * Définit le nom de la maison.
     * @param nomMaison Le nom de la maison à associer.
     */
    public void setNomMaison(String nomMaison) {
        this.nomMaison = nomMaison;
    }

    /**
     * Retourne la liste des élèves associés à cette maison.
     * @return La liste des élèves appartenant à cette maison.
     */
    public List<Eleve> getEleves() {
        return eleves;
    }

    /**
     * Définit la liste des élèves associés à cette maison.
     * @param eleves La liste des élèves à associer à cette maison.
     */
    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }

}
