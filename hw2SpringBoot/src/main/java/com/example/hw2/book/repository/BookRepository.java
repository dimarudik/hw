package com.example.hw2.book.repository;

import com.example.hw2.book.model.Book;
import com.example.hw2.common.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IRepository<Book> {

    private final List<Book> repo = new ArrayList<>();

    @Override
    public Book store(Book book) {
        if (  book.isValid() ) {
            book.setId((long) book.hashCode());
            repo.add(book);
        } else {
            return null;
        }
        return book;
    }

    @Override
    public void removeById(Long id) {
        repo.remove(getById(id));
    }

    @Override
    public boolean removeByAuthor(String author) {
        for (Book book : getAll()) {
            if (book.getAuthor().equals(author)){
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeByTitle(String title) {
        for (Book book : getAll()) {
            if (book.getTitle().equals(title)){
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeBySize(Integer size) {
        for (Book book : getAll()) {
            if (book.getSize().equals(size)){
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public Book getById(Long id) {
        for (Book book : getAll()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

}
