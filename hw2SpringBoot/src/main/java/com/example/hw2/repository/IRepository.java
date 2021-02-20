package com.example.hw2.repository;

import com.example.hw2.model.Book;

import java.util.List;

//TODO комментарии к методам внутри интерфейса,
// уберите неиспользуемый иморт
public interface IRepository<T> {

    List<T> getAll();
    T getById(Long id);
    T store(T entity);
    void removeById(Long id);
    boolean removeByAuthor(String author);
    boolean removeByTitle(String title);
    boolean removeBySize(Integer size);
}
