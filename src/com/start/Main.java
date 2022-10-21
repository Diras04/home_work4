package com.start;

import com.start.Courses.Lessons;
import com.start.Service.LessonsService;

public class Main {
    public static void main(String[] args) {

        LessonsService lessonsService = new LessonsService();
        lessonsService.createLessons();
        lessonsService.createLessons();
        lessonsService.createLessons();
        lessonsService.createLessons();

        lessonsService.createLessons();


        Lessons.countOfClass();
    }
}