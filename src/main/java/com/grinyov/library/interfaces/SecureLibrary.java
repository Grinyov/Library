package com.grinyov.library.interfaces;

import com.grinyov.library.entity.User;

/**
 * Created by green on 11/27/15.
 */
public interface SecureLibrary {

    boolean login(User user);

    void logout(User user);
}
