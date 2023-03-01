package com.start.repository;

import com.start.models.LogEnum;

import java.time.LocalDateTime;
import java.util.*;

public class RepositoryServiceMapa<E> {
    private Map<Integer, E> map;
    Class<E> eClass1;

    public RepositoryServiceMapa(Class<E> eClass1) {
        this.map = new HashMap<>();
        this.eClass1 = eClass1;
    }

    public void add(Integer k, E value) {
        LogRepository.getInstance().createLog("RepositoryServiceMapa", LogEnum.INFO,
                "add", LocalDateTime.now());
        map.put(k, value);
    }

    public E get(Integer k) {
        LogRepository.getInstance().createLog("RepositoryServiceMapa", LogEnum.INFO,
                "get", LocalDateTime.now());
        return map.get(k);

    }

    public Map<Integer, E> getAll() {
        LogRepository.getInstance().createLog("RepositoryServiceMapa", LogEnum.INFO,
                "getAll", LocalDateTime.now());
        return map;
    }

    public E getById(Integer i) {
        LogRepository.getInstance().createLog("RepositoryServiceMapa", LogEnum.INFO,
                "getById", LocalDateTime.now());
        return map.get(i);
    }

    public E deleteById(Integer i) {
        LogRepository.getInstance().createLog("RepositoryServiceMapa", LogEnum.INFO,
                "deleteById", LocalDateTime.now());
        return map.remove(i);
    }
}
