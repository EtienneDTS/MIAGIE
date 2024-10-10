package Serdaigle.MIAGIE.dto;

public abstract class PersonneDTO {
    private int id;
    private String nom;
    private String prenom;
    private JetonUtilisateur jeton;

    public PersonneDTO(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.definirJetonUtilisateur();

    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public JetonUtilisateur getJeton() {
        return jeton;
    }

    public String getPrenom() {
        return prenom;
    }

    public abstract void definirJetonUtilisateur();

    public void setJeton(JetonUtilisateur jeton) {
        this.jeton = jeton;
    }


}
