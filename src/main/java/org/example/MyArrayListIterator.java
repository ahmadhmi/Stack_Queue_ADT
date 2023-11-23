package org.example;

import java.util.NoSuchElementException;

public class MyArrayListIterator<E> implements Iterator<E>{


    private MyArrayList<E> list;
    private int pointer;
    private int size;

    public MyArrayListIterator(MyArrayList<E> list)
    {
        this.list = list;
        pointer = 0;
        this.size = list.size();
    }

    @Override
    public boolean hasNext() {
        return pointer <= size - 1;
    }

    @Override
    public E next() throws NoSuchElementException {
        E temp = list.get(pointer);
        pointer++;
        return temp;
    }

}
