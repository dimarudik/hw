package com.example.hw2.common.repository;

import java.util.List;

public interface IRepository<T> {

    List<T> getAll();
    T getById(Long id);
    T store(T entity);
    void removeById(Long id);
    boolean removeByAuthor(String author);
    boolean removeByTitle(String title);
    boolean removeBySize(Integer size);
}
