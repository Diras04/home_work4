package com.start.repository;

import com.start.models.SuperObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepositoryService<E> implements SuperRepository<E> {

    private List<E> array;

    Class<E> eClass1;


    public RepositoryService(Class<E> eClass) {
        this.array = new ArrayList<>();
        this.eClass1 = eClass;
    }


    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.isEmpty();

    }

    public E get(int index) {
        return (E) array.get(index);
    }


    public void add(int index, E element) {
        array.add(index, element);

    }

    public void remove(int index) {
        array.remove(index);
    }


    public void addObjectToArray(E e) {
        array.add(e);

    }


    public boolean checkId(int inId) {
        for (E n : array) {
            if (((SuperObject) n).getId() == inId)
                return true;
        }

        return false;
    }


    public List<E> getAll() {

        return array;
    }


    public void getById(int id) {
        for (E n : getAll()) {

            if (((SuperObject) n).getId() == id) {
                System.out.println(n);
            }


        }
    }


    public List deleteById(int id) {
        int i = 0;
        for (E n : array) {
            if (((SuperObject) n).getId() == id) {
                array.remove(i);
            }
            i++;
        }
        return array;
    }

    public Iterator<E> findAll() {
        Iterator iterator = array.iterator();

        return iterator;
    }

}