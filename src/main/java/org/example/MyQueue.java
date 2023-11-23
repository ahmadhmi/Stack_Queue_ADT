package org.example;

public class MyQueue<E> implements QueueADT<E>{
    MyDLL<E> dll = new MyDLL<>();

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null)
            throw new NullPointerException("The given value is null");
        dll.add(toAdd);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (dll.isEmpty())
            throw new EmptyQueueException("dequeue cannot be performed as queue is empty");

        return dll.remove(0);
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (dll.isEmpty())
            throw new EmptyQueueException("peek cannot be performed as queue is empty");

        return dll.get(0);
    }

    @Override
    public void dequeueAll() {
        dll.clear();
    }

    @Override
    public boolean isEmpty() {
        return dll.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return dll.iterator();
    }

    @Override
    public boolean equals(QueueADT<E> that) {
        if (that.size() != size())
            return false;

        Iterator<? extends E> thatIterator = that.iterator();
        Iterator<? extends E> thisIterator = iterator();

        while (thatIterator.hasNext()) {
            if (thisIterator.next() != thatIterator.next())
                return false;
        }

        return true;
    }

    @Override
    public Object[] toArray() {
        return dll.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return dll.toArray(holder);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return dll.size();
    }
}
