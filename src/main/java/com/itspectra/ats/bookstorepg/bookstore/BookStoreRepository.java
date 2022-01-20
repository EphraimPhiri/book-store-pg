package com.itspectra.ats.bookstorepg.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookStoreRepository
        extends JpaRepository<BookStore, Long> {

    @Query("SELECT b FROM BookStore b WHERE b.email = ?1")
    Optional<BookStore> findBookStoreByEmail(String email);
}
