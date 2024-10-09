package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Eleve;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
    @Query("SELECT e FROM Eleve e LEFT JOIN FETCH e.nomMaison WHERE e.idEleve = :idEleve")
    Eleve getEleveByIdWithMaison(@Param("idEleve") int idEleve);

    @Query("SELECT e FROM Eleve e WHERE e.nomMaison.nomMaison <> 'Serdaigle'")
    Iterable<Eleve> findElevesFromOtherHouses();

    @Transactional
    @Modifying
    @Query("UPDATE Eleve e SET e.totalPoints = e.totalPoints + :nbPoints WHERE e.idEleve = :idEleve")
    void addPoints(@Param("idEleve") int idEleve, @Param("nbPoints") int nbPoints);

    @Query("SELECT e FROM Eleve e WHERE e.nom LIKE :nom% OR e.prenom LIKE :nom%")
    List<Eleve> searchWithFilter(String nom);
}