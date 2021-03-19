package com.example.MyBookShopApp.comparators;

import com.example.MyBookShopApp.data.Author;

import java.util.Comparator;

public class AuthorNameComparator implements Comparator<Author> {

    @Override
    public int compare(Author o1, Author o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
