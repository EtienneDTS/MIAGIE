package Serdaigle.MIAGIE.controllers;

import Serdaigle.MIAGIE.models.Eleve;
import Serdaigle.MIAGIE.services.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getAllEleves(Model model) {
        List<Eleve> eleves = eleveService.getAllEleves();
        model.addAttribute("eleves", eleves);
        return "eleves";
    }

    // Endpoint pour obtenir un élève par ID
    @GetMapping("/{id}")
    public String getEleveById(@PathVariable int id,Model model) {
        Optional<Eleve> eleve = eleveService.getEleveById(id);
        if (eleve.isPresent()) {
            model.addAttribute("eleve", eleve.get());
            return "eleve";
        }else {
            return "eleve non trouve";
        }
    }

    // Endpoint pour ajouter un nouvel élève
    @PostMapping
    public String addEleve(@RequestBody Eleve eleve, Model model) {
        Eleve addEleve = eleveService.addEleve(eleve);
        model.addAttribute("eleve", addEleve);
        return "eleveAjoute";
    }

    // Endpoint pour supprimer un élève
   @DeleteMapping("/{id}")
public String deleteEleve(@PathVariable int id, Model model) {
    eleveService.deleteEleve(id);
    model.addAttribute("message", "Eleve supprimé");
    return "eleveSupprime";
}
}
