package com.grinyov.library.dao.impl;

import com.grinyov.library.dao.interfaces.LibraryDAO;

import com.grinyov.library.entities.Author;
import com.grinyov.library.entities.Book;
import com.grinyov.library.entities.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
public class LibraryDAOImpl implements LibraryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList bookProjection;

    public LibraryDAOImpl() {
        bookProjection = Projections.projectionList();
        bookProjection.add(Projections.property("id"), "id");
        bookProjection.add(Projections.property("name"), "name");
        bookProjection.add(Projections.property("image"), "image");
        bookProjection.add(Projections.property("genre"), "genre");
        bookProjection.add(Projections.property("pageCount"), "pageCount");
        bookProjection.add(Projections.property("isbn"), "isbn");
        bookProjection.add(Projections.property("publisher"), "publisher");
        bookProjection.add(Projections.property("author"), "author");
        bookProjection.add(Projections.property("publishYear"), "publishYear");
        bookProjection.add(Projections.property("descr"), "descr");
        bookProjection.add(Projections.property("rating"), "rating");
        bookProjection.add(Projections.property("voteCount"), "voteCount");
    }


    @Transactional
    public List<Book> getBooks() {
        DetachedCriteria bookListCriteria = DetachedCriteria.forClass(Book.class, "book"); // создаем аллиас book
        createAliases(bookListCriteria);

        List<Book> books = createBookList(bookListCriteria);

        return books;
    }


    public List<Book> getBooks(Author author) {
        return null;
    }

    public List<Book> getBooks(String bookName) {
        return null;
    }

    public List<Book> getBooks(Genre genre) {
        return null;
    }

    public List<Book> getBooks(Character letter) {
        return null;
    }

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("book.author", "author");
        criteria.createAlias("book.genre", "genre");
        criteria.createAlias("book.publisher", "publisher");
    }


    private List<Book> createBookList(DetachedCriteria bookListCriteria) {
        Criteria criteria = bookListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("b.name")).setProjection(bookProjection).setResultTransformer(Transformers.aliasToBean(Book.class));
        return criteria.list();
    }


}
