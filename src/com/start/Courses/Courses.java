package com.start.Courses;

import java.util.Objects;
import com.start.Courses.Lessons;

public class Courses {

    private String name;
     public static int id;
    String lessonsName;
    String studentsName;
    String teachersName;

    public Courses(String name, String lessonsName, String studentsName, String teachersName) {
        this.name = name;
        this.lessonsName = lessonsName;
        this.studentsName = studentsName;
        this.teachersName = teachersName;
        id++;

    }



    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", lessonsName='" + lessonsName + '\'' +
                ", studentsName='" + studentsName + '\'' +
                ", teachersName='" + teachersName + '\'' +
                '}';
    }
}


