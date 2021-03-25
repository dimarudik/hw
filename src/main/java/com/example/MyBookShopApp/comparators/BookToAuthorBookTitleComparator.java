package com.example.MyBookShopApp.comparators;

import com.example.MyBookShopApp.data.BookToAuthor;

import java.util.Comparator;

public class BookToAuthorBookTitleComparator implements Comparator<BookToAuthor> {

    @Override
    public int compare(BookToAuthor o1, BookToAuthor o2) {
        return o1.getBook().getTitle().compareTo(o2.getBook().getTitle());
    }

}
