package com.example.demo.service;

import com.example.demo.model.entities.Book;

import java.util.List;

public interface BookService {
    void save(Book book);

    List<Book> getBooks();

    Book getBookById(String isbn);

    List<Book> getBooksByGen(String gen);

    List<Book> getBooksByYear(Long year);

    List<Book> getBooksByGenAndYear(String gen, Long year);

    List<Book> getBooksPerPage(int page, int items_per_page);
}
