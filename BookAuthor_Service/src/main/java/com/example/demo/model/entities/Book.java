package com.example.demo.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "book", indexes = {@Index(name = "an_pub_index", columnList = "an_publicare"),
        @Index(name = "gen_index", columnList = "gen")})
public class Book {
    @Id
    private String isbn;
    @Column(unique = true)
    private String titlu;
    private String editura;
    private long an_publicare;
    private String gen;
    private boolean isActive = true;

    public Book() {

    }

    public Book(String isbn, String titlu, String editura, long an_publicare, String gen) {
        this.isbn = isbn;
        this.titlu = titlu;
        this.editura = editura;
        this.an_publicare = an_publicare;
        this.gen = gen;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public long getAn_publicare() {
        return an_publicare;
    }

    public void setAn_publicare(long an_publicare) {
        this.an_publicare = an_publicare;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", isbn='" + isbn +
                ", titlu='" + titlu + '\'' +
                ", editura='" + editura + '\'' +
                ", an_publicare=" + an_publicare +
                ", gen='" + gen + '\'' +
                '}';
    }
}
