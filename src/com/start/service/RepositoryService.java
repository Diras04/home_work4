package com.start.service;

import static com.sun.tools.javac.jvm.ByteCodes.newarray;

public class RepositoryService<E> {
    private E[] array;


    public RepositoryService(E[] array) {
        this.array = array;
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
