package com.start.repository;

import com.start.courses.Courses;

import java.util.Arrays;

public class CoursesRepository {
    static int i = 0;


    int size = 1;
    Courses[] coursesArray = new Courses[size];


    public void addCoursesToArray(Courses courses) {


        if (i < coursesArray.length) {
            coursesArray[i] = courses;
        } else {
            addSizeArray();
            coursesArray[i] = courses;

        }
        i++;


    }


    private void addSizeArray() {
        Courses[] longCourceArray = new Courses[((coursesArray.length) * 3 / 2) + 1];
        System.arraycopy(coursesArray, 0, longCourceArray, 0, coursesArray.length);
        coursesArray = longCourceArray;


    }

    public Courses[] getCoursesArray() {
        return coursesArray;
    }

    @Override
    public String toString() {
        return "CoursesRepository{" +
                "coursesArray=" + Arrays.toString(coursesArray) +
                '}';
    }
}
