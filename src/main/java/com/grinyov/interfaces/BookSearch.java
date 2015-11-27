package com.grinyov.interfaces;

import com.grinyov.entity.Author;
import com.grinyov.entity.Book;
import com.grinyov.entity.Genre;

import java.lang.Character;import java.lang.String;import java.util.List;

/**
 * Created by green on 11/27/15.
 */
public interface BookSearch {

    List<Book> getBooks();

    List<Book> getBooks(Author author);

    List<Book> getBooks(String bookName);

    List<Book> getBooks(Genre genre);

    List<Book> getBooks(Character letter);
}