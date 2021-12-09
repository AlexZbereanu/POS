package com.example.pos_demo.services;

import com.example.pos_demo.model.entities.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthorById(Long id);
    List<Author> getAuthorsByExactName(String name);
    void save(Author author);
}
