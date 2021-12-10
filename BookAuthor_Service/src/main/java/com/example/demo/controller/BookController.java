package com.example.demo.controller;

import com.example.demo.model.entities.Book;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.BookService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/api/bookcollection")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/addbook")
    ResponseEntity<Book> addBook(@RequestBody Book book) {
        bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/getbooks")
    public CollectionModel<Book> getBooks() {
        return CollectionModel.of(bookService.getBooks(),
                linkTo(methodOn(BookController.class).getBooks()).withSelfRel());
    }

    @GetMapping("books/{ISBN}")
    public EntityModel<Book> getBookById(@PathVariable String ISBN) {
        return EntityModel.of(bookService.getBookById(ISBN),
                linkTo(methodOn(BookController.class).getBookById(ISBN)).withSelfRel(),
                linkTo(methodOn(BookController.class).getBooks()).withRel("bookcollection"));
    }

    @GetMapping(path = "books", params = {"genre"})
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam(name = "genre") String genre) {
        List<Book> books = bookService.getBooksByGen(genre);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping(path = "books", params = {"year"})
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam(name = "year") Long year) {
        List<Book> books = bookService.getBooksByYear(year);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping(path = "books", params = {"genre", "year"})
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam(name = "genre") String genre, @RequestParam(name = "year") Long year) {
        List<Book> books = bookService.getBooksByGenAndYear(genre, year);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping(value = "/books", params = {"page", "items_per_page"})
    public ResponseEntity<List<Book>> getBooksPerPage(@RequestParam(name = "page") int page,
                                                      @RequestParam(name = "items_per_page") int items_per_page) {
        List<Book> books = bookService.getBooksPerPage(page, items_per_page);

        return ResponseEntity.status(HttpStatus.OK).body(books);
    }
}
