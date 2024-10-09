package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.dto.MaisonDTO;
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
    public Iterable<MaisonDTO> getAllMaisons() {
        return ecoleService.getAllMaisons();
    }

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