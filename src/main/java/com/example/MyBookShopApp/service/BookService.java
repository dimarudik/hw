package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.repository.AuthorRepository;
import com.example.MyBookShopApp.repository.BookRepository;
import com.example.MyBookShopApp.repository.BookToAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {

    private Logger logger = Logger.getLogger(BookService.class.getSimpleName());

    private final BookRepository bookRepository;
    private final BookToAuthorRepository bookToAuthorRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BookToAuthorRepository bookToAuthorRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.bookToAuthorRepository = bookToAuthorRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

    //NEW BOOK SEVICE METHODS

    public List<Book> getBooksByAuthor(String authorName){
        //return bookRepository.findBooksByAuthorFirstNameContaining(authorName);
        return bookRepository.findAll();
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max){
        return bookRepository.findBooksByPriceBetween(min,max);
    }

    public List<Book> getBooksWithPrice(Integer price){
        return bookRepository.findBooksByPriceOldIs(price);
    }

    public List<Book> getBooksWithMaxPrice(){
        return bookRepository.getBooksWithMaxDiscount();
    }

    public List<Book> getBestsellers(){
        return bookRepository.getBestsellers();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        Page<Book> books = bookRepository.getPageOfRecommendedBooks(nextPage);
        //books.getContent().forEach(book -> book.setAuthor(bookRepository.getAuthorNameByBookId(book.getId())));
        return books;
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBookByTitleContaining(searchWord,nextPage);
    }

/*
    public Map<Book, Author> getRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        List<Book> recommendedBooks = bookRepository.recommendedBooks(nextPage);
        Map<Book, Author> authorBookMap = new HashMap<>();
        recommendedBooks.forEach(book -> {
            authorBookMap.put(
                    book,
                    authorRepository
                    .findAuthorWithExtendedNameByBookId(book.getId(),book.getId())
            );
            //logger.info(authorBookMap.get(i).getName());
        });
        return authorBookMap;
    }
*/

}
