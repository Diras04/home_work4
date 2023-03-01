package com.start.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Homework extends SuperObject implements Serializable {

    public int lessonId;
    public static int idstatik = 1;
    private String task;
    private static String inname;
    private LocalDateTime deadline;

    private String dateDeadLine;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d, 12:00", Locale.UK);


    public Homework(String task) {
        super(inname, idstatik);
        this.task = task;
        this.id = idstatik;

        idstatik++;

    }


    public String getTask() {
        return task;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
        dateDeadLine = dateTimeFormatter.format(deadline.plusDays(1));
    }
    public int getLessonId() {
        return lessonId;
    }
    public String getCreationDateToString() {
        return dateDeadLine;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "lessonId=" + lessonId +
                ", task='" + task + '\'' +
                ", date='" + dateDeadLine + '\'' +
                ", id=" + id +
                '}';
    }
}


