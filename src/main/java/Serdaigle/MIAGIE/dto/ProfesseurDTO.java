package Serdaigle.MIAGIE.dto;

public class ProfesseurDTO {
    private int id;
    private String nom;
    private String prenom;
    private String nomMatiere;

    public ProfesseurDTO(int id, String nom, String prenom, String nomMatiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nomMatiere = nomMatiere;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public String getPrenom() {
        return prenom;
    }
}
