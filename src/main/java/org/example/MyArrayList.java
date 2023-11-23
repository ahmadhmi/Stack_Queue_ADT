package org.example;
public class MyArrayList<E> implements ListADT<E>{

    private int size;
    private E[] data;
    private int max;

    public MyArrayList(int size)
    {
        this.max = size;
        this.size = 0;
        data = (E[]) new Object[size];
    }

    public MyArrayList()
    {
        this.max = 100;
        data = (E[]) new Object[max];
    }

    private void expand()
    {
        // doubling the size and creating a new array
        this.max *= 2;
        E[] newData = (E[]) new Object[this.max];

        // copying elements over
        for (int i = 0; i < this.data.length; i++)
        {
            newData[i] = data[i];
        }

        //replacing data with new data
        this.data = newData;

    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {

        if (size >= max)
        {
            expand();
        }

        if (index >= max)
        {
            throw new IndexOutOfBoundsException("Index greater than maximum size of the array");
        }

        if (index <= size)
        {
            //move data[index + 1...size] one space to the right
            E temp;
            for(int i = size - 1; i >= index; i--)
            {
                data[i + 1] = data[i];
            }
        }

        data[index] = (E) toAdd;
        size++;

        return true;
    }

    @Override
    public boolean add(Object toAdd) throws NullPointerException {
        if (size >= max)
        {
            expand();
        }

        data[size] = (E) toAdd;
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {

        while ((size + toAdd.size()) >= max)
        {
            expand();
        }

        int count = 0;
        for(int i = size; i < size + toAdd.size(); i++, count++)
        {
            data[i] = toAdd.get(count);
        }
        size += toAdd.size();
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= size)
        {
            throw new IndexOutOfBoundsException("Index greater than maximum size of the array");
        }
        return data[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= max)
            throw  new IndexOutOfBoundsException("Index greater than maximum size of the array");

        E remove = data[index];

        for(int i = index; i < size; i++)
            data[i] = data[i+1];
        size--;
        return remove;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {

        int index = indexOf(toRemove);
        return remove(index);

    }

    public int indexOf(E target)
    {
        int indexof = -1;
        for (int i = 0; i < size; i++)
            if (data[i].equals(target)){
                indexof = i;
                break;
            }
        return indexof;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {

        if (index < 0 || index >= max)
            throw  new IndexOutOfBoundsException("Index greater than maximum size of the array");

        E occupant = data[index];
        data[index] = toChange;
        return occupant;

    }

    @Override
    public boolean isEmpty() {
        if (size < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        for( int i = 0;i < size; i++)
            if(data[i].equals(toFind))
            {
                return true;
            }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        E[] used;
        if (toHold.length <= size)
            used = (E[]) new Object[size];
        else
            used = toHold;

        for(int i = 0; i < size; i++)
        {
            used[i] = data[i];
        }

        return used;
    }

    @Override
    public E[] toArray() {
        E[] arr = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = data[i];
        }

        return arr;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>(this);
    }

}
