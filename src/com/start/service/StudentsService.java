package com.start.service;


import com.start.courses.Person;
import com.start.courses.Role;

public class StudentsService {

    public static Person createStudents() {
        Role role = Role.STUDENT;
        Person studentsServ = new Person("Derkach", role);
        return studentsServ;
    }

    public void printStudentsArray(Person[] StudentsArray) {
        for (Person n : StudentsArray) {

            System.out.println("Id - " + n.getId() + "; Name - " + n.getName()+ "; Role - " + n.getRole());


        }

    }


}
