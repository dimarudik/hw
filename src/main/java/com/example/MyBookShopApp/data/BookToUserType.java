package com.example.MyBookShopApp.data;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book2user_type")
public class BookToUserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bookToUserType")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BookToUser> bookToUsers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookToUser> getBookToUsers() {
        return bookToUsers;
    }

    public void setBookToUsers(List<BookToUser> bookToUsers) {
        this.bookToUsers = bookToUsers;
    }
}
