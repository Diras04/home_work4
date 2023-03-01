package com.start.serializbl;

import java.io.*;

public class Serializ {
    private static final String fileName = "D:\\java\\Start\\OnlineSchool\\Ser.txt";

    public void serialize(SortCourses courses) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)) {
            out.writeObject(courses);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SortCourses desireilize() {
        SortCourses courses;
        try (FileInputStream inputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            courses = (SortCourses) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
}
