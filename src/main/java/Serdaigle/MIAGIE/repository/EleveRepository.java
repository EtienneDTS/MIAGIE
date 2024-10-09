package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.model.Maison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
    @Query("SELECT e FROM Eleve e LEFT JOIN FETCH e.nomMaison WHERE e.idEleve = :idEleve")
    Eleve getEleveByIdWithMaison(@Param("idEleve") int idEleve);


}