package com.start.service;

import com.start.models.*;
import com.start.repository.*;

import java.util.ArrayList;
import java.util.Arrays;

import static java.awt.SystemColor.menu;


public class CoursesService<E> {





    public void printCoursesArray(ArrayList<E> coursesArray) {

        for (E n : coursesArray
        ) {
            System.out.println("ID - " +((SuperObject)n).getId() + "; Name - "
                    + ((SuperObject)n).getName() + "; Lessons name - " + (((Courses)n).getLessonsinfo()).getName() +
                    "; Lesson Id - " + ((Courses)n).getLessonsinfo().getId() + "; Students - " +
                    ((Courses)n).getStudentinfo());

        }

    }


}
