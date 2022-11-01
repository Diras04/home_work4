package com.start.service;

import com.start.courses.Courses;
import com.start.courses.Lessons;
import com.start.courses.Teachers;
import com.start.courses.Students;


public class CoursesService {
  public static Courses createCourses() {
        Courses coursesServ = new Courses("Crypto",new Lessons("Discrete mathematics","Graph theory","Good luck"),
                new Students("Bazaleev"),new Teachers("Simonova"));
        return coursesServ;
    }


}
