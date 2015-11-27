package com.grinyov.interfaces;

import com.grinyov.entity.Book;

/**
 * Created by green on 11/27/15.
 */
public interface ShowBook {

    void showBook(Book book);
    void downloadBook(Book book);
    void voteBook(Book book);

}
