package Serdaigle.MIAGIE.dto;

public class EleveDTO{
    private Integer idEleve;
    private String nom;
    private String prenom;
    private Integer totalPoints;
    private String nomMaison;

    // Getters and setters

    public EleveDTO(Integer idEleve, String nom, String prenom,  Integer totalPoints, String nomMaison) {
        this.idEleve = idEleve;
        this.nom = nom;
        this.prenom = prenom;
        this.totalPoints = totalPoints;
        this.nomMaison = nomMaison;
    }

    public Integer getIdEleve() {
        return idEleve;
    }

    /*public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }
    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }
    public void setNomMaison(String nomMaison) {
        this.nomMaison = nomMaison;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    */

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public String getNomMaison() {
        return nomMaison;
    }


    public String getNom() {
        return nom;
    }



    public String getPrenom() {
        return prenom;
    }


}
