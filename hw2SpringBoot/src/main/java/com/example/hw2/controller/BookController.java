package com.example.hw2.controller;

import com.example.hw2.exception.EmptyFilenameException;
import com.example.hw2.model.Book;
import com.example.hw2.model.BookIdToRemove;
import com.example.hw2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Logger;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public String bookPage(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAll());
        model.addAttribute("bookIdToRemove", new BookIdToRemove());
        model.addAttribute("searchBook", new Book());
        return "book";
    }

    @PostMapping("/save")
    public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("book", book);
            model.addAttribute("bookIdToRemove", new BookIdToRemove());
            model.addAttribute("searchBook", new Book());
            return "book";
        } else {
            bookService.save(book);
            return "redirect:/book";
        }
    }

    @PostMapping("/removeById")
    public String removeById(@Valid BookIdToRemove bookIdToRemove, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.getAll());
            model.addAttribute("bookIdToRemove", bookIdToRemove);
            model.addAttribute("searchBook", new Book());
            return "book";
        } else {
            bookService.removeById(bookIdToRemove);
            return "redirect:/book";
        }
    }

    @PostMapping("/removeByAuthor")
    public String removeByAuthor(@RequestParam(value = "authorToRemove") String author) {
        bookService.removeByAuthor(author);
        return "redirect:/book";
    }

    @PostMapping("/removeByTitle")
    public String removeByTitle(@RequestParam(value = "titleToRemove") String title) {
        bookService.removeByTitle(title);
        return "redirect:/book";
    }

    @PostMapping("/removeBySize")
    public String removeBySize(@RequestParam(value = "sizeToRemove") Integer size) {
        bookService.removeBySize(size);
        return "redirect:/book";
    }

    @PostMapping("/findBy")
    public String findBy(@ModelAttribute("searchBook") Book book, BindingResult bindingResult, Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.findBy(book));
        model.addAttribute("bookIdToRemove", new BookIdToRemove());
        return "book";
    }

}
