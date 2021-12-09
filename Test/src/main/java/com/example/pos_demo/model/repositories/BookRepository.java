package com.example.pos_demo.model.repositories;

import com.example.pos_demo.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
