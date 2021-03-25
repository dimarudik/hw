package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.BookRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRating, Integer> {

    @Query(value = "select avg(rating) from book_rating where book_id = ?1", nativeQuery = true)
    Double avgRatingByBook(Integer book_id);
}
