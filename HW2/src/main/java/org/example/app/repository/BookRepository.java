package org.example.app.repository;

import org.apache.log4j.Logger;
import org.example.web.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        if (  book.isValid() ) {
            book.setId(book.hashCode());
            logger.info("store new book: " + book);
            repo.add(book);
        } else {
            logger.warn("Can't save empty book!");
        }
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeItemByAuthor(String author) {
        for (Book book : retreiveAll()) {
            if (book.getAuthor().equals(author)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeItemByTitle(String title) {
        for (Book book : retreiveAll()) {
            if (book.getTitle().equals(title)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeItemBySize(Integer size) {
        for (Book book : retreiveAll()) {
            if (book.getSize().equals(size)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public List<Book> findItemByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        for (Book book : retreiveAll()) {
            if (book.getAuthor().equals(author)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findItemByTitle(String title) {
        List<Book> books = new ArrayList<>();
        for (Book book : retreiveAll()) {
            if (book.getTitle().equals(title)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findItemBySize(Integer size) {
        List<Book> books = new ArrayList<>();
        for (Book book : retreiveAll()) {
            if (book.getSize().equals(size)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findItemBy(String author, String title, Integer size) {
        List<Book> books = retreiveAll();

        if (!author.isEmpty()) {
            books = books.stream()
                    .filter(i -> i.getAuthor().equals(author))
                    .collect(Collectors.toList());
        }

        if (!title.isEmpty()) {
            books = books.stream()
                    .filter(i -> i.getTitle().equals(title))
                    .collect(Collectors.toList());
        }

        if (size != null) {
            books = books.stream()
                    .filter(i -> i.getSize() == size)
                    .collect(Collectors.toList());
        }

        return books;
    }

}
