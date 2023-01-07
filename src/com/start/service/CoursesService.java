package com.start.service;

import com.start.models.*;

import java.util.ArrayList;
import java.util.Collections;


public class CoursesService<E> {

    public static Courses createCoursre(Lessons lessons, Person student, String name){
        return new Courses(name,lessons,student);
    }



    public void printCoursesArray(ArrayList<Courses> coursesArray) {
        Collections.sort(coursesArray,Courses.coursesComparator);

        for (Courses n : coursesArray
        ) {
            System.out.println("ID - " + ((SuperObject) n).getId() + "; Name - "
                    + ((SuperObject) n).getName() + "; Lessons name - " + (((Courses) n).getLessonsinfo()).getName() +
                    "; Lesson Id - " + ((Courses) n).getLessonsinfo().getId() + "; Students - " +
                    ((Courses) n).getStudentinfo());

        }

    }


}
