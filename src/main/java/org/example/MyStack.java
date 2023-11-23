package org.example;

import java.util.EmptyStackException;

public class MyStack implements StackADT {
    @Override
    public void push(Object toAdd) throws NullPointerException {

    }

    @Override
    public Object pop() throws EmptyStackException {
        return null;
    }

    @Override
    public Object peek() throws EmptyStackException {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] holder) throws NullPointerException {
        return new Object[0];
    }

    @Override
    public boolean contains(Object toFind) throws NullPointerException {
        return false;
    }

    @Override
    public int search(Object toFind) {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean equals(StackADT that) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
