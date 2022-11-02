package com.start.repository;

import com.start.courses.Students;

public class StudentsRepository {
    static int i = 0;


    int size = 1;
    Students[] studentsArray = new Students[size];


    public void addStudentsToArray(Students students) {


        if (i < studentsArray.length) {
            studentsArray[i] = students;
        } else {
            addSizeArray();
            studentsArray[i] = students;

        }
        i++;


    }


    private void addSizeArray() {
        Students[] longStudentsArray = new Students[((studentsArray.length) * 3 / 2) + 1];
        System.arraycopy(studentsArray, 0, longStudentsArray, 0, studentsArray.length);
        studentsArray = longStudentsArray;


    }

    public Students[] getStudentsArray() {
        return studentsArray;
    }
}
