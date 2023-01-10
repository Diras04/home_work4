package com.start.service;

import com.start.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CoursesService<E> {

    public static Courses createCoursre(Lessons lessons, Person student, String name){
        return new Courses(name,lessons,student);
    }




    public void printCoursesArray(List<Courses> coursesArray) {
        Collections.sort(coursesArray,Courses.coursesComparator);

        for (Courses n : coursesArray
        ) {
            System.out.println("ID - " + n.getId() + "; Name - "
                    + n.getName() + "; Lessons name - " + (n.getLessonsinfo()).getName() +
                    "; Lesson Id - " + (n.getLessonsinfo().getId() + "; Students - " +
                    n.getStudentinfo()));

        }

    }


}
