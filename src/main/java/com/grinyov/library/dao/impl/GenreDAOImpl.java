package com.grinyov.library.dao.impl;

import com.grinyov.library.dao.interfaces.GenreDAO;
import com.grinyov.library.entities.Genre;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by green on 15.12.2015.
 */


@Component
public class GenreDAOImpl implements GenreDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Genre> getGenres() {
        return sessionFactory.getCurrentSession().createCriteria(Genre.class).list();
    }





}