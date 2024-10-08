package Serdaigle.MIAGIE.repositories;

import Serdaigle.MIAGIE.models.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
 * Interface Spring qui interagit avec la BD
 * JPARepository est une fonctionnalité fournissant les méthodes de base pour la gestion des entités
 */
@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
    List<Eleve> findByNomMaison(String nomMaison);  // requête pour filtrer par maison
    List<Eleve> findByTotalPoints(int totalPoints); // filtre par points
    List<Eleve> findByAnneeEtude(int anneeEtude);   // filtre par année d'étude
    List<Eleve> findAll();  // pour récupérer tous les élèves
}
