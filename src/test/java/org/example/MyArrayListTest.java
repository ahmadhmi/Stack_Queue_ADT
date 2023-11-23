package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    private MyArrayList<Integer> list;

    @Before
    public void setup()
    {
        list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
    }


    @Test
    public void size() {
        assertEquals(6, list.size());
    }

    @Test
    public void clear() {
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void add() {
        list.add(2);
        assertEquals((long) list.get(list.size() - 1), 2);
    }

    @Test
    public void testAdd() {
        list.add(3, 1);
        assertEquals((long) list.get(3), 1);
    }

    @Test
    public void addAll() {

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(7);
        list2.add(8);
        list2.add(9);

        list.addAll(list2);

        for(int i = 0; i < list.size(); i++)
        {
            assertEquals((long) list.get(i), i + 1);
        }
    }

    @Test
    public void get() {
        assertEquals((long) list.get(1), 2);
    }

    @Test
    public void remove() {
        list.remove(1);
        assertEquals((long) list.get(1), 3);
        assertEquals(list.size(), 5);
    }

    @Test
    public void testRemove() {
        list.remove((Integer) 1);
        assertEquals((long) list.get(0), 2);
        assertEquals(list.size(), 5);
    }

    @Test
    public void set() {
        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);


        list.addAll(list2);

        list.set(3, 100);
        assertEquals((long) list.get(3), 100);
    }

    @Test
    public void isEmpty() {
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void contains() {

        assertTrue(list.contains(2));

    }

    @Test
    public void toArray() {
        Object[] arr = list.toArray();
        assertEquals(arr.length, list.size());
        for(int i = 0; i < arr.length; i++)
        {
            assertEquals(list.get(i), arr[i]);
        }

    }

    @Test
    public void testToArray() {
        Integer[] arr = new Integer[6];
        list.toArray(arr);
        assertEquals(arr.length, list.size());
        for (int i = 0; i < arr.length; i++)
        {
            assertEquals(arr[i], list.get(i));
        }

    }

    @Test
    public void iterator() {


        Iterator<Integer> listIterator = list.iterator();

        int counter = 0;
        while(listIterator.hasNext())
        {
            assertEquals(list.get(counter), listIterator.next());
            counter++;
        }


    }

    @After
    public void tearDown()
    {
        list = null;
    }
}