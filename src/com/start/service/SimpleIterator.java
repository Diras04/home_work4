package com.start.service;

import com.start.repository.RepositoryService;

import java.util.Iterator;

public class SimpleIterator<E> {
    E[] collection;


    public SimpleIterator( E[] collection) {
        this.collection = collection;
    }
   public Iterator<E> iterator = new Iterator<E>()
    {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return collection.length > i;
        }

        @Override
        public E next() {
            return (E) collection[i++];
        }
        @Override
        public void remove() {
           for (int j =i++;j< collection.length-1;j++){
               collection[j] =collection[j+1];
            }
        }
    };

       // iterator.forEachRemaining(System.out::println);
}
