package com.start.repository;

import com.start.models.SuperObject;

import java.lang.reflect.Array;

public class RepositoryService<E> implements SuperRepository<E> {
    private E[] array;
    int size = 0;
    int length = 1;
    Class<E> eClass1;


    public RepositoryService(Class<E> eClass) {
        this.array = (E[]) Array.newInstance(eClass, length);
        this.eClass1 = eClass;
    }


    public int size() {
        return array.length;
    }

    public boolean isEmpty() {
        return array.length == 0;

    }

    public E get(int index) {
        return array[index];
    }


    public void add(int index, E element) {
        E[] newarray = (E[]) Array.newInstance(eClass1, array.length + 1);
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


    public void addObjectToArray(E e) {


        if (size < array.length) {
            array[size] = e;
        } else {
            addSizeArray();
            array[size] = e;

        }
        size++;


    }


    private void addSizeArray() {
        E[] longArray = (E[]) Array.newInstance(eClass1, (array.length * 3 / 2) + 1);
        System.arraycopy(array, 0, longArray, 0, array.length);
        array = longArray;


    }

    public boolean checkId(int inId) {
        for (int j = 0; j < size; j++) {
            if (((SuperObject) array[j]).getId() == inId) {
                return true;
            }
        }
        return false;
    }


    public E[] getAll() {
        E[] array1 = (E[]) Array.newInstance(eClass1, size);
        System.arraycopy(array, 0, array1, 0, size);
        return array1;
    }


    public void getById(int id) {
        for (E n : getAll()) {

            if (((SuperObject) n).getId() == id) {
                System.out.println(n);
            }


        }
    }


    public E[] deleteById(int id) {
        for (int i = 0; i < size; i++) {
            if (((SuperObject) array[i]).getId() == id) {
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

}