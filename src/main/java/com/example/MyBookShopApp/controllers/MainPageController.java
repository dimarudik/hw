package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.service.AuthorService;
import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public MainPageController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("bookData",bookService.getBooksData());
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage(Model model){
        return "genres/index";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model){
        model.addAttribute("authorData",authorService.getAuthorsData());
        return "authors/index";
    }

}

