package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.BookToUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookToUserRepository extends JpaRepository<BookToUser, Integer> {
}
