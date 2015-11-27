package com.grinyov.entity;

/**
 * Created by green on 11/27/15.
 */
public class Publisher implements java.io.Serializable {

    private String name;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
