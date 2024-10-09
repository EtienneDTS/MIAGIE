package Serdaigle.MIAGIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Serdaigle.MIAGIE.model.Matiere;

import java.util.Optional;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {

    Matiere findByNomMatiere(String nomMatiere);
}
