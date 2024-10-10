package Serdaigle.MIAGIE.dto;

public class ProfesseurDTO extends PersonneDTO{

    private String nomMatiere;
    public ProfesseurDTO(int id, String nom, String prenom, String nomMatiere) {
        super(id, nom, prenom);
        this.nomMatiere = nomMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    @Override
    public void definirJetonUtilisateur() {
        // Définir le jeton comme étant "professeur"
        this.setJeton(JetonUtilisateur.professeur);
    }


}
