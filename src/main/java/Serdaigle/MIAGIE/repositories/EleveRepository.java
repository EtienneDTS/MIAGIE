package Serdaigle.MIAGIE.repositories;

import Serdaigle.MIAGIE.models.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
    List<Eleve> findByNomMaison(String nomMaison);  // Ex. requête pour filtrer par maison
}
