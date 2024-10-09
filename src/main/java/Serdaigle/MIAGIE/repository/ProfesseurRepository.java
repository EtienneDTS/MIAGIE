package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

    @Query("SELECT e FROM Professeur e WHERE e.nom LIKE :nom% OR e.prenom LIKE :nom%")
    List<Professeur> searchWithFilter(String nom);

}