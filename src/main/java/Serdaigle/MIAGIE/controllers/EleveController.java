package Serdaigle.MIAGIE.controllers;

import Serdaigle.MIAGIE.models.Eleve;
import Serdaigle.MIAGIE.services.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
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
    public String getEleveById(@PathVariable int id, Model model) {
        Optional<Eleve> optionalEleve = eleveService.getEleveById(id);

        //Vérification de l'existence de l'élève dans la BD
         if (optionalEleve.isPresent()) {
            Eleve eleve = optionalEleve.get();
            model.addAttribute("eleve", eleve);
            return "eleve"; // Renvoie vers eleve.html
        } else {
            model.addAttribute("errorMessage", "Élève non trouvé pour l'ID: " + id);
            return "error"; // Renvoie vers error.html
        }
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
