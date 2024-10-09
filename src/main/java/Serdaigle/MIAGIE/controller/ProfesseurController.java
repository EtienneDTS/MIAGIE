package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.model.Professeur;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {


    private EcoleService ecoleService;

    public ProfesseurController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    // GET /professeur : Récupérer la liste de tous les professeurs
    @GetMapping
    public Iterable<Professeur> getAllProfesseurs() {
        return ecoleService.getAllProfesseurs();
    }

    // GET /professeur/{id} : Récupérer un professeur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getProfesseurById(@PathVariable Integer id) {
        Optional<Professeur> professeur = Optional.ofNullable(ecoleService.getProfesseurById(id));
        return professeur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /professeur : Créer un nouveau professeur ou mettre à jour un professeur existant
    @PostMapping
    public Professeur createProfesseur(@RequestBody Map<String, String> body) {

        String nom = body.get("nom");
        String prenom = body.get("prenom");
        String nomMatiere = body.get("nomMatiere");
        return ecoleService.saveProfesseur(nom,prenom,nomMatiere);
    }

    /*
    @PostMapping
    public ResponseEntity<Void> ajouterPointsEleve(@RequestBody Map<String, String> body) {
        int idProfesseur = Integer.parseInt(body.get(body.get("idProfesseur")));
        int idEleve = Integer.parseInt(body.get(body.get("idEleve")));
        int nbPoints = Integer.parseInt(body.get("nbPoints"));
        return ecoleService.ajouterPointsEleve(idProfesseur,idEleve,nbPoints);
    }*/


    // DELETE /professeur/{id} : Supprimer un professeur par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Integer id) {
        ecoleService.deleteProfesseurById(id);
        return ResponseEntity.noContent().build();
    }


}
