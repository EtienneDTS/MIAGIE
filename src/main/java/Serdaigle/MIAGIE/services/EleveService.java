package Serdaigle.MIAGIE.services;

import Serdaigle.MIAGIE.models.Eleve;
import Serdaigle.MIAGIE.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleveService {

    private final EleveRepository eleveRepository;

    @Autowired
    public EleveService(EleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
    }

    // Méthode pour obtenir tous les élèves
    public List<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    // Méthode pour obtenir un élève par son ID
    public Optional<Eleve> getEleveById(int id) {
        return eleveRepository.findById(id);
    }

    // Méthode pour ajouter un nouvel élève
    public Eleve addEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    // Méthode pour supprimer un élève
    public void deleteEleve(int id) {
        eleveRepository.deleteById(id);
    }
}
