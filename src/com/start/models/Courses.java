package com.start.models;

import java.util.Comparator;

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
    public static Comparator<Courses> coursesComparator = new Comparator<Courses>() {

        public int compare(Courses c1, Courses c2) {
            String courseName1 = c1.getName().toUpperCase();
            String courseName2 = c2.getName().toUpperCase();


            return courseName1.compareTo(courseName2);


        }};



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


