package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.model.Maison;
import Serdaigle.MIAGIE.model.Matiere;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maison")
public class MaisonController {

    private EcoleService ecoleService;

    public MaisonController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    @GetMapping
    public Iterable<Maison> getAllMaisons() {
        return ecoleService.getAllMaisons();
    }

    // Endpoint pour trouver une maison par son nom
    @GetMapping("/{nomMaison}")
    public ResponseEntity<Maison> getMaisonByNom(@PathVariable String nomMaison) {
        Maison maison = ecoleService.getMaisonWithElevesByNomMaison(nomMaison);
        return ResponseEntity.ok(maison);

    }

    // Autres endpoints pour créer, modifier, supprimer des matières...
}