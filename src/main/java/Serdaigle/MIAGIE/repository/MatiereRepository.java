package Serdaigle.MIAGIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Serdaigle.MIAGIE.model.Matiere;

import java.util.Optional;


/**
 * Repository pour gérer les opérations CRUD liées aux objets Matiere.
 *
 * Cette interface étend JpaRepository et fournit des méthodes pour
 * effectuer des opérations de base de données sur les entités Matiere.
 *
 * Elle inclut également une méthode personnalisée pour récupérer une
 * matière par son nom.
 *
 * @author Serdaigle
 * @version 1.0
 * @since 2024-10-09
 */
@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

    /**
     * Trouve une matière par son nom.
     *
     * @param nomMatiere Le nom de la matière à rechercher.
     * @return L'objet Matiere correspondant au nom donné.
     */
    Matiere findByNomMatiere(String nomMatiere);
}
