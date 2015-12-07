package com.grinyov.library.dao.interfaces;


import com.grinyov.library.entities.Author;
import com.grinyov.library.entities.Book;
import com.grinyov.library.entities.Genre;

import java.util.List;


public interface BookDAO {

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);

}
