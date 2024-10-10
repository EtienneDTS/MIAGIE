package Serdaigle.MIAGIE.service;
import Serdaigle.MIAGIE.exception.ElevesDansLaMemeMaisonException;
import Serdaigle.MIAGIE.exception.PasAssezDePointsPourMiserException;
import Serdaigle.MIAGIE.model.Propositionpartie;
import Serdaigle.MIAGIE.tooling.ToolingMethods;

import Serdaigle.MIAGIE.dto.EleveDTO;
import Serdaigle.MIAGIE.dto.PropositionPartieDTO;
import Serdaigle.MIAGIE.exception.EleveNotFoundException;
import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.repository.PropositionPartieRepository;
import Serdaigle.MIAGIE.repository.EleveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiFouMiService {

    private final EleveRepository eleveRepository;
    private final ToolingMethods tooling;
    private final  PropositionPartieRepository propositionPartieRepository;

    public ChiFouMiService(EleveRepository eleveRepository, PropositionPartieRepository propositionPartieRepository) {
        this.eleveRepository = eleveRepository;
        this.propositionPartieRepository = propositionPartieRepository;
        this.tooling = new ToolingMethods();
    }


    public PropositionPartieDTO creerPropositionPartie(int idEleveSource, int idEleveDest, int mise)throws ElevesDansLaMemeMaisonException, PasAssezDePointsPourMiserException, EleveNotFoundException{
        // récuperer l'eleve source
        try {
            Eleve source = eleveRepository.findById(idEleveSource).orElseThrow(() -> new EleveNotFoundException("Eleve not found :"+idEleveSource));
            Eleve dest = eleveRepository.findById(idEleveDest).orElseThrow(() -> new EleveNotFoundException("Eleve not found :"+idEleveSource));
            // Creer les objets DTO
            EleveDTO sourceDto = this.tooling.convertEleveToDto(source);
            EleveDTO destDto = this.tooling.convertEleveToDto(dest);

            //Verifier qu'ils ne sont pas dans la même maison
            if(source.getNomMaison().equals(dest.getNomMaison())){
                throw new ElevesDansLaMemeMaisonException("Les deux élèves sont dans la même maison");
            }

            //Verifier qu'ils ont tous les deux assez de totalPoints pour miser
            if(source.getTotalPoints() < mise || dest.getTotalPoints() < mise){
                throw new PasAssezDePointsPourMiserException("Un des deux élèves n'a pas assez de points pour miser");
            }
            // A ce stade les eleves sont bien dans une maison opposée et ont assez de points pour miser
            // On crée la proposition de partie
            Propositionpartie propositionPartie = this.propositionPartieRepository.save(new Propositionpartie(source, dest, mise));
            return new PropositionPartieDTO(propositionPartie.getId(), sourceDto, destDto, mise);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }


    }


    public Iterable<PropositionPartieDTO> getAllPropositionsPartieRecues(Integer id) {
        // Recuperer l'eleve
        Eleve eleve = eleveRepository.findById(id).orElseThrow(() -> new EleveNotFoundException("Eleve not found :"+id));
        // Recuperer les propositions de partie reçues
        Iterable<Propositionpartie> propRecues = this.propositionPartieRepository.getPropositionByJoueurCible(eleve);

       // Iterable propRecuesDto = this.tooling.convertPropositionPartieListToDtoList(propRecues);
        return this.tooling.convertPropositionPartieListToDtoList((List<Propositionpartie>) propRecues);
    }
}
