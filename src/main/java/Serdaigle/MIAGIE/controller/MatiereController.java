package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.model.Matiere;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/matiere")
public class MatiereController {

    private EcoleService ecoleService;
    public MatiereController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    @GetMapping
    public Iterable<Matiere> getAllMatieres() {
        return ecoleService.getAllMatieres();
    }

    // Endpoint pour trouver une matière par son nom
    @GetMapping("/{nomMatiere}")
    public ResponseEntity<Matiere> getMatiereByNom(@PathVariable String nomMatiere) {
        Matiere matiere = ecoleService.getMatiereByNomMatiere(nomMatiere);
        return ResponseEntity.ok(matiere);

    }

    // Autres endpoints pour créer, modifier, supprimer des matières...
}