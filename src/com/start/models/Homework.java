package com.start.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Homework extends SuperObject implements Serializable {

    public int lessonId;
    public static int idstatik = 1;
    private String task;
    private static String inname;
    private LocalDateTime deadline;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d, hh:mm");


    public Homework(String task, LocalDateTime deadline) {
        super(inname, idstatik);
        this.task = task;
        this.id = idstatik;
        this.deadline = deadline;
        idstatik++;

    }

    public int getLessonId() {
        return lessonId;
    }
    public String getCreationDateToString() {
        return dateTimeFormatter.format(deadline);
    }


    public String getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "Homework{" +

                ", task='" + task + '\'' +

                ", id=" + id +
                '}';
    }
}

