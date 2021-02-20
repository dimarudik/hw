package com.example.hw2.service;

import java.util.List;

//TODO комментарии к методам внутри интерфейса,
// уберите неиспользуемый иморт
public interface IBookService<T,Y> {

    List<T> getAll();
    List<T> findBy(T t);
    T save(T t);
    void removeById(Y y);
    boolean removeByAuthor(String author);
    boolean removeByTitle(String title);
    boolean removeBySize(Integer size);

}