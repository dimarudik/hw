package com.example.MyBookShopApp.config;

import com.example.MyBookShopApp.comparators.BookTitleComparator;
import com.example.MyBookShopApp.comparators.BookToAuthorAuthorNameComparator;
import com.example.MyBookShopApp.comparators.BookToAuthorBookTitleComparator;
import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookToGenre;
import com.example.MyBookShopApp.data.BookToGenrePK;
import com.example.MyBookShopApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

// Примеры работы с репозиториями
@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final Logger logger = Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName());

    private AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookToAuthorRepository bookToAuthorRepository;
    private final GenreRepository genreRepository;
    private final BookToGenreRepository bookToGenreRepository;

    @Autowired
    public CommandLineRunnerImpl(AuthorRepository authorRepository, BookRepository bookRepository, BookToAuthorRepository bookToAuthorRepository, GenreRepository genreRepository, BookToGenreRepository bookToGenreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookToAuthorRepository = bookToAuthorRepository;
        this.genreRepository = genreRepository;
        this.bookToGenreRepository = bookToGenreRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        // Список книжек с авторами
        bookToAuthorRepository
                .findAll()
                .stream()
                .sorted(new BookToAuthorBookTitleComparator())
                .forEach(i -> {
                    logger.info( i.getBook().getTitle() + "  ( " + i.getAuthor().getName()+ " )");
                });

        // или
        bookRepository
                .findAll()
                .stream()
                .sorted(new BookTitleComparator())
                .forEach(i -> {
                    i.getBookToAuthors()
                            .stream()
                            .sorted(new BookToAuthorAuthorNameComparator())
                            .forEach(j -> {
                                logger.info(i.getTitle() + "  ( " + j.getAuthor().getName() + " )");
                            });
                });

        // Список авторов с книжками
        bookToAuthorRepository
                .findAll()
                .stream()
                .sorted(new BookToAuthorAuthorNameComparator())
                .forEach(i -> {
                    logger.info(i.getAuthor().getName() + "  ( " + i.getBook().getTitle() + " )");
                });



        // Проверяем, что персистится Embedded Entity
        Book oldBook = bookRepository.findById(1).get();
        Book newBook = new Book();
        newBook.setPubDate(oldBook.getPubDate());
        newBook.setIsBestseller(oldBook.getIsBestseller());
        newBook.setSlug(oldBook.getSlug());
        newBook.setTitle(oldBook.getTitle());
        newBook.setPrice(oldBook.getPrice());
        newBook.setDiscount(oldBook.getDiscount());
        Book savedBook = bookRepository.save(newBook);

        BookToGenre bookToGenre = new BookToGenre();
        BookToGenrePK bookToGenrePK = new BookToGenrePK();
        bookToGenrePK.setBook(savedBook);
        bookToGenrePK.setGenre(genreRepository.findById(1).get());
        bookToGenre.setBookToGenrePK(bookToGenrePK);
        bookToGenreRepository.save(bookToGenre);
    }

}
