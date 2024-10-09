package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.dto.EleveDTO;
import Serdaigle.MIAGIE.exception.EleveNotFoundException;
import Serdaigle.MIAGIE.model.Evaluer;
import Serdaigle.MIAGIE.model.Professeur;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/evaluer")
public class EvaluerController {

    private final EcoleService ecoleService;
    public EvaluerController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    @GetMapping
    public Iterable<Evaluer> getAllEvaluer() {
        return ecoleService.getAllEvaluer();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createEvaluer(@RequestBody Map<String, Integer> body) {

        int idEleve = body.get("idEleve");
        int idProfesseur = body.get("idProfesseur");
        int nbPoints = body.get("nbPoints");

        try {
            Evaluer evaluer = ecoleService.addEvaluer(idEleve,idProfesseur,nbPoints); //Méthode surchargée
            return new ResponseEntity<>(null, HttpStatus.OK); // 200 OK
        } catch (EleveNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 Not Found
        }


    }

}
