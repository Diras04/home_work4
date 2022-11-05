package com.start.service;

import com.start.courses.Students;


public class StudentsService {

    public static Students createStudents() {
        Students studentsServ = new Students("Derkach");
        return studentsServ;
    }

    public void printStudentsArray(Students[] StudentsArray) {
        for (Students n : StudentsArray) {

            System.out.println("Id - " + n.getId() + "; Name - " + n.getName());


        }

    }


}
