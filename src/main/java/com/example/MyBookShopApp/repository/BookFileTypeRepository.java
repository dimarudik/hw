package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.BookFileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFileTypeRepository extends JpaRepository<BookFileType, Integer> {
}
