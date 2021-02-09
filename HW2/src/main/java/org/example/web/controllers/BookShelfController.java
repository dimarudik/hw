package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.exceptions.EmptyFilenameException;
import org.example.app.services.BookService;
import org.example.web.model.Book;
import org.example.web.model.BookIdToRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
@RequestMapping(value = "/books")
public class BookShelfController {

    private final Logger logger = Logger.getLogger(BookShelfController.class);
    private final BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        logger.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookIdToRemove", new BookIdToRemove());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("book", book);
            model.addAttribute("bookIdToRemove", new BookIdToRemove());
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        } else {
            bookService.saveBook(book);
            logger.info("current repository size: " + bookService.getAllBooks().size());
            return "redirect:/books/shelf";
        }
    }

    @PostMapping("/remove")
    public String removeBook(@Valid BookIdToRemove bookIdToRemove, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            logger.warn("There is no book : " + bookIdToRemove);
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        } else {
            bookService.removeBookById(bookIdToRemove.getId());
            return "redirect:/books/shelf";
        }
    }

    @PostMapping("/removeByAuthor")
    public String removeBookByAuthor(Model model, @RequestParam(value = "authorToRemove") String author) {
        if (bookService.removeBookByAuthor(author)) {
            return "redirect:/books/shelf";
        } else {
            logger.warn("There is no book : " + author);
            return "redirect:/books/shelf";
        }
    }

    @PostMapping("/removeByTitle")
    public String removeBookByTitle(@RequestParam(value = "titleToRemove") String title) {
        if (bookService.removeBookByTitle(title)) {
            return "redirect:/books/shelf";
        } else {
            logger.warn("There is no book : " + title);
            return "redirect:/books/shelf";
        }
    }

    @PostMapping("/removeBySize")
    public String removeBookBySize(@RequestParam(value = "sizeToRemove") Integer size) {
        if (bookService.removeBookBySize(size)) {
            return "redirect:/books/shelf";
        } else {
            logger.warn("There is no book : " + size);
            return "redirect:/books/shelf";
        }
    }

    @PostMapping("/findBy")
    public String findBy(Model model,
                         @RequestParam(value = "author") String author,
                         @RequestParam(value = "title") String title,
                         @RequestParam(value = "size") Integer size) {
        logger.info("got book shelf by filter");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.findBookBy(author, title, size));
        return "book_shelf";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file) throws Exception {

        String name = file.getOriginalFilename();
        if (name.isEmpty()) {
            logger.info("missing file name...");
            throw new EmptyFilenameException("missing file name...");
        }

        byte[] bytes = file.getBytes();
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "external_uploads");
        if (!dir.exists()){
            dir.mkdir();
        }

        File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();

        logger.info("file uploaded in " + serverFile.getAbsolutePath());

        return "redirect:/books/shelf";
    }

}
