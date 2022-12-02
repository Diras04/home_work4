package com.start.repository;

import com.start.courses.Person;

public class StudentsRepository {
    static int size = 0;


    int length = 1;
    Person[] studentsArray = new Person[length];


    public void addStudentsToArray(Person students) {


        if (size < studentsArray.length) {
            studentsArray[size] = students;
        } else {
            addSizeArray();
            studentsArray[size] = students;

        }
        size++;


    }


    private void addSizeArray() {
        Person[] longStudentsArray = new Person[((studentsArray.length) * 3 / 2) + 1];
        System.arraycopy(studentsArray, 0, longStudentsArray, 0, studentsArray.length);
        studentsArray = longStudentsArray;


    }

    public Person[] getStudentsArray() {
        Person[] students1 = new Person[size];
        System.arraycopy(studentsArray, 0, students1, 0, size);
        return students1;
    }
}
