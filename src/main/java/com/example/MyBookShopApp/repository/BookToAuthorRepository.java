package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookToAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookToAuthorRepository extends JpaRepository<BookToAuthor, Integer> {

    List<BookToAuthor> findByBook(Book book);
    List<BookToAuthor> findByAuthor(Author author);

}
