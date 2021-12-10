package com.example.demo.service;

import com.example.demo.model.entities.BookAuthor;
import com.example.demo.view.AuthorDTO;

import java.util.List;

public interface BookAuthorService {
    List<AuthorDTO> getAuthorsByIsbn(String isbn);

    BookAuthor addNewBookAuthor(BookAuthor bookAuthor);
}
