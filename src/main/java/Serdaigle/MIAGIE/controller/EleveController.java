package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.dto.EleveDTO;
import Serdaigle.MIAGIE.exception.EleveNotFoundException;
import Serdaigle.MIAGIE.exception.ElevesDansLaMemeMaisonException;
import Serdaigle.MIAGIE.exception.PasAssezDePointsPourMiserException;
import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.service.ChiFouMiService;
import Serdaigle.MIAGIE.service.EcoleService;
import Serdaigle.MIAGIE.dto.PropositionPartieDTO;
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

    private final ChiFouMiService chiFouMiService;

    public EleveController(EcoleService ecoleService, ChiFouMiService chiFouMiService) {
        this.ecoleService = ecoleService;
        this.chiFouMiService = chiFouMiService;
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

    @PostMapping("/propositionPartie"  )
    public ResponseEntity creerPropositionPartie(@RequestBody Map<String, Integer> body) {
        try{
            int idJoueurSource = body.get("idJoueurSource");
            int idJoueurCible = body.get("idJoueurCible");
            int mise = body.get("mise");
            PropositionPartieDTO prop =  this.chiFouMiService.creerPropositionPartie( idJoueurSource,  idJoueurCible,  mise);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }

        catch(ElevesDansLaMemeMaisonException e2){
            return new ResponseEntity<>( e2.getMessage(),HttpStatus.CONFLICT);
            // 404 Not Found
        }
        catch(PasAssezDePointsPourMiserException e3){
            return new ResponseEntity<>(e3.getMessage(), HttpStatus.CONFLICT);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
                //return new ResponseEntity<PropositionPartieDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    /*
     * Endpoint pour supprimer un élève
     */
    public void deleteEleve(@PathVariable int id) {
        this.ecoleService.deleteEleve(id);
    }


    @GetMapping("/voirPropositionsPartieRecues/{id}")
    public Iterable<PropositionPartieDTO> voirPropositionsPartieRecues(@PathVariable Integer id){
        return this.chiFouMiService.getAllPropositionsPartieRecues(id);
    }





}