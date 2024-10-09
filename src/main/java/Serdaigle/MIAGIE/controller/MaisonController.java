package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.dto.MaisonDTO;
import Serdaigle.MIAGIE.model.Maison;
import Serdaigle.MIAGIE.model.Matiere;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller gérant les opérations CRUD pour les maisons.
 * Cette classe fournit des endpoints RESTful pour interagir avec les maisons dans le système MIAGIE.
 *
 * @author Serdaigle
 * @version 1.0
 * @since 2022-01-01
 */
@RestController
@RequestMapping("/maison")
public class MaisonController {

    private EcoleService ecoleService;

    /**
     * Constructeur injectant le service d'école pour la gestion des maisons.
     * @param ecoleService Le service d'école à injecter.
     */
    public MaisonController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }


    /**
     * Endpoint pour obtenir toutes les maisons.
     *
     * @return Une liste d'objets Maison représentant toutes les maisons disponibles dans le système.
     */
    @GetMapping
    public Iterable<MaisonDTO> getAllMaisons() {
        return ecoleService.getAllMaisons();
    }


    /**
     * Endpoint pour trouver une maison par son nom.
     * @param nomMaison Le nom de la maison à rechercher.
     * @return Une réponse HTTP avec l'objet Maison correspondant au nom donné,
     *         ou une réponse HTTP 404 si la maison n'est pas trouvée.
     */
    // Endpoint pour trouver une maison par son nom
    @GetMapping("/{nomMaison}")
    public ResponseEntity<MaisonDTO> getMaisonByNom(@PathVariable String nomMaison) {
        Maison maison = ecoleService.getMaisonWithElevesByNomMaison(nomMaison);
        MaisonDTO maisonDto = ecoleService.convertMaisonToDto(maison);
        return ResponseEntity.ok(maisonDto);
    }



    @GetMapping("/nomMaisonGagnante")
    public ResponseEntity<MaisonDTO> getMaisonGagnante() {
        MaisonDTO nomMaisonGagnante = this.ecoleService.getMaisonGagnante();
        return ResponseEntity.ok(nomMaisonGagnante);
    }




}