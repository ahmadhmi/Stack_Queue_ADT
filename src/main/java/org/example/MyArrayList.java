package org.example;
public class MyArrayList <E> implements ListADT {

    private int size;
    private E[] data;
    private int pointer;
    private int max;

    public MyArrayList(int size)
    {
        this.max = size;
        data = (E[]) new Object[size];
    }

    public MyArrayList()
    {
        this.max = 100;
        data = (E[]) new Object[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        return false;
    }

    @Override
    public boolean add(Object toAdd) throws NullPointerException {
        return false;
    }

    @Override
    public boolean addAll(ListADT toAdd) throws NullPointerException {
        return false;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object remove(Object toRemove) throws NullPointerException {
        return null;
    }

    @Override
    public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object toFind) throws NullPointerException {
        return false;
    }

    @Override
    public Object[] toArray(Object[] toHold) throws NullPointerException {
        return new Object[0];
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
