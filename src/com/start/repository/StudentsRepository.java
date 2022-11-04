package com.start.repository;

import com.start.courses.Students;

public class StudentsRepository {
    static int size = 0;


    int length = 1;
    Students[] studentsArray = new Students[length];


    public void addStudentsToArray(Students students) {


        if (size < studentsArray.length) {
            studentsArray[size] = students;
        } else {
            addSizeArray();
            studentsArray[size] = students;

        }
        size++;


    }


    private void addSizeArray() {
        Students[] longStudentsArray = new Students[((studentsArray.length) * 3 / 2) + 1];
        System.arraycopy(studentsArray, 0, longStudentsArray, 0, studentsArray.length);
        studentsArray = longStudentsArray;


    }

    public Students[] getStudentsArray() {
        Students[] students1 = new Students[size];
        System.arraycopy(studentsArray, 0, students1, 0, size);
        return students1;
    }
}
