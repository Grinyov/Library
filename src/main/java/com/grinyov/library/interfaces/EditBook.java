package com.grinyov.library.interfaces;

import com.grinyov.library.entities.Book;

/**
 * Created by green on 11/27/15.
 *
 * Интерфейс описывает основные(crud) операции над книгой
 */
public interface EditBook {

    boolean save(Book book);
    boolean delete(Book book);
    boolean edit(Book book);
    boolean add(Book book);
}
