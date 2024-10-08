package Serdaigle.MIAGIE.service;

import Serdaigle.MIAGIE.model.Professeur;
import Serdaigle.MIAGIE.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    // Récupérer tous les professeurs
    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    // Récupérer un professeur par son id
    public Optional<Professeur> getProfesseurById(Integer id) {
        return professeurRepository.findById(id);
    }

    // Créer ou mettre à jour un professeur
    public Professeur saveProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    // Supprimer un professeur par son id
    public void deleteProfesseurById(Integer id) {
        professeurRepository.deleteById(id);
    }
}
