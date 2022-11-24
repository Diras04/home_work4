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


    public void add() {

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

    @Override
    public void getById(int id) {
        super.getById(id);
        for (Lessons n : getAll()) {

            if (n.getId() == id) {
                System.out.println(n);
            }


        }
    }

    @Override
    public Lessons[] deleteById(int id) {
        super.deleteById(id);
        for (int i = 0; i < size; i++) {
            if (lessonsArray[i].getId() == id) {
                for (int j = i; j < size - i; j++) {
                    lessonsArray[j] = lessonsArray[j + 1];
                }
                size--;
                lessonsArray[size] = null;

                break;
            }
        }


        return getAll();
    }


}
