package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.dto.EleveDTO;
import Serdaigle.MIAGIE.exception.EleveNotFoundException;
import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
 * Cette classe est un controleur REST
 */
@RestController
/*
 * Les routes commencant par /eleves seront traités par ce controleur
 */
@RequestMapping("/eleve")
public class EleveController {


    private final EcoleService ecoleService;

    /**
     *
     * @param ecoleService
     */
    public EleveController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    @GetMapping
    /*
     * Endpoint pour obtenir tous les élèves
     */
    public Iterable<EleveDTO> getAllEleves(@RequestParam(name = "filter", required = false) String filter) {
        Iterable<EleveDTO> eleves = ecoleService.getAllEleves(filter);
        return ecoleService.getAllEleves(filter);
    }


    /**
     * Recoit les appel
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<EleveDTO> getEleve(@PathVariable Integer id) {
        try {
            EleveDTO eleve = ecoleService.getEleveByIdWithMaison(id); //Méthode surchargée
            return new ResponseEntity<>(eleve, HttpStatus.OK); // 200 OK
        } catch (EleveNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    @GetMapping("/search")
    public Iterable<EleveDTO> searchWithFilter(@PathVariable String nom){
        Iterable<EleveDTO> eleves = this.ecoleService.searchWithFilter(nom);
        return eleves;
    }

    @GetMapping("/fromOtherHouses")
    public Iterable<EleveDTO> getFromOtherHouses() {
        return ecoleService.getEleveFromOtherHouse();
    }

    /*
     * Endpoint pour ajouter un nouvel élève
     */
    @PostMapping
    public Eleve createEleve(@RequestBody Map<String, String> body) {
        String nom = body.get("nom");
        String prenom = body.get("prenom");
        String nomMaison = body.get("nomMaison");
        return ecoleService.addEleve(nom,prenom,nomMaison);
    }

    @DeleteMapping("/{id}")
    /*
     * Endpoint pour supprimer un élève
     */
    public void deleteEleve(@PathVariable int id) {
        this.ecoleService.deleteEleve(id);
    }


}