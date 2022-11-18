package com.start.repository;

import com.start.courses.Courses;


public class CoursesRepository {
    static int size = 0;


    int length = 1;
    Courses[] coursesArray = new Courses[length];


    public void addCoursesToArray(Courses courses) {


        if (size < coursesArray.length) {
            coursesArray[size] = courses;
        } else {
            addSizeArray();
            coursesArray[size] = courses;

        }
        size++;


    }


    private void addSizeArray() {
        Courses[] longCourceArray = new Courses[((coursesArray.length) * 3 / 2) + 1];
        System.arraycopy(coursesArray, 0, longCourceArray, 0, coursesArray.length);
        coursesArray = longCourceArray;


    }

    public boolean checkId(int inId) {
        for (int j = 0; j < size; j++) {
            if (coursesArray[j].getId() == inId) {
                return true;
            }
        }
        return false;
    }

    public Courses[] getCoursesArray() {
        Courses[] coursesarray1 = new Courses[size];
        System.arraycopy(coursesArray, 0, coursesarray1, 0, size);
        return coursesarray1;
    }


}
