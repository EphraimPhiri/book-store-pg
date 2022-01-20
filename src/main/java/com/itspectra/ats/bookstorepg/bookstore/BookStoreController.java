package com.itspectra.ats.bookstorepg.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookstore")
public class BookStoreController {

    private final BookStoreService bookStoreService;

    @Autowired
    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping
    public List<BookStore> getUsers(){
        return bookStoreService.getUsers();
    }
    @PostMapping
    public void registerNewUsers(@RequestBody BookStore bookstore){
        bookStoreService.addNewUser(bookstore);
    }
    @DeleteMapping(path = "{bookStoreId}")
    public void deleteUser(
            @PathVariable("bookStoreId") Long bookStoreId){
    bookStoreService.deleteUser(bookStoreId);
    }
    @PutMapping(path = "{bookStoreId}")
    public void updateUser(
            @PathVariable("bookStoreId") Long bookStoreId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        bookStoreService.updateUser(bookStoreId, name, email);
    }
}
