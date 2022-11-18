package com.start.repository;

import com.start.courses.SuperObject;

import java.util.Arrays;

public class SuperRepository {

    public SuperObject[] getAll() {
        SuperObject[] superObjects = new SuperObject[0];
        return superObjects;
    }

    public void add(SuperObject superObject) {

    }

    public void getById(SuperObject[] superObjects, int id) {
        for (SuperObject n : superObjects) {

            if (n.getId() == id) {
                System.out.println(n);
            }


        }
    }

    public SuperObject[] deleteById(SuperObject[] superObjects, int id) {
        SuperObject[] superObjectNew = new SuperObject[superObjects.length - 1];
        int i = 0;
        for (SuperObject n : superObjects) {

            if (n.getId() != id) {
                superObjectNew[i] = n;

            }
            i++;


        }
        return superObjectNew;
    }
}
