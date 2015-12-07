package com.grinyov.library.interfaces;

import com.grinyov.library.entities.Author;
import com.grinyov.library.entities.Book;
import com.grinyov.library.entities.Genre;

import java.lang.Character;import java.lang.String;import java.util.List;

/**
 * Created by green on 11/27/15.
 *
 * Интерфейс описывает различные вида поиска по каталогу
 */
public interface BookSearch {

    List<Book> getBooks();

    List<Book> getBooks(Author author);

    List<Book> getBooks(String bookName);

    List<Book> getBooks(Genre genre);

    List<Book> getBooks(Character letter);
}