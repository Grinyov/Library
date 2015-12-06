package com.grinyov.library.beans;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by green on 06.12.2015.
 */


@Component
public class TestBean {

    @Autowired
    private SessionFactory sessionFactory;

    public void test(){
        System.out.println("sessionFactory = " + sessionFactory);
    }

}
