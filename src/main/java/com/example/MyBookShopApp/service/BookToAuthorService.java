package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.repository.BookToAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookToAuthorService {

    private BookToAuthorRepository bookToAuthorRepository;

    @Autowired
    public BookToAuthorService(BookToAuthorRepository bookToAuthorRepository) {
        this.bookToAuthorRepository = bookToAuthorRepository;
    }
}
