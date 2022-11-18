package com.start.repository;

import com.start.courses.Courses;
import com.start.courses.Lessons;
import com.start.courses.SuperObject;

public class LessonsRepository extends SuperRepository {
    public static int size = 0;


    int length = 1;
    Lessons[] lessonsArray = new Lessons[length];



    public void addLessonsToArray(Lessons lessons) {


        if (size < lessonsArray.length) {
            lessonsArray[size] = lessons;
        } else {
            addSizeArray();
            lessonsArray[size] = lessons;

        }
        size++;


    }


    private void addSizeArray() {
        Lessons[] longLessonsArray = new Lessons[((lessonsArray.length) * 3 / 2) + 1];
        System.arraycopy(lessonsArray, 0, longLessonsArray, 0, lessonsArray.length);
        lessonsArray = longLessonsArray;


    }

  /*  public Lessons[] getLessonsArray() {
        Lessons[] lessonsarray1 = new Lessons[size];
        System.arraycopy(lessonsArray, 0, lessonsarray1, 0, size);
        return lessonsarray1;
    }*/

    @Override
    public Lessons[] getAll() {
        Lessons[] lessonsarray1 = new Lessons[size];
        System.arraycopy(lessonsArray, 0, lessonsarray1, 0, size);
        return lessonsarray1;
    }

}
