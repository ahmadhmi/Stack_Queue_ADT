package org.example;

public class MyQueue implements QueueADT{
    @Override
    public void enqueue(Object toAdd) throws NullPointerException {

    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        return null;
    }

    @Override
    public Object peek() throws EmptyQueueException {
        return null;
    }

    @Override
    public void dequeueAll() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean equals(QueueADT that) {
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
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
