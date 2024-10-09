package Serdaigle.MIAGIE.service;

import Serdaigle.MIAGIE.dto.EleveDTO;
import Serdaigle.MIAGIE.dto.MaisonDTO;
import Serdaigle.MIAGIE.exception.EleveNotFoundException;
import Serdaigle.MIAGIE.exception.ProfesseurNotFoundException;
import Serdaigle.MIAGIE.model.*;
import Serdaigle.MIAGIE.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
<<<<<<< HEAD

    /**
     * Constructeur du service EcoleService injectant les repositories nécessaires.
     *
     * @param professeurRepository Repository des professeurs
     * @param eleveRepository Repository des élèves
     * @param matiereRepository Repository des matières
     * @param maisonRepository Repository des maisons
     */
    public EcoleService(ProfesseurRepository professeurRepository, EleveRepository eleveRepository, MatiereRepository matiereRepository,MaisonRepository maisonRepository) {
=======
    private final EvaluerRepository evaluerRepository;
    public EcoleService(ProfesseurRepository professeurRepository, EleveRepository eleveRepository, MatiereRepository matiereRepository,
                        MaisonRepository maisonRepository, EvaluerRepository evaluerRepository) {
>>>>>>> 483fa23 (Ajouts DTO, maison gagnante, ajout points, totalPointMaison...)

        this.professeurRepository = professeurRepository;
        this.eleveRepository = eleveRepository;
        this.matiereRepository = matiereRepository;
        this.maisonRepository = maisonRepository;
        this.evaluerRepository = evaluerRepository;
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


    // Pour l'API
    //public EleveDTO getDTOEleveById(int id) {

    //    return eleveDTO;
        //return eleveDTO.orElseThrow(() -> new EleveNotFoundException("Student not found with id: " + id));
    //}

    //Pour interne
    public Eleve getEleveById(int id) {
        Optional<Eleve> eleve = eleveRepository.findById(id);
        return eleve.orElseThrow(() -> new EleveNotFoundException("Student not found with id: " + id));
    }

    public EleveDTO getEleveByIdWithMaison(int idEleve) {
        //Eleve eleve = eleveRepository.getEleveByIdWithMaison(idEleve);
        //return eleve;


        Optional<Eleve> eleve = eleveRepository.findById(idEleve);
        if(!eleve.isPresent()) {
            throw new EleveNotFoundException("Eleve not found with id: " + idEleve);
        }
        EleveDTO eleveDTO = new EleveDTO(eleve.get().getId(), eleve.get().getNom(),
                eleve.get().getPrenom(), eleve.get().getTotalPoints(), eleve.get().getNomMaison());


        return eleveDTO;

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


    // Appels matières
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

<<<<<<< HEAD
    /**
     * Méthode pour obtenir la liste de toutes les maisons.
     *
     * @return Une collection Iterable de maisons.
     */
    public Iterable<Maison> getAllMaisons() {
        return maisonRepository.findAll();
=======
    // Methodes Maisons

    public Iterable<MaisonDTO> getAllMaisons() {
        Iterable<Maison>  maisons = maisonRepository.findAll();
        ArrayList<MaisonDTO> maisonDtoList = new ArrayList<>();
        for(Maison maison : maisons) {
            MaisonDTO mDto = this.convertMaisonToDto(this.getMaisonWithElevesByNomMaison(maison.getNomMaison()));
            maisonDtoList.add(mDto);
        }
        return maisonDtoList;
>>>>>>> 483fa23 (Ajouts DTO, maison gagnante, ajout points, totalPointMaison...)
    }

    /**
     * Méthode pour obtenir une maison par son nom, avec la liste des élèves.
     *
     * @param nomMaison Le nom de la maison.
     * @return L'objet Maison avec ses élèves.
     */
    public Maison getMaisonWithElevesByNomMaison(String nomMaison) {
        Maison maison = maisonRepository.getMaisonWithElevesByNomMaison(nomMaison);
        int totalPoints = maisonRepository.countTotalPoints(nomMaison);
        MaisonDTO maisonDTO = new MaisonDTO(maison.getNomMaison(),totalPoints,convertDBElevesListtoDTOList(maison.getEleves()));
        return maison;

    }

    public MaisonDTO convertMaisonToDto(Maison maison) {
        int totalPoints = maisonRepository.countTotalPoints(maison.getNomMaison());
        List<EleveDTO> eleveDtos = this.convertDBElevesListtoDTOList(maison.getEleves());

        //maisonDto.setEleves(eleveDtos);
        MaisonDTO maisonDto = new MaisonDTO(maison.getNomMaison(),  totalPoints, eleveDtos);
        return maisonDto;

    }


    // Méthodes d'évaluation (Evaluer)
    public Iterable<Evaluer> getAllEvaluer() {
        return evaluerRepository.findAll();
    }


    public Evaluer addEvaluer(int idEleve, int idProfesseur, int nbPoints) {

        Eleve eleve = this.getEleveById(idEleve);
        Professeur professeur = this.getProfesseurById(idProfesseur);
        String nomMatiere = professeur.getNomMatiere().getNomMatiere();

        // Créer l'ID composite pour Evaluer
        EvaluerId evaluerId = new EvaluerId();
        evaluerId.setIdEleve(eleve.getId());  // Supposons que Eleve ait une méthode getId()
        evaluerId.setNomMatiere(nomMatiere);

        // Une évaluation contient : idEleve (json), nomMatière (à récup par professeur), nbPoints
        Evaluer evaluer = new Evaluer();
        evaluer.setId(evaluerId);
        evaluer.setIdEleve(eleve);
        evaluer.setNote(nbPoints);
        evaluer.setDateEval(LocalDate.from(LocalDateTime.now()));

        System.out.println(evaluer);
        eleveRepository.addPoints(idEleve, nbPoints);
        return evaluerRepository.save(evaluer);
    }

    public Iterable<EleveDTO> getEleveFromOtherHouse() {
        // Récupérer la maison de l'utilisateur actuel
        ArrayList<EleveDTO> elevesPasASerdaigle = new ArrayList<>();
        // Rechercher les élèves dans les autres maisons
        Iterable<Eleve> eleves = eleveRepository.findElevesFromOtherHouses();
        for (Eleve e : eleves){
            EleveDTO edto = this.convertEleveToDto(e);
            elevesPasASerdaigle.add(edto);
        }
<<<<<<< HEAD
    }*/
}
=======
        return elevesPasASerdaigle;
    }





    // ______________METHODES PRIVEES - maniulation structures de données___________________

    /**
     * Convertit un modèle Eleve BDD en modèle DTO
     * @param eleve
     * @return
     */
    private EleveDTO convertEleveToDto(Eleve eleve) {
        return new EleveDTO(
                eleve.getId(),
                eleve.getNom(),
                eleve.getPrenom(),
                eleve.getTotalPoints(),
                eleve.getNomMaison()
        );
    }

    /**
     * Convertit une liste de modeles d'eleves bdd en une liste DTO
     * @param eleves
     * @return
     */
    private ArrayList<EleveDTO> convertDBElevesListtoDTOList(List<Eleve> eleves){
        ArrayList<EleveDTO> elevesDto= new ArrayList<>();
        for (Eleve e : eleves){
            elevesDto.add(this.convertEleveToDto(e));
        }
        return elevesDto;
    }


    public MaisonDTO getMaisonGagnante() {
        Maison maison = maisonRepository.getMaisonGagnante();
        MaisonDTO maisonDTO = this.convertMaisonToDto(maison);
        return maisonDTO;
    }
}
>>>>>>> 483fa23 (Ajouts DTO, maison gagnante, ajout points, totalPointMaison...)
