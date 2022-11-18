package com.start.courses;

public class Lessons extends SuperObject {


    public static int idstatik = 1;

    private String homeWork;
    private String dopInfo;
    public int courseId;

    public Lessons(String name, String homeWork, String dopInfo) {
        super(name, idstatik);
        this.homeWork = homeWork;
        this.dopInfo = dopInfo;
        this.courseId = Courses.idstatik;
        idstatik++;

    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
