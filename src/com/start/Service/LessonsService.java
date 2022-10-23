package com.start.Service;

import com.start.Courses.Lessons;

import java.util.ArrayList;

public class LessonsService {
    ArrayList<Lessons> lessonsarray;

    public LessonsService( ArrayList<Lessons> inlessonssarray) {
        this.lessonsarray = inlessonssarray;

    }

    public boolean removeLessons(int id) {
        for (Lessons e : lessonsarray)
            if (e.getId() == id) {
                lessonsarray.remove(e);
                if (lessonsarray.indexOf(e) == -1) {
                    return true;

                }
            }
        return false;


    }

    public boolean removeLessons(String name) {
        for (Lessons e : lessonsarray)
            if (e.getName() == name) {
                lessonsarray.remove(e);
                if (lessonsarray.indexOf(e) == -1) {
                    return true;

                }
            }
        return false;

    }

    public boolean addLessons(Lessons inlessons) {
        this.lessonsarray.add(inlessons);
        if (lessonsarray.indexOf(inlessons) == -1) {
            return false;
        }
        return true;
    }


    public ArrayList<Lessons> getArray() {
        return this.lessonsarray;

    }

    public Lessons getByName(String name) {
        for (Lessons e : lessonsarray) {
            if (e.getName() == name)
                return e;
        }
        return null;
    }
    public Lessons getByhomeWork(String homeWork) {
        for (Lessons e : lessonsarray) {
            if (e.getHomeWork() == homeWork)
                return e;
        }
        return null;
    }
    public Lessons getBydopInfo(String dopInfo) {
        for (Lessons e : lessonsarray) {
            if (e.getDopInfo() == dopInfo)
                return e;
        }
        return null;
    }

    public Lessons getByid(int id) {
        for (Lessons e : lessonsarray)
            if (e.getId() == id)
                return e;
        return null;
    }

    @Override
    public String toString() {
        return "LessonsService{" +
                "lessonsarray=" + lessonsarray +
                '}';
    }
}
