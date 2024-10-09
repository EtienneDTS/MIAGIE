package Serdaigle.MIAGIE.service;

import Serdaigle.MIAGIE.exception.EleveNotFoundException;
import Serdaigle.MIAGIE.exception.ProfesseurNotFoundException;
import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.model.Maison;
import Serdaigle.MIAGIE.model.Matiere;
import Serdaigle.MIAGIE.model.Professeur;
import Serdaigle.MIAGIE.repository.EleveRepository;
import Serdaigle.MIAGIE.repository.MaisonRepository;
import Serdaigle.MIAGIE.repository.MatiereRepository;
import Serdaigle.MIAGIE.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EcoleService {



    private final ProfesseurRepository professeurRepository;
    private final EleveRepository eleveRepository;
    private final MatiereRepository matiereRepository;
    private final MaisonRepository maisonRepository;
    public EcoleService(ProfesseurRepository professeurRepository, EleveRepository eleveRepository, MatiereRepository matiereRepository,MaisonRepository maisonRepository) {

        this.professeurRepository = professeurRepository;
        this.eleveRepository = eleveRepository;
        this.matiereRepository = matiereRepository;
        this.maisonRepository = maisonRepository;
    }

    // Appels des méthodes Professeur

    public Iterable<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    public Professeur getProfesseurById(Integer id) {
        Optional<Professeur> professeur = professeurRepository.findById(id);
        return professeur.orElseThrow(() -> new ProfesseurNotFoundException("Teacher not found with id: " + id));
    }

    public Professeur saveProfesseur(String nom, String prenom, String nomMatiere) {

        Professeur professeur = new Professeur(nom, prenom, nomMatiere);
        return professeurRepository.save(professeur);
    }

    public void deleteProfesseurById(Integer id) {
        professeurRepository.deleteById(id);
    }

    // Appels des méthodes Eleve

    /*
     * Méthode pour obtenir tous les élèves
     */
    public Iterable<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    /*
     * Méthode pour obtenir un élève par son ID
     */
    public Eleve getEleveById(int id) {
        Optional<Eleve> eleve = eleveRepository.findById(id);
        return eleve.orElseThrow(() -> new EleveNotFoundException("Student not found with id: " + id));
    }

    /*
     * Méthode pour ajouter un nouvel élève
     */
    public Eleve addEleve(String nom, String prenom, String nomMaison) {

        Eleve eleve = new Eleve();
        eleve.setNom(nom);
        eleve.setPrenom(prenom);
        eleve.setTotalPoints(0);
        Maison m = maisonRepository.findByNomMaison(nomMaison);
        eleve.setNomMaison(m);
        return eleveRepository.save(eleve);
    }

    /*
     * Méthode pour supprimer un élève
     */
    public void deleteEleve(int id) {
        eleveRepository.deleteById(id);
    }

    // Appels matières

    public Iterable<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    public Matiere getMatiereByNomMatiere(String nomMatiere) {
        Matiere matiere = matiereRepository.findByNomMatiere(nomMatiere);
        return matiere;

    }


    // Methodes Maisons

    public Iterable<Maison> getAllMaisons() {
        return maisonRepository.findAll();
    }

    public Maison getMaisonWithElevesByNomMaison(String nomMaison) {
        Maison maison = maisonRepository.getMaisonWithElevesByNomMaison(nomMaison);
        return maison;

    }



}