package com.example.pos_demo.model.entities;

import javax.persistence.*;

@Entity
@Table(name="author", indexes = {@Index(name = "index_prenume", columnList = "prenume"),
                                @Index(name = "nume_index", columnList = "nume")})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String prenume;
    public String nume;

    public Author() {
    }

    public Author(Long id, String prenume, String nume) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

}
