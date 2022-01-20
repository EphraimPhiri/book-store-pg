package com.itspectra.ats.bookstorepg.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookStoreConfig {

     @Bean
    CommandLineRunner commandLineRunner(BookStoreRepository repository) {
        return  args -> {
            BookStore mercy = new BookStore("Mercy",
                    "mercy@gmail.com");

            BookStore james = new BookStore("James",
                    "james@gmail.com");
            repository.saveAll(
                    List.of(mercy, james)
            );
        };


     };
}
