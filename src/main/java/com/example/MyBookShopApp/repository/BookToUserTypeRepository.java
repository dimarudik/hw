package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.BookToUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookToUserTypeRepository extends JpaRepository<BookToUserType, Integer> {
}
