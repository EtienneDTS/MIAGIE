package Serdaigle.MIAGIE.controllers;

import Serdaigle.MIAGIE.models.Eleve;
import Serdaigle.MIAGIE.services.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eleves")
public class EleveController {

    private final EleveService eleveService;

    @Autowired
    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    // Endpoint pour obtenir tous les élèves
    @GetMapping
    public List<Eleve> getAllEleves() {
        return eleveService.getAllEleves();
    }

    // Endpoint pour obtenir un élève par ID
    @GetMapping("/{id}")
    public Optional<Eleve> getEleveById(@PathVariable int id) {
        return eleveService.getEleveById(id);
    }

    // Endpoint pour ajouter un nouvel élève
    @PostMapping
    public Eleve addEleve(@RequestBody Eleve eleve) {
        return eleveService.addEleve(eleve);
    }

    // Endpoint pour supprimer un élève
    @DeleteMapping("/{id}")
    public void deleteEleve(@PathVariable int id) {
        eleveService.deleteEleve(id);
    }
}
