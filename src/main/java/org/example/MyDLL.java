package org.example;


import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;
    public MyDLL(){
        this.head = this.tail = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null)
            throw new NullPointerException("The given value is null");

        if (index < 0 || index > size )
            throw new IndexOutOfBoundsException("Index is not in the correct range");

        else {

            if (index == 0)
                addFirst(toAdd);

            else if (index == size)
                add(toAdd);

            else {

                MyDLLNode<E> newNode = new MyDLLNode<>();
                newNode.value = toAdd;

                MyDLLNode<E> current = head;

                for (int i = 0; i < index - 1 ; i++){
                    current = current.next;
                }

                MyDLLNode<E> temp = current.next;
                current.next = newNode;
                newNode.next = temp;
                newNode.previous = current;
                temp.previous = newNode;
                size++;
            }
            return true;
        }
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null)
            throw new NullPointerException("The given value is null");

        MyDLLNode<E> node = new MyDLLNode<>();
        node.value = toAdd;

        if (head == null){
            head = tail = node;
        }

        else {
            MyDLLNode<E> temp;
            temp = tail;
            temp.next = node;
            tail = node;
            tail.previous = temp;
        }
        size++;
        return true;
    }
    private boolean addFirst(E toAdd){
        MyDLLNode<E> node = new MyDLLNode<>();
        node.value = toAdd;

        if (head == null){
            head = tail = node;
        }
        else {
            MyDLLNode<E> temp;
            temp = head;
            head = node;
            node.next = temp;
            temp.previous = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null)
            throw new NullPointerException("The given value is null");

        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }

        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("The given Index is not in the correct Range");

        MyDLLNode<E> node = head;

        for (int i = 0; i < index; i++)
            node = node.next;

        return node.value;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("The given Index is not in the correct Range");

        MyDLLNode<E> node = new MyDLLNode<>();

        if (index == 0){
            if (size == 1){
                node.value = head.value;
                head = tail = null;
            }
            else{
                node.value = head.value;
                head = head.next;
                head.previous = null;
            }
        }
        else if (index == size - 1){
            node.value = tail.value;
            tail = tail.previous;
            tail.next = null;
        }
        else {
            MyDLLNode<E> current = head;

            for (int i = 0; i < index - 1 ; i++){
                current = current.next;
            }
            node.value = current.next.value;
            MyDLLNode<E> temp = current.next.next;
            current.next = temp;
            temp.previous = current;
        }
        size--;
        return node.value;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null)
            throw new NullPointerException("The given value is null");

        MyDLLNode<E> node = head;

        int index = -1;

        for (int i = 0; i < size; i++){
            if (node.value == toRemove){
                index = i;
                break;
            }
            node = node.next;
        }

        if (index == -1)
            return null;

        remove(index);
        return node.value;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null)
            throw new NullPointerException("The given value is null");

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("The given Index is not in the correct Range");

        MyDLLNode<E> node = head;

        for (int i = 0; i < index; i++){

            node = node.next;
        }

        node.value = toChange;
        return get(index);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null)
            throw new NullPointerException("The given value is null");

        MyDLLNode<E> node = head;

        while (node != null){

            if (node.value == toFind)
                return true;

            node = node.next;
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {

        if (toHold == null)
            throw new NullPointerException();

        if (toHold.length < size)
            toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);

        MyDLLNode<E> node = head;
        for (int i = 0; i < size; i++){
            toHold[i] = node.value;
            node = node.next;
        }

        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] dll = new Object[size];

        MyDLLNode<E> node = head;
        for (int i = 0; i < size; i++){
            dll[i] = node.value;
            node = node.next;
        }
        return dll;
    }

    @Override
    public Iterator<E> iterator() {
        return new DllIterator(this);
    }
    private class DllIterator implements Iterator<E> {
        private MyDLLNode<E> node;

        public DllIterator(MyDLL<E> dll) {
            this.node = dll.head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = node.value;
            node = node.next;
            return value;
        }
    }
}
