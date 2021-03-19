package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.BookToGenre;
import com.example.MyBookShopApp.data.BookToGenrePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookToGenreRepository extends JpaRepository<BookToGenre, BookToGenrePK> {
}
