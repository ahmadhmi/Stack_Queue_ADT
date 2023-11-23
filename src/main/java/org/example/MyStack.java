package org.example;

import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {

    private MyArrayList<E> arrayList;

    public int getPointer() {
        return pointer;
    }

    private int pointer;

    public MyStack()
    {
        this.arrayList = new MyArrayList<>();
        this.pointer = -1;
    }
    @Override
    public void push(E toAdd) throws NullPointerException {

        arrayList.add(toAdd);
        this.pointer++;

    }

    @Override
    public E pop() throws EmptyStackException {
        E temp = arrayList.get(pointer--);
        arrayList.remove(arrayList.size() - 1);
        return temp;
    }

    @Override
    public E peek() throws EmptyStackException {
        return arrayList.get(pointer);
    }

    @Override
    public void clear() {
        this.arrayList.clear();
        this.pointer = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.pointer <= 0;
    }

    @Override
    public E[] toArray() {
        return arrayList.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return arrayList.toArray(holder);
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return arrayList.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        int index = arrayList.indexOf(toFind);
        if (index < 0)
            return -1;
        return pointer - index + 1;
    }

    @Override
    public Iterator iterator() {
        return new MyStackIterator(this);
    }

    @Override
    public boolean equals(StackADT that) {

        boolean sameSize = this.size() == that.size();
        if (!sameSize)
            return sameSize;
        boolean sameItems = true;
        for(int i = pointer; i > this.size(); i--)
        {
            if (this.search(arrayList.get(i)) != that.search(arrayList.get(i)))
            {
                return false;
            }
        }
        return  sameItems && sameSize;
    }

    @Override
    public int size() {
        return arrayList.size();
    }
}
