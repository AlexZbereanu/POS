package com.example.pos_demo.services;

import com.example.pos_demo.model.domain.AuthorDTO;
import com.example.pos_demo.model.entities.BookAuthor;
import com.example.pos_demo.model.repositories.BookAuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookAuthorServiceImpl implements BookAuthorService{

    private final BookAuthorRepository bookAuthorRepository;

    public BookAuthorServiceImpl(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    @Override
    public List<AuthorDTO> getAuthorsByIsbn(String isbn) {
        Optional<List<BookAuthor>> bookAuthorOptional = Optional.of(bookAuthorRepository.findByBook_isbn(isbn));
        List<AuthorDTO> authorDTOs = new ArrayList<>();
        List<BookAuthor> bookAuthorsList = bookAuthorOptional.get();
        for(BookAuthor bookAuthor : bookAuthorsList)
        {
            authorDTOs.add(bookAuthor.convertFromAuthor(bookAuthor.getAuthor()));
            System.out.println("autor==  " +  bookAuthor.getAuthor().getNume());
        }

        return authorDTOs;
    }

    @Override
    public BookAuthor addNewBookAuthor(BookAuthor bookAuthor){
        return bookAuthorRepository.save(bookAuthor);
    }
}
