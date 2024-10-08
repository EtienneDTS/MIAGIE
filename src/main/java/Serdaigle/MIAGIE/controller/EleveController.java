package Serdaigle.MIAGIE.controller;

import Serdaigle.MIAGIE.exception.EleveNotFoundException;
import Serdaigle.MIAGIE.exception.ProfesseurNotFoundException;
import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.model.Professeur;
import Serdaigle.MIAGIE.service.EcoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestionEcole")
public class EleveController {


    private final EcoleService ecoleService;

    /**
     *
     * @param ecoleService
     */
    public EleveController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    /**
     * Recoit les appel
     * @param id
     * @return
     */
    @GetMapping("/elever/{id}")
    public ResponseEntity<Eleve> getEleve(@PathVariable Integer id) {
        try {
            Eleve eleve = ecoleService.getEleveById(id);
            return new ResponseEntity<>(eleve, HttpStatus.OK); // 200 OK
        } catch (EleveNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }
}