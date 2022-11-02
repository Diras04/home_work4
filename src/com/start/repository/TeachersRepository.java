package com.start.repository;

import com.start.courses.Teachers;

public class TeachersRepository {
    static int i = 0;


    int size = 1;
    Teachers[] TeachersArray = new Teachers[size];


    public void addTeachersToArray(Teachers courses) {


        if (i < TeachersArray.length) {
            TeachersArray[i] = courses;
        } else {
            addSizeArray();
            TeachersArray[i] = courses;

        }
        i++;


    }


    private void addSizeArray() {
        Teachers[] longTeachersArray = new Teachers[((TeachersArray.length) * 3 / 2) + 1];
        System.arraycopy(TeachersArray, 0, longTeachersArray, 0, TeachersArray.length);
        TeachersArray = longTeachersArray;


    }

    public Teachers[] getTeachersArray() {
        return TeachersArray;
    }
}
