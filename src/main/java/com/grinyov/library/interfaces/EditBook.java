package com.grinyov.library.interfaces;

import com.grinyov.library.entity.Book;

/**
 * Created by green on 11/27/15.
 */
public interface EditBook {

    boolean save(Book book);
    boolean delete(Book book);
    boolean edit(Book book);
    boolean add(Book book);
}
