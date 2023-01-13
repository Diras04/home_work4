package com.start.models;

public class Homework extends SuperObject {

    public int lessonId;
    public static int idstatik = 1;
    private String task;
    private static String inname;

    public Homework(String task) {
        super(inname, idstatik);
        this.task = task;

        this.id = idstatik;
        idstatik++;

    }

    public int getLessonId() {
        return lessonId;
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

