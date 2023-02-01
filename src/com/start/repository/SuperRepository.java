package com.start.repository;

import java.util.Iterator;
import java.util.List;

public interface SuperRepository<E> {

    public int size();

    public boolean isEmpty();

    public E get(int index);


    public void add(int index, E element);

    public void remove(int index);

    public void addObjectToArray(E e);


    public boolean checkId(int inId);


    public List getAll();


    public E getById(int id);


    public List deleteById(int id);

    public Iterator<E> findAll();
}
