package com.start.Courses;

public class Lessons {

    private String name;
    private static int id;
    private String homeWork;
    private String dopInfo;
    public int courseId;

    public Lessons(String name, String homeWork, String dopInfo) {
        this.name = name;
        this.homeWork = homeWork;
        this.dopInfo = dopInfo;
        this.courseId = Courses.id;
        id++;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", homeWork='" + homeWork + '\'' +
                ", dopInfo='" + dopInfo + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
