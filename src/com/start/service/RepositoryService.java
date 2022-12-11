package com.start.service;

import com.start.models.SuperObject;
import com.start.repository.SuperRepository;

public class RepositoryService<E> extends SuperObject implements SuperRepository {

    static int size = 0;


    int length = 1;
    E[] array = (E[]) new Object[length];


    public void addToArray(E object) {


        if (size < array.length) {
            array[size] = object;
        } else {
            addSizeArray();
            array[size] = object;

        }
        size++;


    }


    private void addSizeArray() {
        E[] longArray = (E[]) new Object[((array.length) * 3 / 2) + 1];
        System.arraycopy(array, 0, longArray, 0, array.length);
        array = longArray;


    }

    public boolean checkId(int inId) {
        for (int j = 0; j < size; j++) {

            if (array[j] instanceof SuperObject && ((SuperObject) array[j]).getId() == inId) {
                return true;
            }
        }
        return false;
    }

    public E[] getAll() {
        E[] array1 = (E[]) new Object[size];
        System.arraycopy(array, 0, array1, 0, size);
        return array1;
    }


    @Override
    public void getById(int id) {
        for (E n : getAll()) {

            if (n instanceof SuperObject && ((SuperObject) n).getId() == id) {
                System.out.println(n);
            }


        }
    }

    @Override
    public E[] deleteById(int id) {
        for (int i = 0; i < size; i++) {
            if (array[i] instanceof SuperObject && ((SuperObject) array[i]).getId() == id) {
                for (int j = i; j < size - i; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                array[size] = null;

                break;
            }
        }


        return getAll();
    }


    public int size() {
        int size = array.length;
        return size;
    }

    public boolean isEmpty() {
        if (array.length == 0) {
            return true;
        } else return false;
    }

    public E get(int index) {
        return array[index];
    }

    public void add(E element) {
        E[] newarray = (E[]) new Object[array.length + 1];
        newarray = array;
        newarray[array.length + 1] = element;
        array = newarray;

    }

    public void add(int index, E element) {
        E[] newarray = (E[]) new Object[array.length + 1];
        for (int i = 0; i < index; i++) {
            newarray[i] = array[i];
        }
        newarray[index] = element;
        for (int j = index; j < array.length; j++) {
            newarray[j + 1] = array[j];
        }
        array = newarray;

    }

    public void remove(int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

    }
}

