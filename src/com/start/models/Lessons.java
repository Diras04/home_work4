package com.start.models;


public class Lessons<E> extends SuperObject {


    public static int idstatik = 1;

    private Homework homeWork;
    private String description;
    private String dopInfo;
    public int courseId;
    private Person person;

    public Lessons(String name, String dopInfo, Person teacherinfo, String description) {
        super(name, idstatik);
        this.dopInfo = dopInfo;
        this.courseId = Courses.idstatik;
        this.person = teacherinfo;
        this.description = description;
        idstatik++;

    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


    public String getDopInfo() {
        return dopInfo;
    }

    public String getDescription() {
        return description;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                ", name='" + name + '\'' +
                // "homeWork=" + homeWork +
                ", description='" + description + '\'' +
                ", dopInfo='" + dopInfo + '\'' +
                ", courseId=" + courseId +
                ", person=" + person +

                ", id=" + id +
                '}';
    }
}
