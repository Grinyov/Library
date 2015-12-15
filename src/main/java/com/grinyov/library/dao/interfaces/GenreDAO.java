package com.grinyov.library.dao.interfaces;

import com.grinyov.library.entities.Genre;

import java.util.List;

/**
 * Created by green on 15.12.2015.
 *
 * Интерфейс для работы с сущностью Genres
 */
public interface GenreDAO {

    List<Genre> getGenres();

}
