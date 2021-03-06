package com.example.demo.controller;

import com.example.demo.model.entities.Author;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.AuthorService;
import com.example.demo.view.AuthorDTO;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/api/bookcollection")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "authors/{ID}")
    public EntityModel<Author> getAuthorById(@PathVariable Long ID) {
        return EntityModel.of(authorService.getAuthorById(ID),
                linkTo(methodOn(AuthorController.class).getAuthorById(ID)).withSelfRel());
    }

    @PostMapping(path = "authors/add_author")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        authorService.save(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }

    @GetMapping(path = "authors", params = {"name"})
    public ResponseEntity<List<AuthorDTO>> getAuthorsByPartialNameMatch(@RequestParam(name = "name") String name) {
        List<Author> authors = authorService.getAuthorsByPartialName(name);
        List<AuthorDTO> authorsDTO = new ArrayList<>();
        for (Author author : authors) {
            AuthorDTO temp = new AuthorDTO();
            authorsDTO.add(temp.convertFromAuthor(author));
        }
        return ResponseEntity.status(HttpStatus.OK).body(authorsDTO);
    }

    @GetMapping(path = "authors", params = {"name", "match"})
    public ResponseEntity<List<AuthorDTO>> getAuthorsByExactNameMatch(@RequestParam(name = "name") String name,
                                                                      @RequestParam(name = "match") String match) {
        List<Author> authors = authorService.getAuthorsByExactName(name);
        List<AuthorDTO> authorsDTO = new ArrayList<>();
        for (Author author : authors) {
            AuthorDTO temp = new AuthorDTO();
            authorsDTO.add(temp.convertFromAuthor(author));
        }
        return ResponseEntity.status(HttpStatus.OK).body(authorsDTO);
    }

}
