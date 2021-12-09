package com.example.pos_demo.controllers;

import com.example.pos_demo.model.domain.AuthorDTO;
import com.example.pos_demo.model.entities.Author;
import com.example.pos_demo.model.entities.Book;
import com.example.pos_demo.model.entities.BookAuthor;
import com.example.pos_demo.services.BookAuthorService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path="api/bookcollection")
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;

    public BookAuthorController(BookAuthorService bookAuthorService){
        this.bookAuthorService = bookAuthorService;
    }


    //
    @GetMapping("/books/{isbn}/authors")
    public CollectionModel<AuthorDTO> getAuthorsForIsbn(@PathVariable(name="isbn") String isbn){

        List<AuthorDTO> authorList = bookAuthorService.getAuthorsByIsbn(isbn);

        return CollectionModel.of(authorList,
                linkTo(methodOn(BookController.class).getBooks()).withRel("bookcollection"));
    }

    @PostMapping("/addBookAuthor")
    public ResponseEntity<?> registerNewBookAuthor(@RequestBody BookAuthor bookAuthor){

        BookAuthor bookAuthorSaved = bookAuthorService.addNewBookAuthor(bookAuthor);
        EntityModel<BookAuthor> entityModel = EntityModel.of(bookAuthorSaved,
                linkTo(methodOn(BookAuthorController.class).registerNewBookAuthor(bookAuthorSaved)).withSelfRel(),
                linkTo(methodOn(BookController.class).getBooks()).withRel("bookcollection"));

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }
}
