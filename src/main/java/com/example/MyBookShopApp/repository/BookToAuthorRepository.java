package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.BookToAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookToAuthorRepository extends JpaRepository<BookToAuthor, Integer> {

}
