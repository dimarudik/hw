package com.example.hw2.repository;

import com.example.hw2.model.FileObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FileRepository implements IRepository<FileObject>{

    private final List<FileObject> fileRepository = new ArrayList<>();

    @Override
    public FileObject store(FileObject file) {
        fileRepository.add(file);
        return file;
    }

    @Override
    public List<FileObject> getAll() {
        return new ArrayList<>(fileRepository);
    }

    @Override
    public FileObject getById(Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public boolean removeByAuthor(String author) {
        return false;
    }

    @Override
    public boolean removeByTitle(String title) {
        return false;
    }

    @Override
    public boolean removeBySize(Integer size) {
        return false;
    }

}
