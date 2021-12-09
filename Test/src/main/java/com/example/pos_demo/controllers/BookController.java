package com.example.pos_demo.controllers;

import com.example.pos_demo.model.entities.Book;
import com.example.pos_demo.services.BookService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/api/bookcollection")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value="/addbook")
    ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping( "/getbooks")
    public CollectionModel<Book> getBooks(){
        return CollectionModel.of(bookService.getBooks(),
                linkTo(methodOn(BookController.class).getBooks()).withSelfRel());
    }

    @GetMapping("books/{ISBN}")
    public EntityModel<Book> getBookById(@PathVariable String ISBN){
        return EntityModel.of(bookService.getBookById(ISBN),
                linkTo(methodOn(BookController.class).getBookById(ISBN)).withSelfRel(),
                linkTo(methodOn(BookController.class).getBooks()).withRel("bookcollection"));
    }
}
