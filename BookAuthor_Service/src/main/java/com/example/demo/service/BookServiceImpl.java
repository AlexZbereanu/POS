package com.example.demo.service;

import com.example.demo.model.entities.Book;
import com.example.demo.model.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

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
        if (bookOptional.isPresent())
            return bookOptional.get();
        else
            throw new RuntimeException();
    }

    @Override
    public List<Book> getBooksByGen(String gen) {
        List<Book> books = bookRepository.findBooksByGenre(gen);
        if (books.isEmpty()) {
            throw new RuntimeException();
        } else {
            return books;
        }
    }

    @Override
    public List<Book> getBooksByYear(Long year) {
        List<Book> books = bookRepository.findBooksByYear(year);
        if (books.isEmpty()) {
            throw new RuntimeException();
        } else {
            return books;
        }
    }

    @Override
    public List<Book> getBooksByGenAndYear(String gen, Long year) {
        List<Book> books = bookRepository.findBooksByGenreAndYear(gen, year);
        if (books.isEmpty()) {
            throw new RuntimeException();
        } else {
            return books;
        }
    }

    @Override
    public List<Book> getBooksPerPage(int page, int items_per_page) {
        Pageable paging = PageRequest.of(page, items_per_page);
        Page<Book> pageResult = bookRepository.findAll(paging);

        return pageResult.toList();
    }


}

