package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {
}
