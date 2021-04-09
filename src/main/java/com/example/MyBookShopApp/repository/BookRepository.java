package com.example.MyBookShopApp.repository;


import com.example.MyBookShopApp.data.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    //List<Book> findBooksByAuthor_FirstName(String name);

    @Query("from Book")
    List<Book> customFindAllBooks();

    //NEW BOOK REST REPOSITORY COMMANDS

    //List<Book> findBooksByAuthorFirstNameContaining(String authorFirstName);

    List<Book> findBooksByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceBetween(Integer min, Integer max);

    List<Book> findBooksByPriceOldIs(Integer price);

    @Query("from Book where isBestseller=1")
    List<Book> getBestsellers();

    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();

    Page<Book> findBookByTitleContaining(String bookTitle, Pageable nextPage);

    @Query(value =  "select \n" +
                    //"b.* \n" +
                    "b.id,\n" +
                    "b.description,\n" +
                    "b.discount,\n" +
                    "b.image,\n" +
                    "b.is_bestseller,\n" +
                    "b.price,\n" +
                    "b.price_old,\n" +
                    "b.pub_date,\n" +
                    "b.slug,\n" +
                    "b.title \n" +
                    ", get_author_name_by_book_id(b.id) author \n" +
                    "from \n" +
                    "book b \n" +
                    "where \n" +
                    "-- Books with rating more than 4 and published last year\n" +
                    "4 < (select avg(rating) from book_rating br where b.id = br.book_id) OR pub_date >= current_date - 365\n"
            , nativeQuery = true)
    Page<Book> getPageOfRecommendedBooks(Pageable pageable);

    @Query(value = "select get_author_name_by_book_id(?)", nativeQuery = true)
    String getAuthorNameByBookId(Integer book_id);

}
