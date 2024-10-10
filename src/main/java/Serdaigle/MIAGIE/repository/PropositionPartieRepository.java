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

    @Query("SELECT p \n" +
            "FROM Propositionpartie p \n" +
            "WHERE p.ideleveReceveur = :joueurCible\n" +
            "AND p.id NOT IN(\n" +
            "    SELECT pa.propositionPartie.id\n" +
            "    \tFROM Partie pa\n" +
            " )")
    Iterable<Propositionpartie> getPropositionByJoueurCible(Eleve joueurCible);

    @Query("SELECT p FROM Propositionpartie p WHERE p.ideleveLanceur = :joueurSource")
    Iterable<Propositionpartie> getPropositionByJoueurSource(Eleve joueurSource);

}


