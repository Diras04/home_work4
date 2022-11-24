package com.start.service;


import com.start.courses.Person;
import com.start.courses.Role;

public class TeachersService {

    public static Person createTeachers() {

        Person teachersServ = new Person("Belozerov",Role.TEACHER);
        return teachersServ;
    }

    public void printTeachersArray(Person[] teachersArray) {
        for (Person n : teachersArray) {

            System.out.println("Id - " + n.getId() + "; Name - " + n.getName() + "; Role - " + n.getRole());

        }

    }


}
