package Serdaigle.MIAGIE.dto;

public class PropositionPartieDTO {

    private int id;
    private EleveDTO joueurSource;
    private EleveDTO joueurCible;
    private PartieDTO partie;
    private int mise;


    public PropositionPartieDTO(int id, EleveDTO joueurSource, EleveDTO joueurCible,int mise) {
        this.id = id;
        this.joueurSource = joueurSource;
        this.joueurCible = joueurCible;
        this.mise = mise;
    }

    public void setPartie(PartieDTO p){
        this.partie = p;
    }

    public int getId() {
        return id;
    }

    public int getMise() {
        return mise;
    }

    public EleveDTO getJoueurSource() {
        return joueurSource;
    }

    public EleveDTO getJoueurCible() {
        return joueurCible;
    }
}
