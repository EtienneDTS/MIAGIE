package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.dto.EleveDTO;
import Serdaigle.MIAGIE.exception.EleveNotFoundException;
import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Le contrôleur REST pour gérer les opérations liées aux entités "Eleve".
 * Il fournit des endpoints pour ajouter, récupérer, et supprimer des élèves
 * via des requêtes HTTP.
 */
@RestController
@RequestMapping("/eleve")
public class EleveController {


    private final EcoleService ecoleService;

    /**
     * Constructeur pour initialiser le contrôleur avec le service {@link EcoleService}.
     *
     * @param ecoleService Le service de l'école utilisé pour effectuer les opérations sur les entités Eleve.
     */
    public EleveController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    /**
     * Récupère tous les élèves.
     *
     * @return Un iterable contenant tous les élèves disponibles dans la base de données.
     */
    @GetMapping
    public Iterable<Eleve> getAllEleves() {
        return ecoleService.getAllEleves();
    }

    /**
     * Récupère les informations d'un élève spécifique par son ID.
     *
     * @param id L'identifiant de l'élève à récupérer.
     * @return Une réponse HTTP contenant l'élève si trouvé, sinon une réponse 404 (Not Found).
     */
    @GetMapping("/{id}")
    public ResponseEntity<EleveDTO> getEleve(@PathVariable Integer id) {
        try {
            EleveDTO eleve = ecoleService.getEleveByIdWithMaison(id); //Méthode surchargée
            return new ResponseEntity<>(eleve, HttpStatus.OK); // 200 OK
        } catch (EleveNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    @GetMapping("/fromOtherHouses")
    public Iterable<EleveDTO> getFromOtherHouses() {
        return ecoleService.getEleveFromOtherHouse();
    }

    /*
     * Endpoint pour ajouter un nouvel élève
     */
    @PostMapping
    public Eleve createEleve(@RequestBody Map<String, String> body) {
        String nom = body.get("nom");
        String prenom = body.get("prenom");
        String nomMaison = body.get("nomMaison");
        return ecoleService.addEleve(nom,prenom,nomMaison);
    }


    /**
     * Supprime un élève par son ID.
     *
     * @param id L'identifiant de l'élève à supprimer.
     */
    @DeleteMapping("/{id}")
    public void deleteEleve(@PathVariable int id) {
        this.ecoleService.deleteEleve(id);
    }


}
