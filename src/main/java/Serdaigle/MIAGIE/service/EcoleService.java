package Serdaigle.MIAGIE.service;

import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.model.Professeur;
import Serdaigle.MIAGIE.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EcoleService {


    private final ProfesseurRepository professeurRepository;

    @Autowired
    public EcoleService(ProfesseurRepository professeurRepository) {

        this.professeurRepository = professeurRepository;
    }

    public Professeur getProfesseurById(Integer id) {
        Optional<Professeur> professeur = professeurRepository.findById(id);
        return professeur.orElseThrow(() -> new RuntimeException("Professeur not found with id: " + id));
    }

    public Eleve getEleveById(Integer id) {
        return null;// TODO
    }
}