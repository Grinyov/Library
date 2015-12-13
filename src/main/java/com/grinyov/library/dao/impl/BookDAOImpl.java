package com.grinyov.library.dao.impl;

import com.grinyov.library.dao.interfaces.BookDAO;
import com.grinyov.library.entities.Author;
import com.grinyov.library.entities.Book;
import com.grinyov.library.entities.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList bookProjection;

    // в проекции указывем какие поля мы хотим отображать
    public BookDAOImpl() {
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
        List<Book> books = createBookList(createBookCriteria());
        return books;
    }
    // создаем фильтрацию с помощью аллиасов и restriction, то есть выбираем книги по автору,
    // MatchMode.ANYWHERE - указывает что в любом месте может встречатся строка  и записываем их в лист
    // выборка по автору
    @Transactional
    public List<Book> getBooks(Author author) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("author.fio", author.getFio(), MatchMode.ANYWHERE)));
        return books;
    }
    // выборка по названию
    @Transactional
    public List<Book> getBooks(String bookName) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("book.name", bookName, MatchMode.ANYWHERE)));
        return books;
    }
    // выборка по жанру
    @Transactional
    public List<Book> getBooks(Genre genre) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("author.fio", genre.getName(), MatchMode.ANYWHERE)));
        return books;
    }
    // выборка по букве вхождения
    @Transactional
    public List<Book> getBooks(Character letter) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("book.name", letter.toString(), MatchMode.START)));
        return books;

    }

    private DetachedCriteria createBookCriteria(){
        DetachedCriteria bookListCriteria = DetachedCriteria.forClass(Book.class, "book"); // create link
        createAliases(bookListCriteria);
        return bookListCriteria;
    }

    // create allias
    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("book.author", "author");
        criteria.createAlias("book.genre", "genre");
        criteria.createAlias("book.publisher", "publisher");
    }


    private List<Book> createBookList(DetachedCriteria bookListCriteria) {
        Criteria criteria = bookListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("book.name")).setProjection(bookProjection).setResultTransformer(Transformers.aliasToBean(Book.class));
        return criteria.list();
    }

}