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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service gérant les opérations métiers pour l'école.
 * Cette classe permet la gestion des professeurs, élèves, matières et maisons
 * dans le système MIAGIE, en interagissant avec les couches repository correspondantes.
 *
 * @author VotreNom
 * @version 1.0
 * @since 2024-10-08
 */
@Service
public class EcoleService {



    private final ProfesseurRepository professeurRepository;
    private final EleveRepository eleveRepository;
    private final MatiereRepository matiereRepository;
    private final MaisonRepository maisonRepository;

    /**
     * Constructeur du service EcoleService injectant les repositories nécessaires.
     *
     * @param professeurRepository Repository des professeurs
     * @param eleveRepository Repository des élèves
     * @param matiereRepository Repository des matières
     * @param maisonRepository Repository des maisons
     */
    public EcoleService(ProfesseurRepository professeurRepository, EleveRepository eleveRepository, MatiereRepository matiereRepository,MaisonRepository maisonRepository) {

        this.professeurRepository = professeurRepository;
        this.eleveRepository = eleveRepository;
        this.matiereRepository = matiereRepository;
        this.maisonRepository = maisonRepository;
    }

    // Méthodes pour la gestion des professeurs
    /**
     * Méthode pour obtenir la liste de tous les professeurs.
     *
     * @return Une collection Iterable de professeurs.
     */
    public Iterable<Professeur> getAllProfesseurs() {

        return professeurRepository.findAll();
    }

    /**
     * Méthode pour obtenir un professeur par son ID.
     *
     * @param id L'ID du professeur.
     * @return L'objet Professeur correspondant.
     * @throws ProfesseurNotFoundException si le professeur n'est pas trouvé.
     */
    public Professeur getProfesseurById(Integer id) {
        Optional<Professeur> professeur = professeurRepository.findById(id);
        return professeur.orElseThrow(() -> new ProfesseurNotFoundException("Teacher not found with id: " + id));
    }

    /**
     * Méthode pour créer ou mettre à jour un professeur.
     *
     * @param nom Nom du professeur.
     * @param prenom Prénom du professeur.
     * @param nomMatiere Nom de la matière enseignée par le professeur.
     * @return Le professeur créé ou mis à jour.
     */
    public Professeur saveProfesseur(String nom, String prenom, String nomMatiere) {
        Matiere matiere = matiereRepository.findByNomMatiere(nomMatiere);
        Professeur professeur = new Professeur(nom, prenom, matiere);
        return professeurRepository.save(professeur);
    }

    /**
     * Méthode pour supprimer un professeur par son ID.
     *
     * @param id L'ID du professeur à supprimer.
     */
    public void deleteProfesseurById(Integer id) {
        professeurRepository.deleteById(id);
    }

    // Méthodes pour la gestion des élèves
    /**
     * Méthode pour obtenir la liste de tous les élèves.
     *
     * @return Une collection Iterable d'élèves.
     */
    public Iterable<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    /**
     * Méthode pour obtenir un élève par son ID.
     *
     * @param id L'ID de l'élève.
     * @return L'objet Eleve correspondant.
     * @throws EleveNotFoundException si l'élève n'est pas trouvé.
     */
    public Eleve getEleveById(int id) {
        Optional<Eleve> eleve = eleveRepository.findById(id);
        return eleve.orElseThrow(() -> new EleveNotFoundException("Student not found with id: " + id));
    }

    /**
     * Méthode pour ajouter un nouvel élève.
     *
     * @param nom Nom de l'élève.
     * @param prenom Prénom de l'élève.
     * @param nomMaison Nom de la maison à laquelle l'élève appartient.
     * @return L'élève créé.
     */
    public Eleve addEleve(String nom, String prenom, String nomMaison) {

        Eleve eleve = new Eleve();
        eleve.setNom(nom);
        eleve.setPrenom(prenom);
        eleve.setTotalPoints(0);
        Maison m = maisonRepository.findByNomMaison(nomMaison);
        eleve.setMaison(m);
        return eleveRepository.save(eleve);
    }

    /**
     * Méthode pour supprimer un élève par son ID.
     *
     * @param id L'ID de l'élève à supprimer.
     */
    public void deleteEleve(int id) {
        eleveRepository.deleteById(id);
    }

    // Méthodes pour la gestion des matières

    /**
     * Méthode pour obtenir la liste de toutes les matières.
     *
     * @return Une collection Iterable de matières.
     */

    public Iterable<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    /**
     * Méthode pour obtenir une matière par son nom.
     *
     * @param nomMatiere Le nom de la matière.
     * @return L'objet Matiere correspondant.
     */
    public Matiere getMatiereByNomMatiere(String nomMatiere) {
        Matiere matiere = matiereRepository.findByNomMatiere(nomMatiere);
        return matiere;

    }

    // Méthodes pour la gestion des maisons

    /**
     * Méthode pour obtenir la liste de toutes les maisons.
     *
     * @return Une collection Iterable de maisons.
     */
    public Iterable<Maison> getAllMaisons() {
        return maisonRepository.findAll();
    }

    /**
     * Méthode pour obtenir une maison par son nom, avec la liste des élèves.
     *
     * @param nomMaison Le nom de la maison.
     * @return L'objet Maison avec ses élèves.
     */
    public Maison getMaisonWithElevesByNomMaison(String nomMaison) {
        Maison maison = maisonRepository.getMaisonWithElevesByNomMaison(nomMaison);
        return maison;

    }

    /*
    public ResponseEntity<Void> ajouterPointsEleve(int idProfesseur, int idEleve, int nbPoints) {
        Optional<Professeur> professeur = professeurRepository.findById(idProfesseur);
        Optional<Eleve> eleve = eleveRepository.findById(idEleve);
        if (professeur.isPresent() && eleve.isPresent()) {
            Eleve e = eleve.get();
            e.setTotalPoints(e.getTotalPoints() + nbPoints);
            eleveRepository.save(e);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}