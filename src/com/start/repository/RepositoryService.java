package com.start.repository;

import com.start.models.LogEnum;
import com.start.models.SuperObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
        LogRepository.getInstance().createLog("RepositoryService", LogEnum.INFO,
                "size", LocalDateTime.now());
        return array.size();
    }

    public boolean isEmpty() {
        LogRepository.getInstance().createLog("RepositoryService", LogEnum.INFO,
                "isEmpty", LocalDateTime.now());
        return array.isEmpty();

    }

    public E get(int index) {
        LogRepository.getInstance().createLog("RepositoryService", LogEnum.INFO,
                "get", LocalDateTime.now());
        return  array.get(index);
    }


    public void add(int index, E element) {
        LogRepository.getInstance().createLog("RepositoryService", LogEnum.INFO,
                "add", LocalDateTime.now());
        array.add(index, element);

    }

    public void remove(int index) {
        LogRepository.getInstance().createLog("RepositoryService", LogEnum.INFO,
                "remove", LocalDateTime.now());
        array.remove(index);
    }


    public void addObjectToArray(E e) {
        LogRepository.getInstance().createLog("RepositoryService", LogEnum.INFO,
                "addObjectToArray", LocalDateTime.now());

        array.add(e);

    }


    public boolean checkId(int inId) {
        for (E n : array) {
            if (((SuperObject) n).getId() == inId)
                return true;
        }
        var value = Thread.currentThread().getStackTrace();
        LogRepository.getInstance().createLogWarErr("RepositoryService", LogEnum.WARNING, "checkId",
                LocalDateTime.now(), Arrays.deepToString(value));
        return false;
    }


    public List<E> getAll() {
        LogRepository.getInstance().createLog("RepositoryService", LogEnum.INFO,
                "getAll", LocalDateTime.now());

        return array;
    }


    public void getById(int id) {
        LogRepository.getInstance().createLog("RepositoryService", LogEnum.INFO,
                "getById", LocalDateTime.now());
        for (E n : getAll()) {

            if (((SuperObject) n).getId() == id) {
                System.out.println(n);
            }


        }
    }


    public List deleteById(int id) {
        LogRepository.getInstance().createLog("RepositoryService", LogEnum.INFO,
                "deleteById", LocalDateTime.now());
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