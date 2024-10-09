package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.model.Maison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query("SELECT e FROM Eleve e LEFT JOIN FETCH e.nomMaison WHERE e.idEleve = :idEleve")
    Eleve getEleveByIdWithMaison(@Param("idEleve") int idEleve);


}