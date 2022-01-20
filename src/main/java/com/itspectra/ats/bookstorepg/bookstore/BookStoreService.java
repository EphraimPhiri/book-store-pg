package com.itspectra.ats.bookstorepg.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    @Autowired
    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public List<BookStore> getUsers() {
        return bookStoreRepository.findAll();
    }

    public void addNewUser(BookStore bookstore) {
        Optional<BookStore> bookStoreOptional = bookStoreRepository
                .findBookStoreByEmail(bookstore.getEmail());
        if (bookStoreOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        bookStoreRepository.save(bookstore);
    }

    public void deleteUser(Long bookStoreId) {
        boolean exists = bookStoreRepository.existsById(bookStoreId);

        if (!exists) {
            throw new IllegalStateException(
                    "user with id " + bookStoreId + " does not exists");
        }
        bookStoreRepository.deleteById(bookStoreId);
    }

    @Transactional
    public void updateUser(Long bookStoreId, String name, String email) {
        BookStore bookStore = bookStoreRepository.findById(bookStoreId).orElseThrow(() -> new IllegalStateException(
                "student with id " + bookStoreId + " does not exist"));
        if (email != null && name.length() > 0 &&
                !Objects.equals(bookStore.getName(), name)) {
            bookStore.setName(name);
        }
        if (email != null && email.length() > 0 &&
                !Objects.equals(bookStore.getEmail(), email)) {
            Optional<BookStore> bookStoreOptional = bookStoreRepository
                    .findBookStoreByEmail(email);
            if (bookStoreOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            bookStore.setEmail(email);
        }
    }
}