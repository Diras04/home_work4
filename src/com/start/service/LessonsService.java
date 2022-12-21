package com.start.service;

import com.start.models.Homework;
import com.start.models.Lessons;
import com.start.models.SuperObject;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Character.*;


public class LessonsService<E> {
    public boolean chekName(String name) {
        for (int j = 1; j < name.toCharArray().length; j++)
            if (isUpperCase(name.toCharArray()[0]) == false || isLowerCase(name.toCharArray()[j]) == false
                    || isLetter(name.toCharArray()[j]) == false) {
                return false;
            }


        return true;
    }

    public boolean checkPhone(String phone) {
        for (int j = 0; j < phone.toCharArray().length; j++)
            if (isDigit(phone.toCharArray()[j]) == false) {
                return false;
            }

        return true;
    }

    public boolean checkEmail(String email) {
        if (email.contains("@"))
            return true;
        return false;

    }

    public void printLessonsArray(ArrayList<E> lessonsArray) {

        HomeworkService homeworkService = new HomeworkService();
        for (E n : lessonsArray) {


            System.out.println("Id - " + ((Lessons) n).getId() + "; Name - " + ((Lessons) n).getName() + "; CourseId - " + ((Lessons) n).courseId +
                    "; HomeWork - " + (((Lessons) n).getHomeWork()) + "; Dop info - " + ((Lessons) n).getDopInfo() + "; Teacher - " + ((Lessons) n).getPerson());

        }

    }

}
