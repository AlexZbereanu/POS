package com.example.demo.service;

import com.example.demo.model.entities.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthorById(Long id);

    List<Author> getAuthorsByExactName(String name);

    List<Author> getAuthorsByPartialName(String name);

    void save(Author author);
}
