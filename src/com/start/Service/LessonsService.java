package com.start.Service;

import com.start.Courses.Lessons;

public class LessonsService {
    public static Lessons createLessons(String name, String homeWork, String dopInfo){
        Lessons lessonsServ = new Lessons( name, homeWork, dopInfo);

        return lessonsServ;
    }
}
