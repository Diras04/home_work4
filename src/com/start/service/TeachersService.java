package com.start.service;


import com.start.models.Person;
import com.start.models.Role;

public class TeachersService {

    public static Person createTeachers() {

        Person teachersServ = new Person("Genadiy","Bilozerov",
                "5551287","bilozerov@gmail.com",Role.TEACHER);
        return teachersServ;
    }

    public void printTeachersArray(Person[] teachersArray) {
        for (Person n : teachersArray) {

            System.out.println("Id - " + n.getId() + "; First Name - " + n.getName()+ "; Last Name - "
                    + n.getLastname()+ "; Phone - " + n.getPhone()+ "; Email - " + n.getEmail()+ "; Role - " + n.getRole());

        }

    }


}
