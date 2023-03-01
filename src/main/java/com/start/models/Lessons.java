package com.start.models;


import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Lessons extends SuperObject implements Serializable {


    public static int idstatik = 1;

    private Homework homeWork;
    private String description;
    private String dopInfo;
    public int courseId;
    private Person person;
    private LocalDateTime creationDate;
    private LocalDateTime lectureDate;
    private String born;
    private String date;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d,EEE hh:mm:ss", Locale.UK);


    public Lessons(String name, String dopInfo, Person teacherinfo, String description, LocalDateTime lectureDate,Homework homeWork) {

        super(name, idstatik);
        this.dopInfo = dopInfo;
        this.courseId = Courses.idstatik;
        this.person = teacherinfo;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.lectureDate = lectureDate;
        this.homeWork = homeWork;
        this.homeWork.setLessonId(idstatik);
        this.homeWork.setDeadline(lectureDate);

        idstatik++;

    }


    public String getCreationDateToString() {
        return born=dateTimeFormatter.format(creationDate);
    }




    public String getLectureDateToString() {

        return date = dateTimeFormatter.format(lectureDate);

    }

    public Homework getHomeWork() {
        return homeWork;
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

    public int getCourseId() {
        return courseId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLectureDate() {
        return lectureDate;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "homeWork=" + homeWork +
                ", description='" + description + '\'' +
                ", dopInfo='" + dopInfo + '\'' +
                ", courseId=" + courseId +
                ", person=" + person +
                ", born='" + born + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
