package com.example.hw2.book.service;

import java.util.List;

public interface IBookService<T, Y> {

    List<T> getAll();

    List<T> findBy(T t);

    T save(T t);

    void removeById(Y y);

    boolean removeByAuthor(String author);

    boolean removeByTitle(String title);

    boolean removeBySize(Integer size);

}