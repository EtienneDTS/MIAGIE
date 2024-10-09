package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.model.Professeur;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * Controller gérant les opérations CRUD pour les professeurs.
 * Cette classe fournit des endpoints RESTful pour interagir avec les professeurs dans le système MIAGIE.
 *
 * @author VotreNom
 * @version 1.0
 * @since 2022-01-01
 */

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {

    private EcoleService ecoleService;

    /**
     * Constructeur injectant le service d'école pour la gestion des professeurs.
     *
     * @param ecoleService Le service d'école à injecter.
     */
    public ProfesseurController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    /**
     * Endpoint pour obtenir la liste de tous les professeurs.
     *
     * @return Une liste d'objets Professeur.
     */
    // GET /professeur : Récupérer la liste de tous les professeurs
    @GetMapping
    public Iterable<Professeur> getAllProfesseurs() {
        return ecoleService.getAllProfesseurs();
    }

    /**
     * Endpoint pour obtenir un professeur par son ID.
     *
     * @param id L'ID du professeur à rechercher.
     * @return L'objet Professeur correspondant à l'ID donné, ou une réponse HTTP 404 si le professeur n'est pas trouvé.
     */
    // GET /professeur/{id} : Récupérer un professeur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getProfesseurById(@PathVariable Integer id) {
        Optional<Professeur> professeur = Optional.ofNullable(ecoleService.getProfesseurById(id));
        return professeur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint pour créer un nouveau professeur ou mettre à jour un professeur existant.
     *
     * @param body Un objet Map contenant les informations du professeur (nom, prénom, nom de matière).
     * @return L'objet Professeur créé ou mis à jour.
     */
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

    /**
     * Endpoint pour supprimer un professeur par son ID.
     *
     * @param id L'ID du professeur à supprimer.
     * @return Une réponse HTTP 204 (No Content) si le professeur est supprimé avec succès.
     */
    // DELETE /professeur/{id} : Supprimer un professeur par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Integer id) {
        ecoleService.deleteProfesseurById(id);
        return ResponseEntity.noContent().build();
    }


}
