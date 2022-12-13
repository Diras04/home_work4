package com.start.service;

import com.start.models.Homework;

public class HomeworkService {
    public static Homework createHomework() {

        Homework homework1 = new Homework("do some work");
        return homework1;
    }

    public void printHomeWorkArray(Homework[] homeworkArray) {
        for (Homework n : homeworkArray) {

            System.out.println("Id - " + n.getId() + "; Lecture ID - " + n.getLessonId()+ "; Task - "
                    + n.getTask()+ ";");

        }

    }
    

}
