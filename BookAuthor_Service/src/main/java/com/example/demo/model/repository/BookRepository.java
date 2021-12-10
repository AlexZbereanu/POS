package com.example.demo.model.repository;

import com.example.demo.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT book FROM Book book WHERE book.gen = :gen")
    List<Book> findBooksByGenre(@RequestParam("genre") String gen);

    @Query("SELECT book FROM Book book WHERE book.an_publicare = :an")
    List<Book> findBooksByYear(@RequestParam("year") Long an);

    @Query("SELECT book FROM Book book WHERE book.gen = :gen AND book.an_publicare = :an")
    List<Book> findBooksByGenreAndYear(@RequestParam("genre") String gen, @RequestParam("year") Long an);

}