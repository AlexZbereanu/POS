package com.example.pos_demo.model.entities;

import com.example.pos_demo.model.domain.AuthorDTO;

import javax.persistence.*;


@Entity
@Table(name = "book_author")
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int index_author = 1;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "isbn")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Author author;

    public BookAuthor() {
    }

    public BookAuthor(Long id, String isbn, int id_author, int index_author) {
        this.id = id;
        this.index_author = index_author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIndex_author() {
        return index_author;
    }

    public void setIndex_author(int index_author) {
        this.index_author = index_author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public AuthorDTO convertFromAuthor(Author author){
        if(author == null){
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId(author.getId());
        authorDTO.setNume(author.getNume());
        authorDTO.setPrenume(author.getPrenume());

        return authorDTO;
    }

}
