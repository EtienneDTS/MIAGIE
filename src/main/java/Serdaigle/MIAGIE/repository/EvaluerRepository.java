package Serdaigle.MIAGIE.repository;

import Serdaigle.MIAGIE.model.Evaluer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluerRepository extends JpaRepository<Evaluer, Integer> {

}