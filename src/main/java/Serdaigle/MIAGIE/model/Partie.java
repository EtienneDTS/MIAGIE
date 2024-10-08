package Serdaigle.MIAGIE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "partie", schema = "miagie")
public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpartie", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}