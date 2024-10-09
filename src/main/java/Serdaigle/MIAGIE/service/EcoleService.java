package Serdaigle.MIAGIE.service;

import Serdaigle.MIAGIE.dto.EleveDTO;
import Serdaigle.MIAGIE.dto.MaisonDTO;
import Serdaigle.MIAGIE.dto.ProfesseurDTO;
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

@Service
public class EcoleService {

    private final ProfesseurRepository professeurRepository;
    private final EleveRepository eleveRepository;
    private final MatiereRepository matiereRepository;
    private final MaisonRepository maisonRepository;
    private final EvaluerRepository evaluerRepository;
    public EcoleService(ProfesseurRepository professeurRepository, EleveRepository eleveRepository, MatiereRepository matiereRepository,
                        MaisonRepository maisonRepository, EvaluerRepository evaluerRepository) {

        this.professeurRepository = professeurRepository;
        this.eleveRepository = eleveRepository;
        this.matiereRepository = matiereRepository;
        this.maisonRepository = maisonRepository;
        this.evaluerRepository = evaluerRepository;
    }

    // Appels des méthodes Professeur

    public Iterable<ProfesseurDTO> getAllProfesseurs(String filter) {
        Iterable<ProfesseurDTO> professeurs = new ArrayList<>();
        if (filter == null || filter.isEmpty()) {
            List<Professeur> professeurdb = professeurRepository.findAll();
            return this.convertDBProfesseurListtoDTOList(professeurdb);
        }
        List<Professeur> professeurdb = professeurRepository.searchWithFilter(filter);
        return this.convertDBProfesseurListtoDTOList(professeurdb);

    }

    public ProfesseurDTO getProfesseurById(Integer id) {
        Optional<Professeur> professeur = professeurRepository.findById(id);
        if(!professeur.isPresent()) {
            throw new ProfesseurNotFoundException("Teacher not found :"+id);
        }
        return this.convertProfesseurToDto(professeur.get());
    }

    public Professeur saveProfesseur(String nom, String prenom, String nomMatiere) {
        Matiere matiere = matiereRepository.findByNomMatiere(nomMatiere);
        Professeur professeur = new Professeur(nom, prenom, matiere);
        return professeurRepository.save(professeur);
    }

    public void deleteProfesseurById(Integer id) {
        professeurRepository.deleteById(id);
    }

    // Appels des méthodes Eleve

    /*
     * Méthode pour obtenir tous les élèves
     */
    public Iterable<EleveDTO> getAllEleves(String filter) {
        Iterable<EleveDTO> eleves = new ArrayList<>();
        if (filter == null || filter.isEmpty()) {
            List<Eleve> elevesdb = eleveRepository.findAll();
            return this.convertDBElevesListtoDTOList(elevesdb);
        }
        List<Eleve> elevesdb = eleveRepository.searchWithFilter(filter);
        return this.convertDBElevesListtoDTOList(elevesdb);
    }

    /*
     * Méthode pour obtenir un élève par son ID
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

    /*
     * Méthode pour supprimer un élève
     */
    public void deleteEleve(int id) {
        eleveRepository.deleteById(id);
    }

    public Iterable<EleveDTO> searchWithFilter(String nom){
        List<Eleve> eleves = this.eleveRepository.searchWithFilter(nom);
        return this.convertDBElevesListtoDTOList(eleves);
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

    public Iterable<MaisonDTO> getAllMaisons() {
        Iterable<Maison>  maisons = maisonRepository.findAll();
        ArrayList<MaisonDTO> maisonDtoList = new ArrayList<>();
        for(Maison maison : maisons) {
            MaisonDTO mDto = this.convertMaisonToDto(this.getMaisonWithElevesByNomMaison(maison.getNomMaison()));
            maisonDtoList.add(mDto);
        }
        return maisonDtoList;
    }

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
        ProfesseurDTO professeur = this.getProfesseurById(idProfesseur);
        String nomMatiere = professeur.getNomMatiere();

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
        return elevesPasASerdaigle;
    }

    public MaisonDTO getMaisonGagnante() {
        Maison maison = maisonRepository.getMaisonGagnante();
        MaisonDTO maisonDTO = this.convertMaisonToDto(maison);
        return maisonDTO;
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

    private ProfesseurDTO convertProfesseurToDto(Professeur professeur) {
        return new ProfesseurDTO(
                professeur.getId(),
                professeur.getNom(),
                professeur.getPrenom(),
                professeur.getNomMatiere().getNomMatiere()
        );
    }

    private ArrayList<ProfesseurDTO> convertDBProfesseurListtoDTOList(List<Professeur> professeurs){
        ArrayList<ProfesseurDTO> professeurDto= new ArrayList<>();
        for (Professeur p : professeurs){
            professeurDto.add(this.convertProfesseurToDto(p));
        }
        return professeurDto;
    }



}