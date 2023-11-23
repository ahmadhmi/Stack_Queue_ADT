package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyDLLTest {
    private MyDLL<Integer> test;
    private MyDLL<String> testString;

    @Before
    public void setUp() throws Exception {
        test = new MyDLL<>();
        testString = new MyDLL<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        test.add(0,0);
        test.add(1, 1);
        test.add(2, 2);
        int actual = test.size();
        assertEquals(3, actual);
        test.add(3, 3);
        int actual2 = test.size();
        assertEquals(4, actual2);
    }

    @Test
    public void clear() {
        test.add(0,0);
        test.add(1, 1);
        test.add(2, 2);
        test.clear();
        assertTrue(test.isEmpty());
        int actualSize = test.size();
        assertEquals(0,actualSize);
    }

    @Test
    public void add() {

        test.add(0,0);
        test.add(1, 1);
        test.add(2, 2);
        test.add(3, 3);
        boolean expected = test.add(0, 10);
        assertEquals(expected, true);
    }

    @Test
    public void testAdd() {
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(30);
        int actualSize = test.size();
        assertEquals(4, actualSize);
        int lastElement = test.get(3);
        assertEquals(30, lastElement);
    }

    @Test
    public void addAll() {
        test.add(0,0);
        test.add(1, 1);
        test.add(2, 2);
        test.add(3, 3);
        MyDLL<Integer> test2 = new MyDLL<>();
        test2.add(0,4);
        test2.add(1, 5);
        test2.add(2, 6);
        test2.add(3, 7);
        test.addAll(test2);
        assertTrue(true);
    }

    @Test
    public void get() {

        test.add(0,0);
        test.add(1, 1);
        test.add(2, 2);
        test.add(3, 3);
        int number = test.get(0);
        assertEquals(number, 0);
    }

    @Test
    public void remove() {

        test.add(0,10);
        test.add(1, 1);
        test.add(2, 20);
        test.add(3, 3);
        int number = test.remove(3);
        assertEquals(number, 3);
    }

    @Test
    public void testRemove() {

        testString.add(0,"10");
        testString.add(1, "1");
        testString.add(2, "20");
        testString.add(3, "3");
        String toRemove = testString.remove("5");
        assertEquals("10", toRemove);
    }

    @Test
    public void set() {
        test.add(0,10);
        test.add(1, 1);
        test.add(2, 20);
        test.add(3, 3);
        int number = test.set(3, 15);
        assertEquals(15, number);
    }

    @Test
    public void isEmpty() {
        test.add(0,10);
        test.add(1, 1);
        test.add(2, 20);
        test.add(3, 3);
        boolean actual = test.isEmpty();
        assertFalse(actual);
    }

    @Test
    public void contains() {
        test.add(0,10);
        test.add(1, 1);
        test.add(2, 20);
        test.add(3, 3);
        assertTrue(test.contains(20));
    }

    @Test
    public void toArray() {
        Integer[] testArray = new Integer[1];
        test.add(0,10);
        test.add(1, 20);
        test.add(2, 30);
        test.add(3, 40);
        Integer[] actual = test.toArray(testArray);
        Integer[] expected = {10, 20, 30, 40};
        assertEquals(expected, actual);

    }

    @Test
    public void testToArray() {
        test.add(0,10);
        test.add(1, 20);
        test.add(2, 30);
        Object[] actual = test.toArray();
        Object[] expected = {10, 20, 30};
        assertEquals(expected, actual);

    }

    @Test
    public void iterator() {

        MyDLL<Integer> dll = new MyDLL<>();

        dll.add(1);
        dll.add(2);
        dll.add(3);

        Iterator<Integer> it = dll.iterator();

        assertTrue("Iterator should have next element", it.hasNext());
        assertEquals("First element should be 1", Integer.valueOf(1), it.next());
        assertTrue("Iterator should have next element", it.hasNext());
        assertEquals("Second element should be 2", Integer.valueOf(2), it.next());
        assertTrue("Iterator should have next element", it.hasNext());
        assertEquals("Third element should be 3", Integer.valueOf(3), it.next());
        assertFalse("Iterator should not have any more elements", it.hasNext());
    }


}