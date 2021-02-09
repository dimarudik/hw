package org.example.app.repository;

import java.util.List;

public interface ProjectRepository<T> {

    List<T> retreiveAll();
    void store(T entity);
    boolean removeItemById(Integer id);
    boolean removeItemByAuthor(String author);
    boolean removeItemByTitle(String title);
    boolean removeItemBySize(Integer size);
    List<T> findItemByAuthor(String author);
    List<T> findItemByTitle(String title);
    List<T> findItemBySize(Integer size);
    List<T> findItemBy(String author, String title, Integer size);

}
