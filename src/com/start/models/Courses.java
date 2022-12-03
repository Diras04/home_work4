package com.start.models;

public class Courses extends SuperObject {

    public static int idstatik = 1;
    private Lessons lessonsinfo;
    private Person studentinfo;


    public Courses(String inname, Lessons inlessons, Person instudents) {

        super(inname, idstatik);
        this.lessonsinfo = inlessons;
        this.studentinfo = instudents;
        this.lessonsinfo.setCourseId(this.idstatik);
        idstatik++;

    }

    public static int getIdstatik() {
        return idstatik;
    }

    public Lessons getLessonsinfo() {
        return lessonsinfo;
    }

    public Person getStudentinfo() {
        return studentinfo;
    }



    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", lessonsinfo=" + lessonsinfo +
                ", studentinfo=" + studentinfo +

                '}';
    }
}


