package com.start.repository;

import com.start.models.Courses;
import com.start.service.RepositoryService;


public class CoursesRepository  extends RepositoryService {
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

    @Override
    public Object[] getAll() {
        Courses[] coursesarray1 = new Courses[size];
        System.arraycopy(coursesArray, 0, coursesarray1, 0, size);
        return coursesarray1;
    }


    @Override
    public void getById(int id) {
        for (Courses n : getAll()) {

            if (n.getId() == id) {
                System.out.println(n);
            }


        }
    }

    @Override
    public Courses[] deleteById(int id) {
        for (int i = 0; i < size; i++) {
            if (coursesArray[i].getId() == id) {
                for (int j = i; j < size - i; j++) {
                    coursesArray[j] = coursesArray[j + 1];
                }
                size--;
                coursesArray[size] = null;

                break;
            }
        }


        return getAll();
    }


}
