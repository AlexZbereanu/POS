package com.example.demo.view;

import com.example.demo.model.entities.Author;

public class AuthorDTO {
    private Long id;
    private String nume;
    private String prenume;

    public AuthorDTO() {
        this.id = null;
        this.nume = null;
        this.prenume = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public AuthorDTO convertFromAuthor(Author author) {
        if (author == null) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId(author.getId());
        authorDTO.setNume(author.getNume());
        authorDTO.setPrenume(author.getPrenume());

        return authorDTO;
    }
}
