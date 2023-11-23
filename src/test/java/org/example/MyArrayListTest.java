package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    private MyArrayList<Integer> list;

    @Before
    public void setup()
    {
        list = new MyArrayList<>();
    }


    @Test
    public void size() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void clear() {
    }

    @Test
    public void add() {
        list.add(2);
        assertEquals(list.get(0), 2);
        list.add(0, 1);
        for(int i = 0; i < list.size(); i++)
        {
            assertEquals(list.get(i), i + 1);
        }
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void get() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void set() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void testToArray() {
    }

    @Test
    public void iterator() {
    }
}