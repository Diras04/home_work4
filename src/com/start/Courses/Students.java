package com.start.Courses;

public class Students {
    private String name;
    private static int idstatic;
    private int id;

    public Students(String name) {
        this.name = name;
        idstatic++;
        this.id = idstatic;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
