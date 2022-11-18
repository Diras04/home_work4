package com.start.courses;

public class Students extends SuperObject{

    private static int idstatic = 1;


    public Students(String name) {
        super(name,idstatic);
        this.id = idstatic;
        idstatic++;
    }



    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
