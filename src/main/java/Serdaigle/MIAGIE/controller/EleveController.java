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


    /**
     * Le controleur eleve fait appel à un service ecoleService pour effectuer les opérations métier sur les élèves
     * @param ecoleService
     */
    private final EcoleService ecoleService;


    /**
     * Le controleur fait appel à un service chiFouMiService pour effectuer les opérations métier sur les parties
     * @param chiFouMiService
     */
    private final ChiFouMiService chiFouMiService;


    public EleveController(EcoleService ecoleService, ChiFouMiService chiFouMiService) {
        this.ecoleService = ecoleService;
        this.chiFouMiService = chiFouMiService;
    }

    /**
     * Recupere tous les eleves de l'école.
     * Peut être filtré avec un paramètre fourni dans l'url : ?filter=...
     * @param filter
     * @return
     */
    @GetMapping
    public Iterable<EleveDTO> getAllEleves(@RequestParam(name = "filter", required = false) String filter) {
        Iterable<EleveDTO> eleves = ecoleService.getAllEleves(filter);
        return ecoleService.getAllEleves(filter);
    }


    /**
     * Endpoint permettant de récupérer un élève à partir de son id
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

    /**
     * Endpoint pour obtenir les élèves qui ne sont pas à Serdaigle
     * @return
     */
    @GetMapping("/fromOtherHouses")
    public Iterable<EleveDTO> getFromOtherHouses() {
        return ecoleService.getEleveFromOtherHouse();
    }

    /*
     * Endpoint pour ajouter un nouvel élève.
     * Prend un body de type Map<String, String> avec les clés nom, prenom et nomMaison
     */
    @PostMapping
    public Eleve createEleve(@RequestBody Map<String, String> body) {
        String nom = body.get("nom");
        String prenom = body.get("prenom");
        String nomMaison = body.get("nomMaison");
        return ecoleService.addEleve(nom,prenom,nomMaison);
    }

    /**
     * Endpoint pour créer une proposition de partie.
     * Prend un body de type Map<String, Integer> avec les clés idJoueurSource, idJoueurCible et mise
     * @param body
     * @return
     */
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

    /**
     * Endpoint pour supprimer un élève
     * @param id
     */
    @DeleteMapping("/{id}")
    /*
     * Endpoint pour supprimer un élève
     */
    public void deleteEleve(@PathVariable int id) {
        this.ecoleService.deleteEleve(id);
    }


    /**
     * Permet de récuperer les propositions de partie reçues par l'id du joueur passé en paramètres qui n'ont pas encore été acceptées
     * @param id
     * @return
     */
    @GetMapping("/voirPropositionsPartieRecues/{id}")
    public Iterable<PropositionPartieDTO> voirPropositionsPartieRecues(@PathVariable Integer id){
        return this.chiFouMiService.getAllPropositionsPartieRecues(id);
    }

    /**
     * endpoint permettant de récupérer les parties proposées par l'id du joueur passé en paramètres qui n'ont pas encore abouti à une partie
     * @param id
     * @return
     */
    @GetMapping("/voirPropositionsPartieEnAttente/{id}")
    public Iterable<PropositionPartieDTO> voirPropositionsPartieEnAttente(@PathVariable Integer id){
        return this.chiFouMiService.getAllPropositionsPartieRecues(id);
    }





}