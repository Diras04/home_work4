package com.start.service;

import com.start.models.Lessons;

import java.util.List;

import static java.lang.Character.*;


public class LessonsService<E> {
    public boolean checkName(String name) {
        for (int j = 1; j < name.toCharArray().length; j++) {
            if (isUpperCase(name.toCharArray()[0]) == false || isLowerCase(name.toCharArray()[j]) == false
                    || isLetter(name.toCharArray()[j]) == false) {
                return false;
            }
        }
        return true;
    }


    public boolean checkPhone(String phone) {
        for (int j = 0; j < phone.toCharArray().length; j++) {
            if (isDigit(phone.toCharArray()[j]) == false) {
                return false;
            }
        }
        return true;

    }

    public boolean checkEmail(String email) {
        return email.contains("@");


    }

    public void printLessonsArray(List<E> lessonsArray) {

        for (E n : lessonsArray) {


            System.out.println("Id - " + ((Lessons) n).getId() + "; Name - " + ((Lessons) n).getName() +
                    "; CourseId - " + ((Lessons) n).courseId + "; Dop info - " + ((Lessons) n).getDopInfo() + "; Teacher - " + ((Lessons) n).getPerson());

        }

    }

}
