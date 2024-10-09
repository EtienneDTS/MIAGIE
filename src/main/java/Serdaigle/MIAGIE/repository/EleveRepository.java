package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour gérer les opérations CRUD liées aux objets Eleve.
 *
 * Cette interface étend JpaRepository et fournit des méthodes pour
 * effectuer des opérations de base de données sur les entités Eleve.
 *
 * Elle permet d'effectuer des opérations standards de CRUD sur les élèves
 * ainsi que d'ajouter des méthodes spécifiques si nécessaire pour
 * des requêtes personnalisées.
 *
 * @author Serdaigle
 * @version 1.0
 * @since 2024-10-09
 */
@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
    // Tu peux ajouter ici des méthodes spécifiques si besoin, par exemple :
    // List<Eleve> findByNom(String nom);
}