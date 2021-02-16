package com.example.hw2.service;

import com.example.hw2.model.Book;
import com.example.hw2.model.BookIdToRemove;
import com.example.hw2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService<Book, BookIdToRemove> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.store(book);
    }

    @Override
    public void removeById(BookIdToRemove bookIdToRemove) {
        bookRepository.removeById(bookIdToRemove.getId());
    }

    @Override
    public boolean removeByAuthor(String author) {
        return bookRepository.removeByAuthor(author);
    }

    @Override
    public boolean removeByTitle(String title) {
        return bookRepository.removeByTitle(title);
    }

    @Override
    public boolean removeBySize(Integer size) {
        return bookRepository.removeBySize(size);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public List<Book> findBy(Book book) {

        List<Book> books = bookRepository.getAll();

        if (!book.getAuthor().isEmpty()) {
            books = books.stream()
                    .filter(i -> i.getAuthor().equals(book.getAuthor()))
                    .collect(Collectors.toList());
        }

        if (!book.getTitle().isEmpty()) {
            books = books.stream()
                    .filter(i -> i.getTitle().equals(book.getTitle()))
                    .collect(Collectors.toList());
        }

        if (book.getSize() != null) {
            books = books.stream()
                    .filter(i -> i.getSize() == book.getSize())
                    .collect(Collectors.toList());
        }

        return books;

    }

}
