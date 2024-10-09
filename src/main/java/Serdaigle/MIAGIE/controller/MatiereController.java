package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.model.Matiere;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * c'est le controller qui va gerer les operation pour les matieres
 * Cette classe fournit les endpoints Restful pour interagir avec les matieres dans le systeme
 * @author Serdaigle
 * @version 1.0
 * @since 2024-10-09
 */

@RestController
@RequestMapping("/matiere")
public class MatiereController {

    private EcoleService ecoleService;

    /**
     * Constructeur injectant le service d'ecole pour la gestion des matiere
     * @param ecoleService Le service d'ecole a injecter.
     */
    public MatiereController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    /**
     * Endpoint pour obtenir toutes les matières.
     * @return Une liste d'objets Matiere.
     */
    @GetMapping
    public Iterable<Matiere> getAllMatieres() {
        return ecoleService.getAllMatieres();
    }

    /**
     * Endpoint pour trouvé une matiere par son nom
     * @param nomMatiere c'est le nom de la matiere a recherché
     * @return L'objet Matiere correspondant au nom donné, ou une réponse HTTP 404 si la matière n'est pas trouvée.
     */
    // Endpoint pour trouver une matière par son nom
    @GetMapping("/{nomMatiere}")
    public ResponseEntity<Matiere> getMatiereByNom(@PathVariable String nomMatiere) {
        Matiere matiere = ecoleService.getMatiereByNomMatiere(nomMatiere);
        return ResponseEntity.ok(matiere);

    }

    // Autres endpoints pour créer, modifier, supprimer des matières...
}