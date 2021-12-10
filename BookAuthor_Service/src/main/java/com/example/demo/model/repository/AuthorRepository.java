package com.example.demo.model.repository;

import com.example.demo.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT author FROM Author author WHERE author.nume = :nume")
    List<Author> findAuthorsByExactName(@RequestParam("nume") String nume);

    @Query("SELECT author FROM Author author WHERE author.nume LIKE %:nume%")
    List<Author> findAuthorsByPartialName(@RequestParam("nume") String nume);
}
