package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
public class MainPageController {

    private final BookService bookService;
    private final LocaleResolver localeResolver;

    @Autowired
    public MainPageController(BookService bookService, LocaleResolver localeResolver) {
        this.bookService = bookService;
        this.localeResolver = localeResolver;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(HttpServletRequest httpServletRequest){
        Locale locale = localeResolver.resolveLocale(httpServletRequest);
        return locale.toString().equals("en") ? bookService.getBooksData() : null;
    }

    @ModelAttribute("searchPlaceholder")
    public String searchPlaceholder() {
        return "New Search";
    }

    @GetMapping("/")
    public String mainPage(HttpServletRequest httpServletRequest, Model model){
        model.addAttribute("servletPath", httpServletRequest.getServletPath());
        return "index";
    }

    @GetMapping("/postponed")
    public String postponedPage(){
        return "postponed";
    }

    @GetMapping("/cart")
    public String cartPage(){
        return "cart";
    }

    @GetMapping("/signin")
    public String signinPage(){
        return "signin";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }

    @GetMapping("/faq")
    public String faqPage(){
        return "faq";
    }

    @GetMapping("/contacts")
    public String contactsPage(){
        return "contacts";
    }

    @GetMapping("/documents")
    public String documentsPage(){
        return "documents";
    }

}
