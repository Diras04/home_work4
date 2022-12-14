package com.start.service;

import com.start.models.*;
import com.start.repository.*;

import java.util.Arrays;

import static java.awt.SystemColor.menu;


public class CoursesService {





    public void printCoursesArray(Courses[] coursesArray) {

        for (Courses n : coursesArray
        ) {
            System.out.println("ID - " + n.getId() + "; Name - "
                    + n.getName() + "; Lessons name - " + n.getLessonsinfo().getName() + "; Lesson Id - " + n.getLessonsinfo().getId() + "; Students - " +
                    n.getStudentinfo());

        }

    }


}
