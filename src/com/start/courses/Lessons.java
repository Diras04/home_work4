package com.start.courses;

public class Lessons {

    private String name;
    public static int idstatik;
    private int id;
    private String homeWork;
    private String dopInfo;
    public int courseId;

    public Lessons(String name, String homeWork, String dopInfo) {
        this.name = name;
        this.homeWork = homeWork;
        this.dopInfo = dopInfo;
        this.courseId = Courses.idstatik;
        idstatik++;
        this.id = idstatik;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public String getDopInfo() {
        return dopInfo;
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
