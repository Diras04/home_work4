package com.start.courses;

public class Courses {

    private String name;
    public static int idstatik;
    public int id;
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

    public String getName() {
        return name;
    }

    public static int getIdstatik() {
        return idstatik;
    }

    public int getId() {
        return id;
    }

    public Lessons getLessonsinfo() {
        return lessonsinfo;
    }

    public Students getStudentinfo() {
        return studentinfo;
    }

    public Teachers getTeacherinfo() {
        return teacherinfo;
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


