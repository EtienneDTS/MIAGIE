package Serdaigle.MIAGIE.dto;

import java.util.List;

public class MaisonDTO {
    private String nomMaison;
    private List<EleveDTO> eleves;

    // Getters and setters

    public String getNomMaison() {
        return nomMaison;
    }

    public void setNomMaison(String nomMaison) {
        this.nomMaison = nomMaison;
    }

    public List<EleveDTO> getEleves() {
        return eleves;
    }

    public void setEleves(List<EleveDTO> eleves) {
        this.eleves = eleves;
    }
}
