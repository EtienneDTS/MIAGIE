package Serdaigle.MIAGIE.dto;

public class EleveDTO extends PersonneDTO{

    private Integer totalPoints;
    private String nomMaison;

    // Getters and setters

    public EleveDTO(Integer idEleve, String nom, String prenom,  Integer totalPoints, String nomMaison) {
        super(idEleve, nom, prenom);
        this.totalPoints = totalPoints;
        this.nomMaison = nomMaison;
    }

    public String getNomMaison() {
        return nomMaison;
    }



    public void definirJetonUtilisateur() {
        this.setJeton(JetonUtilisateur.eleve);
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }


}
