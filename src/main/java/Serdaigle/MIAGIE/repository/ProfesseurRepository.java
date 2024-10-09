package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository pour gérer les opérations CRUD liées aux objets Professeur.
 *
 * Cette interface étend JpaRepository et fournit des méthodes pour
 * effectuer des opérations de base de données sur les entités Professeur.
 *
 * Les méthodes de cette interface sont héritées de JpaRepository et
 * incluent des opérations telles que la sauvegarde, la recherche, la
 * mise à jour et la suppression des professeurs.
 *
 * @author Serdaigle
 * @version 1.0
 * @since 2024-10-09
 */
@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

}