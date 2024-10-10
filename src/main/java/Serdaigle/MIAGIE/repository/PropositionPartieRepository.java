package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Serdaigle.MIAGIE.model.Propositionpartie;

import java.util.List;

@Repository
public interface PropositionPartieRepository extends JpaRepository<Propositionpartie, Integer> {

    //@Query("SELECT p FROM Propositionpartie p LEFT JOIN Partie pa ON pa.idProposition = p.idProposition WHERE p.idEleveReceveur = 1 AND pa.idProposition IS NULL")

    /*@Query("SELECT p " +
            "FROM Propositionpartie p " +
            "WHERE p.ideleveLanceur = :joueurCible " +
            "AND p.idProposition NOT IN (" +
            "    SELECT pa.propositionPartie.idProposition " +  // On utilise pa.propositionPartie.idProposition pour accéder à l'ID de la proposition dans Partie
            "    FROM Partie pa " +
            ")")*/
    @Query("SELECT p \n" +
            "FROM Propositionpartie p \n" +
            "WHERE p.ideleveReceveur = :joueurCible\n" +
            "AND p.id NOT IN(\n" +
            "    SELECT pa.propositionPartie.id\n" +
            "    \tFROM Partie pa\n" +
            "    )")
    Iterable<Propositionpartie> getPropositionByJoueurCible(Eleve joueurCible);

    @Query("SELECT p FROM Propositionpartie p WHERE p.ideleveLanceur = :joueurSource")
    Iterable<Propositionpartie> getPropositionByJoueurSource(Eleve joueurSource);

}


