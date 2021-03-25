package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.BookReviewLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewLikeRepository extends JpaRepository<BookReviewLike, Integer> {
}
