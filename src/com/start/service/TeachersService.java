package com.start.service;


import com.start.courses.Teachers;


public class TeachersService {

    public static Teachers createTeachers() {
        Teachers teachersServ = new Teachers("Belozerov");
        return teachersServ;
    }

    public void printTeachersArray(Teachers[] teachersArray) {
        for (Teachers n : teachersArray) {

            System.out.println("Id - " + n.getId() + "; Name - " + n.getName());

        }

    }


}
