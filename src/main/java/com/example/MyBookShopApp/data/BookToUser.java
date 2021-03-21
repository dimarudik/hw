package com.example.MyBookShopApp.data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "book2user")
public class BookToUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private BookToUserType bookToUserType;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public BookToUserType getBookToUserType() {
        return bookToUserType;
    }

    public void setBookToUserType(BookToUserType bookToUserType) {
        this.bookToUserType = bookToUserType;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
