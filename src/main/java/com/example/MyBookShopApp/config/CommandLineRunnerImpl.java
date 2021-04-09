package com.example.MyBookShopApp.config;

import com.example.MyBookShopApp.comparators.BookTitleComparator;
import com.example.MyBookShopApp.repository.*;
import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.logging.Logger;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final Logger logger = Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName());

    private BookService bookService;
    private BookToAuthorRepository bookToAuthorRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public CommandLineRunnerImpl(BookService bookService, BookToAuthorRepository bookToAuthorRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookToAuthorRepository = bookToAuthorRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Рекомендованные
        Thread.sleep(1000);
/*
        bookService
                .getRecommendedBooks(0, 6)
                .forEach((i, j) -> {
                    logger.info(j.getName());
                });
*/

    }



}
