package org.example.app.services;

import org.example.app.repository.ProjectRepository;
import org.example.web.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    public boolean removeBookByAuthor(String author) {
        return bookRepo.removeItemByAuthor(author);
    }

    public boolean removeBookByTitle(String title) {
        return bookRepo.removeItemByTitle(title);
    }

    public boolean removeBookBySize(Integer size) {
        return bookRepo.removeItemBySize(size);
    }

    public List<Book> findBookByAuthor(String author) {
        return bookRepo.findItemByAuthor(author);
    }

    public List<Book> findBookByTitle(String title) {
        return bookRepo.findItemByTitle(title);
    }

    public List<Book> findBookBySize(Integer size) {
        return bookRepo.findItemBySize(size);
    }

    public List<Book> findBookBy(String author, String title, Integer size) {
        return bookRepo.findItemBy(author, title, size);
    }

}
