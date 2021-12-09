package com.example.pos_demo.services;

import com.example.pos_demo.model.domain.AuthorDTO;
import com.example.pos_demo.model.entities.BookAuthor;

import java.util.List;

public interface BookAuthorService {
    List<AuthorDTO> getAuthorsByIsbn(String isbn);
    BookAuthor addNewBookAuthor(BookAuthor bookAuthor);
}
