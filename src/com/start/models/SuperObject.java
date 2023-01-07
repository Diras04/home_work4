package com.start.models;

public abstract class  SuperObject {

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