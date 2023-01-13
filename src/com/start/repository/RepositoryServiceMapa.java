package com.start.repository;

import java.util.*;

public class RepositoryServiceMapa<E> {
    private Map<Integer, E> map;
    Class<E> eClass1;

    public RepositoryServiceMapa(Class<E> eClass1) {
        this.map = new HashMap<>();
        this.eClass1 = eClass1;
    }

    public void add(Integer k, E value) {
        map.put(k, value);
    }

    public E get(Integer k) {
        return map.get(k);

    }

    public Map<Integer, E> getAll() {
        return map;
    }

    public E getById(Integer i) {
        return map.get(i);
    }

    public E deleteById(Integer i) {
        return map.remove(i);
    }
}
