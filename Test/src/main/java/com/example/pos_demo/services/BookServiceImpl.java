package com.example.pos_demo.services;

import com.example.pos_demo.model.entities.Book;
import com.example.pos_demo.model.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        Optional<List<Book>> booksOptional = Optional.of(bookRepository.findAll());
        return booksOptional.get();
    }

    @Override
    public Book getBookById(String isbn) {
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if(bookOptional.isPresent())
            return bookOptional.get();
        else
            throw new RuntimeException();
    }
}
