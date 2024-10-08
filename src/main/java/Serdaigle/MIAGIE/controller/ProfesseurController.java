package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.model.Professeur;
import Serdaigle.MIAGIE.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    // GET /professeur : Récupérer la liste de tous les professeurs
    @GetMapping
    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }

    // GET /professeur/{id} : Récupérer un professeur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getProfesseurById(@PathVariable Integer id) {
        Optional<Professeur> professeur = professeurService.getProfesseurById(id);
        return professeur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /professeur : Créer un nouveau professeur ou mettre à jour un professeur existant
    @PostMapping
    public Professeur createOrUpdateProfesseur(@RequestBody Professeur professeur) {
        return professeurService.saveProfesseur(professeur);
    }

    // DELETE /professeur/{id} : Supprimer un professeur par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Integer id) {
        professeurService.deleteProfesseurById(id);
        return ResponseEntity.noContent().build();
    }
}
