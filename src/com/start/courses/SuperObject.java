package com.start.courses;

public class SuperObject {

     String name;

     int id;


    public SuperObject(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public SuperObject(){
        this.name = "";
        this.id = -1;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}