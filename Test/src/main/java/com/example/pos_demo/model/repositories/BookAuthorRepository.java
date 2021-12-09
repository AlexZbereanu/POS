package com.example.pos_demo.model.repositories;

import com.example.pos_demo.model.entities.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

    List<BookAuthor> findByBook_isbn(String isbn);
}
