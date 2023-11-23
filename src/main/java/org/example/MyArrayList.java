package org.example;
public class MyArrayList <E> implements ListADT {

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
    public boolean addAll(ListADT toAdd) throws NullPointerException {

        while ((size + toAdd.size()) >= max)
        {
            expand();
        }

        int count = 0;
        for(int i = size; i < size + toAdd.size(); i++, count++)
        {
            data[i] = (E) toAdd.get(count);
        }
        size += toAdd.size();
        return true;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index >= size)
        {
            throw new IndexOutOfBoundsException("Index greater than maximum size of the array");
        }
        return data[index];
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= max)
            throw  new IndexOutOfBoundsException("Index greater than maximum size of the array");

        for(int i = index; i < size; i++)
            data[i] = data[i+1];
        size--;
        return true;
    }

    @Override
    public Object remove(Object toRemove) throws NullPointerException {

        int indexof = indexOf(toRemove);
        remove(indexof);
        return true;

    }

    public int indexOf(Object target)
    {
        int indexof = 0;
        for (int i = 0; i < size; i++)
            if (data[i].equals(target)){
                indexof = i;
                break;
            }
        return indexof;
    }

    @Override
    public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {

        if (index < 0 || index >= max)
            throw  new IndexOutOfBoundsException("Index greater than maximum size of the array");

        for( int i = 0; i < size ; i++)
            if (i == index)
            {
                data[i] = (E) toChange;
                break;
            }
        return true;

    }

    @Override
    public boolean isEmpty() {
        if (size < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(Object toFind) throws NullPointerException {
        for( int i = 0;i < size; i++)
            if(data[i] == toFind)
            {
                return true;
            }
        return false;
    }

    @Override
    public Object[] toArray(Object[] toHold) throws NullPointerException {
        return new Object[0];
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for(int i = 0; i < size; i++)
        {
            arr[i] = data[i];
        }

        return arr;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
