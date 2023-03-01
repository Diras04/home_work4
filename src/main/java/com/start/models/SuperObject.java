package com.start.models;

import java.io.Serializable;

public abstract class  SuperObject implements Serializable {

    protected String name;

    protected Integer id;


    protected SuperObject(String name, int id) {
        this.name = name;
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}