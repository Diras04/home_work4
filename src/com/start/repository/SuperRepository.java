package com.start.repository;

public interface  SuperRepository<E>  {

    public int size();

    public boolean isEmpty();

    public  E get(int index);


    public  void add(int index, E element);

    public  void remove(int index);

    public  void addObjectToArray(E e);


      public  boolean checkId(int inId);


    public E[] getAll() ;


    public  void getById(int id) ;


    public  E[] deleteById(int id);
}
