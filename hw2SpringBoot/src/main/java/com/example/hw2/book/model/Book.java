package com.example.hw2.book.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

public class Book {

    private Long id;
    @NotEmpty
    private String author;
    @NotEmpty
    private String title;
    @Digits(integer = 4, fraction = 0)
    private Integer size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isValid() {
        return !(getAuthor().isEmpty() && getTitle().isEmpty() && getSize() == null);
    }
}
