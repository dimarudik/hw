package com.example.hw2.book.controller;

import com.example.hw2.book.model.Book;
import com.example.hw2.book.model.BookIdToRemove;
import com.example.hw2.fileobject.repository.FileRepository;
import com.example.hw2.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//TODO добавьте комментарии к каждому методу
// используйте один Autowired на конструктор
//    Done
@Controller
public class BookController {

    private final BookService bookService;
    private final FileRepository fileRepository;

    @Autowired
    public BookController(BookService bookService, FileRepository fileRepository) {
        this.bookService = bookService;
        this.fileRepository = fileRepository;
    }

    // Страница магазина
    @GetMapping("/book")
    public String bookPage(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAll());
        model.addAttribute("bookIdToRemove", new BookIdToRemove());
        model.addAttribute("searchBook", new Book());
        model.addAttribute("fileList", fileRepository.getAll());
        return "book/book";
    }

    // Добавить книгу
    @PostMapping("/save")
    public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("book", book);
            model.addAttribute("bookIdToRemove", new BookIdToRemove());
            model.addAttribute("searchBook", new Book());
            model.addAttribute("fileList", fileRepository.getAll());
            return "book/book";
        } else {
            bookService.save(book);
            return "redirect:/book";
        }
    }

    // Удалить книгу по ID
    @PostMapping("/removeById")
    public String removeById(@Valid BookIdToRemove bookIdToRemove, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.getAll());
            model.addAttribute("bookIdToRemove", bookIdToRemove);
            model.addAttribute("searchBook", new Book());
            model.addAttribute("fileList", fileRepository.getAll());
            return "book/book";
        } else {
            bookService.removeById(bookIdToRemove);
            return "redirect:/book";
        }
    }

    // Удалить книгу по автору
    @PostMapping("/removeByAuthor")
    public String removeByAuthor(@RequestParam(value = "authorToRemove") String author) {
        bookService.removeByAuthor(author);
        return "redirect:/book";
    }

    // Удалить книгу по названию
    @PostMapping("/removeByTitle")
    public String removeByTitle(@RequestParam(value = "titleToRemove") String title) {
        bookService.removeByTitle(title);
        return "redirect:/book";
    }

    // Удалить книгу по числу страниц
    @PostMapping("/removeBySize")
    public String removeBySize(@RequestParam(value = "sizeToRemove") String size) {
        if (!size.isEmpty())
            bookService.removeBySize(Integer.valueOf(size));
        return "redirect:/book";
    }

    // Перехват исключения при вводе символов в поле количества страниц при удалении по числу страниц
    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormatException(Model model, NumberFormatException numberFormatException){
        model.addAttribute("errorMessage", numberFormatException.getMessage());
        return "/error";
    }

    // Поиск по трем полям
    @PostMapping("/findBy")
    public String findBy(@ModelAttribute("searchBook") Book book, BindingResult bindingResult, Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.findBy(book));
        model.addAttribute("bookIdToRemove", new BookIdToRemove());
        return "book/book";
    }

}
