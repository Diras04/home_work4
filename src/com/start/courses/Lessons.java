package com.start.courses;

public class Lessons extends SuperObject {


    public static int idstatik = 1;

    private String homeWork;
    private String description;
    private String dopInfo;
    public int courseId;
    private Person person;

    public Lessons(String name, String homeWork, String dopInfo, Person teacherinfo, String description) {
        super(name, idstatik);
        this.homeWork = homeWork;
        this.dopInfo = dopInfo;
        this.courseId = Courses.idstatik;
        this.person = teacherinfo;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "homeWork='" + homeWork + '\'' +
                ", description='" + description + '\'' +
                ", dopInfo='" + dopInfo + '\'' +
                ", courseId=" + courseId +
                ", person=" + person +
                '}';
    }
}
