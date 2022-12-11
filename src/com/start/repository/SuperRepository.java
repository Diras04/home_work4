package com.start.repository;

import com.start.models.SuperObject;

public interface SuperRepository<E> {


    public E[] getAll();


    public void getById(int id);

    public  E[] deleteById( int id);
}
