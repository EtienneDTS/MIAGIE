package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Maison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaisonRepository extends JpaRepository<Maison, Integer> {

    @Query("SELECT m FROM Maison m LEFT JOIN FETCH m.eleves WHERE m.nomMaison = :nomMaison")
    Maison getMaisonWithElevesByNomMaison(@Param("nomMaison") String nomMaison);

    Maison findByNomMaison(String nomMaison);

    @Query("SELECT SUM(e.totalPoints) FROM Eleve e WHERE e.nomMaison.nomMaison = :nomMaison")
    int countTotalPoints(@Param("nomMaison") String nomMaison);


    @Query("SELECT e.nomMaison, SUM(e.totalPoints) FROM Eleve e GROUP BY e.nomMaison ORDER by SUM(e.totalPoints) DESC  limit 1")
    Maison getMaisonGagnante();
}
