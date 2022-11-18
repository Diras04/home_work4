package com.start.courses;

public class Courses extends SuperObject {

    public static int idstatik = 1;
    private Lessons lessonsinfo;
    private Students studentinfo;
    private Teachers teacherinfo;

    public Courses(String inname, Lessons inlessons, Students instudents, Teachers inteachers) {

        super(inname, idstatik);
        this.lessonsinfo = inlessons;
        this.studentinfo = instudents;
        this.teacherinfo = inteachers;
        this.lessonsinfo.setCourseId(this.idstatik);
        idstatik++;

    }

    public static int getIdstatik() {
        return idstatik;
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


