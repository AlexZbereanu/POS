package com.example.pos_demo.services;

import com.example.pos_demo.model.entities.Author;
import com.example.pos_demo.model.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()){
            return author.get();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Author> getAuthorsByExactName(String name) {
        List<Author> authors = authorRepository.findAuthorsByExactName(name);
        if(authors.isEmpty()){
            throw new RuntimeException();
        }
        else{
            return authors;
        }
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }
}
