package com.start.service;

import com.start.models.Homework;
import com.start.models.SuperObject;

public class HomeworkService {
    public static Homework createHomework() {

        SuperObject homework1 = new Homework("do some work");
        return (Homework) homework1;
    }

    public static void printHomeWorkArray(Homework[] homeworkArray) {
        for (Homework n : homeworkArray) {

            System.out.println("Id - " + n.getId() + "; Lecture ID - " + n.getLessonId()+ "; Task - "
                    + n.getTask()+ ";");

        }

    }
    

}
