package com.start.repository;

import java.util.ArrayList;
import java.util.Iterator;

public interface  SuperRepository<E>  {

    public int size();

    public boolean isEmpty();

    public  E get(int index);


    public  void add(int index, E element);

    public  void remove(int index);

    public  void addObjectToArray(E e);


      public  boolean checkId(int inId);


    public ArrayList getAll() ;


    public  void getById(int id) ;


    public  ArrayList deleteById(int id);

    public Iterator findAll();
}
