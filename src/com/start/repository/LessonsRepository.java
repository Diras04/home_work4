package com.start.repository;

import com.start.courses.Lessons;

public class LessonsRepository {
    static int i = 0;


    int size = 1;
    Lessons[] lessonsArray = new Lessons[size];


    public void addLessonsToArray(Lessons lessons) {


        if (i < lessonsArray.length) {
            lessonsArray[i] = lessons;
        } else {
            addSizeArray();
            lessonsArray[i] = lessons;

        }
        i++;


    }


    private void addSizeArray() {
        Lessons[] longLessonsArray = new Lessons[((lessonsArray.length) * 3 / 2) + 1];
        System.arraycopy(lessonsArray, 0, longLessonsArray, 0, lessonsArray.length);
        lessonsArray = longLessonsArray;


    }

    public Lessons[] getLessonsArray() {
        return lessonsArray;
    }
}
