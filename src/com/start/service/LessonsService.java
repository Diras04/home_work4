package com.start.service;

import com.start.models.Homework;
import com.start.models.Lessons;

import java.util.Arrays;

import static java.lang.Character.*;


public class LessonsService {
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

    public void printLessonsArray(Lessons[] lessonsArray) {

        HomeworkService homeworkService = new HomeworkService();
        for (Lessons n : lessonsArray) {


            System.out.println("Id - " + n.getId() + "; Name - " + n.getName() + "; CourseId - " + n.courseId +
                    "; HomeWork - " + Arrays.deepToString(n.getHomeWork()) + "; Dop info - " + n.getDopInfo() + "; Teacher - " + n.getPerson());

        }

    }

}
