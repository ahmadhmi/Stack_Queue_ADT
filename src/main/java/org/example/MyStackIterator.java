package org.example;

import java.util.NoSuchElementException;

public class MyStackIterator<E> implements Iterator<E>{

    private MyStack<E> stack;

    private int pointer;

    public MyStackIterator(MyStack<E> stack)
    {
        this.stack = stack;
        this.pointer = stack.getPointer();
    }

    @Override
    public boolean hasNext() {
        return this.stack.isEmpty();
    }

    @Override
    public E next() throws NoSuchElementException {
        return stack.pop();
    }
}
