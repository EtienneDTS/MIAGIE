package Serdaigle.MIAGIE.tooling;

import Serdaigle.MIAGIE.dto.EleveDTO;
import Serdaigle.MIAGIE.dto.ProfesseurDTO;
import Serdaigle.MIAGIE.dto.PropositionPartieDTO;
import Serdaigle.MIAGIE.model.Eleve;
import Serdaigle.MIAGIE.model.Professeur;
import Serdaigle.MIAGIE.model.Propositionpartie;

import java.util.ArrayList;
import java.util.List;

public  class  ToolingMethods {

    public ToolingMethods() {
    }

    // ______________METHODES PRIVEES - maniulation structures de données___________________

    /**
     * Convertit un modèle Eleve BDD en modèle DTO
     * @param eleve
     * @return
     */
    public EleveDTO convertEleveToDto(Eleve eleve) {
        return new EleveDTO(
                eleve.getId(),
                eleve.getNom(),
                eleve.getPrenom(),
                eleve.getTotalPoints(),
                eleve.getNomMaison()
        );
    }

    /**
     * Convertit une liste de modeles d'eleves bdd en une liste DTO
     * @param eleves
     * @return
     */
    public ArrayList<EleveDTO> convertDBElevesListtoDTOList(List<Eleve> eleves){
        ArrayList<EleveDTO> elevesDto= new ArrayList<>();
        for (Eleve e : eleves){
            elevesDto.add(this.convertEleveToDto(e));
        }
        return elevesDto;
    }

    public ProfesseurDTO convertProfesseurToDto(Professeur professeur) {
        return new ProfesseurDTO(
                professeur.getId(),
                professeur.getNom(),
                professeur.getPrenom(),
                professeur.getNomMatiere().getNomMatiere()
        );
    }

    public ArrayList<ProfesseurDTO> convertDBProfesseurListtoDTOList(List<Professeur> professeurs){
        ArrayList<ProfesseurDTO> professeurDto= new ArrayList<>();
        for (Professeur p : professeurs){
            professeurDto.add(this.convertProfesseurToDto(p));
        }
        return professeurDto;
    }

    public PropositionPartieDTO convertPropositionPartieToDto(Propositionpartie prop){
        return new PropositionPartieDTO(prop.getId(),this.convertEleveToDto(prop.getEleveLanceur()), this.convertEleveToDto(prop.getEleveReceveur()), prop.getMise());
    }

    public ArrayList<PropositionPartieDTO> convertPropositionPartieListToDtoList(List<Propositionpartie> propRecues){
        ArrayList<PropositionPartieDTO> propRecuesDto = new ArrayList<>();
        for (Propositionpartie p : propRecues){
            PropositionPartieDTO pdto = new PropositionPartieDTO(p.getId(),this.convertEleveToDto(p.getEleveLanceur()), this.convertEleveToDto(p.getEleveReceveur()), p.getMise());
            propRecuesDto.add(pdto);
        }
        return propRecuesDto;
    }

}

