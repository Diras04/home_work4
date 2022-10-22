package com.start.Service;

import com.start.Courses.Courses;

public class CoursesService {
    public static Courses createCourses() {
        Courses coursesServ = new Courses("first", "Mathematic", "Petrov", "Ivanov");
        return coursesServ;
    }


}
