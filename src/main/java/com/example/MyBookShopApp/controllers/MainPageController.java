package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

/*
    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.recommendedBooks();
    }
*/

    @ModelAttribute("recommendedBooks")
    public Map<Book, Author> recommendedBooks(){
        return bookService.recommendedBooks();
    }

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }
}
