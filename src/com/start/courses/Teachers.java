package com.start.courses;

public class Teachers {
    private String name;
    private static int idstatic;
    private int id;

    public Teachers(String name) {
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
        return "Teachers{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
