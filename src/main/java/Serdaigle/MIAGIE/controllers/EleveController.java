package Serdaigle.MIAGIE.controllers;

import Serdaigle.MIAGIE.models.Eleve;
import Serdaigle.MIAGIE.services.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/* 
 * Cette classe est un controleur REST
 */
@RestController
/*
 * Les routes commencant par /eleves seront traités par ce controleur
 */
@RequestMapping("/eleves")
public class EleveController {

    private final EleveService eleveService;
    /*
     * injection de EleveRepository pour interagir avec la base de données
     */
    @Autowired
    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    @GetMapping
    /*
     * Endpoint pour obtenir tous les élèves
     */
    public List<Eleve> getAllEleves() {
        return eleveService.getAllEleves();
    }

    /*
     * methode répondant aux requetes GET avec un iD dans l'URL
     */
    @GetMapping("/{id}")
    /*
     * Endpoint pour obtenir un élève par ID
     */
    public ResponseEntity<Eleve> getEleveById(@PathVariable Integer id) {
        Optional<Eleve> eleve = eleveRepository.findById(id);
        if (eleve.isPresent()) {
            return ResponseEntity.ok(eleve.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Eleve addEleve(@RequestBody Eleve eleve) {
        /*
         * Endpoint pour ajouter un nouvel élève
         */
        return eleveService.addEleve(eleve);
    }

    @DeleteMapping("/{id}")
    /*
     * Endpoint pour supprimer un élève
     */
    public void deleteEleve(@PathVariable int id) {
        eleveService.deleteEleve(id);
    }
}
