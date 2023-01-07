package com.start.service;

import java.util.Iterator;

public class SimpleIterator<E> {
    E[] collection;


    public SimpleIterator( E[] collection) {
        this.collection = collection;
    }
   public  final Iterator<E> iterator = new Iterator<E>()
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


}
