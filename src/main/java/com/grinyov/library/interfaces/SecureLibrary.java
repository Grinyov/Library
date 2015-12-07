package com.grinyov.library.interfaces;

import com.grinyov.library.entities.User;

/**
 * Created by green on 11/27/15.
 *
 * Интерфейс описывает авторизацию пользователей в систему
 */
public interface SecureLibrary {

    boolean login(User user);

    void logout(User user);
}
