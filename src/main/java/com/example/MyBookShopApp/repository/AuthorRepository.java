package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // Разобраться, как использовать одну bind переменную дважды
    @Query(value =
            "select a.id, a.description, a.photo, a.slug, case when b.c = 1 then a.name else a.name||' and others...' end as name \n" +
            "from author a,\n" +
            "(select author_id, (select count(1) c from book2author b2a where b2a.book_id = ? limit 2) \n" +
            "from book2author b2a where book_id = ? limit 1) b \n" +
            "where a.id = b.author_id\n"
            , nativeQuery = true)
    Author findAuthorWithExtendedNameByBookId(Integer p1, Integer p2);

}
