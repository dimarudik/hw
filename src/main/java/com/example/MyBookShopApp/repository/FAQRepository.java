package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Integer> {
}
