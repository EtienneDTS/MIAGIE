package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Maison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository pour gérer les opérations CRUD liées aux objets Maison.
 *
 * Cette interface étend JpaRepository et fournit des méthodes pour
 * effectuer des opérations de base de données sur les entités Maison.
 *
 * Elle inclut des méthodes personnalisées pour récupérer une maison
 * avec ses élèves par nom ainsi que pour trouver une maison par son nom.
 *
 * @author Serdaigle
 * @version 1.0
 * @since 2024-10-09
 */
@Repository
public interface MaisonRepository extends JpaRepository<Maison, Integer> {

    /**
     * Récupère une maison et ses élèves en fonction du nom de la maison.
     *
     * @param nomMaison Le nom de la maison à rechercher.
     * @return L'objet Maison correspondant au nom donné, incluant ses élèves.
     */
    @Query("SELECT m FROM Maison m LEFT JOIN FETCH m.eleves WHERE m.nomMaison = :nomMaison")
    Maison getMaisonWithElevesByNomMaison(@Param("nomMaison") String nomMaison);


    /**
     * Trouve une maison par son nom.
     *
     * @param nomMaison Le nom de la maison à rechercher.
     * @return L'objet Maison correspondant au nom donné.
     */
    Maison findByNomMaison(String nomMaison);

    @Query("SELECT SUM(e.totalPoints) FROM Eleve e WHERE e.nomMaison.nomMaison = :nomMaison")
    int countTotalPoints(@Param("nomMaison") String nomMaison);


    @Query("SELECT e.nomMaison, SUM(e.totalPoints) FROM Eleve e GROUP BY e.nomMaison ORDER by SUM(e.totalPoints) DESC  limit 1")
    Maison getMaisonGagnante();
}
