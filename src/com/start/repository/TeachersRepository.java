package com.start.repository;


import com.start.courses.Teachers;

public class TeachersRepository {
    static int size = 0;


    int lenght = 1;
    Teachers[] TeachersArray = new Teachers[lenght];


    public void addTeachersToArray(Teachers courses) {


        if (size < TeachersArray.length) {
            TeachersArray[size] = courses;
        } else {
            addSizeArray();
            TeachersArray[size] = courses;

        }
        size++;


    }


    private void addSizeArray() {
        Teachers[] longTeachersArray = new Teachers[((TeachersArray.length) * 3 / 2) + 1];
        System.arraycopy(TeachersArray, 0, longTeachersArray, 0, TeachersArray.length);
        TeachersArray = longTeachersArray;


    }

    public Teachers[] getTeachersArray() {
        Teachers[] teachersArray1 = new Teachers[size];
        System.arraycopy(TeachersArray, 0, teachersArray1, 0, size);
        return teachersArray1;
    }
}
