package com.start.service;

import com.start.courses.Lessons;


public class LessonsService {
    public void printLessonsArray(Lessons[] lessonsArray) {
        for (Lessons n : lessonsArray) {


            System.out.println("Id - " + n.getId() + "; Name - " + n.getName() + "; CourseId - " + n.courseId +
                    "; HomeWork - " + n.getHomeWork() + "; Dop info - " + n.getDopInfo() + "; Teacher - " +  n.getPerson());

        }

    }

}
