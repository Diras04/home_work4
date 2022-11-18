package com.start.courses;

public class Teachers extends SuperObject {

    private static int idstatic = 1;


    public Teachers(String name) {
       super(name,idstatic);
        this.id = idstatic;
        idstatic++;

    }



    @Override
    public String toString() {
        return "Teachers{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
