package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("from Book")
    List<Book> customFindAllBooks();

    @Query(value = "select \n" +
            "b.* \n" +
            "from \n" +
            "book b\n" +
            "where\n" +
            "4 < (select avg(rating) from book_rating br where b.id = br.book_id) OR\n" +
            "pub_date >= current_date - 365\n"
            , nativeQuery = true)
    List<Book> recommendedBooks();

}
