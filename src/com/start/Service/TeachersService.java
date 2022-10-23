package com.start.Service;

import com.start.Courses.Students;
import com.start.Courses.Teachers;

import java.util.ArrayList;

public class TeachersService {
    ArrayList<Teachers> teachersarray;

    public TeachersService(ArrayList<Teachers> inteachersarray) {
        this.teachersarray = inteachersarray;

    }
    public static Teachers createTeachers(){
        Teachers teachersServ = new Teachers("Belozerov");
        return teachersServ;
    }

    public boolean removeTeachers(int id) {
        for (Teachers e : teachersarray)
            if (e.getId() == id) {
                teachersarray.remove(e);
                if (teachersarray.indexOf(e) == -1) {
                    return true;

                }
            }
        return false;


    }

    public boolean removeTeachers(String name) {
        for (Teachers e : teachersarray)
            if (e.getName() == name) {
                teachersarray.remove(e);
                if (teachersarray.indexOf(e) == -1) {
                    return true;

                }
            }
        return false;

    }

    public boolean addTeachers(Teachers inTeacher) {
        this.teachersarray.add(inTeacher);
        if (teachersarray.indexOf(inTeacher) == -1) {
            return false;
        }
        return true;
    }


    public ArrayList<Teachers> getArray() {
        return this.teachersarray;

    }

    public Teachers getByName(String name) {
        for (Teachers e : teachersarray) {
            if (e.getName() == name)
                return e;
        }
        return null;
    }

    public Teachers getByid(int id) {
        for (Teachers e : teachersarray)
            if (e.getId() == id)
                return e;
        return null;
    }


    @Override
    public String toString() {
        return "TeachersService{" +
                "teachersarray=" + teachersarray +
                '}';
    }
}
