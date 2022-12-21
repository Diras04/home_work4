package com.start.service;


import com.start.models.Lessons;
import com.start.models.Person;
import com.start.models.Role;
import com.start.models.SuperObject;

import java.util.ArrayList;

public class StudentsService<E> {

    public static Person createStudents() {
        Role role = Role.STUDENT;
        Person studentsServ = new Person("Andriy","Derkach",
                "0977320951","dira_s@gmail.com", role);
        return studentsServ;
    }

    public void printStudentsArray(ArrayList<E> StudentsArray) {
        for (E n : StudentsArray) {

            System.out.println("Id - " + ((Person)n).getId() + "; First Name - " + ((Person)n).getName()+ "; Last Name - "
                    + ((Person)n).getLastname()+ "; Phone - " + ((Person)n).getPhone()+ "; Email - " + ((Person)n).getEmail()+ "; Role - " + ((Person)n).getRole());


        }

    }


}
