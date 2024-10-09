package Serdaigle.MIAGIE.dto;

import java.util.List;

public class MaisonDTO {
    private final String nomMaison;
    private List<EleveDTO> eleves;
    private int nbPointTotal;

    public MaisonDTO(String nomMaison,int nbPointTotal, List<EleveDTO> eleves) {
        this.nomMaison = nomMaison;
        this.eleves = eleves;
        this.nbPointTotal = nbPointTotal;
    }

    // Getters and setters

    public String getNomMaison() {
        return nomMaison;
    }

    public int getNbPointTotal() {
        return nbPointTotal;
    }

    public void setEleves(List<EleveDTO> eleves) {
        this.eleves = eleves;
    }

    public List<EleveDTO> getEleves() {
        return eleves;
    }


}
