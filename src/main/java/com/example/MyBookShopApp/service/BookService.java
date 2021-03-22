package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.repository.BookRepository;
import com.example.MyBookShopApp.repository.BookToAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class BookService {

    private Logger logger = Logger.getLogger(BookService.class.getSimpleName());

    private final BookRepository bookRepository;
    private final BookToAuthorRepository bookToAuthorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BookToAuthorRepository bookToAuthorRepository) {
        this.bookRepository = bookRepository;
        this.bookToAuthorRepository = bookToAuthorRepository;
    }

    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

/*
    public List<Book> recommendedBooks(){
        return bookRepository.recommendedBooks();
    }
*/

    public Map<Book, Author> recommendedBooks(){
        List<Book> recommendedBooks = bookRepository.recommendedBooks();
        Map<Book, Author> authorBookMap = new HashMap<>();
        recommendedBooks.forEach(i -> {
            //logger.info(i.getId().toString());
            authorBookMap.put(i, bookToAuthorRepository
                    .findByBook(i)
                    .stream()
                    .findFirst()
                    .get()
                    .getAuthor()
            );
        });
        return authorBookMap;
    }

}
