package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
    // Tu peux ajouter ici des méthodes spécifiques si besoin, par exemple :
    // List<Eleve> findByNom(String nom);
}