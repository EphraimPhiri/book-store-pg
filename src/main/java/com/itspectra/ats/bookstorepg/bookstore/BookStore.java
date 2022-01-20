package com.itspectra.ats.bookstorepg.bookstore;

import javax.persistence.*;

@Entity
@Table
public class BookStore {

    @Id
    @SequenceGenerator(
            name = "bookstore_sequence",
            sequenceName = "bookstore_sequence",
            allocationSize = 1
    )
    @GeneratedValue( strategy = GenerationType.SEQUENCE,
            generator= "bookstore_sequence")
    private Long id;
    private String name;
    private String email;

    public BookStore() {
    }
    public BookStore(Long id
            , String name
            , String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public BookStore(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
