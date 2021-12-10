package com.example.demo.model.repository;

import com.example.demo.model.entities.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

    List<BookAuthor> findByBook_isbn(String isbn);
}
