package Serdaigle.MIAGIE.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "professeur")
public class Professeur extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprofesseur", nullable = false, unique = true)
    private Integer idProfesseur;

    @Column(name = "nommaison", nullable = false, unique = true)
    private String nomMaison;

    // Liste des matières enseignées
    @ElementCollection
    @CollectionTable(name = "matieres", joinColumns = @JoinColumn(name = "idprofesseur"))
    @Column(name = "matiere")
    private List<String> matieresEnseignees;

    // Getters et Setters
    public Integer getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Integer idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public String getNomMaison() {
        return nomMaison;
    }

    public void setNomMaison(String nomMaison) {
        this.nomMaison = nomMaison;
    }

    public List<String> getMatieresEnseignees() {
        return matieresEnseignees;
    }

    public void setMatieresEnseignees(List<String> matieresEnseignees) {
        this.matieresEnseignees = matieresEnseignees;
    }

    // Implémenter ici les méthodes abstraites héritées de Personne

}
