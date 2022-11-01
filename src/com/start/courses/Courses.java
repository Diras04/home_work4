package com.start.courses;

public class Courses {

    private String name;
    public static int idstatik;
    public  int id;
    Lessons lessonsinfo;
    Students studentinfo;
    Teachers teacherinfo;

    public Courses(String inname, Lessons inlessons, Students instudents, Teachers inteachers) {
        this.name = inname;
        this.lessonsinfo = inlessons;
        this.studentinfo = instudents;
        this.teacherinfo = inteachers;
        idstatik++;
        this.id = idstatik;
        this.lessonsinfo.setCourseId(this.id);

    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", lessonsinfo=" + lessonsinfo +
                ", studentinfo=" + studentinfo +
                ", teacherinfo=" + teacherinfo +
                '}';
    }
}


