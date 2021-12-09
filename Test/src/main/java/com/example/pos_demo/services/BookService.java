package com.example.pos_demo.services;

import com.example.pos_demo.model.entities.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    List<Book> getBooks();
    Book getBookById(String isbn);
}
