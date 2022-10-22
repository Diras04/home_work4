package com.start;

import com.start.Courses.Lessons;
import com.start.Courses.Courses;
import com.start.Courses.Students;
import com.start.Courses.Teachers;
import com.start.Service.CoursesService;
import com.start.Service.LessonsService;
//import com.start.Service.CoursesService;

public class Main {
    public static void main(String[] args) {
        System.out.println(CoursesService.createCourses());
        System.out.println(LessonsService.createLessons("Mathematic", "Page23", "Page 24"));
        System.out.println(LessonsService.createLessons("Mathematic", "Page24", "Page 25"));
        System.out.println(LessonsService.createLessons("Mathematic", "Page25", "Page 26"));
        System.out.println(LessonsService.createLessons("Mathematic", "Page26", "Page 27"));
        System.out.println(LessonsService.createLessons("Mathematic", "Page27", "Page 28"));
        System.out.println(LessonsService.createLessons("Mathematic", "Page28", "Page 29"));
    }
}