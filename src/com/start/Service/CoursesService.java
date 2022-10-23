package com.start.Service;

import com.start.Courses.Courses;
import com.start.Courses.Lessons;
import com.start.Courses.Teachers;
import com.start.Courses.Students;
import com.start.Service.LessonsService;



public class CoursesService {
  public static Courses createCourses() {
        Courses coursesServ = new Courses("Crypto",new Lessons("Discrete mathematics","Graph theory","Good luck"),
                new Students("Bazaleev"),new Teachers("Simonova"));
        return coursesServ;
    }


}
