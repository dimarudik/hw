package com.example.MyBookShopApp.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book2genre")
public class BookToGenre implements Serializable {

    @EmbeddedId
    private BookToGenrePK bookToGenrePK;

    public BookToGenrePK getBookToGenrePK() {
        return bookToGenrePK;
    }

    public void setBookToGenrePK(BookToGenrePK bookToGenrePK) {
        this.bookToGenrePK = bookToGenrePK;
    }
}
